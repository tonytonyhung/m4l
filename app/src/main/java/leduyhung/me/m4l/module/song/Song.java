package leduyhung.me.m4l.module.song;

import android.app.Activity;
import android.content.Context;

import org.greenrobot.eventbus.EventBus;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.concurrent.TimeoutException;

import leduyhung.me.m4l.module.song.data.SongInfo;
import leduyhung.me.m4l.rest.BaseRestApi;
import leduyhung.me.m4l.util.ClientUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Song {

    private int total_item;
    private int total_page;
    private int current_page;
    private List<SongInfo> data;
    private transient Call<Song> call;

    public int getTotal_item() {
        return total_item;
    }

    public int getTotal_page() {
        return total_page;
    }

    public int getCurrent_page() {
        return current_page;
    }

    public List<SongInfo> getData() {
        return data;
    }

    public void getListSong(final Context ctx, String name, int page, int type) {

        if (!((Activity) ctx).isFinishing()) {
            call = BaseRestApi.request().getListSong(ClientUtil.getVersionCode(ctx), ClientUtil.getPakageName(ctx), name, page, type);
            call.enqueue(new Callback<Song>() {
                @Override
                public void onResponse(Call<Song> call, Response<Song> response) {
                    if (response.isSuccessful()) {

                    } else {

                    }
                }

                @Override
                public void onFailure(Call<Song> call, Throwable t) {
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

    public void cancelRequestSong() {
        if (call.isExecuted() && !call.isCanceled())
            call.cancel();
    }

    public void loveSong(final Context ctx) {
        // TODO: love song
    }

    public void downloadSong(final Context ctx) {
        // TODO: download song
    }

    public void getSongLocal(final Context ctx) {
        // TODO: get song local
    }
}