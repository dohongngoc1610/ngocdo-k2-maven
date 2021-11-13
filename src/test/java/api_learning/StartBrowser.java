package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;

public class StartBrowser implements Urls {


    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= DriverFactory.getChromeDriver();

        // Launch target test url
        driver.get(baseUrl);

        // DEBUG purpose ONLY
        Thread.sleep(2000);

        // Quit the session
        driver.quit();

    }
}
