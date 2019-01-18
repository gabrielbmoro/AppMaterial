package com.example.gabrielmoro.xyz_reader.model;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class XyzReaderJson implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("thumb")
    @Expose
    private String thumb;
    @SerializedName("photo")
    @Expose
    private String photo;
    @SerializedName("aspect_ratio")
    @Expose
    private double aspectRatio;
    @SerializedName("published_date")
    @Expose
    private String publishedDate;
    @SerializedName("body")
    @Expose
    private String body;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("title")
    @Expose
    private String title;

    public XyzReaderJson(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        thumb = in.readString();
        photo = in.readString();
        aspectRatio = in.readDouble();
        publishedDate = in.readString();
        body = in.readString();
        author = in.readString();
        title = in.readString();
    }

    public static final Creator<XyzReaderJson> CREATOR = new Creator<XyzReaderJson>() {
        @Override
        public XyzReaderJson createFromParcel(Parcel in) {
            return new XyzReaderJson(in);
        }

        @Override
        public XyzReaderJson[] newArray(int size) {
            return new XyzReaderJson[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeString(thumb);
        dest.writeString(photo);
        dest.writeDouble(aspectRatio);
        dest.writeString(publishedDate);
        dest.writeString(body);
        dest.writeString(author);
        dest.writeString(title);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public double getAspectRatio() {
        return aspectRatio;
    }

    public void setAspectRatio(double aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
