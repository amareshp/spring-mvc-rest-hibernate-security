package com.visitamaresh.ws.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlUtil {
    private static HtmlUtil htmlUtil = null;
    private static WebDriver driver = null;
    private static WebElement element = null;
    private static Logger logger = Logger.getLogger(new Exception().getStackTrace()[0].getClassName());

    private HtmlUtil() {
        driver = new HtmlUnitDriver(false);
        HtmlunitHelper.turnOffHtmlUnitLogging();
    }
    
    public static HtmlUtil getInstance() {
        if(htmlUtil == null) {
            htmlUtil = new HtmlUtil();
        }
        return htmlUtil;
    }
    
    public String getSource(String url) {
        String source = null;
        try {
            logger.info("Getting page source from url: " + url);
            source = driver.getPageSource();
        } catch(Exception ex) {
            logger.error(ex);
        }
        return source;
    }
    
    public String getPageTitle(String url) {
        String title = null;
        try {
            logger.info("Getting page title from url: " + url);
            driver.get(url);
            title = driver.getTitle();
        } catch(Exception ex) {
            logger.error(ex);
        }
        return title;
    }

    public List<String> getLinks(String url) {
        List<String> links = new ArrayList<String>();
        try {
            logger.info("Getting links title from url: " + url);
            driver.get(url);
            List<WebElement> elements = driver.findElements( By.cssSelector("a") );
            for(WebElement element : elements) {
                String href = element.getText() + " : " + element.getAttribute("href");
                links.add(href);
            }
        } catch(Exception ex) {
            logger.error(ex);
        }
        return links;
    }
    
}
