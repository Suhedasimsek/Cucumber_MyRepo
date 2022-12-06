package com.krafttech.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (
        features="src/test/resources/features",
        glue = "com/krafttech/step_definitions",
       // dryRun = true// sadece undefined stepleri almak istiyosak kullanırız.Java kodları çalıştırmaz.
        dryRun = false,
        tags = "@Start"
)
public class CukesRunner {
}
