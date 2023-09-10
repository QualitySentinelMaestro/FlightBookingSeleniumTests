/*********************************************************************************************************************************************************************************
 * @author : Lakshmi Ay
 * This is the Cleartrip flight home page Java class which initiates all the webelements with page facttory class
 * and contains actions method to implement webelements.

 ***********************************************************************************************************************************************************************************/

package pages;

import Helper.JavascriptHelper;
import Helper.WaitHelper;
import Helper.XpathHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ClearTripHomePage {

    WebDriver driver;

    Logger log = Logger.getLogger(ClearTripHomePage.class);
    XpathHelper xpathHelper;

    @FindBy(how = How.XPATH, using = "//h1[text()='Search flights']")
    public WebElement clickSearchFlightselt;

    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'p-relative')]/following::button")
    public WebElement oneWayelt;


    public ClearTripHomePage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
        xpathHelper = new XpathHelper(driver);

    }

    public void clickSearchFlights() {
        WebElement clickSearchFlightsElement = WaitHelper.clickWhenReady(driver, clickSearchFlightselt, 5);
        JavascriptHelper.highlightElement(driver, clickSearchFlightsElement);
        WaitHelper.implicitWait(driver, 5);

    }


    public void selectOneWayTrip(String triptyp) {
        WebElement oneWayelement = WaitHelper.clickWhenReady(driver, oneWayelt, 10);
        JavascriptHelper.highlightElement(driver, oneWayelement);
        oneWayelt.click();
        WaitHelper.implicitWait(driver, 5);

    }

    public void entertripDetails(String tripType ,String fromplace, String destinationplace, String traveldt) {
        WebElement dropdown = driver.findElement(By.xpath("//div[contains(@class, 'bg-white br-4 elevation-5 p-1 p-absolute mt-2 z-50 l-0')]"));
        List<WebElement> options = dropdown.findElements(By.tagName("li"));
        WebElement firstElement ;
        if (!options.isEmpty()) {
            if(tripType.equals("One way")) {
                 firstElement = options.get(0);
            }
            else
            {
                 firstElement = options.get(1);
            }
            JavascriptHelper.highlightElement(driver, firstElement);
            firstElement.click();
            WaitHelper.simpleWait(driver, 5);

        }

        WebElement fromtagelt = driver.findElement(By.xpath("//input[@placeholder='Where from?']"));
        JavascriptHelper.highlightElement(driver, fromtagelt);
        fromtagelt.click();
        fromtagelt.sendKeys(fromplace);
        WaitHelper.simpleWait(driver, 5);
        WebElement codeelt = driver.findElement(By.xpath("//div[contains(@class, 'fw-600') and text()='BLR']"));
        codeelt.click();
        WaitHelper.simpleWait(driver, 5);


        WebElement totagelt = driver.findElement(By.xpath("//input[@placeholder='Where to?']"));
        JavascriptHelper.highlightElement(driver, totagelt);
        totagelt.click();
        totagelt.sendKeys(destinationplace);
        WaitHelper.simpleWait(driver, 5);
        WebElement codetoelt = driver.findElement(By.xpath("//div[contains(@class, 'fw-600') and text()='DEL']"));
        codetoelt.click();
        WaitHelper.simpleWait(driver, 5);



        WebElement clickcalet = driver.findElement(By.xpath("//div[contains(@class, 'flex flex-middle p-relative homeCalender')]"));
        JavascriptHelper.highlightElement(driver, clickcalet);
        WaitHelper.simpleWait(driver,5);
        clickcalet.click();
        WaitHelper.simpleWait(driver,5);

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0, 200);");


        String fromdt = "//div[contains(@class, 'DayPicker-Day') and @aria-label='Tue Aug 08 2023']";
        WebElement daypickElt = driver.findElement(By.xpath(fromdt));
        JavascriptHelper.highlightElement(driver, daypickElt);
        daypickElt.click();
        WaitHelper.waituntileltdisplayed(driver, 5);

        if(tripType.equals("Round trip")) {


            String todt = "//div[contains(@class, 'DayPicker-Day') and @aria-label= 'Tue Aug 15 2023']";
            WebElement todtelement = driver.findElement(By.xpath(todt));
            JavascriptHelper.highlightElement(driver, todtelement);
            daypickElt.click();
            WaitHelper.waituntileltdisplayed(driver, 5);
        }


        WebElement searchelt = driver.findElement(By.xpath("//span[text() = 'Search flights']"));
        JavascriptHelper.highlightElement(driver, searchelt);
        searchelt.click();
        WaitHelper.simpleWait(driver, 5);


    }
}

