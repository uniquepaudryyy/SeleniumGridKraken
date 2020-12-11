package test.Login;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LoginSteps {

    WebDriver driver;

    @Parameters("browser")
    public void launch_browser(String browser) throws MalformedURLException {

        String URL = "https://kraken-web.sumpahpalapa.com/";

        if (browser.equalsIgnoreCase("firefox")) {
            System.out.println(" Executing on FireFox");
            String Node = "http://192.168.43.173:5567/wd/hub";
            DesiredCapabilities cap = DesiredCapabilities.firefox();
            cap.setBrowserName("firefox");

            driver = new RemoteWebDriver(new URL(Node), cap);
            // Puts an Implicit wait, Will wait for 10 seconds before throwing
            // exception
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            // Launch website
            driver.navigate().to(URL);
            driver.manage().window().maximize();
        } else if (browser.equalsIgnoreCase("chrome")) {
            System.out.println(" Executing on Chrome");
            DesiredCapabilities cap = DesiredCapabilities.chrome();
            cap.setBrowserName("chrome");
            String Node = "http://192.168.43.173:5566/wd/hub";
            driver = new RemoteWebDriver(new URL(Node), cap);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            // Launch website
            driver.navigate().to(URL);
            driver.manage().window().maximize();
        } else if (browser.equalsIgnoreCase("safari")) {
            System.out.println(" Executing on Safari");
            DesiredCapabilities cap = DesiredCapabilities.safari();
            cap.setBrowserName("safari");
            String Node = "http://192.168.43.173:5566/wd/hub";
            driver = new RemoteWebDriver(new URL(Node), cap);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            // Launch website
            driver.navigate().to(URL);
            driver.manage().window().maximize();
        } else {
            throw new IllegalArgumentException("The Browser Type is Undefined");
        }
    }

    // Input username
    public void input_username(){
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div/div/div[1]/div[1]/input")).sendKeys("kraken");
    }
    // Input password
    public void input_password() {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div/div/div[1]/div[2]/input")).sendKeys("kraken");
    }

    // Click Login Button
    public void click_login_button(){
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div/div/div[1]/div[4]/div[1]/button")).click();
    }

    //Assert success open dashboard
    public void login_success(){
        String dashboard = driver.findElement(By.id("qe_dashboard_breadcrumb")).getText();
        Assert.assertEquals("Dashboard", dashboard);
    }

    public void close_browser() {
        driver.quit();
    }
}