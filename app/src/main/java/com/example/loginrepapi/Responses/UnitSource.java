package com.example.loginrepapi.Responses;

import android.os.Parcel;
import android.os.Parcelable;

public class UnitSource implements Parcelable {
    String id;
    String base_content_id;
    String content;
    String description;
    String static_writing;
    String weight;
    String voice;
    String remark_voice;

    public UnitSource(String id, String base_content_id, String content, String description, String static_writing, String weight, String voice, String remark_voice) {
        this.id = id;
        this.base_content_id = base_content_id;
        this.content = content;
        this.description = description;
        this.static_writing = static_writing;
        this.weight = weight;
        this.voice = voice;
        this.remark_voice = remark_voice;
    }

    protected UnitSource(Parcel in) {
        id = in.readString();
        base_content_id = in.readString();
        content = in.readString();
        description = in.readString();
        static_writing = in.readString();
        weight = in.readString();
        voice = in.readString();
        remark_voice = in.readString();
    }

    public static final Creator<UnitSource> CREATOR = new Creator<UnitSource>() {
        @Override
        public UnitSource createFromParcel(Parcel in) {
            return new UnitSource(in);
        }

        @Override
        public UnitSource[] newArray(int size) {
            return new UnitSource[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBase_content_id() {
        return base_content_id;
    }

    public void setBase_content_id(String base_content_id) {
        this.base_content_id = base_content_id;
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

    public String getStatic_writing() {
        return static_writing;
    }

    public void setStatic_writing(String static_writing) {
        this.static_writing = static_writing;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    public String getRemark_voice() {
        return remark_voice;
    }

    public void setRemark_voice(String remark_voice) {
        this.remark_voice = remark_voice;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(base_content_id);
        parcel.writeString(content);
        parcel.writeString(description);
        parcel.writeString(static_writing);
        parcel.writeString(weight);
        parcel.writeString(voice);
        parcel.writeString(remark_voice);
    }
}
