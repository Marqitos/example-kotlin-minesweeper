package to.marcospor

import kotlin.random.Random

class Minesweeper {
    
    /**
      * @return a set of 10 random numbers between 0 and 80
      */
    fun getMines(): MutableSet<Int> {
        val mines = mutableSetOf<Int>()
        do {
            val position = Random.nextInt(0, 81)
            mines.add(position)
        } while (mines.count() < 10)
        return mines;
    }

    /**
      * Return a 9x9 field.
      * We will use `X` for mines and `.` for safe cells.
      *
      * @param mines a set of 10 random numbers between 0 and 80
      * @return a string representing the field
      */
    fun getField(mines: MutableSet<Int>): String {
        var field = ""
        repeat(81) { index ->
            field += if (mines.contains(index)) 'X' else '.'
            if ((index + 1) % 9 == 0) {
                field += "\n"
            }
        }
        return field;
    }
}

fun main() {

    val minesweeper = Minesweeper()

    // Get 10 mines
    val mines = minesweeper.getMines()

    // Get 9x9 field
    val field = minesweeper.getField(mines)

    // Print field
    println(field)
}