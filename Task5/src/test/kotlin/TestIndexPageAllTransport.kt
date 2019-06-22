import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

class TestIndexPageAllTransport {
    private lateinit var driver: WebDriver
    private lateinit var indexPage: IndexPage
    private lateinit var indexPageResult: IndexPageResult

    @Before
    fun setup() {
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
        indexPage.search("Кемерово", "Москва", "7 июля")
        indexPage.clickButtonSubmit()
        Thread.sleep(5000)
        indexPageResult = IndexPageResult(driver)
    }

    @Test
    fun test1() {
        val allSegmentIcon = indexPageResult.allSearchSegment()

        if (allSegmentIcon.size == 0)
            Assert.fail()
        try {
            allSegmentIcon.forEach { it.findElement(By.className("SegmentTitle__title")) }
            Assert.assertTrue(true)
        } catch (ex: Exception) {
            Assert.fail()
        }

    }

    @Test
    fun test2() {
        val allSegmentIcon = indexPageResult.allSearchSegment()

        if (allSegmentIcon.size == 0)
            Assert.fail()
        try {
            allSegmentIcon.forEach { it.findElement(By.className("SearchSegment__duration")) }
            Assert.assertTrue(true)
        } catch (ex: Exception) {
            Assert.fail()
        }

    }

    @Test
    fun test3() {
        val allSegmentIcon = indexPageResult.allSearchSegment()

        if (allSegmentIcon.size == 0)
            Assert.fail()
        try {
            allSegmentIcon.forEach { it.findElement(By.className("TransportIcon__icon")) }
            Assert.assertTrue(true)
        } catch (ex: Exception) {
            Assert.fail()
        }

    }

    @Test
    fun test4() {
        val allSegmentIcon = indexPageResult.allSearchSegment()

        Assert.assertEquals(3, allSegmentIcon.size)

    }

    @After
    fun close() {
        indexPage.close()
    }
}
