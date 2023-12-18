# testcrew-assessment
# TestCrew:Selenium-Automation-Task
[**TestCrew Automation Framework**] using [**Selenium**](https://marketsquare.github.io/robotframework-browser/Browser.html) 

## **Technology stack**
* **Selenium**
* **TestNG**
* **Jenkins**
* **Docker**

## **Automation Framework Design**:
Testcrew framework are implementing the **Customize Framework ** design pattern (**Page Object Model** for GUI). And below is the project structure folders:
* **browser** folder: include browser which contians the stc web applications 
* **driver** folder: include driver and driver manager which control drivers and capbilities,
* **platform** folder: include stc class which include all screens in web application
* **screen** folder: include stc screens which include pom pattern for screens.
* **tests** folder: include tests suite [bahrain - kuwait - saudi arabia] which contains methods seperate and reusable for test cases.
* **utils** folder: include read properties and waits explicit helper method
* **HookHandler** folder: include all pre-conditions and post-conditions
* **resource** folder:include run remotely or local which means you can run from container
* **docker-compose** this yaml file contain 4 container [selenium-hub] and 3 container [edge-firefox-chrome]
* **jenkinsfile.groovy** contain pipeline for run on container.

## Setup:
1. Install [**Docker™**](https://www.docker.com/products/docker-desktop/)
   2. Enable Hyper-V:
   3. Go to "Control Panel" -> "Programs" -> "Turn Windows features on or off."
   4. Check the box next to "Hyper-V" and click "OK." You may need to restart your computer to apply the changes.
   5. Download Docker Desktop:
2. Install [**Python™**](https://www.python.org/downloads/)
3. Install [**Allure Report**](https://allurereport.org/) to be able to open allure after download and add in environment variable run  **Allure Report** ``` allure serve ```
4. Install [**Allure Report Compile**](https://pypi.org/project/allure-robotframework/) to be able to compile into one  f **html file **Allure Report html** ``` pip install allure-combine ```


## Execution:
* Run from local through command line: navigate to stc-xml in project directory  ```mvn clean install``` if downloaded dependacies before run ```mvn clean test```
* Run from Remote command line: navigate to docker file then run  ```docker-compose up ``` waiting file to download images and then run containers. then run ```mvn clean test```
* Generate allure-results ``` allure generate --clean ```
* Naviagte to allure-report then Compile all generated file to one source html ``` allure-combine . ```


## Testcrew Framework 
* 1- U can run parallel **
* 2- Generate historical allure report
* 3- U can change versions of browsers in docker containers and make browser compatabilty

