import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ArticleCommentCountTest {
    private WebDriver driver;
    private final String URL = ("http://rus.delfi.lv");
    private final By HOME_PAGE_ARTICLE_COMMENT_COUNT = By.xpath(".//a[contains(@class, 'comment')]");
    private final By FIRST_ARTICLE = By.xpath(".//h1[contains(@class, 'headline__title')]");
    private final By ARTICLE_PAGE_COMMENT_COUNT = By.xpath(".//a[contains(@class, '19')]");
    private final By ANONYMOUS_COMMENT_COUNT = By.xpath(".//span[contains(@class, 'cnt')]");
    private final By REGISTER_COMMENT_COUNT = By.xpath("(.//span[@class='select-type-text']/span)[2]");

    @Test
    public void commentCountTest() {

        System.setProperty("webdriver.chrome.driver", "c:/webdrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();

        //Find comment
        WebElement comment = driver.findElement(HOME_PAGE_ARTICLE_COMMENT_COUNT);

        //Save comment count
        int commentCount = Integer.valueOf(comment.getText().replaceAll("\\p{P}", ""));

        //find-click title
        driver.findElement(FIRST_ARTICLE).click();

        //find-save comment count
        int articlePageCommentCount = Integer.valueOf(driver.findElement(ARTICLE_PAGE_COMMENT_COUNT).getText().replaceAll("\\p{P}", ""));

        Assertions.assertEquals(commentCount, articlePageCommentCount, "Wrong comment count on article page!!!");

        //click comment
        driver.findElement(ARTICLE_PAGE_COMMENT_COUNT).click();

        //find-save anonymous comment
        int anonymousCommentCount = Integer.valueOf(driver.findElement(ANONYMOUS_COMMENT_COUNT).getText().replaceAll("\\p{P}", ""));

        //find-save register comment
        int registerCommentCount = Integer.valueOf(driver.findElement(REGISTER_COMMENT_COUNT).getText().replaceAll("\\p{P}", ""));

        Assertions.assertEquals(commentCount, anonymousCommentCount + registerCommentCount, "Wrong comment register and anonymous counts sum!!!");
    }

    @AfterEach
    public void closeBrowser() {
        driver.close();
    }
}
