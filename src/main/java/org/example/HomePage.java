package org.example;

import org.example.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {


    private static final String GROUP_NAME_INPUT_XPATH = "//div[@class='control-element']/div[contains(@class, 'control-inline')]/input[@id='input-group']";
    private static final String ARTIFACT_INPUT_XPATH = "//div[@class='control-element']/div[contains(@class, 'control-inline')]/input[@id='input-artifact']";
    private static final String NAME_INPUT_XPATH = "//div[@class='control-element']/div[contains(@class, 'control-inline')]/input[@id='input-name']";
    private static final String DESCRIPTION_INPUT_XPATH = "//div[@class='control-element']/div[contains(@class, 'control-inline')]/input[@id='input-description']";
    private static final String PACKAGE_NAME_INPUT_XPATH = "//div[@class='control-element']/div[contains(@class, 'control-inline')]/input[@id='input-packageName']";
    private static final String EXPLORE_DEPENDENCIES_BUTTON_XPATH = "//button[@id='explore-dependencies']";
    private static final String DEPENDENCY_INPUT_XPATH = "//input[@id='input-quicksearch']";
    private static final String GENERATE_BUTTON_XPATH = "//button[@id='generate-project']";

    public HomePage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }


    public void selectDependencyManager(String dependencyManager) {
        String xpath = "//div[@class='control-element']/div/a/span[text()='" + dependencyManager + "']";
        getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        findElement(xpath).click();
    }


    public void selectVersionOfSpringBoot(String versionOfSpring) {
        findElement("//div[@class='control-element']/div/a/span[text()='" + versionOfSpring + "']").click();
    }

    public void selectLanguage(String language) {
        findElement("//div[@class='control-element']/div/a/span[text()='" + language + "']").click();
    }

    public void inputGroupName(String groupName) {
        WebElement element = findElement(GROUP_NAME_INPUT_XPATH);
        element.clear();
        element.sendKeys(groupName);
    }

    public void inputArtifact(String artifact) {
        WebElement element = findElement(ARTIFACT_INPUT_XPATH);
        element.clear();
        element.sendKeys(artifact);
    }

    public void inputName(String name) {
        WebElement element = findElement(NAME_INPUT_XPATH);
        element.clear();
        element.sendKeys(name);
    }

    public void inputDescription(String description) {
        WebElement element = findElement(DESCRIPTION_INPUT_XPATH);
        element.clear();
        element.sendKeys(description);
    }

    public void inputPackageName(String packageName) {
        WebElement element = findElement(PACKAGE_NAME_INPUT_XPATH);
        element.clear();
        element.sendKeys(packageName);
    }

    public void selectPackaging(String packaging) {
        findElement("//div[contains(@class, 'control-inline')]/div/a/span[text()='" + packaging + "']").click();
    }

    public void selectVersionOfJava(String versionOfJava) {
        findElement("//div[contains(@class, 'control-inline')]/div/a/span[text()='" + versionOfJava + "']").click();
    }

    public void clickExploreDependenciesButton() {
        findElement(EXPLORE_DEPENDENCIES_BUTTON_XPATH).click();
    }

    public void inputDependency(String dependency) {
        findElement(DEPENDENCY_INPUT_XPATH).sendKeys(dependency);
    }

    public void clickGenerateButton() {
        findElement(GENERATE_BUTTON_XPATH).click();
    }





}
