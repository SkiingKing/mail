package com.example.user.mail;


import android.os.Parcel;
import android.os.Parcelable;

public class EmailItem implements Parcelable {

    private String title;
    private String secondtext;
    private String text;
    private String date;
    private String imageUrl;

    public EmailItem(String title, String secondtext, String text, String date,String imageUrl) {
        this.title = title;
        this.secondtext = secondtext;
        this.text = text;
        this.date = date;
        this.imageUrl= imageUrl;

    }

    String getTitle() {
        return title;
    }

    String getSecondtext() {
        return secondtext;
    }

    String getText() {
        return text;
    }

    String getDate() {
        return date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.secondtext);
        dest.writeString(this.text);
        dest.writeString(this.date);
        dest.writeString(this.imageUrl);
    }

    protected EmailItem(Parcel in) {
        this.title = in.readString();
        this.secondtext = in.readString();
        this.text = in.readString();
        this.date = in.readString();
        this.imageUrl = in.readString();
    }

    public static final Creator<EmailItem> CREATOR = new Creator<EmailItem>() {
        @Override
        public EmailItem createFromParcel(Parcel source) {
            return new EmailItem(source);
        }

        @Override
        public EmailItem[] newArray(int size) {
            return new EmailItem[size];
        }
    };
}