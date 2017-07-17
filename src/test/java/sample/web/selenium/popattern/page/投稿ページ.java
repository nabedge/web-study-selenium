package sample.web.selenium.popattern.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by nabedge
 */
public class 投稿ページ {

    private WebDriver driver;

    // ページ内の要素を定数として定義
    By サマリーのinput = By.id("summary");
    By テキストのinput = By.id("text");
    By Saveボタン = By.cssSelector("input[type=\"submit\"]");

    public 投稿ページ(WebDriver driver) {
        this.driver = driver;
    }

    public 投稿完了ページ 投稿する(String summary, String text){

        // サマリーとメッセージ詳細を入力してsaveボタンを押す
        driver.findElement(サマリーのinput).sendKeys(summary);
        driver.findElement(テキストのinput).sendKeys(text);
        driver.findElement(Saveボタン).click();

        return new 投稿完了ページ(driver);
    }
}
