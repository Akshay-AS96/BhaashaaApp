package com.example.loginrepapi.Responses;

import com.google.gson.annotations.SerializedName;

public class EntityData {
    private String id;
    private String content;
    private String description;
    private String phonetics;
    @SerializedName("entity_ref_id")
    private String entityrefid;
    private String weight;
    @SerializedName("static_writing")
    private int staticwriting;
    private String img;
    private String creator;
    @SerializedName("content_type")
    private int contenttype;
    @SerializedName("source_langcode")
    private String sourcelangcode;
    @SerializedName("destinationlangcode")
    private String destination_langcode;
    @SerializedName("source")
    private EntitySource source;
    @SerializedName("destination")
    private EntityDestination destination;

    public EntityData(String id, String content, String description, String phonetics, String entityrefid, String weight, int staticwriting, String img, String creator, int contenttype, String sourcelangcode, String destination_langcode, EntitySource source, EntityDestination destination) {
        this.id = id;
        this.content = content;
        this.description = description;
        this.phonetics = phonetics;
        this.entityrefid = entityrefid;
        this.weight = weight;
        this.staticwriting = staticwriting;
        this.img = img;
        this.creator = creator;
        this.contenttype = contenttype;
        this.sourcelangcode = sourcelangcode;
        this.destination_langcode = destination_langcode;
        this.source = source;
        this.destination = destination;
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getDescription() {
        return description;
    }

    public String getPhonetics() {
        return phonetics;
    }

    public String getEntityrefid() {
        return entityrefid;
    }

    public String getWeight() {
        return weight;
    }

    public int getStaticwriting() {
        return staticwriting;
    }

    public String getImg() {
        return img;
    }

    public String getCreator() {
        return creator;
    }

    public int getContenttype() {
        return contenttype;
    }

    public String getSourcelangcode() {
        return sourcelangcode;
    }

    public String getDestination_langcode() {
        return destination_langcode;
    }

    public EntitySource getSource() {
        return source;
    }

    public EntityDestination getDestination() {
        return destination;
    }
}
