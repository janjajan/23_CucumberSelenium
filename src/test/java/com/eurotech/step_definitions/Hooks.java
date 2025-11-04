package com.eurotech.step_definitions;

import com.eurotech.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;

public class Hooks {                          // similar to TestBase

    @Before
    public void setup(){
        Driver.get().manage().window().maximize();
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("*** This is coming from before ***");
    }

    @After
    public void tearDown(Scenario scenario){

        if (scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }

        System.out.println("*** This is coming from after ***");
        Driver.closeDriver();
    }

    @Before("@db")
    public void setupDatabase(){
        System.out.println("Database starting");
    }

    @After("@db")
    public void closeDb(){
        System.out.println("Closing Database");
    }
}
