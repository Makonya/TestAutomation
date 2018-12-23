package com.test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchTest extends WebDriverSettings {
    private static final String SEARCH_STRING = "Programming";

    /*
     * Тест проверяет возможность поиска с пустым запросом
     */
    @Test
    public void testEmptyRequest() {
        searchPage.clearSearchInputField();
        searchPage.clickEnterButton();
        Assert.assertEquals(webDriver.getCurrentUrl(), MAIN_PAGE_URL);
    }

    /*
     * Тест проверяет наличие заданой подстроки в заголовке страницы с результатами,
     * после осуществления запроса
     */
    @Test
    public void testTitleAfterSearch() {
        searchPage.clearSearchInputField();
        searchPage.enterSearchText(SEARCH_STRING);
        searchPage.clickEnterButton();
        Assert.assertTrue(resultPage.getPageTitle().contains("Поиск в Google"));
    }

    /*
     * Тест проверяет количество результатов выданных(<5), по заданному запросу
     */
    @Test
    public void testCountOfSearchResults() {
        searchPage.clearSearchInputField();
        searchPage.enterSearchText(SEARCH_STRING);
        searchPage.clickEnterButton();
        Assert.assertTrue(resultPage.getResultsOfSearch().size() > 5);
    }

    /*
     * Тест проверяет возможность перехода по выданным результатам поиска,
     * проверяется кликабельность ссылок всех результатов
     */
    @Test
    public void testLinksOfSearchResults() {
        searchPage.clearSearchInputField();
        searchPage.enterSearchText(SEARCH_STRING);
        searchPage.clickEnterButton();
        for (int i = 0; i < resultPage.getResultsOfSearch().size(); i++) {
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("rcnt")));
            resultPage.getResultsOfSearch().get(i).findElement(By.xpath("..")).click();
            webDriver.navigate().back();
        }
    }
}
