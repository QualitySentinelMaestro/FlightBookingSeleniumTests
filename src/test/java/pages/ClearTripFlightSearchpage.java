/*********************************************************************************************************************************************************************************
 * @author : Lakshmi Ay
 * This is the Cleartrip flight search page Java class which initiates all the webelements with page facttory class
 * and contains actions method to implement webelements.

 ***********************************************************************************************************************************************************************************/

package pages;

import Helper.JavascriptHelper;
import Helper.WaitHelper;
import Helper.XpathHelper;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ClearTripFlightSearchpage {

    WebDriver driver;

    Logger log = Logger.getLogger(ClearTripFlightSearchpage.class);
    XpathHelper xpathHelper;

    @FindBy(how = How.XPATH, using = "//span[text() = 'Midnight - 8 am']/following::label/div")
    public WebElement morningElement;

    @FindBy(how = How.XPATH, using = "//p[text() = 'Stops']/following::div[3]")
    public WebElement nonstopElement;

    @FindBy(how = How.XPATH, using = "//button[text() = 'Search']")
    public WebElement searchElement;

    @FindBy(how = How.XPATH, using = "//span[text() = 'Book now']")
    public WebElement booknowElement;

    @FindBy(how = How.XPATH, using = "//button[text() = 'Book']")
    public WebElement bookElement;

    public ClearTripFlightSearchpage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
        xpathHelper = new XpathHelper(driver);

    }

    public void selectEarlyMorningFlight(String morningflight) {
        log.info("user is browsing for early morning flights:" + morningflight);

        WebElement morningElt = WaitHelper.clickWhenReady(driver, morningElement, 5);
        JavascriptHelper.highlightElement(driver, morningElt);
        morningElt.click();

        WebElement nonStopElt = WaitHelper.clickWhenReady(driver, nonstopElement, 5);
        JavascriptHelper.highlightElement(driver, nonStopElt);
        nonStopElt.click();


    }


    public void isearlyMorningFlightsavailable(String booktext) {
        WaitHelper.simpleWait(driver, 10);
        WebElement searchelt = WaitHelper.clickWhenReady(driver, searchElement, 5);
        searchelt.click();
        WaitHelper.waituntileltdisplayed(driver, 10);
        boolean val;
        if (booktext.equals("Book now")) {
            val = xpathHelper.isSpanWebElementExist(booktext);
            Assert.assertTrue(val);
            WebElement bookelt = xpathHelper.findSpanWithText(booktext);

            WaitHelper.simpleWait(driver, 10);
            bookelt.click();
            WaitHelper.simpleWait(driver, 10);
        } else {
            val = xpathHelper.isButtonWebElementExist(booktext);
            Assert.assertTrue(val);
            WebElement bookelt = xpathHelper.findButtonWebElementByText(booktext);
            WaitHelper.simpleWait(driver, 10);
            bookelt.click();
            WaitHelper.simpleWait(driver, 10);

        }
    }

    public void flightConfirmation() {
        WaitHelper.simpleWait(driver, 10);

        WebElement bookelt = WaitHelper.clickWhenReady(driver, bookElement, 10);
        WaitHelper.simpleWait(driver, 10);
        bookelt.click();
        WaitHelper.simpleWait(driver, 10);

        String currentWindowHandle = driver.getWindowHandle();
        boolean newTabOpened = false;

        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(currentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                System.out.println(driver.switchTo().window(windowHandle).getTitle());
                newTabOpened = true;
            }

            driver.close();
            break;
        }

        driver.switchTo().window(currentWindowHandle);
    }
}



