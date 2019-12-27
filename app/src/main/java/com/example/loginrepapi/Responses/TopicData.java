package com.example.loginrepapi.Responses;

public class TopicData {
    String id;
    String mode;
    String version;
    String base_content_id;
    String weight;
    String content;
    String description;
    String phonetics;
    String status;
    String creator;
    String verifier;
    String created;
    String last_update;
    String img;
    String voice;
    String url;
    String base_content;
    String derived_img;
    String derived_video;
    private int completed;



    public TopicData(String id, String mode, String version, String base_content_id, String weight, String content,
                     String description, String phonetics, String status, String creator, String verifier,
                     String created, String last_update, String img, String voice, String url,
                     String base_content, String derived_img, String derived_video,int completed) {
        this.id = id;
        this.mode = mode;
        this.version = version;
        this.base_content_id = base_content_id;
        this.weight = weight;
        this.content = content;
        this.description = description;
        this.phonetics = phonetics;
        this.status = status;
        this.creator = creator;
        this.verifier = verifier;
        this.created = created;
        this.last_update = last_update;
        this.img = img;
        this.voice = voice;
        this.url = url;
        this.base_content = base_content;
        this.derived_img = derived_img;
        this.derived_video = derived_video;
        this.completed = completed;

    }
    public int getCompleted() {
        return completed;
    }

    public String getId() {
        return id;
    }

    public String getMode() {
        return mode;
    }

    public String getVersion() {
        return version;
    }

    public String getBase_content_id() {
        return base_content_id;
    }

    public String getWeight() {
        return weight;
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

    public String getStatus() {
        return status;
    }

    public String getCreator() {
        return creator;
    }

    public String getVerifier() {
        return verifier;
    }

    public String getCreated() {
        return created;
    }

    public String getLast_update() {
        return last_update;
    }

    public String getImg() {
        return img;
    }


    public String getVoice() {
        return voice;
    }

    public String getUrl() {
        return url;
    }

    public String getBase_content() {
        return base_content;
    }

    public String getDerived_img() {
        return derived_img;
    }

    public String getDerived_video() {
        return derived_video;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setBase_content_id(String base_content_id) {
        this.base_content_id = base_content_id;
    }

    public void setWeight(String weight) {
        this.weight = weight;
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

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void setVerifier(String verifier) {
        this.verifier = verifier;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setBase_content(String base_content) {
        this.base_content = base_content;
    }

    public void setDerived_img(String derived_img) {
        this.derived_img = derived_img;
    }

    public void setDerived_video(String derived_video) {
        this.derived_video = derived_video;
    }
}
