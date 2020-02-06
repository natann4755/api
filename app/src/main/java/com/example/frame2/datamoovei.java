package com.example.frame2;

import android.os.Parcel;
import android.os.Parcelable;

public class datamoovei implements Parcelable {
    private String titel;
    private String text;
    private int imeg;
    private String url;

    public datamoovei(String titel, String text, int imeg, String url) {
        this.titel = titel;
        this.text = text;
        this.imeg = imeg;
        this.url = url;
    }

    protected datamoovei(Parcel in) {
        titel = in.readString();
        text = in.readString();
        imeg = in.readInt();
        url = in.readString();
    }

    public static final Creator<datamoovei> CREATOR = new Creator<datamoovei>() {
        @Override
        public datamoovei createFromParcel(Parcel in) {
            return new datamoovei(in);
        }

        @Override
        public datamoovei[] newArray(int size) {
            return new datamoovei[size];
        }
    };

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImeg() {
        return imeg;
    }

    public void setImeg(int imeg) {
        this.imeg = imeg;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(titel);
        dest.writeString(text);
        dest.writeInt(imeg);
        dest.writeString(url);
    }
}
