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
}
