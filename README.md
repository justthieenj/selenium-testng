# Selenium TestNG

## Setup

- Install JDK 17
- Install Maven
- Install IntelliJ IDEA
- Install IntelliJ Plugin: Lombok

## Run Test

- CLI:
    - `mvn clean test` (run all test by default)
        - options:
            - `-DthreadCount=<NUMBER_OF_THREAD>`
            - `-DxmlSuite=<XML_SUITE_FILE>` (located at `src/test/resources/testsuite`)
    - Example: `mvn clean test -DxmlSuite=magento -DthreadCount=2`

- IntelliJ IDEA:
    - Open testng xml file (located at `src/test/resources/testsuite`) and execute test via right click and select `Run`
      option
      ([image](docs/images/intellij_run_testng_xml.png))

## View Report

- TBD