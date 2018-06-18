package leduyhung.me.m4l.module.user.data;

import android.os.Parcel;
import android.os.Parcelable;

public class UserInfo implements Parcelable {

    private int id;
    private String name;
    private String fb;

    public UserInfo() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFb() {
        return fb;
    }

    UserInfo(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.fb = in.readString();
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public UserInfo createFromParcel(Parcel in) {
            return new UserInfo(in);
        }

        public UserInfo[] newArray(int size) {
            return new UserInfo[size];
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
        parcel.writeString(this.fb);
    }
}