/***********************************************************************************************************************************
 * @author : Lakshmi Ay
 ***********************************************************************************************************************************************************************************/

package Helper;

import org.openqa.selenium.*;

public class XpathHelper {

    private WebDriver driver;

    public XpathHelper(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findSpanWithText(String text) {
        return findByXPath("//span[text()='" + text + "']");
    }

    public WebElement findByXPath(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public boolean isSpanWebElementExist(String text) {
        try {
            WaitHelper.simpleWait(driver, 5);
            WebElement confirmElement = findSpanWithText(text);
            return true;
        } catch (NotFoundException e) {
            return false;
        }

    }

    public boolean isButtonWebElementExist(String text) {
        try {
            WaitHelper.simpleWait(driver, 5);
            WebElement confirmElement = findButtonWebElementByText(text);
            return true;
        } catch (NotFoundException e) {
            return false;
        }

    }


    public WebElement findButtonWebElementByText(String text) {

        WebElement bookelt = driver.findElement(By.xpath("//button[text() = 'Book']"));
        JavascriptHelper.highlightElement(driver, bookelt);
        WaitHelper.simpleWait(driver, 10);
        return bookelt;
    }


}
