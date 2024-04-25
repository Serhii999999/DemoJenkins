package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BuildPage;
import pages.LoginPage;
import pages.ProjectPage;
import pages.ScreamingFrogPage;
import services.Actions;
import services.Constants;
import services.CredService;
import services.UrlService;

import static services.DriverInit.driver;

public class DemoTest {
    LoginPage loginPage = new LoginPage();
    ScreamingFrogPage screamingFrogPage  = new ScreamingFrogPage();
    ProjectPage projectPage = new ProjectPage();
    BuildPage buildPage = new BuildPage();
    private final int THRESHOLD = 30;
    @BeforeTest
    public void setUp()  {
        Actions.open(UrlService.BASIC_URL);
        loginPage.logInSystem(CredService.USERNAME, CredService.PASSWORD);
    }
    @Test
    public void checkAllValuesAreCorrect() {
        SoftAssert softAssert = new SoftAssert();
        screamingFrogPage
                .frogLink()
                .prodLinkClick();
        projectPage.clickBuildLink();
        buildPage.clickConsoleOutputButton();
        var prodServerError = Actions.retrieveNumberFromPage(Constants.REGEX_FOR_500);
        var prodPages = Actions.retrieveNumberFromPage(Constants.REGEX_FOR_PAGES);
        var prodTitleMissing = Actions.retrieveNumberFromPage(Constants.REGEX_FOR_TITLE_MISSING);
        var prodTitleDuplicate = Actions.retrieveNumberFromPage(Constants.REGEX_FOR_TITLE_DUPLICATE);
        var prodMetaMissing = Actions.retrieveNumberFromPage(Constants.REGEX_FOR_META_MISSING);
        var prodMetaDuplicate = Actions.retrieveNumberFromPage(Constants.REGEX_FOR_META_DUPLICATE);
        var prodH1Missing = Actions.retrieveNumberFromPage(Constants.REGEX_FOR_H1_MISSING);
        var prodH1Duplicate = Actions.retrieveNumberFromPage(Constants.REGEX_FOR_H1_DUPLICATE);
        var prodH2Missing = Actions.retrieveNumberFromPage(Constants.REGEX_FOR_H2_MISSING);

        softAssert.assertEquals(prodServerError,0, "500 on prod -");
        softAssert.assertEquals(prodTitleMissing,0,"missing title on prod - ");
        softAssert.assertEquals(prodTitleDuplicate,0,"duplicate titles on prod -");
        softAssert.assertEquals(prodMetaMissing,0,"missing meta on prod -");
        softAssert.assertEquals(prodMetaDuplicate,0,"duplicate meta on prod - ");
        softAssert.assertEquals(prodH1Missing,0, "missing H1 on prod -");
        softAssert.assertEquals(prodH1Duplicate,0,"duplicate H1 on prod -");
        softAssert.assertEquals(prodH2Missing,0,"missing H2 on prod -");

        Actions.navigateBack();
        Actions.navigateBack();
        screamingFrogPage.preprodLinkClick();
        projectPage.clickBuildLink();
        buildPage.clickConsoleOutputButton();
        var preProdServerError = Actions.retrieveNumberFromPage(Constants.REGEX_FOR_500);
        var preProdPages = Actions.retrieveNumberFromPage(Constants.REGEX_FOR_PAGES);
        var preProdTitleMissing = Actions.retrieveNumberFromPage(Constants.REGEX_FOR_TITLE_MISSING);
        var preProdTitleDuplicate = Actions.retrieveNumberFromPage(Constants.REGEX_FOR_TITLE_DUPLICATE);
        var preProdMetaMissing = Actions.retrieveNumberFromPage(Constants.REGEX_FOR_META_MISSING);
        var preProdMetaDuplicate = Actions.retrieveNumberFromPage(Constants.REGEX_FOR_META_DUPLICATE);
        var preProdH1Missing = Actions.retrieveNumberFromPage(Constants.REGEX_FOR_H1_MISSING);
        var preProdH1Duplicate = Actions.retrieveNumberFromPage(Constants.REGEX_FOR_H1_DUPLICATE);
        var preProdH2Missing = Actions.retrieveNumberFromPage(Constants.REGEX_FOR_H2_MISSING);

        softAssert.assertEquals(preProdServerError,0, "500 on preProd -");
        softAssert.assertEquals(preProdTitleMissing,0,"missing title on preProd - ");
        softAssert.assertEquals(preProdTitleDuplicate,0,"duplicate titles on preProd -");
        softAssert.assertEquals(preProdMetaMissing,0,"missing meta on preProd -");
        softAssert.assertEquals(preProdMetaDuplicate,0,"duplicate meta on preProd - ");
        softAssert.assertEquals(preProdH1Missing,0,"missing H1 on preProd -");
        softAssert.assertEquals(preProdH1Duplicate,0,"duplicate H1 on preProd -");
        softAssert.assertEquals(preProdH2Missing,0,"missing H2 on preProd -");
        softAssert.assertTrue(Actions.areApproximatelyEqual(prodPages,preProdPages, THRESHOLD ),
                "there is a big difference between amount of pages on prod and preProd");
        softAssert.assertAll();
    }

        @AfterTest
    public void tearDown(){
        if(driver!=null) {
            driver.quit();
        }
    }

}
