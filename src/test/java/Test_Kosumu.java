import org.junit.jupiter.api.Test;

public class Test_Kosumu extends BaseTest {

    HomePage homePage;


    @Test
    public void homePageSearch(){

        homePage = new HomePage(driver);
        homePage.searchCimri();

    }

}