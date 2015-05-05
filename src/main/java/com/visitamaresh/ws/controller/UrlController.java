package com.visitamaresh.ws.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.visitamaresh.ws.component.HtmlPageService;
import com.visitamaresh.ws.util.HtmlUtil;

@Controller
@RequestMapping("/page")
public class UrlController {
    @Autowired
    private HtmlPageService pageService;

    @RequestMapping(value = { "/details/", "/details" }, method = RequestMethod.GET)
    public String getPageTitle(@RequestParam Map<String, String> allRequestParams, ModelMap model) {
        String url = allRequestParams.get("url");
        System.out.println("url: " + url);
        model.addAttribute("msg", "Page title: " + pageService.getPageTitle(url) );
        return "result";
    }
    
    @RequestMapping(value = { "/details/", "/details" }, method = RequestMethod.POST)
    public String getPageInfo(@RequestParam("url") String url, ModelMap model) {
        System.out.println("url: " + url);
        model.addAttribute("url", "url: " + url );
        model.addAttribute("msg", "Page title: " + pageService.getPageTitle(url) );
        List<String> links = HtmlUtil.getInstance().getLinks(url);
        model.addAttribute("links", links);
        return "page-result";
    }
    
}