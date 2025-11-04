package com.eurotech.runners;

import io.cucumber.core.backend.CucumberBackendException;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",                     // creates json file, used to make reports - json = data storage language
        "html:target/default-html-reports.html",                    // creates HTML report
        "rerun:target/rerun.txt"
        },


        features = "src/test/resources/Features",     // path of Feature folder
        glue = "com/eurotech/step_definitions",       // path of step definitions folder
        dryRun = false,
        tags = "@WIP"                                // must be changed each time  // use WIP for tests being developed. Can also tag by environment
                                                     // "@Login and @Developer"    // run scenarios that match both
                                                     //"@Sanity and not @Teacher"  // exclude certain cases from a selection
        // must be changed each time // use WIP for tests being developed. Can also tag by environment
)
public class CukesRunner {

}
