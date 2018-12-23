package com.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebSite {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    public WebSite(WebDriver webDriver, WebDriverWait webDriverWait) {
        this.webDriver = webDriver;
        this.webDriverWait = webDriverWait;

        PageFactory.initElements(webDriver, this);
    }

    public SearchPage getSearchPage() {
        return new SearchPage(webDriver, webDriverWait);
    }

    public ResultPage getResultPage() {
        return new ResultPage(webDriver, webDriverWait);
    }
}
