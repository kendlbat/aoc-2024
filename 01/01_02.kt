import java.util.HashMap

fun main() {
    val file = Aoc.getInput(1)

    val nums = file.readLines().subList(0, 1000).map { it.split("   ").map { it.toInt() } }
    val counts1 = HashMap<Int, Int>()
    val counts2 = HashMap<Int, Int>()

    nums.forEach { (a, b) ->
        counts1[a] = counts1.getOrDefault(a, 0) + 1
        counts2[b] = counts2.getOrDefault(b, 0) + 1
    }

    println(counts1.entries.sumOf { ( num, count ) ->
        num * count * counts2.getOrDefault(num, 0)
    })
}