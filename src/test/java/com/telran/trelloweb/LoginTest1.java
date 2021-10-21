package com.telran.trelloweb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class LoginTest1 {

    WebDriver wd;

    @BeforeClass
    public void setUp(){
         wd = new ChromeDriver();
         wd.manage().window().maximize();//
         wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// wait 10 seconds
         wd.navigate().to("https://trello.com/");
    }

    @Test
    public void testLogin() throws InterruptedException {
        click(By.cssSelector("[href='/login']"));
        type(By.cssSelector("#user"),"juliakliot.jk@gmail.com");
        Thread.sleep(2000);
        click(By.cssSelector("#login"));
        type(By.name("password"), "misha240613");
        click(By.id("login-submit"));
        Thread.sleep(15000);

        Assert.assertTrue(wd.findElements(By.cssSelector("._2ft40Nx3NZII2i")).size() > 0);

    }

    public void type(By locator2, String text) {
        click(locator2);
        wd.findElement(locator2).clear();
        wd.findElement(locator2).sendKeys(text);
    }

    private void click(By locator) {
        wd.findElement(locator).click();
    }

    @AfterClass
    public void tearDown(){
    //wd.close();
        wd.quit();
    }
}
