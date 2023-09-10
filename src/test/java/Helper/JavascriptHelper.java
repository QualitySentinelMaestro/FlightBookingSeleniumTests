/***********************************************************************************************************************************
 * @author : Lakshmi Ay
 ***********************************************************************************************************************************************************************************/

package Helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptHelper {
    JavascriptExecutor js;

    public Object executeScript(WebDriver driver, String script) {
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        return exe.executeScript(script);
    }

    public static void highlightElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String bgcolor = element.getCssValue("backgroundColor");
        for (int i = 0; i < 15; i++) {
            changeColor(driver, "rgb(0,255,0)", element);//1  //Highlight Element 10 times
            changeColor(driver, bgcolor, element);//2 // Then move back to original colour
        }
    }

    public static void changeColor(WebDriver driver, String color, WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);

        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
        }
    }
}