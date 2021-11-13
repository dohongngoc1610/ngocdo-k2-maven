package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormHandling implements Urls{
    private static final By usernameSel=By.id("username");
    private static final By passwordSel=By.cssSelector("#password");
    private static final By loginBtnSel=By.cssSelector("[type='submit']");

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= DriverFactory.getChromeDriver();

        // Open target URL
        String loginUrl=baseUrl.concat(loginSlug);
        driver.get(loginUrl);

        String username="tomsmith";
        String password="SuperSecretPassword!";

        try {
            login(driver,username,password);
            Thread.sleep(2000);
        } catch (Exception ignored) {
        } finally {
            driver.quit();
        }


    }

    private static void login(WebDriver driver,String username, String password){
            // Find username and password element
            WebElement usernameElement=driver.findElement(usernameSel);
            WebElement passwordElement=driver.findElement(passwordSel);
            WebElement loginBtnElement=driver.findElement(loginBtnSel);

            usernameElement.sendKeys("tomsmith");
            passwordElement.sendKeys("SuperSecretPassword!");

            loginBtnElement.click();
        }

}
