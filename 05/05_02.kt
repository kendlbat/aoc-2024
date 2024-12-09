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

    fun findFirstIllegalIndex(book: List<Int>): Int {
        val disallowed = mutableSetOf<Int>()
        book.reversed().forEachIndexed() { index, pg ->
            if (pg in disallowed) {
                return book.size - index - 1
            }
            if (pg in rules) {
                disallowed.addAll(rules[pg]!!)
            }
        }
        return -1
    }

    for (book in books.map { it.toMutableList()}) {
        if (findFirstIllegalIndex(book) == -1) {
            continue
        }

        while (true) {
            val illegal = findFirstIllegalIndex(book)
            if (illegal == -1) {
                break
            }
            // Move the illegal page one step to the right
            book.add(illegal + 1, book.removeAt(illegal))
        }

        sum += getMiddleElement(book)


    }

    println(sum)
}