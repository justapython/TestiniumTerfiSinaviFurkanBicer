/**
 *
 *  Created by furkanbicer@testinium.com (07.03.2024)
 *
 *  Projenin çalışması için Chromedriver'ın projeye eklenmesi gerekmez.
 *  Pom.xml'de yer alan io.github.bonigarcia ile kullanılan makinenin chrome driverın versiyonu otomatik olarak algılanarak test koşumu sağlanmaktadır.
 *  Projede statik bekleme kullanılmadı ve tüm beklemeler dinamik olarak yazıldı.
 *  BasePage java classı methodların yazıldığı class ve HomePage classı ise senaryonun elementlerinin alınarak
 *  otomasyon sırasının verildiği yerdir. Burada HomePage-ListePage-UrunPage adı altında da ekstra baslıklar
 *  acmak istedim ancak anlamadığım bir hata aldım. Farklı classlar ile daha anlasılır olabilirdi.
 *
 *
 * BaseTest BeforeALL ve AfterAll adımlarını (driverın ayağa kalkaması ve kapanması) adımlarını içerir.
 * Test_Kosumu java classında otomasyon koşumu gerçekleştirilebilir.
 *
 *
 * Pom'un maven tarafından güncellendiği bir senaryoda driver hatası alınıyorsa bonigarcia sürümü güncellenmis
 * demektir. Bu projede son sürüm kullanıldı.
 *
 *  Senaryo;
 *  Cimri.com sitesine gidilir.
 *  Michael Kors MK5735 Kadın Kol Saati araması yapılır
 *  İlk listelenen ürünün cimri sitesindeki datay ekranına gidilir ve bu ekrandaki fiyat değeri alınır
 *  Bu sayfada Mağazaya git butonu kullanılır ve ürünün mağaza sayfasına gidilir.
 *  Mağaza sayfasındaki ürün fiyatı ile cimri sitesindeki ürün fiyatı karşılaştırılır.
 *
 *
 *
 *  Excelden veri çekimi ve Allure report için yeterli zamanım kalmadı.
 *
 * */

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

public class BasePage {
    WebDriver driver;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement find(By locator) {
        return driver.findElement(locator);
    }
    public void click(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
        webElement.click();
    }

    public void elementeDegerYazVeAra(By locator, String key){

        WebElement inputElement = driver.findElement(locator);
        inputElement.sendKeys(key); // İstediğin değeri burada yazabilirsin
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }

    public String getElementText(By locator){

        String element = driver.findElement(locator).getText();
        return element;

    }

    public void checkElementTextIsEqual(String key1, String key2){

        if (key1.equals(key2)){
            System.out.printf("Fiyat degerleri birbirine esit.");
        }
        else {
            System.out.println("Fiyat degerleri birbirine esit degil.");
        }

    }

    public void checkElementClickable(By locator) {
        try {
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(locator));
            System.out.println("Element is clickable");
        } catch (TimeoutException e) {
            System.out.println("Element isn't clickable");
        }
    }
    public boolean checkElementVisible(By locator) {

        try {
            new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(locator));
            logger.info("true");
            return true;
        } catch (Exception e) {
            logger.info("false" + " " + e.getMessage());
            return false;
        }
    }
    public void switchTab(int tabNumber){

        driver.switchTo().window(listTabs().get(tabNumber));
    }
    public List<String> listTabs(){
        List<String> list = new ArrayList<String>();
        for (String window: driver.getWindowHandles()){
            list.add(window);
        }
        return list;
    }


}

