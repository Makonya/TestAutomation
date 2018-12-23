package com.test;

import com.test.pages.ResultPage;
import com.test.pages.SearchPage;
import com.test.pages.WebSite;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverSettings {
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;
    protected WebSite webSite;
    protected SearchPage searchPage;
    protected ResultPage resultPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src//main//resources//drivers//chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriverWait = new WebDriverWait(webDriver, 30, 500);
        webSite = new WebSite(webDriver, webDriverWait);
        searchPage = webSite.getSearchPage();
        resultPage = webSite.getResultPage();
        webDriver.get("https://www.google.com/");
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("viewport")));

    }

    @After
    public void tearDown() {
        if (webDriver != null) {
            webDriver.close();
        }
    }
}
