package br.com.rbsj.java_mongodb.service;

import br.com.rbsj.java_mongodb.model.Application;

public interface ApplicationService {

    public void addApplicationWTemplate(Application application);

    public Application findByIdTemplate(String id);

    public void deleteWTemplate(Application application);

    public void updateApplicationWTemplate(Application application, String name);
}
