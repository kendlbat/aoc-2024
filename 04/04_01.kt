fun main() {
    val input = Aoc.getInput(4).readLines()

    val width = input[0].length
    val height = input.size

    var count = 0

    input.forEachIndexed{ y, line ->
        line.forEachIndexed { x, c ->
            if (c == 'X') {
                if (y + 3 < height) {
                    // | down
                    if (input[y + 1][x] == 'M' && input[y + 2][x] == 'A' && input[y + 3][x] == 'S') {
                        count++
                    }

                    if (x - 3 >= 0) {
                        // / bottom left
                        if (input[y + 1][x - 1] == 'M' && input[y + 2][x - 2] == 'A' && input[y + 3][x - 3] == 'S') {
                            count++
                        }
                    }

                    if (x + 3 < width) {
                        // \ bottom right
                        if (input[y + 1][x + 1] == 'M' && input[y + 2][x + 2] == 'A' && input[y + 3][x + 3] == 'S') {
                            count++
                        }
                    }
                }

                if (y - 3 >= 0) {
                    // | up
                    if (input[y - 1][x] == 'M' && input[y - 2][x] == 'A' && input[y - 3][x] == 'S') {
                        count++
                    }

                    if (x + 3 < width) {
                        // / top right
                        if (input[y - 1][x + 1] == 'M' && input[y - 2][x + 2] == 'A' && input[y - 3][x + 3] == 'S') {
                            count++
                        }
                    }

                    if (x - 3 >= 0) {
                        // \ top left
                        if (input[y - 1][x - 1] == 'M' && input[y - 2][x - 2] == 'A' && input[y - 3][x - 3] == 'S') {
                            count++
                        }
                    }
                }

                if (x + 3 < width) {
                    // - right
                    if (input[y][x + 1] == 'M' && input[y][x + 2] == 'A' && input[y][x + 3] == 'S') {
                        count++
                    }
                }

                if (x - 3 >= 0) {
                    // - left
                    if (input[y][x - 1] == 'M' && input[y][x - 2] == 'A' && input[y][x - 3] == 'S') {
                        count++
                    }
                }
            }

        }
    }

    println(count)


}