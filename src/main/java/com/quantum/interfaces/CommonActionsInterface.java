package com.quantum.interfaces;

import org.openqa.selenium.By;

public interface CommonActionsInterface {

    void verifyIfTheHomePageIsDisplayed() throws Exception;

    /**
     * Verify Text by given locator and expected Text on UI
     */
    void verifyTextByLocatorAndExpectedText(By locator, String expectedText) throws Exception;

    /**
     * Enter the details on an input field
     */
    void enterTheDetailsOnInputField(By inputFieldLocator, String detail) throws Exception;

    /**
     * Wait until element is displayed on screen
     */
    void waitUntilElementIsDisplayed(By locator, int timeToWaitInSeconds) throws Exception;

    /**
     * Wait until element becomes clickable on UI
     */
    void waitUntilElementIsClickable(By locator, int secondsToWait) throws Exception;

    /**
     * Perform force Click using JavaScript executor
     */
    void performForceClickUsingJS(By locator, boolean scrollToElement) throws Exception;

    /**
     * Click on an element present on UI
     *
     * @param locator         - locator of the element that needs a click
     * @param scrollToElement
     * @throws Exception
     */
    void scrollAndClickElement(By locator, boolean scrollToElement) throws Exception;

    /**
     * Method to select a dropdown value based on index
     * @param dropdownLocator - locator of the dropdown webelement
     * @param index - dropdown value that is to be selected based on index
     * @throws Exception
     */
    void selectDropdownValueByIndex(By dropdownLocator, int index) throws Exception;

    /**
     * Method to get a value of a selected dropdown option
     * @param dropdownLocator - locator of the dropdown
     * @param index - index of the option value that needs to be extracted
     * @throws Exception
     */
    String getValueOfOptionFromDropdown(By dropdownLocator, int index) throws Exception;

    /**
     * Refresh the browser page
     */
    void refreshTheBrowserPage() throws Exception;

    /**
     * Launch the URL in a new Browser Instance
     */
    void launchURLInANewTab(String url) throws Exception;
}
