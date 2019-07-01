import java.io.File

fun main() {
    val path = "src/main/resources/strings.txt"

    val file = pathToFile(path)
    val string = fileToFirstLine(file)
    val size = sizeLine(string)

    println(size)
}

fun pathToFile(name: String) = File(name)

fun fileToFirstLine(file: File) = file.readLines().first()

fun sizeLine(list: String): Int = list.split(' ').size