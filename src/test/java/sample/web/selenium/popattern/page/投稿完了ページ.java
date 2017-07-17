package sample.web.selenium.popattern.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class 投稿完了ページ {

    private WebDriver driver;

    // ページ内の要素を定数として定義
    private By サマリーのセレクタ = By.id("summary");
    private By テキストのセレクタ = By.id("text");

    public 投稿完了ページ(WebDriver driver) {
        this.driver = driver;
    }

    public String getサマリー() {
        return driver.findElement(サマリーのセレクタ).getText();
    }

    public String getテキスト() {
        return driver.findElement(テキストのセレクタ).getText();
    }

}
