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

public class TC14_OdemedenOnceKayitOlusturma extends ExtentReport {
    @Test
    public void odemeSonrasıKayitTesti(){
        AutoMationexercisePages autoMationexercisePages=new AutoMationexercisePages();
        SoftAssert softAssert=new SoftAssert();
        Faker faker=new Faker();


        extentTest=extentReports.createTest("Kullanici ödeme isleminden önce sisteme kayıt olur",
                "Kullanici ödeme isleminden önce sisteme kayıt olup odeme yapılabildiğini test eder ");

        extentTest.pass("Kullanici autoMationexercise sitesine gider");
        Driver.getDriver().get(ConfigReader.getProperty("autom"));

        extentTest.pass("Kullanıcı doğru sayfaya gittiğini doğrular");
        String expectedTitle=ConfigReader.getProperty("expectedTitle");
        String actualTitle=Driver.getDriver().getTitle();
        softAssert.assertEquals(actualTitle,expectedTitle,
                                        "Title bilgileri farklı");

        extentTest.pass("Sign up butonuna basar");
        autoMationexercisePages.signUpLoginButonu.click();

        extentTest.pass("Yeni kullanici Sign in butonunun görünür olduğunu test eder");
        softAssert.assertTrue(autoMationexercisePages.yeniKullaniciSignupYazisi.isDisplayed(),
                                                        "Sign in Butonu gözükmüyor");

        extentTest.pass("Kullanici adi ve email girerek sisteme kayıt olur");
        autoMationexercisePages.yeniKullaniciIsimKayitButonu.sendKeys(faker.name().firstName());
        autoMationexercisePages.yeniKullaniciEmailKayitButonu.sendKeys(faker.internet().emailAddress());
        autoMationexercisePages.getYeniKullaniciSignupButonu.click();

        extentTest.pass("Enter Account Infermation yazisinin görünür olduğunu test eder");
        softAssert.assertTrue(autoMationexercisePages.enterAccountInformationYazisi.isDisplayed(),
                "Enter Account Infermation yazisi gözükmüyor");

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
        softAssert.assertTrue(autoMationexercisePages.accountCreatedYazisi.isDisplayed(),
                                        "Hesabınız olusuturuldu yazisi gözükmüyor");
        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));


        extentTest.pass("Devam butonuna tıklar");
        autoMationexercisePages.continueYazisi.click();


        extentTest.pass("Sisteme giriş yapıldığını test eder");
        softAssert.assertTrue(autoMationexercisePages.loggedInButonu.isDisplayed(),
                                                        "sisteme giriş yapılamadı");

        extentTest.pass("Ilk urunun üzerinde ki 'Add Cart' butonunna tıklar");
        ReusableMethods.click(autoMationexercisePages.ilkUrunUzerindekiAddCartButonu);

        extentTest.pass("Cıkan uyarıda View Cart Butonuna tıklar");
        autoMationexercisePages.viewCartElementi.click();

        extentTest.pass("Sepete urun eklendiğini test eder");
        softAssert.assertTrue(autoMationexercisePages.sepettekiIlkurun.isDisplayed(),"" +
                                                      "Sepete urun eklenemedi");

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

        extentTest.pass("Çıkan sayfada ödeme bilgilerini girer ve enter tuşuna basar ve ekran görüntüsü alır");
        autoMationexercisePages.krediKartiIsimBolumu.sendKeys(faker.name().firstName() +
                Keys.TAB+faker.finance().creditCard() +
                Keys.TAB+faker.number().numberBetween(100,999)+
                Keys.TAB+faker.letterify("mm") +
                Keys.TAB+faker.number().numberBetween(2024,2028)+
                Keys.ENTER);

        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));

        extentTest.pass("Your order has been placed successfully!'Yazısının çıktığını doğrular");

        softAssert.assertTrue(autoMationexercisePages.orderPlacedYaziElementi.isDisplayed(),
                "Your order has been placed successfully!' yazısı gözükmüyor");

        extentTest.pass("Continue butonuna tiklar");
        autoMationexercisePages.continueYazisi.click();

        extentTest.pass("Account delete butonuna basar");
        autoMationexercisePages.deleteAccountButonu.click();

        extentTest.pass("Account Deleted yazısının göründüğünü test eder,continue butonuna basar ve sayfayı kapatır");
        ReusableMethods.bekle(1);
        softAssert.assertTrue(autoMationexercisePages.accountDeleteYazisi.isDisplayed(),
                                                            "Account Deleted yazısı gözükmüyor");

        softAssert.assertAll();

    }
}
