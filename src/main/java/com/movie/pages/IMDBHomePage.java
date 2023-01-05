package com.movie.pages;

import com.movie.base.MovieBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IMDBHomePage extends MovieBase {
    public String movieName = properties.getProperty("movieName");
    public String imdbSearchOptionXPath = "//li[contains(@id,react-autowhatever-1--)]/a/div"
            + "/div[contains(text(), '" + movieName + "')]";

    public IMDBSearchResultPage searchMovieOnImdb() throws InterruptedException {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(properties.getProperty("imdbUrl"));

        WebElement imdbSearchEditField = driver.findElement(By.id("suggestion-search"));
        imdbSearchEditField.sendKeys(movieName);
        Thread.sleep(2000);
        WebElement imdbSearchOption;
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        imdbSearchOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(imdbSearchOptionXPath)));
        imdbSearchOption.click();

        return new IMDBSearchResultPage();
    }
}
