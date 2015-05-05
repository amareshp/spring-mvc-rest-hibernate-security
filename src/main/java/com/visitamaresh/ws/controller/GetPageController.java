package com.visitamaresh.ws.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.visitamaresh.ws.component.HtmlPageDetails;
import com.visitamaresh.ws.util.HtmlUtil;

@RestController
public class GetPageController {

    @RequestMapping("/getpage")
    public HtmlPageDetails getPage(@RequestParam(value="url", defaultValue="http://google.com") String url) {
        String title = HtmlUtil.getInstance().getPageTitle(url);
        List<String> links = HtmlUtil.getInstance().getLinks(url);
        List<String> forms = new ArrayList<String>();
        forms.add("form1");
        forms.add("form2");
        HtmlPageDetails pageDetails = new HtmlPageDetails(title, links, forms);
        
        return pageDetails;
    }
}