package com.visitamaresh.ws.component;

import java.util.ArrayList;
import java.util.List;

import com.visitamaresh.ws.util.HtmlUtil;

public class HtmlPageService {
    
    public String getPageTitle(String url) {
        return HtmlUtil.getInstance().getPageTitle(url);
    }

    public List<String> getLinks(String url) {
        return HtmlUtil.getInstance().getLinks(url);
    }
    
}
