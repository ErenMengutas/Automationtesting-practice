package tests.US03;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutoMationexercisePages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC15_OdemeYapmadanGiris extends ExtentReport {
    @Test
    public void odemeYapmadanGirisYapmaTesti(){
        AutoMationexercisePages autoMationexercisePages=new AutoMationexercisePages();
        SoftAssert softAssert=new SoftAssert();
        Faker faker=new Faker();

        extentTest=extentReports.createTest("Odeme yapmadan önce sisteme giriş yapma",
                "Kullanıcı ödeme yapmadan önce sisteme gecerli kullanıcı adı ve e-posta ile giriş yapabilmeli");

        extentTest.pass("Kullanici autoMationexercise sitesine gider");
        Driver.getDriver().get(ConfigReader.getProperty("autom"));

        extentTest.pass("Kullanıcı doğru sayfaya gittiğini doğrular");
        String expectedTitle=ConfigReader.getProperty("expectedTitle");
        String actualTitle=Driver.getDriver().getTitle();
        softAssert.assertEquals(actualTitle,expectedTitle,"Title bilgileri farklı");

        extentTest.pass("Sign up butonuna basar");
        autoMationexercisePages.signUpLoginButonu.click();


        extentTest.pass("'Login To Your Account' yazisinin görünür olduğunu test eder");
        softAssert.assertTrue(autoMationexercisePages.loginToYourAccountYazisi.isDisplayed(),
                                                "Login To Your Account' yazisi gözükmüyor");

        extentTest.pass("Geçerli kullanici adi, sifre girer ve login butonuna tıklar");
        autoMationexercisePages.mevcutKullaniciEmailButonu.sendKeys(ConfigReader.getProperty("gecerliKullaniciEmail"));
        autoMationexercisePages.mevcutKullaniciPassButonu.sendKeys(ConfigReader.getProperty("gecerliSifre"));
        autoMationexercisePages.mevcutKullaniciLoginButonu.click();

        extentTest.pass("Sisteme giriş yapıldığını test eder ve ekran görüntüsü alır");
        softAssert.assertTrue(autoMationexercisePages.loggedInButonu.isDisplayed(),
                                                "Sisteme giriş yapılmadı");
        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));

        extentTest.pass("Ilk urunun üzerinde ki 'Add Cart' butonunna tıklar");
        ReusableMethods.click(autoMationexercisePages.ilkUrunUzerindekiAddCartButonu);

        extentTest.pass("Cıkan uyarıda View Cart Butonuna tıklar");
        autoMationexercisePages.viewCartElementi.click();

        extentTest.pass("Sepete urun eklendiğini test eder");
        softAssert.assertTrue(autoMationexercisePages.sepettekiIlkurun.isDisplayed(),
                                                        "Sepe urun eklenemedi");

        extentTest.pass("Odeme işlemleri için 'Proceed To Checkout' butonuna tıklar");
        autoMationexercisePages.sepettekiOdemeButonu.click();

        extentTest.pass("Delivery addres ve billing addres yazılarının gözüktüğünü doğrular");
        softAssert.assertTrue(autoMationexercisePages.delievryAdressYazisi.isDisplayed(),
                                           "Delivery addres yazısı gözükmüyor");
        softAssert.assertTrue(autoMationexercisePages.billingAdressYazisi.isDisplayed(),
                                            "Billing addres yazısı gözükmüyor");

        extentTest.pass("Sepettki açıklamalar bölümüne istenilen yazıyı yazar ve 'place order' butonuna basar");
        autoMationexercisePages.sepettekiAciklamalarBolumu.sendKeys(ConfigReader.getProperty("istenilenAciklama"));
        autoMationexercisePages.placeOrderButonu.click();

        extentTest.pass("Çıkan sayfada ödeme bilgilerini girer ve enter tuşuna basar");
        autoMationexercisePages.krediKartiIsimBolumu.sendKeys(faker.name().firstName() +
                Keys.TAB+faker.finance().creditCard() +
                Keys.TAB+faker.number().numberBetween(100,999)+
                Keys.TAB+faker.letterify("mm") +
                Keys.TAB+faker.number().numberBetween(2024,2028)+
                Keys.ENTER);

        extentTest.pass("Your order has been placed successfully!'Yazısının çıktığını doğrular ve ekran görüntüsü alır");
        ReusableMethods.bekle(1);

        softAssert.assertTrue(autoMationexercisePages.orderPlacedYaziElementi.isDisplayed(),
                "Your order has been placed successfully!' yazısı gözükmüyor");
        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));

        softAssert.assertAll();
    }
}
