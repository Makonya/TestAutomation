package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ResultPage {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    public ResultPage(WebDriver webDriver, WebDriverWait webDriverWait) {
        this.webDriver = webDriver;
        this.webDriverWait = webDriverWait;
        PageFactory.initElements(webDriver, this);
    }

    public List<WebElement> getResultsOfSearch() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("rcnt")));
        List<WebElement> elements = webDriver.findElements(By.className("LC20lb"));
        return elements;
    }

    public String getPageTitle() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("gsr")));
        return webDriver.getTitle();
    }
}
