package tests.US01;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutoMationexercisePages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC04_NegatifRegisterTesti extends ExtentReport {
    @Test
    public void negatifKayıt(){
        AutoMationexercisePages autoMationexercisePages=new AutoMationexercisePages();
        SoftAssert softAssert=new SoftAssert();

        extentTest=extentReports.createTest("Negatif Login Testi",
                                            "Kullanici daha önce kayıt edilmiş email ve şifre ile tekrar kayıt olamamalı");

        extentTest=extentReports.createTest("Hesap oluşturulup silme testi",
                "Kullanıcı oluşturduğu hesabın silinebildiğini test eder.");

        extentTest.pass("Kullanici autoMationexercise sitesine gider");
        Driver.getDriver().get(ConfigReader.getProperty("autom"));

        extentTest.pass("Kullanıcı doğru sayfaya gittiğini doğrular");
        String expectedTitle=ConfigReader.getProperty("expectedTitle");
        String actualTitle=Driver.getDriver().getTitle();
        softAssert.assertEquals(actualTitle,expectedTitle);

        extentTest.pass("Sign up butonuna basar");
        autoMationexercisePages.signUpLoginButonu.click();


        extentTest.pass("Yeni kullanici Sign in butonunun görünür olduğunu test eder");
        softAssert.assertTrue(autoMationexercisePages.yeniKullaniciSignupYazisi.isDisplayed());

        extentTest.pass("Daha önce kayıt yapılmış kullanici adini ve emaili girerek sign up butonuna tıklar");
        autoMationexercisePages.yeniKullaniciIsimKayitButonu.sendKeys(ConfigReader.getProperty("gecerliKullaniciEmail"));
        autoMationexercisePages.yeniKullaniciEmailKayitButonu.sendKeys(ConfigReader.getProperty("gecerliKullaniciEmail"));
        autoMationexercisePages.getYeniKullaniciSignupButonu.click();

        extentTest.pass("'Email Address already exist' yazısının görünür olduğunu doğrular, ekran görüntüsü alır ve sayfayı kapatır");
        softAssert.assertTrue(autoMationexercisePages.emailAddressalreadyexistUyariYazisi.isDisplayed());
        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));





        softAssert.assertAll();
    }
}
