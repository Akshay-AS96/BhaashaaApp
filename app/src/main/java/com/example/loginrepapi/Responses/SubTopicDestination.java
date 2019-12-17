package com.example.loginrepapi.Responses;

public class SubTopicDestination {
    private String id;
    private String content;
    private String description;
    private String weight;
    private String voice;

    public SubTopicDestination(String id, String content, String description, String weight, String voice) {
        this.id = id;
        this.content = content;
        this.description = description;
        this.weight = weight;
        this.voice = voice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
