package com.movie.pages;

import com.movie.base.MovieBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WikipediaHomePage extends MovieBase {

    public String movieName = properties.getProperty("movieName");
    public String wikiSearchOptionXPath = "//a[@class='suggestion-link']/div/h3[contains(text(), '" + movieName +
            "')]//following-sibling::p[contains(text(), 'film')]";

    public WikipediaSearchResultPage searchMovieOnWikipedia() throws InterruptedException {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(properties.getProperty("wikipediaUrl"));

        WebElement wikipediaSearchEditField = driver.findElement(By.id("searchInput"));
        wikipediaSearchEditField.sendKeys(movieName);

        WebElement wikipediaSearchOption;
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wikipediaSearchOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(wikiSearchOptionXPath)));
        wikipediaSearchOption.click();

        return new WikipediaSearchResultPage();
    }
}
