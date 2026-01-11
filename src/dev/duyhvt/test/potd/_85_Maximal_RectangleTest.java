package dev.duyhvt.test.potd;

import dev.duyhvt.coding.potd._85_Maximal_Rectangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _85_Maximal_RectangleTest {

    private final _85_Maximal_Rectangle sol = new _85_Maximal_Rectangle();

    @Test
    void exampleCase() {
        char[][] matrix = grid(
                "10100",
                "10111",
                "11111",
                "10010"
        );
        assertEquals(6, sol.maximalRectangle(matrix));
    }

    @Test
    void allZeros() {
        char[][] matrix = grid(
                "000",
                "000"
        );
        assertEquals(0, sol.maximalRectangle(matrix));
    }

    @Test
    void allOnes() {
        char[][] matrix = grid(
                "11",
                "11",
                "11"
        );
        assertEquals(6, sol.maximalRectangle(matrix));
    }

    @Test
    void singleRow() {
        char[][] matrix = grid("10111");
        assertEquals(3, sol.maximalRectangle(matrix));
    }

    @Test
    void singleCol() {
        char[][] matrix = grid(
                "1",
                "1",
                "0",
                "1"
        );
        assertEquals(2, sol.maximalRectangle(matrix));
    }

    @Test
    void emptyMatrix() {
        assertEquals(0, sol.maximalRectangle(new char[][]{}));
    }

    // Helper: convert String rows into char[][]
    private static char[][] grid(String... rows) {
        if (rows == null || rows.length == 0) return new char[][]{};
        int m = rows.length;
        int n = rows[0].length();
        char[][] g = new char[m][n];

        for (int i = 0; i < m; i++) {
            if (rows[i].length() != n) {
                throw new IllegalArgumentException("All rows must have same length");
            }
            g[i] = rows[i].toCharArray();
        }
        return g;
    }
}