package tests.US01;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutoMationexercisePages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC05_Musteri_iletisim_Formu extends ExtentReport {
    @Test
    public void musteriIletişimFormu(){

        AutoMationexercisePages autoMationexercisePages=new AutoMationexercisePages();
        SoftAssert softAssert=new SoftAssert();

        extentTest=extentReports.createTest("Musteri iletişim formu tesi",
                "Kullanıcı müşteri ileişim formunu doldurarak dosya yükleyebilmeli");

        extentTest.pass("Kullanici autoMationexercise sitesine gider");
        Driver.getDriver().get(ConfigReader.getProperty("autom"));

        extentTest.pass("Kullanıcı doğru sayfaya gittiğini doğrular");
        String expectedTitle=ConfigReader.getProperty("expectedTitle");
        String actualTitle=Driver.getDriver().getTitle();
        softAssert.assertEquals(actualTitle,expectedTitle);

        extentTest.pass("Contact us butonunun görünür olduğunu test eder");
        softAssert.assertTrue(autoMationexercisePages.contactUsButonu.isDisplayed());

        extentTest.pass("Contact us butonuna tiklar");
        autoMationexercisePages.contactUsButonu.click();

        extentTest.pass("'Get In Touch' yazisinin göründüğünü doğrular");
        softAssert.assertTrue(autoMationexercisePages.getInTounchYaziElementi.isDisplayed());

        extentTest.pass("Musteri iletişim formunu doldurur");
        autoMationexercisePages.contactUsNameButonu.sendKeys(ConfigReader.getProperty("gecerliKullaniciAdi")+ Keys.TAB+
        ConfigReader.getProperty("gecerliKullaniciEmail")+Keys.TAB+"Musteri şikayet formu"+Keys.TAB+"ilgili mesaj girildi");

        extentTest.pass("Musteri iletisim formu dosyasını sisteme yükler ");
        String dosyaYolu=System.getProperty("user.dir")+"/"+"src/test/java/tests/US01/musteriIletisimFormu.txt";
        autoMationexercisePages.uploadFile.sendKeys(dosyaYolu);

        extentTest.pass("Submit butonuna tıklar");
        autoMationexercisePages.musteriIletisimSubmitButonu.click();

        extentTest.pass("Cıkan Alert yazısında accepte tıklar");
        Driver.getDriver().switchTo().alert().accept();

        extentTest.pass("'Success! Your details have been submitted successfully.'" +
                                "yazi elementinin çıktığını doğrular, ekran görüntüsü alır");
        softAssert.assertTrue(autoMationexercisePages.succesYaziElementi.isDisplayed());
        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));

        extentTest.pass("Home butonuna tıklar ve Ana sayfada olduğunu doğrular ve sayfayı kapatır");
        autoMationexercisePages.musteriFormundanSonraCıkanHomeButonu.click();
        softAssert.assertEquals(actualTitle,expectedTitle);

        softAssert.assertAll();
    }
}
