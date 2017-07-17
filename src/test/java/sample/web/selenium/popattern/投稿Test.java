package sample.web.selenium.popattern;

import org.junit.Test;
import sample.web.selenium.TestBase;
import sample.web.selenium.popattern.page.トップページ;
import sample.web.selenium.popattern.page.投稿ページ;
import sample.web.selenium.popattern.page.投稿完了ページ;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class 投稿Test extends TestBase {

    @Test
    public void 投稿する() throws Exception {

        トップページ トップページ = new トップページ(driver);

        投稿ページ 投稿ページ = トップページ.投稿ページに遷移する();

        投稿完了ページ 投稿完了ページ = 投稿ページ.投稿する("さまりー", "テキストですよ");

        // 結果を検証する
        assertThat(投稿完了ページ.getサマリー()).isEqualTo("さまりー");
        assertThat(投稿完了ページ.getテキスト()).isEqualTo("テキストですよ");

        TimeUnit.SECONDS.sleep(5);
    }
}
