package PageObjects.o1;

import PageObjects.PageBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import org.openqa.selenium.By;

public class LandingPage extends PageBase {
    public LandingPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(id = "welcome_login_btn")
    @iOSXCUITFindBy(id = "button.logIn")
    MobileElement logInButton;

    @AndroidFindBy(id = "welcome_register_btn")
    @iOSXCUITFindBy(id = "button.signIn")
    MobileElement signInButton;

    @AndroidFindBy(id = "welcome_welcome")
    @iOSXCUITFindBy(id = "label.welcome")
    MobileElement welcomeLabel;

    By welcomeLogo = By.id("welcome_welcome");
    By welcomeTitle = By.id("welcome_title");
    By welcomeSubTitle = By.id("welcome_subtitle");

    public boolean isLoaded(){
        return (logInButton).isDisplayed();
    }

    public void verifyLogInButton(String expectedName){
        String actualName = (logInButton).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void verifySignUpButton(String expectedName){
        String actualName = (signInButton).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void verifyWelcomeLabel(String expectedName){
        String actualName = (welcomeLabel).getText().replace("\n", " ");
        Assert.assertEquals(expectedName, actualName);
    }

    public String getLogInButtonName(){
        return (logInButton).getText();

    }

    public String getSignInButtonName(){
        return (signInButton).getText();

    }

    public ProductCarouselPage logInToProductCarouselPage(AppiumDriver driver){
        (signInButton).click();
        return new ProductCarouselPage(driver);
    }

}
