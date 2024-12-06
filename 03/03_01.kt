fun main() {
    val input = Aoc.getInput(3).readLines().joinToString("\n")

    val matches = Regex("""mul\((\d+),(\d+)\)""").findAll(input)

    println(matches.map { it.groups[1]!!.value.toInt() * it.groups[2]!!.value.toInt() }.sum())


}