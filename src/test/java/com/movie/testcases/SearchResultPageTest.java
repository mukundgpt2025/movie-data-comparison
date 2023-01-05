package com.movie.testcases;

import com.movie.base.MovieBase;
import com.movie.pages.IMDBHomePage;
import com.movie.pages.IMDBSearchResultPage;
import com.movie.pages.WikipediaHomePage;
import com.movie.pages.WikipediaSearchResultPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchResultPageTest extends MovieBase {
    WikipediaHomePage wikipediaHomePage;
    IMDBHomePage imdbHomePage;
    WikipediaSearchResultPage wikipediaSearchResultPage;
    IMDBSearchResultPage imdbSearchResultPage;

    String wikipediaMovieReleaseDate, imdbMovieReleaseDate, wikipediaMovieCountry, imdbMovieCountry;

    public SearchResultPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        wikipediaHomePage = new WikipediaHomePage();
        imdbHomePage = new IMDBHomePage();
    }

    @Test
    public void movieDataComparisonTest() throws InterruptedException {
        wikipediaSearchResultPage = wikipediaHomePage.searchMovieOnWikipedia();
        wikipediaMovieReleaseDate = wikipediaSearchResultPage.validateWikipediaReleaseDate();
        wikipediaMovieCountry = wikipediaSearchResultPage.validateWikipediaCountry();

        imdbSearchResultPage = imdbHomePage.searchMovieOnImdb();
        imdbMovieReleaseDate = imdbSearchResultPage.validateImdbReleaseDate();
        imdbMovieCountry = imdbSearchResultPage.validateImdbCountry();

        Assert.assertEquals(wikipediaMovieReleaseDate, imdbMovieReleaseDate);
        Assert.assertEquals(wikipediaMovieCountry, imdbMovieCountry);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
