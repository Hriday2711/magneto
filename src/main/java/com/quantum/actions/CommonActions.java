package com.quantum.actions;

import com.quantum.interfaces.CommonActionsInterface;
import com.quantum.utils.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonActions extends PageObject implements CommonActionsInterface {
    @Override
    public void verifyIfTheHomePageIsDisplayed() throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
