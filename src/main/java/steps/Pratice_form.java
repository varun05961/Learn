package steps;

import demoqa.Practice_form;
import demoqa.praframe;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import methods.Practice_formOR;

public class Pratice_form {

@Given("User is able to launch google chrome browser in window {int}.")
public void user_is_able_to_launch_google_chrome_browser_in_window(Integer int1) {
    
    
}

@Given("Enter Url {string}")
public void enter_url(String lauch_browser) throws InterruptedException {
    
    Practice_form.launchBrowser();
}

@When("user enter {string} , {string} , {string}")
public void user_enter(String firstname, String Lastname, String Email, io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
    
    Practice_form.enterdata();
}

@When("click on gender as {string}")
public void click_on_gender_as(String gender) {
    Practice_form.gender();
    
}

@When("Enter mobile number as\"\"")
public void enter_mobile_number_as() throws InterruptedException {
	Practice_form.Phonenumber();
    
    
}

@When("Enter {string},{string},{string} and {string}")
public void enter_and(String subject, String hobbies, String datepicker, String address) throws InterruptedException {
    Practice_form.subject_dropdown();
    Practice_form.hobbies();
    Practice_form.datepicker();
    Practice_form.address();
    
}

@When("Upload the picture")
public void upload_the_picture() throws InterruptedException {
    
    Practice_form.upload_image();
}

@When("Select state as {string} and city as {string}")
public void select_state_as_and_city_as(String state, String city) throws InterruptedException {
    
    Practice_form.dropdown();
}

@When("Click on {string} button")
public void click_on_button(String submit) {
    
    Practice_form.submit();
}

@Then("User should register successfully in the portal.")
public void user_should_register_successfully_in_the_portal() {
    
    

	
}
}