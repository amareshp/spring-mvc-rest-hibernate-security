package com.visitamaresh.ws.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class CalUtil {
    private static WebDriver driver = null;
    private static WebElement element = null;
    private static List<WebElement> elements = null;
    private static Logger logger = Logger.getLogger(new Exception().getStackTrace()[0].getClassName());

    public static List<String> getPoolLinks(String url) {
        List<String> links = new ArrayList<String>();
        List<PoolDetails> hitCounts = new ArrayList<PoolDetails>();
        
        try {
            driver = new HtmlUnitDriver(true);
            HtmlunitHelper.turnOffHtmlUnitLogging();
            logger.info("Getting page source from url: " + url);
            driver.get(url);
            WebdriverUtil.waitForElementToAppear(driver, By.xpath("//a[@id='xxxxxxx']"));
            
            elements = driver.findElements( By.xpath("//a[@id='xxxxxx']") );
            for(WebElement ele : elements) {
                String pool = ele.getAttribute("pool");
                String link = ele.getAttribute("href");
                driver.get(link);
                element = driver.findElement( By.xpath("//a[@id='xxxx']"));
                String countStr = element.getText();
                Long count = Long.valueOf(countStr);
                PoolDetails details = new PoolDetails(pool, count);
                hitCounts.add(details);
            }
            
            
        } catch(Exception ex) {
            logger.error(ex);
        }
        return links;
    }
}
