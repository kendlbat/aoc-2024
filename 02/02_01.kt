fun main() {
    val input = Aoc.getInput(2)

    var count = 0

    input.forEachLine {
        val nums = it.split(" ").map { it.toInt() }
        var direction = if (nums[0] < nums[1] ) 1 else -1
        var valid = true

        for ((i, num) in nums.withIndex()) {
            if (i == 0) continue
            val prev = nums[i - 1]
            if (num == prev) {
                valid = false
                break
            }
            if (num > prev) {
                if (direction == -1 || num - prev > 3) {
                    valid = false
                    break
                }
            } else {
                if (direction == 1 || prev - num > 3) {
                    valid = false
                    break
                }
            }

        }

        if (direction == 0) {
            valid = false
        }

        if (valid) {
            count++
        }
    }


    println(count)
}