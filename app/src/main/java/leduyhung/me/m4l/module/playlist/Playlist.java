package leduyhung.me.m4l.module.playlist;

import android.app.Activity;
import android.content.Context;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.concurrent.TimeoutException;

import leduyhung.me.m4l.module.playlist.data.PlaylistInfo;
import leduyhung.me.m4l.rest.BaseRestApi;
import leduyhung.me.m4l.util.ClientUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Playlist {

    private int total_item;
    private int total_page;
    private int current_page;
    private List<PlaylistInfo> data;
    private transient Call<Playlist> callPlaylist, callMyPlaylist;

    public int getTotal_item() {
        return total_item;
    }

    public int getTotal_page() {
        return total_page;
    }

    public int getCurrent_page() {
        return current_page;
    }

    public List<PlaylistInfo> getData() {
        return data;
    }

    public void getTopPlaylist(final Context ctx, String name, int page) {

        if (!((Activity) ctx).isFinishing()) {
            callPlaylist = BaseRestApi.request().getListPlaylist(ClientUtil.getVersionCode(ctx), ClientUtil.getPakageName(ctx), name, page);
            callPlaylist.enqueue(new Callback<Playlist>() {
                @Override
                public void onResponse(Call<Playlist> call, Response<Playlist> response) {
                    if (response.isSuccessful()) {

                    } else {

                    }
                }

                @Override
                public void onFailure(Call<Playlist> call, Throwable t) {

                    if (!ClientUtil.isConnectInternet(ctx)) {

                    } else {

                        if (t instanceof TimeoutException || t instanceof SocketTimeoutException || t instanceof UnknownHostException) {

                        } else {

                        }
                    }
                }
            });
        }
    }

    public void cancelRequestGetTopPlaylist() {
        if (callPlaylist.isExecuted() && !callPlaylist.isCanceled())
            callPlaylist.cancel();
    }

    public void getMyPlaylist(final Context ctx, int user_id, String name, int page) {

        if (!((Activity) ctx).isFinishing()) {
            callMyPlaylist = BaseRestApi.request().getMyListPlaylist(ClientUtil.getVersionCode(ctx),
                    ClientUtil.getPakageName(ctx), user_id, name, page);
            callMyPlaylist.enqueue(new Callback<Playlist>() {
                @Override
                public void onResponse(Call<Playlist> call, Response<Playlist> response) {
                    if (response.isSuccessful()) {

                    } else {

                    }
                }

                @Override
                public void onFailure(Call<Playlist> call, Throwable t) {

                    if (!ClientUtil.isConnectInternet(ctx)) {

                    } else {

                        if (t instanceof TimeoutException || t instanceof SocketTimeoutException || t instanceof UnknownHostException) {

                        } else {

                        }
                    }
                }
            });
        }
    }

    public void cancelRequestGetMyPlaylist() {

        if (callMyPlaylist.isExecuted() && !callMyPlaylist.isCanceled())
            callMyPlaylist.cancel();
    }
}
