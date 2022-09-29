package LoginTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class Login_With_Credentials {

   Object[][]data={
           {"Admin","admin123"},
           {"Admin01","ad1mn1"},
           {"Admin","asm1i"},
           {"dmin","admin123"}

    };

    @DataProvider(name = "loginCredentials")
    public Object[][] loginDataProvider() {
        return data;

    }
    @Test(dataProvider ="loginCredentials")
    public void loginwithBIC(String Uname,String Pword){

        WebDriver driver=new EdgeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement username= driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys(Uname);

        WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys(Pword);

        WebElement login= driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();

    }
}
