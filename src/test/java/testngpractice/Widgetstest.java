package testngpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Widgetstest {

    WebDriver driver;

    @BeforeTest
    public void beforetest() {
        WebDriverManager.chromedriver().clearDriverCache().driverVersion("").setup();
        ChromeOptions ops = new ChromeOptions();
        String downloadFilepath = "C:\\Users\\Rupak\\Desktop\\Course\\java_projects\\java_work\\src\\test\\java\\resources";

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadFilepath);
        prefs.put("download.prompt_for_download", false);  // Automatically download files without asking
        prefs.put("download.directory_upgrade", true);
        prefs.put("safebrowsing.enabled", true);  // To avoid the "Keep file" prompt for certain files
        prefs.put("profile.default_content_settings.popups", 0);

        ops.setExperimentalOption("prefs", prefs);
        ops.addArguments("--disable-notifications");
        ops.addArguments("--remote-allow-origins=*");
        ops.addArguments("--start-maximized");
//        ops.addArguments("--incognito");
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

//    @Test
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

//    @Test
    public void test_dynamic_elements() throws InterruptedException {
        driver.get("https://demoqa.com/dynamic-properties");
        WebElement button = driver.findElement(By.xpath("//button[@id='enableAfter']"));
        WebElement button2 = driver.findElement(By.xpath("//button[@id='visibleAfter']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(button));

        wait.until(ExpectedConditions.visibilityOf(button2));


    }


    @Test
    public void test_autocomplete() throws InterruptedException {
        driver.get("https://jqueryui.com/autocomplete/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id='tags']")).sendKeys("C");

        String texttobeclicked = "Clojure";
        WebElement autooptions  = driver.findElement(By.id("ui-id-1"));

        try {
            wait.until(ExpectedConditions.visibilityOf(autooptions));
        } catch (TimeoutException e) {
            System.out.println("No element present with the character");
        }

        List<WebElement> alloptions = autooptions.findElements(By.tagName("li"));


        for (WebElement option : alloptions) {
            if (option.getText().equals(texttobeclicked)) {
                option.click();
                break;
            }
        }


        Thread.sleep(3000);

    }

    @Test
    public void test_download() throws InterruptedException {
        driver.get("https://demoqa.com/upload-download");

        WebElement button = driver.findElement(By.xpath("//a[@id='downloadButton']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(button));

        button.click();

        Thread.sleep(5000);

    }

    @Test
    public void openHRM_add_user() throws InterruptedException {
        String user_role_to_be_select = "ESS";
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/saveSystemUser");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        driver.findElement(By.xpath("//label[contains(text(),'User Role')]/../following-sibling::div")).click();

        Actions act = new Actions(driver);
        while (true){
            act.sendKeys(Keys.DOWN).perform();
            Thread.sleep(500);
            String userroleselected = driver.findElement(By.xpath("//label[contains(text(),'User Role')]/../following-sibling::div//div[@role='option' and contains(@class, 'select-option --focused')]")).getText();
            if (userroleselected.equals(user_role_to_be_select)){
                act.sendKeys(Keys.ENTER).perform();
                break;
            }
        }
    }

    @Test(priority = 2)
    public void test_select_class() throws Exception {
        driver.get("https://demoqa.com/select-menu");

        WebElement selectcolor = driver.findElement(By.xpath("//select[@id='oldSelectMenu']"));

        Select se = new Select(selectcolor);

        //se.selectByIndex(1);
        se.selectByVisibleText("Yellow");
        //se.selectByValue("Red");


        //se.deselectAll();
    }

    @Test(priority = -11)
    public void test_alerts() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");

        driver.findElement(By.xpath("//button[@id='alertButton']")).click();

        Thread.sleep(1000);
        System.out.println(driver.switchTo().alert().getText());

//        driver.switchTo().alert().dismiss();
        driver.switchTo().alert().accept();

    }

    @Test
    public void hover_test() throws InterruptedException {
        driver.get("https://www.spicejet.com/");
        Actions actions = new Actions(driver);
        WebElement spicejet = driver.findElement(By.xpath("(//div[text()='SpiceClub'])[1]"));
        actions.moveToElement(spicejet).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href,'undefined/home#benefits')]")));

        WebElement homeprogram = driver.findElement(By.xpath("//a[contains(@href,'undefined/home#benefits')]"));

        String targetattr = homeprogram.getAttribute("target");

        if (targetattr.equals("_blank")) {
            Assert.assertTrue(true);
        } else {
            Assert.fail("Link Our Program has no attribute _blank");
        }

        homeprogram.click();

        Thread.sleep(4000);

        actions.keyDown(Keys.CONTROL).keyDown(Keys.TAB).build().perform();


    }

    @Test
    public void open_in_new_link_test() {
        try {
            driver.get("https://www.tutorialspoint.com/about/about_careers.htm");
            String term = Keys.chord(Keys.CONTROL, Keys.ENTER);
            driver.findElement(By.xpath("//a[text()='Terms of Use']")).sendKeys(term);

            Thread.sleep(1000);


            List<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));

            String title = driver.getTitle();

            if (title.equals("Terms of Use")) {
                Assert.assertTrue(true);
            } else {
                Assert.fail("Landed in wrong tab");
            }

//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='search-strings']")));
//
//            driver.findElement(By.xpath("//input[@id='search-strings']")).sendKeys("hhgj");
        } catch (InterruptedException e) {
            System.out.println("");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println();
        }
    }

    @Test
    public void test_new_window() {
        driver.get("https://demoqa.com/browser-windows");
        String currentwindowid = driver.getWindowHandle();
        driver.findElement(By.xpath("//button[@id='windowButton']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        for (String allwindow : driver.getWindowHandles()) {
            if (!currentwindowid.contentEquals(allwindow)) {
                driver.switchTo().window(allwindow);
                break;
            }
        }

        String urlofnewwindow = driver.getCurrentUrl();
        if (urlofnewwindow.contains("https://demoqa.com/sample")) {
            Assert.assertTrue(true);
        } else {
            Assert.fail("URL of child window is different");
        }

    }

    @Test
    public void test_scroll() throws InterruptedException {
        driver.get("https://www.tutorialspoint.com/index.htm");
        WebElement element = driver.findElement(By.xpath("//*[text()='ABOUT US']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",element);
        Thread.sleep(3000);
        driver.close();
    }





//    @AfterTest
//    public void aftertest() {
//        driver.quit();
//    }

}
