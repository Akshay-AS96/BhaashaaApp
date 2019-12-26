package com.example.loginrepapi.Responses;

import com.google.gson.annotations.SerializedName;

public class EntityDestination {
    private String id;
    private String content;
    private String description;
    private String phonetics;
    @SerializedName("base_content_id")
    private String basecontentid;
    @SerializedName("entity_ref_id")
    private String entityrefid;
    private String weight;
    private String voice;
    @SerializedName("remark_voice")
    private String remarkvoice;
    @SerializedName("static_writing")
    private String staticwriting;
    @SerializedName("derived_img")
    private String derivedimg;

    public EntityDestination(String id, String content, String description, String phonetics, String basecontentid, String entityrefid, String weight, String voice, String remarkvoice, String staticwriting, String derivedimg) {
        this.id = id;
        this.content = content;
        this.description = description;
        this.phonetics = phonetics;
        this.basecontentid = basecontentid;
        this.entityrefid = entityrefid;
        this.weight = weight;
        this.voice = voice;
        this.remarkvoice = remarkvoice;
        this.staticwriting = staticwriting;
        this.derivedimg = derivedimg;
    }
}
