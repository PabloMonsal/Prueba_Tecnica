package co.com.t_evolvers.utils;

import org.openqa.selenium.WebDriver;

public class ClickAlert {

    public ClickAlert() {
    }

    public static void clickAlert(WebDriver driver){
        driver.switchTo().alert().accept();
    }
}
