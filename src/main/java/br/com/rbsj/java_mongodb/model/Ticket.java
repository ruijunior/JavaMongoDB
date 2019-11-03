package br.com.rbsj.java_mongodb.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Ticket {

    private String id;
    private String title;
    private String description;
    private String appId;
    private String status;

    public Ticket(){}

    public Ticket(String title, String description, String appId, String status){

        this.title = title;
        this.description = description;
        this.appId = appId;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
