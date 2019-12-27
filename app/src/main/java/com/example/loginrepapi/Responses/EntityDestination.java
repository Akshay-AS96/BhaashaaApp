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

    public void setId(String id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPhonetics(String phonetics) {
        this.phonetics = phonetics;
    }

    public void setBasecontentid(String basecontentid) {
        this.basecontentid = basecontentid;
    }

    public void setEntityrefid(String entityrefid) {
        this.entityrefid = entityrefid;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    public void setRemarkvoice(String remarkvoice) {
        this.remarkvoice = remarkvoice;
    }

    public void setStaticwriting(String staticwriting) {
        this.staticwriting = staticwriting;
    }

    public void setDerivedimg(String derivedimg) {
        this.derivedimg = derivedimg;
    }

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
