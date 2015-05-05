package com.visitamaresh.ws.component;

import java.util.List;

public class HtmlPageDetails {
    
    private String title;
    private List<String> links;
    private List<String> forms;
    
    
    
    public HtmlPageDetails(String title, List<String> links, List<String> forms) {
        this.title = title;
        this.links = links;
        this.forms = forms;
    }
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public List<String> getLinks() {
        return links;
    }
    public void setLinks(List<String> links) {
        this.links = links;
    }
    public List<String> getForms() {
        return forms;
    }
    public void setForms(List<String> forms) {
        this.forms = forms;
    }
    
    

}
