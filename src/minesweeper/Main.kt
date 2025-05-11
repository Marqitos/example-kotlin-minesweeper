package minesweeper

import java.util.Scanner
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

data class Size2D(val x:Int, val y:Int)
data class Point(val x:Int, val y:Int)
enum class CellType {
    SAFE, NUMBER, MINE
}
data class Cell(val type:CellType, val value:Int = 0)

object Minesweeper {

    /**
      * Return random mines
      *
      * @param size Size of the field
      * @param count Amount of mines
      * @return A set of `count` random numbers between the field size (x×y)
      */
    fun getMines(size:Size2D, count: Int): Set<Int> {
        val until = (size.x * size.y) - 1
        val mines = mutableSetOf<Int>()
        do {
            val position = Random.nextInt(0, until)
            mines.add(position)
        } while (mines.count() < count)
        return mines.toSet()
    }

    /**
      * Return a list<cell> representing the field.
      *
      * @param mines A set of random numbers between the field size (x×y)
      * @param size Size of the field
      * @return List of cells
      */
    fun getField(mines:Set<Int>, size:Size2D): List<Cell> {
        val cells = mutableListOf<Cell>()
        // Minefield
        repeat(size.x) { indexX ->
            repeat(size.y) { indexY ->
                val position = indexX * size.y + indexY
                if (mines.contains(position)) {
                    cells.add(Cell(CellType.MINE))
                } else {
                    val count = countMines(size, mines, indexX, indexY)
                    cells.add(if (count == 0) Cell(CellType.SAFE) else Cell(CellType.NUMBER, count))
                }
            }
        }
        return cells.toList()
    }

    /**
      * Mark a mine on the field
      *
      * @param size Size of the field
      * @param visibleField List of cells that are visible
      * @param markList List of cells marked as mines
      * @param mark Point to set or delete a mark
      * @return True if the markList changed, false if visibleField contains mark coordinates.
      */
    fun setMine(size:Size2D, visibleField:MutableSet<Int>, markList:MutableSet<Int>, mark:Point): Boolean {
        val position:Int = (mark.y - 1) * size.y + (mark.x - 1)
        if (visibleField.contains(position)) {
            return false
        }

        if (markList.contains(position)) {
            markList.remove(position)
        } else {
            markList.add(position)
        }
        return true
    }

    /**
      * Try to claim a cell as free
      *
      * @param size Size of the field
      * @param visibleField List of cells that are visible
      * @param markList List of cells marked as mines
      * @param field List of cells
      * @param mark Point to claim as free
      *
      * @return True if cell is marked as mine, cannot be claimed; False if cell is a mine; null otherwise.
      */
    fun freeCell(size:Size2D, visibleField:MutableSet<Int>, markList:MutableSet<Int>, field:List<Cell>, mark:Point): Boolean? {
        val position:Int = ((mark.y - 1) * size.y) + (mark.x - 1)
        if (visibleField.contains(position)) {
            return null
        }
        if (markList.contains(position)) {
            return true
        }
        visibleField.add(position)
        val cell = field[position]
        return when (cell.type) {
            CellType.SAFE -> {
                // Free cells around
                val rangeX = max(0, mark.x - 2)..min(mark.x, size.x - 1)
                val rangeY = max(0, mark.y - 2)..min(mark.y, size.y - 1)
                for(indexX in rangeX) {
                    for(indexY in rangeY) {
                        if (mark.x == indexX + 1 &&
                            mark.y == indexY + 1) { // Don't do anything in current position
                            continue
                        }
                        val point = Point(indexX + 1, indexY + 1)
                        val isMark = freeCell(size, visibleField, markList, field, point)
                        if (isMark == true) { // Remove mine mark if it is safe
                            val positionPoint = ((point.y - 1) * size.y) + (point.x - 1)
                            markList.remove(positionPoint)
                            freeCell(size, visibleField, markList, field, point)
                        }
                    }
                }
                return null
            }
            CellType.NUMBER -> {
                return null
            }
            CellType.MINE -> false
        }
    }

    fun printField(size:Size2D, visibleField:MutableSet<Int>, markList:MutableSet<Int>, field:List<Cell>) {
        var draw = " │"
        // File numbers and up line
        repeat(size.y) { indexY ->
            draw += (indexY + 1).toString()
        }
        draw += "│\n—│"
        repeat(size.y) {
            draw += "—"
        }
        draw += "│\n"

        // Minefield
        repeat(size.x) { indexX ->
            draw += "${indexX + 1}│"
            repeat(size.y) { indexY ->
                val position = indexX * size.y + indexY
                if (visibleField.contains(position)) {
                    val cell = field[position]
                    draw += when (cell.type) {
                        CellType.SAFE -> '/'
                        CellType.NUMBER -> cell.value
                        CellType.MINE -> 'X'
                    }
                } else if (markList.contains(position)) {
                    draw += '*'
                } else {
                    draw += '.'
                }
            }
            draw += "│\n"
        }

        // Down line
        draw += "—│"
        repeat(size.y) {
            draw += "—"
        }
        draw += "│\n"

        println(draw)
    }

    /**
      * Return the amount of mines around a position
      *
      * @param size Field size
      * @param mines Position of mines
      * @param x Current x position
      * @param y Current y position
      */
    private fun countMines(size:Size2D, mines:Set<Int>, x:Int, y:Int): Int {
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

}

fun main() {
    // Initialize Java Scanner
    val scanner = Scanner(System.`in`)

    // Get the amount of mines
    print("How many mines do you want on the field? ")
    val count = scanner.nextInt()

    // Initialize Minesweeper
    val size = Size2D(9, 9)

    // Initialize marks list
    val markList = mutableSetOf<Int>()

    // Initialize visible list
    val visibleField = mutableSetOf<Int>()

    // Get the mines
    var mines = Minesweeper.getMines(size, count)
    // Get field
    var field = Minesweeper.getField(mines, size)

    var lose = false
    var equals:Boolean
    do {
        Minesweeper.printField(size, visibleField, markList, field)

        print("Set/unset mines marks or claim a cell as free: ")
        val x = scanner.nextInt()
        val y = scanner.nextInt()
        val action = scanner.next("mine|free")
        val mark = Point(x, y)
        if (action == "mine") {
            Minesweeper.setMine(size, visibleField, markList, mark)
        } else {
            lose = Minesweeper.freeCell(size, visibleField, markList, field, mark) == false
            while (visibleField.size == 0 && lose) { // The first cell explored cannot be a mine
                // Get the mines
                mines = Minesweeper.getMines(size, count)
                // Get field
                field = Minesweeper.getField(mines, size)
                lose = Minesweeper.freeCell(size, visibleField, markList, field, mark) == false
            }
        }

        equals = (mines.size == markList.size &&
                  mines.containsAll(markList)) ||
                 mines.size == field.size - visibleField.size
    } while (!equals && !lose)

    Minesweeper.printField(size, visibleField, markList, field)
    println(if (lose) "You stepped on a mine and failed!" else "Congratulations! You found all the mines!")

    // Free resources
    scanner.close()
}
