package com.movie.pages;

import com.movie.base.MovieBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WikipediaSearchResultPage extends MovieBase {
    public String validateWikipediaReleaseDate() {
        WebElement wikipediaReleaseDateElement = driver.findElement(By.xpath("//th[@class=" +
                "'infobox-label']/div[text()='Release date']/parent::th/following-sibling::td/div/ul/li"));
        return wikipediaReleaseDateElement.getText();
    }

    public String validateWikipediaCountry() {
        WebElement wikipediaCountryElement = driver.findElement(By.xpath("//th[@class=" +
                "'infobox-label' and text()='Country']/following-sibling::td"));
        return wikipediaCountryElement.getText();
    }


}
