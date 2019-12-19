package com.example.loginrepapi.Responses;

import android.os.Parcel;
import android.os.Parcelable;

public class UnitDestination implements Parcelable {
    String content_app_id;
    String order;
    String type;
    String id;
    String weight;
    String content;
    String description;
    String gender;
    String phonetics;
    String remark_voice;
    String voice;
    String static_writing;

    public UnitDestination(String content_app_id, String order, String type, String id, String weight, String content, String description, String gender, String phonetics, String remark_voice, String voice, String static_writing) {
        this.content_app_id = content_app_id;
        this.order = order;
        this.type = type;
        this.id = id;
        this.weight = weight;
        this.content = content;
        this.description = description;
        this.gender = gender;
        this.phonetics = phonetics;
        this.remark_voice = remark_voice;
        this.voice = voice;
        this.static_writing = static_writing;
    }

    protected UnitDestination(Parcel in) {
        content_app_id = in.readString();
        order = in.readString();
        type = in.readString();
        id = in.readString();
        weight = in.readString();
        content = in.readString();
        description = in.readString();
        gender = in.readString();
        phonetics = in.readString();
        remark_voice = in.readString();
        voice = in.readString();
        static_writing = in.readString();
    }

    public static final Creator<UnitDestination> CREATOR = new Creator<UnitDestination>() {
        @Override
        public UnitDestination createFromParcel(Parcel in) {
            return new UnitDestination(in);
        }

        @Override
        public UnitDestination[] newArray(int size) {
            return new UnitDestination[size];
        }
    };

    public String getContent_app_id() {
        return content_app_id;
    }

    public void setContent_app_id(String content_app_id) {
        this.content_app_id = content_app_id;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhonetics() {
        return phonetics;
    }

    public void setPhonetics(String phonetics) {
        this.phonetics = phonetics;
    }

    public String getRemark_voice() {
        return remark_voice;
    }

    public void setRemark_voice(String remark_voice) {
        this.remark_voice = remark_voice;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    public String getStatic_writing() {
        return static_writing;
    }

    public void setStatic_writing(String static_writing) {
        this.static_writing = static_writing;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(content_app_id);
        parcel.writeString(order);
        parcel.writeString(type);
        parcel.writeString(id);
        parcel.writeString(weight);
        parcel.writeString(content);
        parcel.writeString(description);
        parcel.writeString(gender);
        parcel.writeString(phonetics);
        parcel.writeString(remark_voice);
        parcel.writeString(voice);
        parcel.writeString(static_writing);
    }
}
