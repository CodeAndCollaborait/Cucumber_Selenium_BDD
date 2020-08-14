package stepdefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.CucumberRunner;
import org.openqa.selenium.By;
import static org.testng.Assert.*;

public class LoginPageTest extends CucumberRunner {
  
  @Given("^system open the browser and enter the website name$")
  public void system_open_the_browser_and_enter_the_website_name()  {
    
    driver.get("https://opensource-demo.orangehrmlive.com/");
  }
  
  @When("^website has opened successfully$")
  public void website_has_opened_successfully()  {
  
    String url = driver.getCurrentUrl();
    assertEquals(url,"https://opensource-demo.orangehrmlive.com/" );
  }
  
  @Then("^verify that website url name and page title are as expected$")
  public void verify_that_website_url_name_and_page_title_are_as_expected() {
     String pageTitle = driver.getTitle();
     assertEquals(pageTitle, "OrangeHRM");
  }
  
  @Then("^verify that website homepage has username box$")
  public void verify_that_website_homepage_has_username_box() {
  
    String userName = driver.findElement(By.id("txtUsername")).getAttribute("id");
    assertEquals(userName, "txtUsername");
  }
  
  @Then("^website page has password box$")
  public void website_page_has_password_box() {
    String passWord = driver.findElement(By.id("txtPassword")).getAttribute("id");
    assertEquals(passWord, "txtPassword");
  
  }
  
  @Then("^website page has login button$")
  public void website_page_has_login_button() {
    String loginButton = driver.findElement(By.id("btnLogin")).getAttribute("id");
    assertEquals(loginButton, "btnLogin");
    
  
  }
  
  @When("^user enters the correct username value$")
  public void user_enters_the_correct_username_value()  {
    driver.findElement(By.id("txtUsername")).sendKeys("Admin");
  }
  
  @When("^user enters the correct password value$")
  public void user_enters_the_correct_password_value()  {
    driver.findElement(By.id("txtPassword")).sendKeys("admin123");
  
  }
  
  @When("^click the login button$")
  public void click_the_login_button()  {
    driver.findElement(By.id("btnLogin")).click();
  }
  
  @Then("^user should be redirected to dashboard page\\.$")
  public void user_should_be_redirected_to_dashboard_page() {
   String dashboardPage =  driver.getCurrentUrl();
   assertEquals(dashboardPage,"https://opensource-demo.orangehrmlive.com/index.php/dashboard");
  }
  
  @When("^user enters no password$")
  public void user_enters_no_password()  {
    driver.findElement(By.id("txtPassword")).clear();
  
  }
  
  @Then("^user is unable to login$")
  public void user_is_unable_to_login()  {
    String url = driver.getCurrentUrl();
    assertEquals(url,"https://opensource-demo.orangehrmlive.com/" );
 
  }
  
  @Then("^a \"([^\"]*)\" error message is shown$")
  public void a_error_message_is_shown(String message)  {
    
    String errorMessage = driver.findElement(By.id("spanMessage")).getText();
//    System.out.println(errorMessage);
    assertEquals(errorMessage, message);
   
  }
  
  @When("^user enters no username$")
  public void user_enters_no_username()  {
   driver.findElement(By.id("txtUsername")).clear();
  }
  
  @When("^user enters invalid username such as \"([^\"]*)\"$")
  public void user_enters_invalid_username_such_as(String usernames)  {
    System.out.println(usernames);
    driver.findElement(By.id("txtUsername")).sendKeys(usernames);
    
  }
  
  @When("^user enters invalid password such as \"([^\"]*)\"$")
  public void user_enters_invalid_password_such_as(String passwords)  {
    System.out.println(passwords);
    driver.findElement(By.id("txtPassword")).sendKeys(passwords);
   
  }
  
  
  @And("^an \"([^\"]*)\" error message is shown$")
  public void anErrorMessageIsShown(String message) throws InterruptedException {
    String errorMessage = driver.findElement(By.id("spanMessage")).getText();
   System.out.println(errorMessage);
    assertEquals(errorMessage, message);
    Thread.sleep(3000);
    driver.navigate().back();
   
  }
}
