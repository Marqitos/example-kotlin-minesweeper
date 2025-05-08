package minesweeper

import java.util.Scanner
import kotlin.random.Random

fun main() {
    // Initialize Java Scanner
    val scanner = Scanner(System.`in`)

    // Get the amount of mines
    print("How many mines do you want on the field? ")
    val count = scanner.nextInt()

    // Get the mines
    val mines = mutableSetOf<Int>()
    do {
        val position = Random.nextInt(0, 81)
        mines.add(position)
    } while (mines.count() < count)

    // Print field 9×9
    repeat(81) { index ->
        val cell:Char = if (mines.contains(index)) 'X' else '.'
        print(cell)
        if ((index + 1) % 9 == 0) {
            println()
        }
    }

    // Free resources
    scanner.close()
}
