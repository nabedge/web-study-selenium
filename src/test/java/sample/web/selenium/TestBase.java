package sample.web.selenium;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sample.web.ui.SampleWebUiApplication;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by nabedge
 */
public class TestBase {

    protected WebDriver driver;

    protected static final Logger log = LoggerFactory.getLogger(BasicTest.class);

    public TestBase() {
        // chrome用のWebDriverを自動ダウンロードするおまじない
        ChromeDriverManager.getInstance().setup();
    }

    @BeforeClass
    public static void beforeClass() throws Exception {
        log.info("テスト対象のアプリケーションを起動する");
        SampleWebUiApplication.main(new String[]{});
    }

    @AfterClass
    public static void afterClass() throws Exception {
        log.info("テスト対象のアプリケーションを終了する");
        SampleWebUiApplication.close();
    }

    private WebDriver createChromeDriver() {
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        return new ChromeDriver(capabilities);
    }


    @Before
    public void before() throws Exception {

        WebDriver wd = createChromeDriver();

        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wd.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        wd.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
        wd.manage().window().setSize(new Dimension(1100, 700));
        wd.manage().deleteAllCookies();

        this.driver = wd;
    }

    @After
    public void after() throws Exception {
        if (this.driver != null) {
            this.driver.quit();
        }
    }

}
