/*********************************************************************************************************************************************************************************
 * @author : Lakshmi Ay
 * This is the step definitions class which implement the Gherkin steps in the feature file
 ***********************************************************************************************************************************************************************************/

package stepdefinitions;

import Helper.WaitHelper;
import Helper.XpathHelper;
import common.CommonConstants;
import common.CommonUtility;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.PageObjectFactory;

import java.io.IOException;
import java.util.Map;


public class ClearTripStepDefinitions {

    private PageObjectFactory pageFactory;
    private XpathHelper xpathHelper;
    private WaitHelper waitHelper;
    private WebDriver driver;
    private Scenario scenario;
    private Logger log = Logger.getLogger(ClearTripStepDefinitions.class);
    String booktext;

    @Before
    public void setEnv(Scenario scenario) {
        this.scenario = scenario;
        initEnv();
    }

    @Given("User launches the Browser")
    public void userLaunchesTheBrowser() {
        System.out.println("User launched browser");

    }

    @When("User is in flight booking website page and browse for flights")
    public void userIsInFlightBookingWebsitePageAndBrowseForFlights(DataTable cwebsite) {

        for (Map<Object, Object> cwebst : cwebsite.asMaps(String.class, String.class)) {
            String weblink = (String) cwebst.get("CWebsite");
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.get(weblink);
            pageFactory.createClearTripHomePage().clickSearchFlights();
            log.info("User launched cleartrip website");
        }

    }

    @Given("User enters his choices for booking the flight for the {string} trip")
    public void userEntersHisChoicesForBookingTheFlightForTheTrip(String triptype) {
        if (triptype.equals("One way")) {
            booktext = "Book";
        } else {
            booktext = "Book now";
        }
        pageFactory.createClearTripHomePage().selectOneWayTrip(triptype);
    }

    @And("User entering the {string} trip details and search for the flights")
    public void userEnteringTheTripDetailsAndSearchForTheFlights(String tripType, DataTable tripTypedt) {
        for (Map<Object, Object> tripTypedata : tripTypedt.asMaps(String.class, String.class)) {
            String frmplace = (String) tripTypedata.get("Fromplace");
            String toplace = (String) tripTypedata.get("Destinationplace");
            String traveldate = (String) tripTypedata.get("traveldt");

            pageFactory.createClearTripHomePage().entertripDetails(tripType, frmplace, toplace, traveldate);

        }

    }

    @Then("User is browsing for earlymorning {string} flights")
    public void userIsBrowsingForEarlymorningFlights(String earlyTimings) {

        pageFactory.createClearTripFlightSearchpage().selectEarlyMorningFlight(earlyTimings);


    }

    @And("Verify whether the earlymorning flights are available")
    public void verifyWhetherTheEarlymorningFlightsAreAvailable() {

        pageFactory.createClearTripFlightSearchpage().isearlyMorningFlightsavailable(booktext);
    }

    @And("Verify whether the flightconfirmation page is loaded")
    public void verifyWhetherTheFlightconfirmationPageIsLoaded() {
        pageFactory.createClearTripFlightSearchpage().flightConfirmation();
    }

    @After
    public void tearDown() throws IOException {

        String fileName = scenario.getName();
        System.out.println("Finished Scenario:" + scenario.getName());


        if (scenario.isFailed()) {
            CommonUtility.takeFailedScreenshot(driver, fileName);
        } else {
            CommonUtility.takeScreenshot(driver, fileName);
        }
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    public void initEnv() {

        try {

            System.out.println("**Execution of Feature File Started**");

            CommonUtility.createFolders();
            System.setProperty("webdriver.chrome.driver", CommonConstants.chromeDriverPath);
            ChromeOptions options = new ChromeOptions();
            options.setBinary(CommonConstants.chromeBinPath);
            options.addArguments("--start-maximized");
            options.addArguments("--disable-cache");
            options.addArguments("--disable-cookies");
            driver = new ChromeDriver(options);
            pageFactory = new PageObjectFactory(driver);


        } catch (Exception e) {

        }

    }


}
