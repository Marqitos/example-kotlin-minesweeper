package to.marcospor

import kotlin.test.*

class MinesweeperTest {

    @Test
    fun testMines() {
        val minesweeper = Minesweeper()
        val mines = minesweeper.getMines()

        assertEquals(10, mines.size, "Minesweeper should return 10 mines")

        for (mine in mines) {
            assertTrue(mine >= 0, "mine value should be positive")
            assertTrue(mine < 81, "mine value should be smaller than 81")
        }

        println("OK: Minesweeper.getMines")
    }

    @Test
    fun testField() {
        val minesweeper = Minesweeper()
        val mines = minesweeper.getMines()
        val field = minesweeper.getField(mines)

        val lines = field.split("\n")

        assertFalse(lines.isEmpty(), "Looks like you didn't output a single line!")


        assertTrue(lines.size > 2, "Your game field should contain at least 2 lines.")

        val firstLineLength = lines.get(0).toString().length;
        val symbols = mutableSetOf<Char>()

        for (line in lines) {
            val currLineLength = line.toString().length;

            assertEquals(firstLineLength, currLineLength, "You have lines with different lengths!\n" +
                        "Found lines with " + currLineLength + " and " +
                        firstLineLength + " length.")

            for (c in line) {
                symbols.add(c)

                assertFalse(symbols.size > 2, "There are more than 2 different symbols, but there must be two - " +
                            "one for mines, one for safe zones.")
            }

        }
        assertFalse(symbols.size == 2, "Your field should contain 2 different symbols: " +
                    "one for mines, one for safe zones.");

        println("OK: Minesweeper.getField")
    }
}
