package testngpractice.stepdefinations;

import io.cucumber.java.en.*;

public class Teststepdef {

    @Given("User print their favorite fruit name")
    public void user_print_their_favorite_fruit_name() {
        System.out.println("apple");
    }
    @When("User starts writing the name")
    public void user_starts_writing_the_name() {
        System.out.println("apple");
    }
    @Then("They completes the statement")
    public void they_completes_the_statement() {
        System.out.println("apple");
    }

    @Given("User Enters positive username")
    public void user_enters_positive_username() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("User enters postive password")
    public void user_enters_postive_password() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user clicks on Login button")
    public void user_clicks_on_login_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("user should be able to see dashboard")
    public void user_should_be_able_to_see_dashboard() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
