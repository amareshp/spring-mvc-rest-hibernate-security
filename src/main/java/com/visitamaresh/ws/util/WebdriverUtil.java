package com.visitamaresh.ws.util;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebdriverUtil {
    private static Logger logger = Logger.getLogger(new Exception().getStackTrace()[0].getClassName());
    private static int MAX_WAIT = 60;
    private static int EACH_WAIT = 4;
    private static int WAIT_COUNT = MAX_WAIT / (EACH_WAIT * 2);
    private static WebElement element = null;
    private TimeUtil timeUtil = null;

    public WebdriverUtil() {
        timeUtil = new TimeUtil();
        element = null;
    }
    public WebdriverUtil(int maxWaitSeconds) {
        timeUtil = new TimeUtil();
        element = null;
        MAX_WAIT = maxWaitSeconds;
    }
    
    public static void waitForElementToAppear(WebDriver driver, By by) throws Exception {
        boolean found = false;
        logger.info("Waiting for element: " + by);
        element = null;
        driver.manage().timeouts().implicitlyWait(EACH_WAIT, TimeUnit.SECONDS);
        for (int i = 0; i < WAIT_COUNT; i++) {
            try {
                Thread.sleep(EACH_WAIT * 1000);
                element = driver.findElement(by);
                if (element != null) {
                    found = true;
                    break;
                }
            } catch (Exception ex) {
                //ignore
            }
        }
        // turn off implicit wait
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        if( !found ) {
            throw new Exception("Could not locate: " + by);
        }
    }

    
    public void dynamicWaitForElement(WebDriver driver, By by) {
        try {
            while(timeUtil.timeElapsedSeconds() < MAX_WAIT) {
                Thread.sleep(2000);
                element = driver.findElement(by);
                if(element != null) {
                    break;
                }
            }
            
        } catch(Exception ex) {
            dynamicWaitForElement(driver, by);
        }
    }

    public static void waitTillPageUrlContains(WebDriver driver, String urlPart) {
        logger.info("Waiting until page url contains: " + urlPart);
        String url = driver.getCurrentUrl();
        driver.manage().timeouts().implicitlyWait(EACH_WAIT, TimeUnit.SECONDS);
        for (int i = 0; i < WAIT_COUNT; i++) {
            try {
                Thread.sleep(EACH_WAIT * 1000);
                url = driver.getCurrentUrl();
            } catch (Exception e) {
                //ignore the exception
            }
            if (url.contains(urlPart)) {
                break;
            }
        }
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

}
