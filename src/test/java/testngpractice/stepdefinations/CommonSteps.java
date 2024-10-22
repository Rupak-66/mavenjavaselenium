package testngpractice.stepdefinations;

import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import testngpractice.utils.Browserclass;
import testngpractice.utils.Staticinstances;

public class CommonSteps {

    @BeforeAll
    public static void setup() {
        Staticinstances.sbc = Browserclass.getInstanceOfSingletonBrowserClass();
    }

    @Before
    public static void beforetest() {
    }

    @BeforeStep
    public static void beforestep(Scenario scenario) {
    }

    @AfterStep
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){
            System.out.println("Scenario "+scenario.getName()+" is failed");
//            final byte[] screenshot = ((TakesScreenshot) StaticInstances.sbc).getScreenshotAs(OutputType.BYTES);
//            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }

    @After
    public static void aftertest() {
    }

    @AfterAll
    public static void teardown(){
        Staticinstances.sbc.getDriver().quit();
    }


}
