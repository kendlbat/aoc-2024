fun main() {
    val input = Aoc.getInput(4).readLines()

    val width = input[0].length
    val height = input.size

    var count = 0

    input.forEachIndexed { y, line ->
        line.forEachIndexed { x, c ->
            if (c == 'A') {
                if (y + 1 < height && x - 1 >= 0 && x + 1 < width && y - 1 >= 0) {
                    if ((input[y - 1][x - 1] == 'M' && input[y + 1][x + 1] == 'S' || input[y - 1][x - 1] == 'S' && input[y + 1][x + 1] == 'M') && (input[y - 1][x + 1] == 'M' && input[y + 1][x - 1] == 'S' || input[y - 1][x + 1] == 'S' && input[y + 1][x - 1] == 'M')) {
                        count++
                    }
                }
            }

        }
    }

    println(count)


}