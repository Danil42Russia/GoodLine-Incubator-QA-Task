import org.junit.Assert
import org.junit.Test

class MainKtTest {
    @Test
    fun test1() {
        val path = "src/main/resources/strings.txt"

        val file = pathToFile(path)
        val string = fileToFirstLine(file)
        val size = sizeLine(string)

        Assert.assertEquals(16, size)
    }
}