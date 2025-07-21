# Selenium Java Hybrid Framework Documentation

## Overview
This is a Maven-based Selenium Java Hybrid Framework using TestNG for test automation. The framework follows the Page Object Model (POM) design pattern and includes comprehensive reporting with ExtentReports and Allure.

## Framework Architecture

### Project Structure
```
Selenium-Java-Hybrid-Framework/
├── src/
│   ├── main/java/
│   │   ├── Base_Layer/           # Base classes for WebDriver setup
│   │   ├── Page_Layer/           # Page Object Model classes
│   │   ├── Util_package/         # Utility classes and helper methods
│   │   ├── driver/               # WebDriver factory and management
│   │   ├── extentReportPackage/  # ExtentReports configuration
│   │   └── listenerPackage/      # TestNG listeners for reporting
│   └── test/java/
│       └── Test_Layer/           # Test classes
├── reports/                      # ExtentReports output directory
├── allure-results/              # Allure test results (generated)
├── Config.Properties            # Configuration file
├── testng.xml                   # TestNG suite configuration
├── pom.xml                      # Maven dependencies
└── frameworkinfo.md            # This documentation file
```

## Key Components

### 1. Base Layer (`src/main/java/Base_Layer/`)
- **baseClass.java**: Core WebDriver initialization and browser setup
- Supports Chrome, Edge, and Opera browsers
- Handles configuration loading from `Config.Properties`

### 2. Page Layer (`src/main/java/Page_Layer/`)
Page Object Model implementation with the following pages:
- **LoginPage.java**: Login functionality with Allure step annotations
- **HomePage.java**: Homepage verification and navigation
- **AdminPage.java**: Admin panel operations
- **PurchasePage.java**: E-commerce purchase flow
- **FacebookPage.java**: Facebook integration testing
- **OhmDirectoryPage.java**: Directory management
- **PimPage.java**: PIM module operations
- **RecruitmentPage.java**: Recruitment module testing

### 3. Test Layer (`src/test/java/Test_Layer/`)
Test classes containing actual test methods:
- **logintest.java**: Login functionality tests
- **homepagetest.java**: Homepage verification tests
- **adminpagetest.java**: Admin page functionality tests
- **PurchaseTest.java**: E-commerce purchase flow tests (3 test methods)
- **facebookID.java**: Facebook-related testing
- **Ohm_directoryTest.java**: Directory testing

### 4. Utilities (`src/main/java/Util_package/`)
- **utilClass.java**: Common utility methods including screenshot capture
- **WebEventListener.java**: WebDriver event handling and logging
- Excel data handling utilities using Apache POI

### 5. Reporting (`src/main/java/extentReportPackage/` & `src/main/java/listenerPackage/`)
- **ExtentReporterNg.java**: ExtentReports configuration and setup
- **Listneres.java**: TestNG listener for ExtentReports and Allure integration
- **AnnotationTransformer.java**: TestNG annotation transformation
- **IReport.java**: Additional reporting functionality

## Dependencies

### Core Dependencies (from pom.xml)
- **Selenium WebDriver**: 3.141.59
- **TestNG**: 7.4.0
- **ExtentReports**: 5.0.9
- **WebDriverManager**: 5.0.3
- **Apache POI**: 3.9 (Excel data handling)
- **Allure TestNG**: 2.17.3

### Java Version
- **Target**: Java 1.7 (for legacy compatibility)
- **Maven Compiler**: 3.11.0

## Configuration

### Config.Properties
Contains environment-specific configurations:
- Application URLs
- Browser settings
- Credentials
- Timeouts and other parameters

### testng.xml
TestNG suite configuration with:
- Listener configurations (ExtentReports, Allure, Custom listeners)
- Test class specifications
- Test method inclusions/exclusions

## Getting Started

### Prerequisites
1. **Java 8 or higher** installed
2. **Maven 3.6+** installed
3. **Chrome browser** installed (primary browser for testing)
4. **Git** for cloning the repository

### Setup Instructions

1. **Clone the Repository**
   ```bash
   git clone <repository-url>
   cd Selenium-Java-Hybrid-Framework
   ```

2. **Install Dependencies**
   ```bash
   mvn clean install
   ```

3. **Verify Configuration**
   - Check `Config.Properties` for correct URLs and settings
   - Ensure `testng.xml` has the required test classes configured

## Running Tests

### Method 1: Run Complete Test Suite (Recommended)
```bash
mvn test
```
This runs all tests defined in `testng.xml` with proper listener integration.

### Method 2: Run Individual Test Class
```bash
mvn -Dtest=logintest test
mvn -Dtest=adminpagetest test
mvn -Dtest=homepagetest test
```
**Note**: Individual test runs may not invoke all listeners from `testng.xml`.

### Method 3: Run Specific Test Methods
```bash
mvn -Dtest=logintest#loginFunctionality test
```

## Reporting

### ExtentReports
- **Location**: `reports/extentReport.html`
- **Features**: 
  - Test execution status
  - Step-by-step logs
  - Screenshots on failure
  - System information
  - Dark theme UI

### Allure Reports
1. **Generate Allure Results** (automatically generated during test runs)
2. **Install Allure CLI** (if not already installed):
   - Download from: https://github.com/allure-framework/allure2/releases
   - Extract and add to PATH
3. **Generate and View Report**:
   ```bash
   allure generate allure-results --clean
   allure open allure-report
   ```

## Framework Features

### 1. Thread-Safe Execution
- WebDriver instances managed via ThreadLocal
- Supports parallel test execution
- Thread-safe ExtentTest instances

### 2. Cross-Browser Support
- Chrome (primary)
- Edge
- Opera
- Configurable via `Config.Properties`

### 3. Comprehensive Logging
- WebDriver event logging
- Step-by-step execution logs
- Console output for debugging

### 4. Screenshot Capture
- Automatic screenshots on test failure
- Attached to both ExtentReports and Allure reports
- Stored with timestamp and test method names

### 5. Data-Driven Testing
- Excel file support via Apache POI
- Configurable test data management

## Troubleshooting

### Common Issues

1. **ChromeDriver Version Mismatch**
   - WebDriverManager automatically handles driver downloads
   - Clear cache if issues persist: Delete `~/.cache/selenium/`

2. **ExtentReports Not Generated**
   - Ensure tests are run via `mvn test` (not individual `-Dtest`)
   - Check that listeners are properly configured in `testng.xml`

3. **Test Failures Due to Element Not Found**
   - Check if application URL is accessible
   - Verify element locators in Page classes
   - Increase implicit wait times if needed

4. **Maven Build Warnings**
   - Duplicate Apache POI dependencies (can be ignored)
   - SLF4J logger warnings (doesn't affect functionality)

## Best Practices

### For New Team Members

1. **Follow Page Object Model**
   - Keep page elements and actions in Page_Layer classes
   - Test logic should only be in Test_Layer classes

2. **Use Proper Annotations**
   - Add `@Step` annotations for Allure reporting
   - Use `@Test` with proper descriptions

3. **Maintain Configuration**
   - Update `Config.Properties` for environment changes
   - Keep `testng.xml` updated with new test classes

4. **Reporting Standards**
   - Always run complete test suite for accurate reports
   - Review both ExtentReports and Allure reports
   - Attach screenshots for failed test analysis

## Support and Maintenance

### Framework Maintainer
- **Automation Tester**: Akshay Gaikwad

### Future Enhancements
- Upgrade to Java 17 and Selenium 4+
- Implement Docker containerization
- Add API testing capabilities
- Enhance parallel execution support

---

**Last Updated**: July 2025  
**Framework Version**: 1.0  
**Compatible with**: Selenium 3.x, TestNG 7.x, Java 8+
