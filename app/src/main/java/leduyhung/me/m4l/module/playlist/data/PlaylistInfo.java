package leduyhung.me.m4l.module.playlist.data;

import android.os.Parcel;
import android.os.Parcelable;

public class PlaylistInfo implements Parcelable {

    private int id;
    private String name;
    private int total_view;
    private int user_id;
    private int love;
    private int song;

    public PlaylistInfo() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTotal_view() {
        return total_view;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getLove() {
        return love;
    }

    public int getSong() {
        return song;
    }

    PlaylistInfo(Parcel in) {

        this.id = in.readInt();
        this.name = in.readString();
        this.total_view = in.readInt();
        this.user_id = in.readInt();
        this.love = in.readInt();
        this.song = in.readInt();
    }

    public static final Creator<PlaylistInfo> CREATOR = new Creator<PlaylistInfo>() {
        @Override
        public PlaylistInfo createFromParcel(Parcel in) {
            return new PlaylistInfo(in);
        }

        @Override
        public PlaylistInfo[] newArray(int size) {
            return new PlaylistInfo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeInt(total_view);
        parcel.writeInt(user_id);
        parcel.writeInt(love);
        parcel.writeInt(song);
    }
}
