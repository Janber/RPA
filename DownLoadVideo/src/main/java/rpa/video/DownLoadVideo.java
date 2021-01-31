package rpa.video;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import rpa.common.CommonUtils;
import rpa.common.Constants;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author Jianbo
 * @version 1.0
 * @date 2021/1/23 下午1:40
 */
public class DownLoadVideo {

    public static void getVideo() throws AWTException {

        System.setProperty("webdriver.chrome.driver", Constants.ChromeDriverPath);

        ChromeOptions options = new ChromeOptions();
//        String userProfile = "C:/Users/kousei/AppData/Local/Google/Chrome/User Data";
        String userProfile = "/Users/kousei/Library/Application Support/Google/Chrome";
        options.addArguments("user-data-dir=" + userProfile);
        options.addArguments("--start-maximized");


        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://www.youtube.com/");

        WebElement searchWord = driver.findElement(By.id("search"));
        searchWord.sendKeys("news");
        WebElement search = driver.findElement(By.id("search-icon-legacy"));

        search.click();

        DoSleep(3000);


        WebElement login = driver.findElement(By.xpath("//*[@id=\"container\"]/ytd-toggle-button-renderer/a"));
        login.click();


        DoSleep(3000);

        WebElement today = driver.findElement(By.xpath("/html/body/ytd-app/div/ytd-page-manager/ytd-search/div[1]/ytd-two-column-search-results-renderer/div/ytd-section-list-renderer/div[1]/div[2]/ytd-search-sub-menu-renderer/div[1]/iron-collapse/div/ytd-search-filter-group-renderer[1]/ytd-search-filter-renderer[2]/a"));
        today.click();


        DoSleep(3000);

        WebElement login1 = driver.findElement(By.xpath("//*[@id=\"container\"]/ytd-toggle-button-renderer/a"));
        login1.click();

        DoSleep(3000);

        WebElement mini4 = driver.findElement(By.xpath("/html/body/ytd-app/div/ytd-page-manager/ytd-search/div[1]/ytd-two-column-search-results-renderer/div/ytd-section-list-renderer/div[1]/div[2]/ytd-search-sub-menu-renderer/div[1]/iron-collapse/div/ytd-search-filter-group-renderer[3]/ytd-search-filter-renderer[1]/a"));
        mini4.click();

        DoSleep(3000);

        WebElement login2 = driver.findElement(By.xpath("//*[@id=\"container\"]/ytd-toggle-button-renderer/a"));
        login2.click();

        DoSleep(3000);

        WebElement clickNum = driver.findElement(By.xpath("/html/body/ytd-app/div/ytd-page-manager/ytd-search/div[1]/ytd-two-column-search-results-renderer/div/ytd-section-list-renderer/div[1]/div[2]/ytd-search-sub-menu-renderer/div[1]/iron-collapse/div/ytd-search-filter-group-renderer[5]/ytd-search-filter-renderer[3]/a"));
        clickNum.click();


        DoSleep(3000);

        String URL1 = "/html/body/ytd-app/div/ytd-page-manager/ytd-search/div[1]/ytd-two-column-search-results-renderer/div/ytd-section-list-renderer/div[2]/ytd-item-section-renderer/div[3]/ytd-video-renderer[";
        String URL2 = "]/div[1]/div/ytd-badge-supported-renderer/div[1]/span";

        Integer i = 1;
        Boolean dlFlg = false;
        while (i <= 20 && !dlFlg){
            String URL = URL1 + i.toString() + URL2;
            WebElement row = driver.findElement(By.xpath(URL));

            if (row.getText().equals("新着")){

                row.click();

                DoSleep(3000);
                WebElement download2 = driver.findElement(By.xpath("/html/body/ytd-app/div/ytd-page-manager/ytd-watch-flexy/div[5]/div[1]/div/div[5]/div[2]/div"));

                System.out.println(download2.getText());
                download2.click();
                DoSleep(20000);

                driver.navigate().back();

                DoSleep(1000);
            }
            i++;
        }

        driver.close();

    }


    /**
     * 秒間隔でスリーブ
     */
    private static void DoSleep(Integer sleeptime) {
        try {
            Thread.sleep(sleeptime);
        } catch (InterruptedException e) {
            System.out.println(CommonUtils.GetSystemTime() + e.toString());
        }
    }
}
