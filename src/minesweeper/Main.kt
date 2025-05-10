package minesweeper

import java.util.Scanner
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

data class Size2D(val x:Int, val y:Int)
data class Point(val x:Int, val y:Int)

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
      * @param markList A set of marks
      * @param mark Point to set or delete a mark
      * @return If the minefield was printed
      */
    fun printField(mines: MutableSet<Int>, size:Size2D, markList: MutableSet<Int>, mark:Point? = null): Boolean {
        val markPosition:Int? = if(mark != null) (mark.y - 1) * size.y + (mark.x - 1) else null
        var field = " │"
        // File numbers and up line
        repeat(size.y) { indexY ->
            field += (indexY + 1).toString()
        }
        field += "│\n—│"
        repeat(size.y) {
            field += "—"
        }
        field += "│\n"
        // Minefield
        repeat(size.x) { indexX ->
            field += "${indexX + 1}│"
            repeat(size.y) { indexY ->
                val position = indexX * size.y + indexY
                val count:Int = if (mines.contains(position)) 0 else countMines(size, mines, indexX, indexY)

                if (markPosition == position &&
                    count != 0) { // markPosition contains a number
                        // Don't print the minefield.
                        return false
                }
                field += getPosition(position, markPosition, markList, count)
            }
            field += "│\n"
        }
        // Down line
        field += "—│"
        repeat(size.y) {
            field += "—"
        }
        field += "│\n"

        println(field)
        return true
    }

    /**
      * Return the amount of mines around a position
      *
      * @param size Field size
      * @param mines Position of mines
      * @param x Current x position
      * @param y Current y position
      */
    private fun countMines(size:Size2D, mines:MutableSet<Int>, x:Int, y:Int): Int {
        var count = 0
        val rangeX = max(0, x - 1)..min(x + 1, size.x - 1)
        val rangeY = max(0, y - 1)..min(y + 1, size.y - 1)
        for(indexX in rangeX) {
            for(indexY in rangeY) {
                if (x == indexX &&
                    y == indexY) { // Don't count current position
                    continue
                }
                if (mines.contains(indexX * size.y + indexY)) {
                    count++
                }
            }
        }
        return count
    }

    /**
      * Return the symbol of the current position:
      * Mine mark: *
      * A safe cell: .
      * Amount of mines around the cell: number
      *
      * @param position Current index position
      * @param markPosition (Optional) User selected position for set or delete
      * @param markList Marks positions
      * @param count (Optional) Amount mines around the cell
      */
    private fun getPosition(position:Int, markPosition:Int?, markList:MutableSet<Int>, count:Int = 0): Char {
        if(markPosition == position) {
            if (markList.contains(position)) {
                markList.remove(position)
            } else {
                markList.add(position)
            }
        }
        return if (markList.contains(position)) {
            '*'
        } else {
            if (count == 0) '.' else count.toString()[0]
        }

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

    // Initialize marks list
    val markList = mutableSetOf<Int>()

    // Print field
    Minesweeper.printField(mines, size, markList)

    var equals:Boolean
    do {
        print("Set/delete mines marks (x and y coordinates): ")
        val x = scanner.nextInt()
        val y = scanner.nextInt()
        val mark = Point(x, y)

        // Print field and set/delete mark
        val valid = Minesweeper.printField(mines, size, markList, mark)

        // Warning if mark contains a number
        if (!valid) {
            println("There is a number here!")
        }

        equals = mines.size == markList.size &&
                 mines.containsAll(markList)
    } while (!equals)
    println("Congratulations! You found all the mines!")

    // Free resources
    scanner.close()
}
