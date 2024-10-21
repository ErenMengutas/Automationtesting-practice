package tests.US01;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutoMationexercisePages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC06_AnasayfaTestCasesButonu extends ExtentReport {
    @Test
    public void anasayfaTestCaseButonu(){
        AutoMationexercisePages autoMationexercisePages=new AutoMationexercisePages();
        SoftAssert softAssert=new SoftAssert();
        Faker faker=new Faker();


        extentTest=extentReports.createTest("Anasayfa'da bulunan test case butonu doğrulama",
                "Kullanıcı anasayfada ki 'Test Cases' butonunun görünür ve kullanilabilir olduğunu test eder .");

        extentTest.pass("Kullanici autoMationexercise sitesine gider");
        Driver.getDriver().get(ConfigReader.getProperty("autom"));

        extentTest.pass("Kullanıcı doğru sayfaya gittiğini doğrular");
        String expectedTitle=ConfigReader.getProperty("expectedTitle");
        String actualTitle=Driver.getDriver().getTitle();
        softAssert.assertEquals(actualTitle,expectedTitle);

        extentTest.pass("'Test Cases' butonunun görünür olduğunu doğrular");
        softAssert.assertTrue(autoMationexercisePages.anaSayfaTestCasesButonu.isDisplayed(),"Test Case butonu gözükmüyor");

        extentTest.pass("'Test Cases' butonuna tiklar");
        autoMationexercisePages.anaSayfaTestCasesButonu.click();

        extentTest.pass("'Test Cases' sayfasında olduğunu doğrular, ekran görüntüsü alır ve sayfayı kapatır");
        softAssert.assertTrue(autoMationexercisePages.testCaseYaziElementi.isDisplayed(),"Test Case yazi elementi gözükmüyor");
        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));

        softAssert.assertAll();
    }
}
