package leduyhung.me.m4l.rest;

import leduyhung.me.m4l.module.user.User;
import leduyhung.me.m4l.module.user.data.UserInfo;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface TaskApi {

    @POST("/v1/auth")
    Call<UserInfo> login(@Header("version") int version, @Header("pakage") String pakage, @Body User user);
}
