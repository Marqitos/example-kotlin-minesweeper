package minesweeper

import java.util.Scanner
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

data class Size2D(val x:Int, val y:Int)

object Minesweeper {

    /** Return random mines
      *
      * @param size Size of the field
      * @param count Amount of mines
      * @return A set of `count` random numbers between the field size (x×y)
      */
    fun getMines(size:Size2D, count: Int): MutableSet<Int> {
        val until = (size.x * size.y) - 1
        val mines = mutableSetOf<Int>()
        do {
            val position = Random.nextInt(0, until)
            mines.add(position)
        } while (mines.count() < count)
        return mines
    }

    /**
     * Return a string representing the field.
     * We will use `X` for mines, and the amount of mines around safe cells or `.` for 0 mines around.
     *
     * @param mines A set of random numbers between the field size (x×y)
     * @param size Size of the field
     * @return A string representing the field
     */
    fun getField(mines: MutableSet<Int>, size:Size2D): String {
        var field = ""
        repeat(size.x) { indexX ->
            repeat(size.y) { indexY ->
                if (mines.contains(indexX * size.y + indexY)) {
                    field += 'X'
                } else {
                    var count = 0
                    val rangeX = max(0, indexX - 1)..min(indexX + 1, size.x -1)
                    val rangeY = max(0, indexY - 1)..min(indexY + 1, size.y - 1)
                    for(x in rangeX) {
                        for(y in rangeY) {
                            if (x == indexX &&
                                y == indexY) {
                                continue
                            }
                            if (mines.contains(x * size.y + y)) {
                                count++
                            }
                        }
                    }

                    field += if (count == 0) '.' else count.toString()
                }
            }
            field += "\n"
        }
        return field
    }
}

fun main() {
    // Initialize Java Scanner
    val scanner = Scanner(System.`in`)

    // Get the amount of mines
    print("How many mines do you want on the field? ")
    val count = scanner.nextInt()

    // Initialize Minesweeper
    val size = Size2D(9, 9)

    // Get the mines
    val mines = Minesweeper.getMines(size, count)

    // Get the field
    val field = Minesweeper.getField(mines, size)

    // Print field
    println(field)

    // Free resources
    scanner.close()
}
