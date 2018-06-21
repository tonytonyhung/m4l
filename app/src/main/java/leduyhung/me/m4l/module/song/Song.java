package leduyhung.me.m4l.module.song;

import java.util.List;

import leduyhung.me.m4l.module.song.data.SongInfo;

public class Song {

    private int total_item;
    private int total_page;
    private int current_page;
    private List<SongInfo> data;

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
}
