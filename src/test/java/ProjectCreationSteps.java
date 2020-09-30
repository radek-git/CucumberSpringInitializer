import io.cucumber.java8.En;
import org.example.HomePage;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.StringJoiner;

import static org.junit.Assert.assertTrue;

public class ProjectCreationSteps implements En {


    private static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions actions;
    private static HomePage homePage;

    private String artifact;

    public ProjectCreationSteps() {
        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
//        chromeOptions.addArguments("load-extension=" + "E:\\IdeaProjects\\CucumberFilmweb\\extensions\\3.8.4_0");
//        chromeOptions.addArguments("load-extension=" + "E:\\IdeaProjects\\CucumberFilmweb\\extensions\\4.14.0_0");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--lang=en-US");
        driver = new ChromeDriver(chromeOptions);

        wait = new WebDriverWait(driver, 15);
        actions = new Actions(driver);
        driver.manage().window().maximize();

        Given("User opens page", () -> {
            driver.get("https://start.spring.io/");
            homePage = new HomePage(driver, wait, actions);
        });

        Given("User selects {string} project", (String dependencyManager) -> {
            homePage.selectDependencyManager(dependencyManager);
        });

        Given("User selects {string} language", (String language) -> {
            homePage.selectLanguage(language);
        });

        Given("User selects {string} version of SpringBoot", (String springBootVersion) -> {
            homePage.selectVersionOfSpringBoot(springBootVersion);
        });

        Given("User inputs {string} group name", (String groupName) -> {
            homePage.inputGroupName(groupName);
        });

        Given("User inputs {string} artifact", (String artifact) -> {
            this.artifact = artifact;
            homePage.inputArtifact(artifact);
        });

        Given("User inputs {string} name", (String name) -> {
            homePage.inputName(name);
        });

        Given("User inputs {string} description", (String description) -> {
            homePage.inputDescription(description);
        });

        Given("User inputs {string} package name", (String packageName) -> {
            homePage.inputPackageName(packageName);
        });

        Given("User selects {string} packaging", (String packaging) -> {
            homePage.selectPackaging(packaging);
        });

        Given("User select {string} version of Java", (String versionOfJava) -> {
            homePage.selectVersionOfJava(versionOfJava);
        });

        Given("User inputs {string} dependencies", (String dependencies) -> {
            String[] dependenciesToAdd = dependencies.split(", ");
            for (String s : dependenciesToAdd) {
                homePage.clickExploreDependenciesButton();
                homePage.inputDependency(s);
                homePage.getActions().sendKeys(Keys.ENTER).build().perform();
            }

        });

        When("User clicks Generate button", () -> {
            homePage.clickGenerateButton();
        });

        Then("Project is downloaded", () -> {
            Thread.sleep(500);
            assertTrue(isFileDownloaded(artifact));
        });

    }

    public boolean isFileDownloaded(String artifact) {
        String zipPath = "C:\\Users\\Radek\\Downloads\\" + artifact + ".zip";
        File file = new File(zipPath);
        return file.exists();
    }
}
