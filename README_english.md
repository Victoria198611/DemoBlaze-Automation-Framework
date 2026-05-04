DemoBlaze Automation Framework (English Version)

DemoBlaze Automation Framework
End to end UI automation framework for testing the DemoBlaze web application, built using Java + Selenium WebDriver + TestNG, with Allure reporting and a CI/CD pipeline in GitHub Actions.

Technologies Used:
•	Java 
•	Selenium WebDriver 
•	TestNG 
•	WebDriverManager 
•	Allure TestNG + Allure Maven Plugin
•	Maven
•	GitHub Actions (CI/CD)
Project Structure

src
├── main
│   └── java
│       └── org.example
│           ├── BasePage.java
│           ├── CartPage.java
│           ├── HomePage.java
│           ├── LoginPage.java
│           ├── Main.java
│           ├── ProductDetailsPage.java
│           └── ProductsPage.java
└── test
    └── java
        └── org.example
            ├── BaseTest.java
            └── LoginTest.java

src/main/java/org.example
Contains the framework implementation:
BasePage
Common reusable methods:
•	click
•	waits
•	alert handling
•	element interactions
HomePage
Main page actions and navigation.
LoginPage
•	login
•	logout
•	validation of error messages
ProductsPage
•	product list
•	category navigation
•	selecting a product
ProductDetailsPage
•	product details
•	add to cart
CartPage
•	cart validation
•	order confirmation

src/test/java/org.example
Contains the automated tests:
BaseTest
•	WebDriver setup
•	teardown
•	TestNG configuration
LoginTest
•	login
•	logout
•	validation scenarios

How to Run the Project
1.	Run tests from IntelliJ IDEA or Terminal
mvn clean test
2.	Generate Allure Report
allure serve allure-results

Allure Reports in GitHub Actions
The CI pipeline automatically generates:
•	allure-results
•	allure-report (full HTML report)
You can download them from: Actions → Artifacts

CI/CD Workflow (GitHub Actions)
The pipeline performs:
•	code checkout
•	JDK setup
•	Chrome installation
•	running TestNG tests
•	generating Allure report
•	uploading artifacts
The workflow runs automatically on every push to the master branch.

What I Learned in This Project
•	How to build a modular POM framework
•	How to manage WebDriver and ChromeDriver reliably
•	How to fix real UI automation issues (stale elements, JS click, alert handling)
•	How to integrate Allure with Maven and GitHub Actions
•	How to configure a professional CI/CD pipeline
Implemented Functionalities
•	Login / Logout
•	Category navigation
•	Open product details
•	Add product to cart
•	Validate messages and alerts
•	Stable end to end tests



