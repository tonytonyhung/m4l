package leduyhung.me.m4l.module.user;

import android.content.Context;
import android.content.Intent;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import org.greenrobot.eventbus.EventBus;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import leduyhung.me.m4l.R;
import leduyhung.me.m4l.module.user.data.UserInfo;
import leduyhung.me.m4l.module.message.MessageForActivity;
import leduyhung.me.m4l.rest.BaseRestApi;
import leduyhung.me.m4l.util.CacheUtil;
import leduyhung.me.m4l.util.ClientUtil;
import leduyhung.me.m4l.util.GsonUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * HOW TO USE:
 * Call {@link #isUserLogin()} (return boolean) to check user has login or not.
 * Call {@link #getUserInfo()} to get user infor
 * Call {@link #setActivityResult(int, int, Intent)} in onActivityResult to receive data from facebook
 * To logout, call {@link #logout()}. This function will delete cache user and logout facebook
 */
public class User implements FacebookCallback<LoginResult> {

    private transient static final String KEY_CACHE_USER = "KEY_CACHE_USER";
    private transient CallbackManager callbackManager;
    private transient Context mContext;
    private transient CacheUtil cacheUtil;
    private UserInfo userInfo;
    private String access_token;

    User(Context ctx, boolean needAccessFacebook) {

        this.mContext = ctx;
        cacheUtil = new CacheUtil(ctx);
        if (needAccessFacebook) {
            callbackManager = CallbackManager.Factory.create();
            LoginManager.getInstance().registerCallback(callbackManager, this);
        }
    }

    private String getAccess_token() {
        return access_token;
    }

    private void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    private void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public UserInfo getUserInfo() {
        setUserInfo(GsonUtil.newInstance().fromJson(cacheUtil.getString(KEY_CACHE_USER, ""), UserInfo.class));
        return userInfo;
    }

    public boolean isUserLogin() {

        return !cacheUtil.getString(KEY_CACHE_USER, "").equalsIgnoreCase("");
    }

    public void setActivityResult(int requestCode, int resultCode, Intent data) {

        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    public void logout() {

        synchronized (this) {

            userInfo = null;
            cacheUtil.clearByName(KEY_CACHE_USER);
            LoginManager.getInstance().logOut();
        }
    }

    private void pushDataToServer() {

        if (getAccess_token() != null && getAccess_token().equalsIgnoreCase(""))
            BaseRestApi.request().login(ClientUtil.getVersionCode(mContext), ClientUtil.getPakageName(mContext), this).enqueue(new Callback<UserInfo>() {
                @Override
                public void onResponse(Call<UserInfo> call, Response<UserInfo> response) {

                    if (response.isSuccessful()) {

                        setUserInfo(userInfo);
                        cacheUtil.putString(KEY_CACHE_USER, GsonUtil.newInstance().toJson(this));
                        EventBus.getDefault().post(new MessageForActivity(MessageForActivity.ConstantMessage.CODE_LOGIN_SERVER_SUCCESS, null));
                    } else {

                        EventBus.getDefault().post(new MessageForActivity(MessageForActivity.ConstantMessage.CODE_LOGIN_SERVER_FAIL, mContext.getResources()
                                .getString(R.string.login_server_error)));
                        logout();
                    }

                }

                @Override
                public void onFailure(Call<UserInfo> call, Throwable t) {

                    if (!ClientUtil.isConnectInternet(mContext)) {

                        EventBus.getDefault().post(new MessageForActivity(MessageForActivity.ConstantMessage.CODE_LOGIN_FACEBOOK_FAIL, mContext.getResources()
                                .getString(R.string.no_connect_internet)));
                    } else {

                        if (t instanceof TimeoutException || t instanceof SocketTimeoutException || t instanceof UnknownHostException) {

                            EventBus.getDefault().post(new MessageForActivity(MessageForActivity.ConstantMessage.CODE_LOGIN_FACEBOOK_FAIL, mContext.getResources()
                                    .getString(R.string.server_connect_timeout)));
                        } else {

                            EventBus.getDefault().post(new MessageForActivity(MessageForActivity.ConstantMessage.CODE_LOGIN_FACEBOOK_FAIL, mContext.getResources()
                                    .getString(R.string.server_maintain)));
                        }
                    }
                    logout();
                }
            });
    }

    @Override
    public void onSuccess(LoginResult loginResult) {

        setAccess_token(loginResult.getAccessToken().getToken());
        pushDataToServer();
    }

    @Override
    public void onCancel() {

        EventBus.getDefault().post(new MessageForActivity(MessageForActivity.ConstantMessage.CODE_LOGIN_FACEBOOK_CANCEL, null));
        logout();
    }

    @Override
    public void onError(FacebookException error) {

        EventBus.getDefault().post(new MessageForActivity(MessageForActivity.ConstantMessage.CODE_LOGIN_FACEBOOK_FAIL, mContext.getResources()
                .getString(R.string.facebook_login_error)));
        logout();
    }
}