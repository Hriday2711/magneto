package runner;

import com.quantum.utils.BaseTest;
import io.cucumber.java.*;
import io.cucumber.testng.*;
import org.testng.*;
import org.testng.annotations.*;
import org.testng.xml.XmlTest;

import java.util.Objects;

@CucumberOptions(features = "src/test/resources/features/", glue = "com.quantum.steps",
        plugin = {"json:target/cucumber.json",
                "html:target/cucumber.html",})
public class CucumberRunner extends AbstractTestNGCucumberTests {

    Scenario scenario;
    private static TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass(ITestContext context) {
        XmlTest currentXmlTest = context.getCurrentXmlTest();
        Objects.requireNonNull(currentXmlTest);
        CucumberPropertiesProvider properties = currentXmlTest::getParameter;
        this.testNGCucumberRunner = new TestNGCucumberRunner(this.getClass(), properties);
    }

    @Test(description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        this.testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }
    @DataProvider
    public Object[][] scenarios(){
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        BaseTest baseTest = new BaseTest();
//        baseTest.closeTheDriver(DataFetcher.getDriverType());
        testNGCucumberRunner.finish();
    }
}
