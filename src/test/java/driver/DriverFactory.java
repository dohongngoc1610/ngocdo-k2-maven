package driver;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {

    // DriverFactory.getChromeDriver();

    public static WebDriver getChromeDriver(){
        // Current project directory
        String currentProjectDirectoryLocation=System.getProperty("user.dir");

        // Specify ChromeDriver Option | Incognito
        String chromeDriverLocation="";
        if(OS.isFamilyMac())
            chromeDriverLocation=currentProjectDirectoryLocation+"/src/test/resources/drivers/chromedriver";
        if(OS.isFamilyWindows())
            chromeDriverLocation=currentProjectDirectoryLocation+"\\src\\test\\resources\\drivers\\chromedriver.exe";
        if(chromeDriverLocation==null)
            throw new IllegalArgumentException("Can't detech current OS");

        System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--incognito");

        // Session initialization
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        return driver;
    }

}
