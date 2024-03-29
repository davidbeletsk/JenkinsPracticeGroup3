package com.loop.step_definitions;

import com.loop.utilities.utilities.BrowserUtilities;
import com.loop.utilities.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {

        private static final Logger LOG = LogManager.getLogger();

        @Before
        public void setUp(Scenario scenario) throws Throwable{
            Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);;
            BrowserUtilities.myScenario = scenario;
            LOG.info("..........START AUTOMATION.........LOOP ACADEMY");

        }

        @After
        public void tearDown(Scenario scenario){
            // only takes a screenshot when scenario is failed
            if(scenario.isFailed()){
                final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
            }
            Driver.closeDriver();
            LOG.info("..........END AUTOMATION.........LOOP ACADEMY");
        }

        // @AfterStep
        public void screenShot(Scenario scenario){
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }

