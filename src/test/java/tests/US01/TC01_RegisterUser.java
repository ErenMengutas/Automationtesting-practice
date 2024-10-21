package tests.US01;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutoMationexercisePages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC01_RegisterUser extends ExtentReport {
    @Test
    public void RegisterTesti(){

        AutoMationexercisePages autoMationexercisePages=new AutoMationexercisePages();
        SoftAssert softAssert=new SoftAssert();
        Faker faker=new Faker();


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

        extentTest.pass("Kullanici adi ve email girerek sisteme kayıt olur");
        autoMationexercisePages.yeniKullaniciIsimKayitButonu.sendKeys(faker.name().firstName());
        autoMationexercisePages.yeniKullaniciEmailKayitButonu.sendKeys(faker.internet().emailAddress());
        autoMationexercisePages.getYeniKullaniciSignupButonu.click();

        extentTest.pass("Enter Account Infermation yazisinin görünür olduğunu test eder");
        softAssert.assertTrue(autoMationexercisePages.enterAccountInformationYazisi.isDisplayed());

        extentTest.pass("Kayıt formuna gerekli bilgileri doldurarak kayıt olur");
        autoMationexercisePages.signUpforNewsletterbutonu.click();
        autoMationexercisePages.receiveSpecialOfferButonu.click();


        autoMationexercisePages.formName.sendKeys(
                faker.name().firstName()+
                Keys.TAB+ faker.internet().password()+
                Keys.TAB+faker.number().numberBetween(1,31)+
                Keys.TAB+faker.letterify("a")+
                Keys.TAB+faker.number().numberBetween(1990,2000)+
                Keys.TAB+Keys.TAB+Keys.TAB+faker.name().firstName()+
                Keys.TAB+faker.name().lastName()+
                Keys.TAB+faker.name().name()+
                Keys.TAB+faker.address()+
                Keys.TAB+faker.address()+
                Keys.TAB+faker.letterify("a")+
                Keys.TAB+ faker.address().state()+
                Keys.TAB+faker.address().city()+
                Keys.TAB+faker.address().zipCode()+
                Keys.TAB+faker.phoneNumber().phoneNumber() +Keys.ENTER
        );

        extentTest.pass("Hesabınız olusuturuldu yazisinin görünür olduğunu doğrular ve ekran görüntüsü alır");
        softAssert.assertTrue(autoMationexercisePages.accountCreatedYazisi.isDisplayed());
        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));

        extentTest.pass("Devam butonuna tıklar");
        autoMationexercisePages.continueYazisi.click();


        extentTest.pass("Sisteme giriş yapıldığını test eder");
        softAssert.assertTrue(autoMationexercisePages.loggedInButonu.isDisplayed());

        extentTest.pass("Account delete butonuna basar");
        autoMationexercisePages.deleteAccountButonu.click();

        extentTest.pass("Account Deleted yazısının göründüğünü test eder,continue butonuna basar ve sayfayı kapatır");
        softAssert.assertTrue(autoMationexercisePages.accountDeleteYazisi.isDisplayed());






        softAssert.assertAll();
    }
}
