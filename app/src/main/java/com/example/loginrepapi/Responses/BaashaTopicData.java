package com.example.loginrepapi.Responses;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class BaashaTopicData implements  Parcelable {
    @SerializedName("base_content_id")
    private String baseId;
    private String mode;
    private String weight;
    private String content;
    private String description;
    private String phonetics;
    private String static_writing;
    private String img;
    private String important;
    public BaashaaAppSourceRes source;
    public static final Parcelable.Creator<BaashaTopicData> CREATOR = new Creator<BaashaTopicData>() {
        public BaashaTopicData createFromParcel(Parcel in) {
            return new BaashaTopicData(in);
        }

        @Override
        public BaashaTopicData[] newArray(int size) {
            return new BaashaTopicData[size];
        }

    };
    protected BaashaTopicData(Parcel in) {
        this.baseId = in.readString();
        this.mode = in.readString();
        this.weight = in.readString();
        this.content = in.readString();
        this.description = in.readString();
        this.phonetics = in.readString();
        this.static_writing = in.readString();
        this.img = in.readString();
        this.important = in.readString();
        this.source = ( BaashaaAppSourceRes) in.readParcelable(BaashaaAppSourceRes.class.getClassLoader());
    }

    public String getBaseId() {
        return baseId;
    }

    public void setBaseId(String baseId) {
        this.baseId = baseId;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhonetics() {
        return phonetics;
    }

    public void setPhonetics(String phonetics) {
        this.phonetics = phonetics;
    }

    public String getStatic_writing() {
        return static_writing;
    }

    public void setStatic_writing(String static_writing) {
        this.static_writing = static_writing;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImportant() {
        return important;
    }

    public void setImportant(String important) {
        this.important = important;
    }

    public BaashaaAppSourceRes getSource() {
        return source;
    }

    public void setSource(BaashaaAppSourceRes source) {
        this.source = source;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.baseId);
        dest.writeString(this.mode);
        dest.writeString(this.weight);
        dest.writeString(this.content);
        dest.writeString(this.description);
        dest.writeString(this.phonetics);
        dest.writeString(this.static_writing);
        dest.writeString(this.img);
        dest.writeString(this.important);
        dest.writeParcelable((Parcelable) this.source, flags);
    }
}

