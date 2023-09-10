import Helper.WaitHelper;
import Helper.XpathHelper;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FlightBookingTest {

    WebDriver driver;
    XpathHelper xpathhelper;
    WaitHelper waitHelper;

      //@Test
    public void testbooking() {

        driver = setupChromeDriver();
       // waitHelper = new WaitHelper(driver);

        driver.manage().window().maximize();
        WaitHelper.simpleWait(driver,5);
        driver.manage().deleteAllCookies();


        driver.get("https://www.cleartrip.com/");
        WaitHelper.simpleWait(driver,5);


        xpathhelper = new XpathHelper(driver);

        WebElement sefl = xpathhelper.findByXPath("//h1[text()='Search flights']");
        highlightElement(driver, sefl);
        WaitHelper.simpleWait(driver,5);
        System.out.println("search flights");

        WebElement oneWayelt = xpathhelper.findByXPath("//div[contains(@class, 'p-relative')]/following::button");
        highlightElement(driver, oneWayelt);
        oneWayelt.click();
        WaitHelper.simpleWait(driver,5);


        WebElement dropdown = driver.findElement(By.xpath("//div[contains(@class, 'bg-white br-4 elevation-5 p-1 p-absolute mt-2 z-50 l-0')]"));
        List<WebElement> options = dropdown.findElements(By.tagName("li"));

        if (!options.isEmpty()) {
            WebElement firstElement = options.get(0);
            highlightElement(driver, firstElement);
            firstElement.click();
            WaitHelper.simpleWait(driver,5);

        }

        // WebElement fromtagelt  = xpathhelper.findByXPath("//div[contains(@class, 'field-1 flex flex-middle p-relative pr-4 w-100p')]/following::div[1]/input");

        //input[@placeholder='Gender']
        //String s=driver.findElement(By.xpath("//input[@placeholder='Where from?']")).getAttribute("placeholder");
        //System.out.println(s);

        WebElement fromtagelt = driver.findElement(By.xpath("//input[@placeholder='Where from?']"));
        highlightElement(driver, fromtagelt);
        fromtagelt.click();
        fromtagelt.sendKeys("BLR");
        WaitHelper.simpleWait(driver,5);
        WebElement codeelt = driver.findElement(By.xpath("//div[contains(@class, 'fw-600') and text()='BLR']"));
        codeelt.click();
        WaitHelper.simpleWait(driver,5);


        WebElement totagelt = driver.findElement(By.xpath("//input[@placeholder='Where to?']"));
        highlightElement(driver, totagelt);
        totagelt.click();
        totagelt.sendKeys("DEL");
        WaitHelper.simpleWait(driver,5);
        WebElement codetoelt = driver.findElement(By.xpath("//div[contains(@class, 'fw-600') and text()='DEL']"));
        codetoelt.click();
        WaitHelper.simpleWait(driver,5);

        WebElement clickcalet = driver.findElement(By.xpath("//div[contains(@class, 'flex flex-middle p-relative homeCalender')]"));
        highlightElement(driver, clickcalet);
        WaitHelper.simpleWait(driver,5);
        clickcalet.click();
        WaitHelper.simpleWait(driver,5);

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0, 200);");

        //String divXPath = "//div[contains(text(), 'August 2023')]";
        String xp = "//div[contains(@class, 'DayPicker-Day') and @aria-label='Tue Aug 08 2023']";
        //String xp = "//div[contains(@class, 'DayPicker-Day') and aria-label()='Tue Aug 01 2023']";
        //  WebElement daypickElt = driver.findElement(By.xpath("//div[contains(@class, 'DayPicker-Day')]/following::div[2]"));
        WebElement daypickElt = driver.findElement(By.xpath(xp));
        highlightElement(driver, daypickElt);
        daypickElt.click();
        WaitHelper.simpleWait(driver,5);


        WebElement searchelt = driver.findElement(By.xpath("//span[text() = 'Search flights']"));
        highlightElement(driver, searchelt);
        searchelt.click();
        WaitHelper.simpleWait(driver,10);
/*

        WebElement regularfareElt  = driver.findElement(By.xpath("//div[text() = 'Regular fare']"));
        highlightElement(driver,regularfareElt);
        WaitHelper.implicitWait(driver, 10);

        WebElement regfareSearchelt   = driver.findElement(By.xpath("//span[text() = 'Search flights']"));
        highlightElement(driver,regfareSearchelt);
        regfareSearchelt.click();
        WaitHelper.implicitWait(driver, 10);
*/


        WebElement morningElt = driver.findElement(By.xpath("//span[text() = 'Midnight - 8 am']/following::label/div"));
        highlightElement(driver, morningElt);
        morningElt.click();

        WebElement nonStopElt = driver.findElement(By.xpath("//p[text() = 'Stops']/following::div[3]"));
        highlightElement(driver, nonStopElt);
        nonStopElt.click();

        //WebElement sliderelt =  driver.findElement(By.xpath("//span[contains(@class,'input-range__slider-container') ]/following::div"));
        WebElement sliderelt = driver.findElement(By.xpath("//span[contains(@class,'input-range__slider-container')]"));
        highlightElement(driver, sliderelt);
        Actions move = new Actions(driver);
        move.moveToElement(sliderelt).clickAndHold().moveByOffset(0, -100).release().perform();
        WaitHelper.simpleWait(driver,5);

        WebElement bookelt = driver.findElement(By.xpath("//button[text() = 'Book']"));
        highlightElement(driver, bookelt);
        bookelt.click();
        WaitHelper.simpleWait(driver,5);


        String currentWindowHandle = driver.getWindowHandle();
        boolean newTabOpened = false;


        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(currentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                System.out.println(driver.switchTo().window(windowHandle).getTitle());
                newTabOpened = true;

              WebElement ip = driver.findElement(By.xpath("//div[contains(@class, ‘p-relative') ]/following::input"));

                ip.sendKeys("232");




/*
                    WebElement otpElt = driver.findElement(By.xpath("//span[text() = 'Search flights']"));
                    highlightElement(driver,otpElt) ;
                    otpElt.click();

                    WebElement closeelt = driver.findElement(By.xpath("//div[contains(@class, 'px1   flex flex-middle nmx-1 pb-1')]"));
                    highlightElement(driver, closeelt);
                    closeelt.click();*/


                    driver.close();
                    break;
                }
            }

            //switch to the parent currentWindowHandle
            driver.switchTo().window(currentWindowHandle);


                driver.close();
                driver.quit();

            }






            public WebDriver setupChromeDriver () {
                String projectRoot = System.getProperty("user.dir");
                String chromeDriverPath = projectRoot + "/Drivers/chromedriver";
                String chromeBinPath = projectRoot + "/ChromeBin/Google Chrome for Testing.app/Contents/MacOS/Google Chrome for Testing";

                System.setProperty("webdriver.chrome.driver", chromeDriverPath);
                ChromeOptions options = new ChromeOptions();
                options.setBinary(chromeBinPath);
                options.addArguments("--start-maximized");
                options.addArguments("--disable-cache");
                options.addArguments("--disable-cookies");


                WebDriver driver = new ChromeDriver(options);
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

                return driver;
            }


            public static void highlightElement (WebDriver driver, WebElement element){
                JavascriptExecutor js = ((JavascriptExecutor) driver);
                String bgcolor = element.getCssValue("backgroundColor");
                for (int i = 0; i < 30; i++) {
                    changeColor(driver, "rgb(0,255,0)", element);//1  //Highlight Element 10 times
                    changeColor(driver, bgcolor, element);//2 // Then move back to original colour
                }
            }


            public static void changeColor (WebDriver driver, String color, WebElement element){
                JavascriptExecutor js = ((JavascriptExecutor) driver);
                js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);

                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                }
            }

        }

