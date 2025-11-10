package com.eurotech.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class Driver {

    private Driver() {
    }
    // InheritableThreadLocal  --> this is like a container, bag, pool.
    // in this pool we can have separate objects for each thread
    // for each thread, in InheritableThreadLocal we can have separate object for that thread
    // driver class will provide separate webdriver object per thread
    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();
    public static WebDriver get(){
        //if this thread doesn't have driver - create it and add to pool
        if (driverPool.get() == null) {
//            if we pass the driver from terminal then use that one
//           if we do not pass the driver from terminal then use the one properties file
            String browser = System.getProperty("browser") != null ? browser = System.getProperty("browser") : ConfigurationReader.get("browser");
            switch (browser) {
                case "chrome":

                    driverPool.set(new ChromeDriver());
                    break;
                case "chrome-headless":
                    ChromeOptions chromeHeadlessOptions = new ChromeOptions();
                    chromeHeadlessOptions.addArguments("--headless"); // Enables headless mode
                    chromeHeadlessOptions.addArguments("--disable-gpu"); // Optional: Improves compatibility on Windows
                    driverPool.set(new ChromeDriver(chromeHeadlessOptions));
                    break;
                case "firefox":

                    driverPool.set(new FirefoxDriver());
                    break;

                case "firefox-headless":
                    FirefoxOptions firefoxHeadlessOptions = new FirefoxOptions();
                    firefoxHeadlessOptions.addArguments("--headless"); // Enables headless mode
                    driverPool.set(new FirefoxDriver(firefoxHeadlessOptions));
                    break;
                case "ie":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("Your OS doesn't support Internet Explorer");

                    driverPool.set(new InternetExplorerDriver());
                    break;
                case "edge":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("Your OS doesn't support Edge");

                    driverPool.set(new EdgeDriver());
                    break;
                case "safari":
                    if (!System.getProperty("os.name").toLowerCase().contains("mac"))
                        throw new WebDriverException("Your OS doesn't support Safari");

                    driverPool.set(new SafariDriver());
                    break;

                case "remote_chrome":
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*","--start-maximized");

                    try {

                        String hubUrl = ConfigurationReader.get("hub_url");
                        driverPool.set(new RemoteWebDriver(new URL(hubUrl), options));
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case "remote_firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    try {
                        //  driverPool.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),chromeOptions));
                        driverPool.set(new RemoteWebDriver(new URL("http://35.178.166.162:4444/wd/hub"), firefoxOptions));

                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
            }
        }

        return driverPool.get();
    }
    public static void closeDriver() {
        driverPool.get().quit();
        driverPool.remove();
    }

}