/***********************************************************************************************************************************
 * @author : Lakshmi Ay
 ***********************************************************************************************************************************************************************************/

package Helper;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitHelper {


    static WebDriverWait wait;

    public static void implicitWait(WebDriver driver, int waitTimeSeconds) {
        driver.manage().timeouts().implicitlyWait(waitTimeSeconds, TimeUnit.SECONDS);
    }


    public static WebElement waitUntilVisible(WebDriver driver, WebElement elt, int waitTimeSeconds) {
        try {

            wait = new WebDriverWait(driver, waitTimeSeconds);
            elt = wait.until(ExpectedConditions.visibilityOf(elt));
            System.out.println("text coming on screen to be visible is  : " + elt.getText());
            return elt;
        } catch (Exception e) {
            return null;
        }

    }

    public static WebElement clickWhenReady(WebDriver driver, WebElement elt, int waitTimeSeconds) {
        try {
            WebElement element = null;
            wait = new WebDriverWait(driver, waitTimeSeconds);
            element = wait.until(ExpectedConditions.elementToBeClickable(elt));
            System.out.println("text coming on screen to be clicked  is : " + element.getText());

            return element;
        } catch (Exception e) {
            return null;
        }

    }

    public static void simpleWait(WebDriver driver, int waitTimeSeconds) {

        try {
            driver.manage().timeouts().implicitlyWait(waitTimeSeconds, TimeUnit.SECONDS);
            //   WebDriverWait wait = new WebDriverWait(driver, waitTimeSeconds);
            // ExpectedCondition<WebElement> ec = ExpectedConditions.visibilityOfElementLocated(By.id("invalid_id"));
            //    wait.until(ec);

        } catch (TimeoutException ex) {
            // Ignore the timeout
        } catch (UnhandledAlertException uae) {
            // We are in FF

        }

    }

    public static void waituntileltdisplayed(WebDriver driver, int waitTimeSeconds) {

        try {
            driver.manage().timeouts().implicitlyWait(waitTimeSeconds, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(driver, waitTimeSeconds);
            ExpectedCondition<WebElement> ec = ExpectedConditions.visibilityOfElementLocated(By.id("invalid_id"));
            wait.until(ec);

        } catch (TimeoutException ex) {
            // Ignore the timeout
        } catch (UnhandledAlertException uae) {
            // We are in FF

        }

    }
}
