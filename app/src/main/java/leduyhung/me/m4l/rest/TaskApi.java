package leduyhung.me.m4l.rest;

import java.util.List;

import leduyhung.me.m4l.module.song.Song;
import leduyhung.me.m4l.module.user.User;
import leduyhung.me.m4l.module.user.data.UserInfo;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface TaskApi {

    @POST("/v1/auth")
    Call<UserInfo> login(@Header("version") int version, @Header("pakage") String pakage, @Body User user);

    @GET("/v1/songs")
    Call<Song> getListSong(@Header("version") int version, @Header("pakage") String pakage, @Query("page") int page);
}
