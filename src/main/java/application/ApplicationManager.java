package application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    UserHelper userHelper;
    ContactHelper contactHelper;

    public UserHelper getUserHelper() {
        return userHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }

    public void init() {
        wd = new ChromeDriver();
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