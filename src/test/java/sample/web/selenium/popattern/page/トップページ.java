package sample.web.selenium.popattern.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class トップページ {

    private WebDriver driver;

    // ページ内の要素を定数として定義
    By 投稿ページへ遷移するリンク = By.linkText("Create Message");

    public トップページ(WebDriver driver) {
        this.driver = driver;
        // トップページをひらく
        driver.get("http://localhost:8080");
    }

    // そのページで行える動作をメソッドとして定義
    public 投稿ページ 投稿ページに遷移する() {
        driver.findElement(投稿ページへ遷移するリンク).click();
        return new 投稿ページ(driver);
    }

}
