package testngpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Widgetstest {

    WebDriver driver;

    @BeforeTest
    public void beforetest() {
        WebDriverManager.chromedriver().clearDriverCache().driverVersion("").setup();
        ChromeOptions ops = new ChromeOptions();

        ops.addArguments("--remote-allow-origins=*");
        ops.addArguments("--start-maximized");
        ops.addArguments("--incognito");
        ops.setExperimentalOption("useAutomationExtension", false);
        ops.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        driver = new ChromeDriver(ops);
        //implicit wait
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

    }


    @Test
    public void test_drag_and_drop() throws InterruptedException {
        driver.get("https://demoqa.com/droppable");
        Actions actions = new Actions(driver);

        WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));

        WebElement drop = driver.findElement(By.xpath("//div[@id='draggable']/following-sibling::div"));

        //actions.clickAndHold(drag).moveToElement(drop).release(drop).build().perform();

        actions.dragAndDrop(drag, drop).perform();

    }

    @Test
    public void test_button_color() throws InterruptedException {
        driver.get("https://demoqa.com/dynamic-properties");
        WebElement button = driver.findElement(By.xpath("//button[@id='colorChange']"));
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(button));

        String colorbefore = button.getCssValue("color");
        System.out.println(colorbefore);

        button.click();

        Thread.sleep(2000);

        String colorafter = button.getCssValue("color");
        System.out.println(colorafter);

        assert !Objects.equals(colorbefore, colorafter);
    }


    @Test
    public void test_sliders() throws InterruptedException {
        driver.get("https://demoqa.com/slider");
        Actions actions = new Actions(driver);
        WebElement slider = driver.findElement(By.xpath("//input[contains(@class,'range-slider')]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(slider));

        actions.click(slider).build().perform();

        for (int i = 0; i < 5; i++) {
            actions.sendKeys(Keys.ARROW_RIGHT).build().perform();
            Thread.sleep(500);
        }

    }

    @AfterTest
    public void aftertest() {
        driver.quit();
    }

}
