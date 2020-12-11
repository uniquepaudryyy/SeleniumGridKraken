package test.Login;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.net.MalformedURLException;

public class Login {


    @Steps
    LoginSteps loginSteps;

    @Given("I already open sentinel login page on ([^\"]*)")
    public void already_on_sentinel_login_page(String browser) throws MalformedURLException{
        loginSteps.launch_browser(browser);
    }

    @When("I input username")
    public void input_username(){
        loginSteps.input_username();
    }

    @When("I input password")
    public void input_password(){
        loginSteps.input_password();
    }

    @When("I click login button")
    public void click_login_button(){
        loginSteps.click_login_button();
    }

    @Then("Login success")
    public void login_success(){
        loginSteps.login_success();
        loginSteps.close_browser();
    }
}