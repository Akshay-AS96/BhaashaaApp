package com.example.loginrepapi.Responses;

import com.google.gson.annotations.SerializedName;

public class EntitySource {
    String id;
    String content;
    String description;
    @SerializedName("static_writitng")
    String staticwrititng;
    @SerializedName("entity_ref_id")
    String entityrefid;
    String weight;
    String voice;
    @SerializedName("remark_voice")
    String remarkvoice;
    String video;
    @SerializedName("derived_img")
    String derivedimg;

    public EntitySource(String id, String content, String description, String staticwrititng, String entityrefid, String weight, String voice, String remarkvoice, String video, String derivedimg) {
        this.id = id;
        this.content = content;
        this.description = description;
        this.staticwrititng = staticwrititng;
        this.entityrefid = entityrefid;
        this.weight = weight;
        this.voice = voice;
        this.remarkvoice = remarkvoice;
        this.video = video;
        this.derivedimg = derivedimg;
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

    public String getStaticwrititng() {
        return staticwrititng;
    }

    public String getEntityrefid() {
        return entityrefid;
    }

    public String getWeight() {
        return weight;
    }

    public String getVoice() {
        return voice;
    }

    public String getRemarkvoice() {
        return remarkvoice;
    }

    public String getVideo() {
        return video;
    }

    public String getDerivedimg() {
        return derivedimg;
    }
}
