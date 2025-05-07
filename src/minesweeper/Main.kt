package minesweeper

import kotlin.random.Random

fun main() {
    // Get 10 mines
    val mines = mutableSetOf<Int>()
    do {
        val position = Random.nextInt(0, 81)
        mines.add(position)
    } while (mines.count() < 10)

    // Print field 9x9
    repeat(81) { index ->
        val cell:Char = if (mines.contains(index)) 'X' else '.'
        print(cell)
        if ((index + 1) % 9 == 0) {
            println()
        }
    }
}
