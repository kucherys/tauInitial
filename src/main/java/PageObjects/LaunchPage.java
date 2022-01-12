package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import junit.framework.Assert;

public class LaunchPage extends PageBase {

    public LaunchPage(AppiumDriver appiumDriver) {
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

//    By logInButton = By.id("button.logIn");
//    By signInButton = By.id("button.signIn");
//    String welcomeLabel = "label.welcome";

//    public IOSLaunchPage(IOSDriver<IOSElement> iosDriver){
//        this.iosDriver = iosDriver;
//    }

//    public boolean isLoaded(IOSDriver<IOSElement> iosDriver){
//        return iosDriver.findElement(logInButton).isDisplayed();
//    }

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

//    public ProductCarouselPage logInToProductCarouselPage(IOSDriver<IOSElement> driver){
//        driver.findElement(signInButton).click();
//        return new ProductCarouselPage(driver);
//    }

}
