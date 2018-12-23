package com.test.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    @FindBy(css = ".gLFyf.gsfi")
    WebElement searchInputField;

    public SearchPage(WebDriver webDriver, WebDriverWait webDriverWait) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void enterSearchText(String text) {
        searchInputField.clear();
        searchInputField.sendKeys(text);
    }

    public void clickEnterButton() {
        searchInputField.sendKeys(Keys.RETURN);
    }

    public void clearSearchInputField() {
        searchInputField.clear();
    }
}
