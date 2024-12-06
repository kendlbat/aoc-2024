fun main() {
    val input = Aoc.getInput(3).readLines().joinToString("\n")

    val matches = Regex("""(mul\((\d+),(\d+)\)|do\(\)|don't\(\))""").findAll(input)

    var doing = true
    println(matches.map {
        if (it.groups[1]!!.value == "do()") {
            doing = true
            return@map 0
        }
        if (it.groups[1]!!.value == "don't()") {
            doing = false
            return@map 0
        }
        return@map if (doing) it.groups[2]!!.value.toInt() * it.groups[3]!!.value.toInt() else 0
    }.sum())
}