fun getMiddleElement(list: List<Int>): Int {
    return list[list.size / 2]
}

fun main() {
    val input = Aoc.getInput(5).readText()
    val split = input.split("\n\n")
    val rules = split[0].split("\n").map { it.split("|").map { it.toInt() } }
        .groupBy { it[0] }
        .mapValues { it.value.map { it[1] } }

    val books = split[1].split("\n").filter {
        it.isNotEmpty()
    }.map {
        it.split(",").map {
            it.toInt()
        }
    }

    var sum = 0

    for (book in books) {
        val disallowed = mutableSetOf<Int>()
        var valid = true

        for (pg in book.reversed()) {
            if (pg in disallowed) {
                valid = false
                break
            }
            if (pg in rules) {
                disallowed.addAll(rules[pg]!!)
            }
        }

        if (valid) {
            sum += getMiddleElement(book)
        }

    }

    println(sum)
}