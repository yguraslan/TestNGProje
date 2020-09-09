package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WaitTest extends TestBase {

    @Test
    public void implicitlyWait() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement removeButtonu = driver.findElement(By.xpath("//*[.='Remove']"));
        removeButtonu.click();

        WebElement element = driver.findElement(By.xpath("//*[.='Add']"));
    }

    @Test
    public void explicitWait() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        //Explicit Wait kullanmak icin WebDriverWait class indan nesne uretmek zorundayiz
        WebDriverWait wait = new WebDriverWait(driver,30);

        WebElement removeButton = driver.findElement(By.xpath("//*[.='Remove']"));
        removeButton.click();

        //<p id="message">It's gone!</p>
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        System.out.println(message.getText());
    }
}