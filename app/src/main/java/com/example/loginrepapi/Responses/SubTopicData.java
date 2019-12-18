package com.example.loginrepapi.Responses;

import java.util.ArrayList;

public class SubTopicData{
    private String content_app_id;
    private String order;
    private String type;
    private String base_content_id;
    private String topic_id;
    private String weight;
    private String content;
    private String description;
    private String phonetics;
    private String img;
    private String completed;
    private String units_count;
    private SubTopicSource source;
    private SubTopicDestination destination;

    public SubTopicData(String content_app_id, String order, String type, String base_content_id, String topic_id, String weight, String content, String description, String phonetics, String img, String completed, String units_count, SubTopicSource source, SubTopicDestination destination) {
        this.content_app_id = content_app_id;
        this.order = order;
        this.type = type;
        this.base_content_id = base_content_id;
        this.topic_id = topic_id;
        this.weight = weight;
        this.content = content;
        this.description = description;
        this.phonetics = phonetics;
        this.img = img;
        this.completed = completed;
        this.units_count = units_count;
        this.source = source;
        this.destination = destination;
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

    public String getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(String topic_id) {
        this.topic_id = topic_id;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }

    public String getUnits_count() {
        return units_count;
    }

    public void setUnits_count(String units_count) {
        this.units_count = units_count;
    }

    public SubTopicSource getSource() {
        return source;
    }

    public void setSource(SubTopicSource source) {
        this.source = source;
    }

    public SubTopicDestination getDestination() {
        return destination;
    }

    public void setDestination(SubTopicDestination destination) {
        this.destination = destination;
    }
}

