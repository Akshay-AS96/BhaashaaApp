package com.example.loginrepapi.Responses;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class UnitData  implements Parcelable {
    String content_app_id;
    String order;
    String type;
    String base_content_id;
    String subtopic_id;
    String weight;
    String content;
    String description;
    String phonetics;
    String topic_id;
    String img;
    String source_langcode;
    String destination_langcode;
    String entity_count;
    String related_units;
    @SerializedName("source")
    private UnitSource unitSource;
    @SerializedName("destination")
    private UnitDestination unitDestination;

    protected UnitData(Parcel in) {
        content_app_id = in.readString();
        order = in.readString();
        type = in.readString();
        base_content_id = in.readString();
        subtopic_id = in.readString();
        weight = in.readString();
        content = in.readString();
        description = in.readString();
        phonetics = in.readString();
        topic_id = in.readString();
        img = in.readString();
        source_langcode = in.readString();
        destination_langcode = in.readString();
        entity_count = in.readString();
        related_units = in.readString();
    }

    public static final Creator<UnitData> CREATOR = new Creator<UnitData>() {
        @Override
        public UnitData createFromParcel(Parcel in) {
            return new UnitData(in);
        }

        @Override
        public UnitData[] newArray(int size) {
            return new UnitData[size];
        }
    };

    public String getSource_langcode() {
        return source_langcode;
    }

    public void setSource_langcode(String source_langcode) {
        this.source_langcode = source_langcode;
    }

    public String getDestination_langcode() {
        return destination_langcode;
    }

    public void setDestination_langcode(String destination_langcode) {
        this.destination_langcode = destination_langcode;
    }

    public String getEntity_count() {
        return entity_count;
    }

    public void setEntity_count(String entity_count) {
        this.entity_count = entity_count;
    }

    public String getRelated_units() {
        return related_units;
    }

    public void setRelated_units(String related_units) {
        this.related_units = related_units;
    }



    public UnitData(String content_app_id, String order, String type, String base_content_id, String subtopic_id, String weight, String content, String description, String phonetics, String topic_id, String img, UnitSource unitSource, UnitDestination unitDestination, String source_langcode, String destination_langcode,String entity_count,String related_units) {
        this.content_app_id = content_app_id;
        this.order = order;
        this.type = type;
        this.base_content_id = base_content_id;
        this.subtopic_id = subtopic_id;
        this.weight = weight;
        this.content = content;
        this.description = description;
        this.phonetics = phonetics;
        this.topic_id = topic_id;
        this.img = img;
        this.unitSource = unitSource;
        this.unitDestination = unitDestination;
        this.source_langcode=source_langcode;
        this.destination_langcode=destination_langcode;
        this.entity_count=entity_count;
        this.related_units=related_units;
    }

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

    public String getBase_content_id() {
        return base_content_id;
    }

    public void setBase_content_id(String base_content_id) {
        this.base_content_id = base_content_id;
    }

    public String getSubtopic_id() {
        return subtopic_id;
    }

    public void setSubtopic_id(String subtopic_id) {
        this.subtopic_id = subtopic_id;
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

    public String getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(String topic_id) {
        this.topic_id = topic_id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public UnitSource getUnitSource() {
        return unitSource;
    }

    public void setUnitSource(UnitSource unitSource) {
        this.unitSource = unitSource;
    }

    public UnitDestination getUnitDestination() {
        return unitDestination;
    }

    public void setUnitDestination(UnitDestination unitDestination) {
        this.unitDestination = unitDestination;
    }

    @Override
    public int describeContents()  {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(content_app_id);
        parcel.writeString(order);
        parcel.writeString(type);
        parcel.writeString(base_content_id);
        parcel.writeString(subtopic_id);
        parcel.writeString(weight);
        parcel.writeString(content);
        parcel.writeString(description);
        parcel.writeString(phonetics);
        parcel.writeString(topic_id);
        parcel.writeString(img);
        parcel.writeString(source_langcode);
        parcel.writeString(destination_langcode);
        parcel.writeString(entity_count);
        parcel.writeString(related_units);
    }
}
