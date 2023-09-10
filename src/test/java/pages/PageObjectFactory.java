/*********************************************************************************************************************************************************************************
 * @author : Lakshmi Ay
 * This is the pageobject factory which initiates the page objects for all the page classes of the cleartrip website.
 ***********************************************************************************************************************************************************************************/

package pages;

import org.openqa.selenium.WebDriver;

public class PageObjectFactory {
    private WebDriver driver;

    public PageObjectFactory(WebDriver driver) {
        this.driver = driver;
    }

    public ClearTripHomePage createClearTripHomePage() {
        return new ClearTripHomePage(driver);
    }

    public ClearTripFlightSearchpage createClearTripFlightSearchpage()

    {
        return new ClearTripFlightSearchpage(driver);
    }

}
