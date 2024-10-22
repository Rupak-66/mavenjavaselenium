package testngpractice.stepdefinations;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import testngpractice.utils.Staticinstances;

public class Saucedemostepdef {

    @Given("User goes to saucedemo website")
    public void user_goes_to_saucedemo_website() {
        Staticinstances.sbc.getDriver().get("https://www.saucedemo.com/");
    }
    @When("User enters username {string}")
    public void user_enters_username(String username) {
        Staticinstances.sbc.getDriver().findElement(By.id("user-name")).sendKeys(username);
    }
    @When("User enters  password {string}")
    public void user_enters_password(String password) {
        Staticinstances.sbc.getDriver().findElement(By.id("password")).sendKeys(password);
    }
    @Then("User should be able to login")
    public void user_should_be_able_to_login() {
        Staticinstances.sbc.getDriver().findElement(By.cssSelector("input[id='login-button']")).click();

        String product = Staticinstances.sbc.getDriver().findElement(By.xpath("//span[@data-test='title']")).getText();
        if (product.contains("Products")){
            Assert.assertTrue(true);
        }
        else {
            Assert.fail("Products banner is not present");
        }
    }
}
