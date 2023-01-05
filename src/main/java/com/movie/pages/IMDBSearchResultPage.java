package com.movie.pages;

import com.movie.base.MovieBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class IMDBSearchResultPage extends MovieBase {
    public String validateImdbReleaseDate() {
        WebElement imdbReleaseDateElement = driver.findElement(By.xpath("//a[@class=" +
                "'ipc-metadata-list-item__label ipc-metadata-list-item__label--link' " +
                "and text()='Release date']/following-sibling::div/ul/li/a"));
        String imdbReleaseDate = imdbReleaseDateElement.getText();
        imdbReleaseDate = imdbReleaseDate.replace(",", "");
        String[] imdbDateArray = imdbReleaseDate.split("\\s+");
        imdbReleaseDate = imdbDateArray[1] + " " + imdbDateArray[0] + " " + imdbDateArray[2];
        return imdbReleaseDate;
    }

    public String validateImdbCountry() {
        WebElement imdbCountryElement = driver.findElement(By.xpath("//button[@class=" +
                "'ipc-metadata-list-item__label' and text()='Country of origin']/following-sibling::div/ul/li/a"));
        return imdbCountryElement.getText();
    }
}
