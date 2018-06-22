package leduyhung.me.m4l.module.message;

import leduyhung.me.m4l.module.song.Song;

public class GetListSongMessage extends BaseMessage {

    private Song data;

    public GetListSongMessage(StatusResponse status, String message, int fromId, Song data) {
        super(status, message, fromId);
        this.data = data;
    }

    public Song getData() {
        return data;
    }
}