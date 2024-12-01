import java.io.File
import java.util.PriorityQueue
import kotlin.math.abs

fun main() {
    val file = Aoc.getInput(1)

    val q1 = PriorityQueue<Int>()
    val q2 = PriorityQueue<Int>()

    file.forEachLine {
        if (it.isEmpty()) return@forEachLine
        val nums = it.split("   ").map { it.toInt() }
        q1.add(nums[0])
        q2.add(nums[1])
    }

    var sum = 0

    while (q1.isNotEmpty()) {
        sum += abs(q1.poll() - q2.poll())
    }

    println(sum)
}