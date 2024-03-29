import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions



class TestIndexPageForBus {
    private lateinit var driver: WebDriver
    private lateinit var indexPage: IndexPage
    private lateinit var indexPageResult: IndexPageResult

    @Before
    fun init() {
        System.setProperty(
            "webdriver.chrome.driver",
            "/usr/bin/chromedriver"
        )

        val chromeOptions = ChromeOptions()
        chromeOptions.addArguments("--headless")
        chromeOptions.addArguments("--no-sandbox")

        driver = ChromeDriver(chromeOptions)
        driver.get("https://rasp.yandex.ru/")

        indexPage = IndexPage(driver)
        indexPage.search("Кемерово проспект Ленина", "Кемерово Бакинский переулок", "среда")
        indexPage.setBus()
        indexPage.clickButtonSubmit()
        Thread.sleep(5000)
        indexPageResult = IndexPageResult(driver)
    }

    @Test
    fun test1() {
        val allPopupErrors = indexPageResult.allPopupErrors()
        if (allPopupErrors.size == 0)
            Assert.fail()

        val element = allPopupErrors.find { it.text == "Пункт отправления не найден" }
        Assert.assertNotNull(element)
    }

    @After
    fun close() {
        indexPage.close()
    }
}
