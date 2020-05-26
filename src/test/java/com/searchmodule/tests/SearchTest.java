package com.searchmodule.tests;

import com.searchmodule.pages.SearchPage;
import com.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    @Parameters({"searchKeyword"})
    public void searchTestDemo(String searchKeyword){
        SearchPage searchPage = new SearchPage(driver);
        searchPage.goToDuckDuck();
        searchPage.doSearch(searchKeyword);
        searchPage.goToVideo();
        Assert.assertTrue(searchPage.getResult() > 10);
    }
}
