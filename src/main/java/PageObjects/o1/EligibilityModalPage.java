package PageObjects.o1;

import PageObjects.PageBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import junit.framework.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class EligibilityModalPage extends PageBase {
    public EligibilityModalPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    ProductCarouselPage productCarouselPage;

    @AndroidFindBy(id = "eligibility_criteria_close")
    @iOSXCUITFindBy(id = "")
    MobileElement closeButton;

    @AndroidFindBy(id = "eligibility_criteria_title")
    @iOSXCUITFindBy(id = "")
    MobileElement eligibilityLabel;

    @AndroidFindBy(id = "eligibility_criteria_description")
    @iOSXCUITFindBy(id = "")
    MobileElement eligibilityList;

    public boolean isLoaded() {
        return (eligibilityLabel).isDisplayed();
    }

    public void verifyCloseButton() {
        String actualName = (closeButton).getText();
        Assert.assertEquals("multiply", actualName);
    }


    public ProductCarouselPage closeEligibilityModal(AppiumDriver driver) {
        (closeButton).click();
        return new ProductCarouselPage(driver);
    }

    public void verifyEligibilityLabelName(String expectedName) {
        String actualName = (eligibilityLabel).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void verifyEligibilityList(List<String> expectedString) {
        String str = (eligibilityList).getText();
        List<String> actualString = Pattern.compile("\n")
                .splitAsStream(str)
                .collect(Collectors.toList());
        List<String> transformActual = new ArrayList<>();
        actualString.forEach(s -> transformActual.add(s.replace("\n", "").trim()));
        transformActual.removeAll(Arrays.asList("", null));

        Assert.assertTrue(transformActual.equals(expectedString));
    }
}
