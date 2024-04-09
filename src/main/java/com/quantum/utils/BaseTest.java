package com.quantum.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest extends DataFetcher {

    //Setting up the Remote server url
//    URL url;
//    {
//        try {
//            url = new URL(getRemoteServerURL());
//        } catch (MalformedURLException e) {
//            throw new RuntimeException(e);
//        }
//    }

//    public static RemoteWebDriver remoteWebDriver;
    public static WebDriver localWebDriver;
    public static WebDriverWait wait;

    //Driver types for test-execution
    public static String localDriver = "local";
//    public static String remoteDriver = "remote";

    //Browser's for test-execution
    private static String safari = "safari";
    private static String chrome = "chrome";
    private static String firefox = "firefox";
    private static String edge = "edge";


    /**
     * Method to open and access the webpage for automation test
     * @param url
     */
    public void openPage(String url) throws Exception {
        getDriver().get(url);
    }

    /**
     * Launch the Automation Exercise HomePage
     */
    public void launchHomePage() throws Exception {
        openPage(getApplicationUrl());
    }

    /**
     * Method to return the created WebDriver instance - whether the tester wants to run it locally or remotely
     * @return - the webdriver instance for local or remote test execution
     */
    public WebDriver getDriver() throws Exception {
            if(localWebDriver == null) {
                setDriver();
            }
            return localWebDriver;
    }

    /**
     * Method to setup the Web driver instance for automation test
     */
    public void setDriver() throws Exception {
        Logger.logAction("Setting up the Local WebDriver for Test-Execution");
        if(getBrowser().equals(safari)){
            localWebDriver = new SafariDriver();
            localWebDriver.manage().window().maximize();
            localWebDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(getImplicitlyWait()));
        } else if(getBrowser().equals(chrome)){
            localWebDriver = new ChromeDriver();
            localWebDriver.manage().window().maximize();
            localWebDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(getImplicitlyWait()));
        } else if(getBrowser().equals(firefox)){
            localWebDriver = new FirefoxDriver();
            localWebDriver.manage().window().maximize();
            localWebDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(getImplicitlyWait()));
        } else if(getBrowser().equals(edge)){
            localWebDriver = new EdgeDriver();
            localWebDriver.manage().window().maximize();
            localWebDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(getImplicitlyWait()));
        } else {
            throw new Exception("Browser is not compatible. Please check the app-config file!!");
        }
//        if(driverType.equals("remote")){
//            Logger.logAction("Setting up the Remote driver for Test-execution");
//            if(getBrowser().equals(safari)){
//                SafariOptions options = new SafariOptions();
//                options.setPlatformName("macOS 13");
//                options.setBrowserVersion(getBrowserVersion());
//                options.setCapability("sauce:options",getSauceOptions());
//                remoteWebDriver = new RemoteWebDriver(url,options);
//                remoteWebDriver.manage().window().maximize();
//                remoteWebDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(getImplicitlyWait()));
//            } else if(getBrowser().equals(chrome)){
//                ChromeOptions options = new ChromeOptions();
//                options.setPlatformName(getPlatformName());
//                options.setBrowserVersion(getBrowserVersion());
//                options.setCapability("sauce:options",getSauceOptions());
//                remoteWebDriver = new RemoteWebDriver(url,options);
//                remoteWebDriver.manage().window().maximize();
//                remoteWebDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(getImplicitlyWait()));
//            } else if(getBrowser().equals(firefox)){
//                FirefoxOptions options = new FirefoxOptions();
//                options.setPlatformName(getPlatformName());
//                options.setBrowserVersion(getBrowserVersion());
//                options.setCapability("sauce:options",getSauceOptions());
//                remoteWebDriver = new RemoteWebDriver(url,options);
//                remoteWebDriver.manage().window().maximize();
//                remoteWebDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(getImplicitlyWait()));
//            } else if(getBrowser().equals(edge)){
//                EdgeOptions options = new EdgeOptions();
//                options.setPlatformName(getPlatformName());
//                options.setBrowserVersion(getBrowserVersion());
//                options.setCapability("sauce:options",getSauceOptions());
//                remoteWebDriver = new RemoteWebDriver(url,options);
//                remoteWebDriver.manage().window().maximize();
//                remoteWebDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(getImplicitlyWait()));
//            } else {
//                throw new Exception("Browser is not compatible. Please check the app-config file!!");
//            }
//        } else {
            //else-block for local web driver test-execution in-case when remote web-driver is also an available option
//        }

    }

    /**
     * Create the sauce labs remote driver object with specified capabilities
     * @return - the sauce labs object and pass it to the remote driver execution
     * @throws Exception
     */
//    private static Map<String, Object> getSauceOptions() throws Exception {
//        Map<String, Object> sauceOptions = new HashMap<>();
//        sauceOptions.put("username",getRemoteServerUserName());
//        sauceOptions.put("accessKey",getRemoteServerAccessKey());
//        sauceOptions.put("name",getRemoteServerTestName());
//        sauceOptions.put("build",getRemoteServerBuild());
//        return sauceOptions;
//    }

    /**
     * Method to quit the WebDriver instance after completion of automation test
     */
    public void closeTheDriver() throws Exception {
        Logger.logAction("Closing the Local Web Driver");
        if(localWebDriver != null){
            localWebDriver.quit();
        }
    }

}
