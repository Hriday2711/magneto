package com.quantum.steps;

import com.quantum.utils.PageObject;
import io.cucumber.java.en.And;
import org.testng.annotations.Test;

public class CommonActionSteps extends PageObject {

    @Test
    @And("Home Page - Verify Home page is displayed")
    public void verifyIfTheHomePageIsDisplayed() throws Exception {
        System.out.println("Navigating to the Home page");
        commonActions.verifyIfTheHomePageIsDisplayed();
    }
}
