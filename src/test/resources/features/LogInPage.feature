
Feature: Test Orange HRM home and Login page

# 1. Open website in any browser and and web site opened successfully
# 2. verify that there is username, password and login button element is there
# 3. verify that if you enter when enter correct username and password and click login button then website direct to dashboard
# 4. Verify that what happened when you only enter username and click login button
# 5. Verify that what happened when you enters only correct password with username and click the login button
# 6. Verify that you when you enter invalid username and password and click the login button
# 7. Verify that forgot the password  link and provide your user name?


  Scenario: Verify that website has opened successfully in given browser
    Given  system open the browser and enter the website name
    When   website has opened successfully
    Then   verify that website url name and page title are as expected
#
#
  Scenario: Verify that website page has username,password and login button features
    Given  system open the browser and enter the website name
    When   website has opened successfully
    Then   verify that website homepage has username box
    And    website page has password box
    And    website page has login button

  Scenario: Verify what happens when user enters only username and click login button
    Given system open the browser and enter the website name
    When   website has opened successfully
    And   user enters the correct username value
    And  user enters no password
    And click the login button
    Then user is unable to login
    And a "Password cannot be empty" error message is shown

  Scenario: Verify what happens when entering only password and click login button
    Given system open the browser and enter the website name
    When website has opened successfully
    And user enters no username
    And user enters the correct password value
    And click the login button
    Then user is unable to login
    And  a "Username cannot be empty" error message is shown


  Scenario Outline: Verify what happens when entering incorrect username and password and click login button
    Given system open the browser and enter the website name
    When website has opened successfully
    And user enters invalid username such as <usernames>
    And user enters invalid password such as <passwords>
    And click the login button
    Then an "Invalid credentials" error message is shown
    Examples:
      | usernames   | passwords      |
      | "testuser"  |  "test123"     |
      | "userOne"   |  "password123" |
      | "testTwo"   |  "testtwo123"  |

  Scenario: Verify the correct username and password
    Given  system open the browser and enter the website name
    When   website has opened successfully
    And    user enters the correct username value
    And    user enters the correct password value
    And    click the login button
    Then   user should be redirected to dashboard page.















