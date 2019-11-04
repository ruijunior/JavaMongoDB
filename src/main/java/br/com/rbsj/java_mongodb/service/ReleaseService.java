package br.com.rbsj.java_mongodb.service;

import br.com.rbsj.java_mongodb.model.Release;

import java.util.List;

public interface ReleaseService {

    public List<Release> getReleaseByTicketStatus(String status);

    public Release save(Release release);
}
