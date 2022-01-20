package PageObjects.o1;

import PageObjects.PageBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import junit.framework.Assert;


public class ProductCarouselPage extends PageBase {
    public ProductCarouselPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(id = "carousel_open_account_btn")
    @iOSXCUITFindBy(id = "")
    MobileElement openBankAccountButton;

    @AndroidFindBy(id = "carousel_eligible")
    @iOSXCUITFindBy(id = "")
    MobileElement eligibleButton;

    @AndroidFindBy(id = "carousel_eligible_txt")
    @iOSXCUITFindBy(id = "")
    MobileElement eligibleButtonText;

    @AndroidFindBy(id = "carousel_title")
    @iOSXCUITFindBy(id = "")
    MobileElement logoLabel;

    @AndroidFindBy(id = "carousel_subtitle")
    @iOSXCUITFindBy(id = "")
    MobileElement instructionText;

    @AndroidFindBy(id = "carousel_img")
    @iOSXCUITFindBy(id = "")
    MobileElement carouselImage;

    @AndroidFindBy(id = "carousel_tab_1")
    @iOSXCUITFindBy(id = "")
    MobileElement spinButton1;

    @AndroidFindBy(id = "carousel_tab_2")
    @iOSXCUITFindBy(id = "")
    MobileElement spinButton2;

    @AndroidFindBy(id = "carousel_tab_3")
    @iOSXCUITFindBy(id = "")
    MobileElement spinButton3;

    @AndroidFindBy(id = "carousel_tab_4")
    @iOSXCUITFindBy(id = "")
    MobileElement spinButton4;

    public boolean isLoaded(){
        return (openBankAccountButton).isDisplayed();
    }
    public void verifyImagePresent(){
        Assert.assertTrue((carouselImage).isDisplayed());
    }

    public void verifyOpenBankAccountButton(String expectedName){
        String actualName = (openBankAccountButton).getText();
        Assert.assertEquals(actualName, expectedName);
    }

    public void verifyEligibilityLabel(String expectedName){
        String actualName = (eligibleButtonText).getText();
        Assert.assertEquals(actualName, expectedName);  //leave
    }

    public void verifyLogoLabel(String expectedName){
        String actualName = (logoLabel).getText().replace("\n", " ");
        Assert.assertEquals(actualName, expectedName);
    }

    public void verifyInstructionText(String expectedName){
        String actualName = (instructionText).getText().replace("\n", " ");
        Assert.assertEquals(actualName, expectedName);
    }

//    public EligibilityModalPage openEligibilityModal(){
//        driver.findElement(eligibleButton).click();
//        return new EligibilityModalPage(driver);
//    }

    public ProductCarouselPage spinToCarouselPage(String pageNb, AppiumDriver driver){
        ProductCarouselPage productCarouselPage;
        switch (pageNb) {
            case ("1"):
                productCarouselPage = getProductCarouselPage(driver, spinButton1);
                break;
            case ("2"):
                productCarouselPage = getProductCarouselPage(driver, spinButton2);
                break;
            case ("3"):
                productCarouselPage = getProductCarouselPage(driver, spinButton3);
                break;
            case ("4"):
                productCarouselPage = getProductCarouselPage(driver, spinButton4);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + pageNb);
        }
        return productCarouselPage;
    }

    public ProductCarouselPage getProductCarouselPage(AppiumDriver driver, MobileElement locator){
        (locator).click();
        return new ProductCarouselPage(driver);
    }

//    public AppFlowPage getAppFlowPage(AndroidDriver<AndroidElement> driver){
//        driver.findElement(openBankAccountButton).click();
//        return new AppFlowPage(driver);
//    }

}
