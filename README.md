# Polovni Automobili Automation Framework

Automated UI test suite for the Polovni Automobili marketplace platform. 
The project is built using Java with Selenium WebDriver, implementing the Page Object Model (POM) design pattern.

## Technologies Used
* Java 21
* Selenium WebDriver
* JUnit 4
* Maven

## Project Structure
* `src/main/java/Pages/` - Page Object classes mapping page components and interaction logic (HomePage, LoginPage, PostAdPage, etc.)
* `src/test/java/Tests/` - Test execution scripts covering smoke tests and core UI flows (BaseTest, SmokeTests)
* `pom.xml` - Maven project configurations and dependency management

## Setup and Run Instructions

1. Clone the repository:
   git clone https://github.com/MinaStefanovic28/java-selenium-pom-polovni-automobili.git

2. Run tests via Maven:
   mvn clean test
