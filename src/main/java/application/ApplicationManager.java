package application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    UserHelper userHelper;
    ContactHelper contactHelper;
    String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public UserHelper getUserHelper() {
        return userHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }

    public void init() {

        if(browser.equals(BrowserType.CHROME)){
            wd = new ChromeDriver();
        }
        else if(browser.equals(BrowserType.FIREFOX)){
            wd = new FirefoxDriver();
        }
        else if(browser.equals(BrowserType.EDGE)){
            wd = new EdgeDriver();
        }

        wd.manage().window().maximize();
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        userHelper = new UserHelper(wd);
        contactHelper = new ContactHelper(wd);
    }

    /*public void stop() {

        wd.quit();
    }*/

}
