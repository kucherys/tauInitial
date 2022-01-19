package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
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


    public void verifyLogInButton(String expectedName){
        String actualName = (logInButton).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void verifySignUpButton(String expectedName){
        String actualName = (signInButton).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public String getLogInButtonName(){
        return (logInButton).getText();

    }

    public String getSignInButtonName(){
        return (signInButton).getText();

    }

}
