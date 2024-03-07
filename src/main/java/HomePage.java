import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    By homePageCimriSearchTextBoxBackground = By.xpath("//div[@class='SearchBox_searchBarPlaceholder__2yBF3']");
    By homePageCimriSearchTextBox = By.id("search-input");
    By listePageSaatBaslik = By.xpath("//h1[@class='s1tg1k8o-2 lkHUwQ']");
    By listePageIlkUrun = By.xpath("(//div[@class='z7ntrt-0 gLJVmk s1a29zcm-7 bnaxiu'])[1]");

    By urunPageIlkUrunFiyatText = By.xpath("//span[@class='Offer_price__wzExN']");

    By urunPageMagazayaGitButton = By.xpath("//a[@class='JumpButton_button__CppBA']");
    By urunOrginalPagePriceText = By.xpath("//div[@class='product-price']");

    By getUrunOrginalPagePriceText = By.xpath("//div[@class='product-price']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchCimri() {

        checkElementClickable(homePageCimriSearchTextBoxBackground);
        click(homePageCimriSearchTextBoxBackground);
        checkElementClickable(homePageCimriSearchTextBox);
        elementeDegerYazVeAra(homePageCimriSearchTextBox, "Michael Kors MK5735 Kadın Kol Saati");
        checkElementVisible(listePageSaatBaslik);
        click(listePageIlkUrun);
        checkElementClickable(urunPageMagazayaGitButton);
        String ilkFiyat = getElementText(urunPageIlkUrunFiyatText);
        click(urunPageMagazayaGitButton);
        switchTab(1);
        checkElementVisible(urunOrginalPagePriceText);
        String ikinciFiyat = getElementText(getUrunOrginalPagePriceText);
        checkElementTextIsEqual(ilkFiyat, ikinciFiyat);

    }
}

