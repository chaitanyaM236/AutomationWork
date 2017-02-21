package com.easytox.automation.driver;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = { "pretty", "html:target/features" },
        features = "classpath:features/Choosefile.feature"
		)
public class BmtechRunner {

}
