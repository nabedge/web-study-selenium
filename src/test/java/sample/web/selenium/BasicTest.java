package sample.web.selenium;

import org.junit.Test;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class BasicTest extends TestBase {

    @Test
    public void test_トップページを表示して3秒で閉じる() throws Exception {

        // ブラウザを開いてトップページへ移動
        driver.get("http://localhost:8080");

        // h1タグの中身を検証する
        String h1Title = driver.findElement(By.tagName("h1")).getText();
        assertThat(h1Title).contains("Messages : View all");

        TimeUnit.SECONDS.sleep(3);
    }

    @Test
    public void test_投稿する() throws Exception {

        // ブラウザを開いてトップページへ移動
        driver.get("http://localhost:8080");
        TimeUnit.SECONDS.sleep(3);

        // "Create Message"というリンクを探して踏む
        driver.findElement(By.linkText("Create Message")).click();

        // h1タグの中身を検証する
        String h1Title = driver.findElement(By.tagName("h1")).getText();
        assertThat(h1Title).contains("Messages : Create");
        TimeUnit.SECONDS.sleep(3);

        // サマリーとメッセージ詳細を入力してsaveボタンを押す
        final String summary = "サマリーです";
        final String text = "メッセージです";
        driver.findElement(By.id("summary")).sendKeys(summary);
        driver.findElement(By.id("text")).sendKeys(text);
        TimeUnit.SECONDS.sleep(3);
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();

        // 保存されたことを検証する
        String alertMessage = driver.findElement(By.className("alert-success")).getText();
        assertThat(alertMessage).contains("Successfully created a new message");
        assertThat(driver.findElement(By.id("summary")).getText()).isEqualTo(summary);
        assertThat(driver.findElement(By.id("text")).getText()).isEqualTo(text);

        TimeUnit.SECONDS.sleep(3);
    }
}
