package leduyhung.me.m4l.module.song.data;

import android.os.Parcel;
import android.os.Parcelable;

public class SongInfo implements Parcelable {

    private int id;
    private String name;
    private String auth;
    private String key_search;
    private String link;
    private int total_view;
    private int type;
    private int love;
    private boolean isPlay;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuth() {
        return auth;
    }

    public String getKey_search() {
        return key_search;
    }

    public String getLink() {
        return link;
    }

    public int getTotal_view() {
        return total_view;
    }

    public int getType() {
        return type;
    }

    public int getLove() {
        return love;
    }

    public boolean isPlay() {
        return isPlay;
    }

    public void setPlay(boolean play) {
        isPlay = play;
    }

    SongInfo(Parcel in) {

        this.id = in.readInt();
        this.name = in.readString();
        this.auth = in.readString();
        this.key_search = in.readString();
        this.link = in.readString();
        this.total_view = in.readInt();
        this.type = in.readInt();
        this.love = in.readInt();
        this.isPlay = in.readByte() != 0;
    }

    public static final Creator<SongInfo> CREATOR = new Creator<SongInfo>() {
        @Override
        public SongInfo createFromParcel(Parcel in) {
            return new SongInfo(in);
        }

        @Override
        public SongInfo[] newArray(int size) {
            return new SongInfo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeInt(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.auth);
        parcel.writeString(this.key_search);
        parcel.writeString(this.link);
        parcel.writeInt(this.total_view);
        parcel.writeInt(this.type);
        parcel.writeInt(this.love);
        parcel.writeByte((byte) (isPlay ? 1 : 0));
    }
}