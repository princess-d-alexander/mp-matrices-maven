package edu.grinnell.csc207.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * Tests for the MatrixV0.
 *
 * @author Princess Alexander
 */
public class TestsByStudent {

  /**
   * Test the get() method.
   */
  @Test
  public void testGet() {
    MatrixV0<String> matrix = new MatrixV0<>(3, 3, "default");
    matrix.set(0, 0, "A");
    assertEquals("A", matrix.get(0, 0), "Expected to get 'A' at (0,0)");
  } // testGet()

  /**
   * Test the set() method.
   */
  @Test
  public void testSet() {
    MatrixV0<Integer> matrix = new MatrixV0<>(2, 2, 0);
    matrix.set(1, 1, 42);
    assertEquals(42, matrix.get(1, 1), "Expected to get 42 at (1,1)");
  } // testSet()

  /**
   * Test the height() method.
   */
  @Test
  public void testHeight() {
    MatrixV0<String> matrix = new MatrixV0<>(4, 5, "default");
    int expectedHeight = 5;
    assertEquals(expectedHeight, matrix.height(), "Expected height of " + expectedHeight);
  } // testHeight()

  /**
   * Test the width() method.
   */
  @Test
  public void testWidth() {
    MatrixV0<String> matrix = new MatrixV0<>(4, 5, "default");
    int expectedWidth = 4;
    assertEquals(expectedWidth, matrix.width(), "Expected width of " + expectedWidth);
  } // testWidth()

  /**
   * Test the insertRow() method.
   */
  @Test
  public void testInsertRow() {
    MatrixV0<Integer> matrix = new MatrixV0<>(3, 3, 0);
    matrix.insertRow(1);
    int expectedHeight = 4;
    assertEquals(expectedHeight, matrix.height(), "Expected height of " + expectedHeight + " after row insertion");
  } // testInsertRow()

  /**
   * Test the insertRow(int row, T[] vals) method.
   */
  @Test
  public void testInsertRowWithVals() throws ArraySizeException {
    MatrixV0<String> matrix = new MatrixV0<>(3, 3, "default");
    matrix.insertRow(1, new String[]{"X", "Y", "Z"});
    assertEquals("X", matrix.get(1, 0), "Expected 'X' at (1, 0)");
  } // testInsertRowWithVals()

  /**
   * Test the insertCol() method.
   */
  @Test
  public void testInsertCol() {
    MatrixV0<Integer> matrix = new MatrixV0<>(2, 2, 0);
    matrix.insertCol(1);
    int expectedWidth = 3;
    assertEquals(expectedWidth, matrix.width(), "Expected width of " + expectedWidth + " after column insertion");
  } // testInsertCol()

  /**
   * Test the insertCol(int col, T[] vals) method.
   */
  @Test
  public void testInsertColWithVals() throws ArraySizeException {
    MatrixV0<String> matrix = new MatrixV0<>(2, 2, "default");
    matrix.insertCol(1, new String[]{"A", "B"});
    assertEquals("A", matrix.get(0, 1), "Expected 'A' at (0,1)");
  } // testInsertColWithVals()

  /**
   * Test the deleteRow() method.
   */
  @Test
  public void testDeleteRow() {
    MatrixV0<String> matrix = new MatrixV0<>(2, 2, "default");
    matrix.deleteRow(1);
    int expectedHeight = 1;
    assertEquals(expectedHeight, matrix.height(), "Expected height of " + expectedHeight + " after row deletion");
  } // testDeleteRow()

  /**
   * Test the deleteCol() method.
   */
  @Test
  public void testDeleteCol() {
    MatrixV0<String> matrix = new MatrixV0<>(2, 2, "default");
    matrix.deleteCol(1);
    int expectedWidth = 1;
    assertEquals(expectedWidth, matrix.width(), "Expected width of " + expectedWidth + " after column deletion");
  } // testDeleteCol()

  /**
   * Test the fillRegion() method.
   */
  @Test
  public void testFillRegion() {
    MatrixV0<Integer> matrix = new MatrixV0<>(3, 3, 0);
    matrix.fillRegion(0, 0, 2, 2, 9);
    assertEquals(9, matrix.get(1, 1), "Expected 9 in the filled region");
  } // testFillRegion()

  /**
   * Test the fillLine() method.
   */
  @Test
  public void testFillLine() {
    MatrixV0<String> matrix = new MatrixV0<>(3, 3, "default");
    matrix.fillLine(0, 0, 1, 1, 3, 3, "L");
    assertEquals("L", matrix.get(1, 1), "Expected 'L' at (1,1)");
  } // testFillLine()

  /**
   * Test the clone() method.
   */
  @Test
  public void testClone() {
    MatrixV0<String> matrix = new MatrixV0<>(2, 2, "A");
    Matrix<String> clone = matrix.clone();
    assertEquals(matrix, clone, "Expected the cloned matrix to be equal");
  } // testClone()

  /**
   * Test the equals() method.
   */
  @Test
  public void testEquals() {
    MatrixV0<String> matrix1 = new MatrixV0<>(2, 2, "A");
    MatrixV0<String> matrix2 = new MatrixV0<>(2, 2, "A");
    assertTrue(matrix1.equals(matrix2), "Expected matrices to be equal");
  } // testEquals()
  
} // class TestsByStudent
