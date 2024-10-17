package edu.grinnell.csc207.util;

import java.util.Arrays;

/**
 * Implementation of two-dimensional matrices using a 2D array.
 *
 * @author Princess Alexander
 * @author Samuel A. Rebelsky
 *
 * @param <T> The type of values stored in the matrix.
 */
public final class MatrixV0<T> implements Matrix<T> {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The width of the matrix.
   */
  private int width;

  /**
   * The height of the matrix.
   */
  private int height;

  /**
   * The default value for the matrix cells.
   */
  private T defaultVal;

  /**
   * The 2D array for storing the matrix values.
   */

  private T[][] values;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new matrix of the specified width and height with the given
   * value as the default.
   *
   * @param width The width of the matrix.
   * @param height The height of the matrix.
   * @param def The default value, used to fill all the cells.
   * @throws NegativeArraySizeException If either the width or height are
   * negative.
   */


  public MatrixV0(int width, int height, T def) {
    if (width < 0 || height < 0) {
      throw new NegativeArraySizeException("Matrix size cannot be negative.");
    } // if
    this.width = width;   // Use `this.width` to refer to the instance variable
    this.height = height; // Use `this.height` to refer to the instance variable
    this.defaultVal = def;
    this.values = (T[][]) new Object[height][width];

    // Fill the matrix with default values
    for (int i = 0; i < this.height; i++) {  // Always refer to `this.height`
      Arrays.fill(this.values[i], def);
    } // for
  } // MatrixV0(int, int, T)

  /**
   * Create a new matrix of the specified width and height with null as the
   *  * default value.
   *
   * @param width The width of the matrix.
   * @param height The height of the matrix.
   * @throws NegativeArraySizeException If either the width or height are
   * negative.
   */
  public MatrixV0(int width, int height) {
    this(width, height, null);
  } // MatrixV0(int, int)

  // +--------------+------------------------------------------------
  // | Core methods |
  // +--------------+
  /**
   * Get the element at the given row and column.
   *
   * @param row The row index.
   * @param col The column index.
   * @return The value at the specified location.
   * @throws IndexOutOfBoundsException if row or col are out of bounds.
   */
  @Override
  public T get(int row, int col) {
    if (row < 0 || row >= height || col < 0 || col >= width) {
      throw new IndexOutOfBoundsException("Invalid row or column.");
    } // if
    return values[row][col];
  } // get(int, int)

  /**
   * Set the element at the given row and column.
   *
   * @param row The row index.
   * @param col The column index.
   * @param val The value to set.
   * @throws IndexOutOfBoundsException if row or col are out of bounds.
   */
  @Override
  public void set(int row, int col, T val) {
    if (row < 0 || row >= height || col < 0 || col >= width) {
      throw new IndexOutOfBoundsException("Invalid row or column.");
    } // if
    values[row][col] = val;
  } // set(int, int, T)

  /**
   * Determine the number of rows in the matrix.
   *
   * @return the number of rows.
   */
  @Override
  public int height() {
    return height;
  } // height()

  /**
   * Determine the number of columns in the matrix.
   *
   * @return the number of columns.
   */
  @Override
  public int width() {
    return width;
  } // width()

  /**
   * Insert a row filled with the default value.
   *
   * @param row The row to insert.
   * @throws IndexOutOfBoundsException if row is out of bounds.
   */
  @Override
  public void insertRow(int row) {
    if (row < 0 || row > height) {
      throw new IndexOutOfBoundsException("Invalid row to insert.");
    } // if

    T[][] newValues = (T[][]) new Object[height + 1][width];
    for (int i = 0; i < row; i++) {
      newValues[i] = values[i];
    } // for

    Arrays.fill(newValues[row], defaultVal);
    for (int i = row; i < height; i++) {
      newValues[i + 1] = values[i];
    } // for
    values = newValues;
    height++;
  } // insertRow(int)

  /**
   * * Insert a row filled with the specified values.
   *
   * @param row The row to insert.
   * @param vals The values to insert.
   * @throws IndexOutOfBoundsException if row is out of bounds.
   * @throws ArraySizeException if the size of vals is not the same as the
   * width.
   * */
  @Override
  public void insertRow(int row, T[] vals) throws ArraySizeException {
    if (row < 0 || row > height) {
      throw new IndexOutOfBoundsException("Invalid row to insert.");
    } // if
    if (vals.length != width) {
      throw new ArraySizeException("Invalid row size.");
    } // if
    T[][] newValues = (T[][]) new Object[height + 1][width];
    for (int i = 0; i < row; i++) {
      newValues[i] = values[i];
    } // for
    newValues[row] = vals;
    for (int i = row; i < height; i++) {
      newValues[i + 1] = values[i];
    } // for
    values = newValues;
    height++;
  } // insertRow(int, T[])

  /**
   * Insert a column filled with the default value.
   *
   * @param col The column to insert.
   * @throws IndexOutOfBoundsException if col is out of bounds.
   */
  @Override
  public void insertCol(int col) {
    if (col < 0 || col > width) {
      throw new IndexOutOfBoundsException("Invalid column to insert.");
    } // if

    T[][] newValues = (T[][]) new Object[height][width + 1];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < col; j++) {
        newValues[i][j] = values[i][j];
      } // for
      newValues[i][col] = defaultVal;
      for (int j = col; j < width; j++) {
        newValues[i][j + 1] = values[i][j];
      } // for
    } // for

    values = newValues;
    width++;
  } // insertCol(int)

  /**
   * Insert a column filled with the specified values.
   *
   * @param col The column to insert.
   * @param vals The values to insert.
   * @throws IndexOutOfBoundsException if col is out of bounds.
   * @throws ArraySizeException if the size of vals is not the same as the
   * height.
   */
  @Override
  public void insertCol(int col, T[] vals) throws ArraySizeException {
    if (col < 0 || col > width) {
      throw new IndexOutOfBoundsException("Invalid column to insert.");
    } // if

    if (vals.length != height) {
      throw new ArraySizeException("Invalid column size.");
    } // if

    T[][] newValues = (T[][]) new Object[height][width + 1];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < col; j++) {
        newValues[i][j] = values[i][j];
      } // for

      newValues[i][col] = vals[i];
      for (int j = col; j < width; j++) {
        newValues[i][j + 1] = values[i][j];
      } // for
    } // for

    values = newValues;
    width++;
  } // insertCol(int, T[])

  /**
   * Delete a row.
   *
   * @param row The row to delete.
   * @throws IndexOutOfBoundsException if row is out of bounds.
   */
  @Override
  public void deleteRow(int row) {
    if (row < 0 || row >= height) {
      throw new IndexOutOfBoundsException("Invalid row to delete.");
    } // if

    T[][] newValues = (T[][]) new Object[height - 1][width];
    for (int i = 0; i < row; i++) {
      newValues[i] = values[i];
    } // for

    for (int i = row + 1; i < height; i++) {
      newValues[i - 1] = values[i];
    } // for
    values = newValues;
    height--;
  } // deleteRow(int)

  /**
   * Delete a column.
   *
   * @param col The column to delete.
   * @throws IndexOutOfBoundsException if col is out of bounds.
   */
  @Override
  public void deleteCol(int col) {
    if (col < 0 || col >= width) {
      throw new IndexOutOfBoundsException("Invalid column to delete.");
    } // if

    T[][] newValues = (T[][]) new Object[height][width - 1];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < col; j++) {
        newValues[i][j] = values[i][j];
      } // for

      for (int j = col + 1; j < width; j++) {
        newValues[i][j - 1] = values[i][j];
      } // for
    } // for
    values = newValues;
    width--;
  } // deleteCol(int)

  /**
   * Fill a rectangular region of the matrix with a value.
   *
   * @param startRow The starting row (inclusive).
   * @param startCol The starting column (inclusive).
   * @param endRow The ending row (exclusive).
   * @param endCol The ending column (exclusive).
   * @param val The value to fill the region with.
   * @throws IndexOutOfBoundsException if the region boundaries are out of
   * bounds.
   */
  @Override
  public void fillRegion(int startRow, int startCol, int endRow, int endCol, T val) {
    if (startRow < 0 || startCol < 0 || endRow > height || endCol > width) {
      throw new IndexOutOfBoundsException("Invalid region boundaries.");
    } // if

    for (int i = startRow; i < endRow; i++) {
      for (int j = startCol; j < endCol; j++) {
        values[i][j] = val;
      } // for
    } // for
  } // fillRegion(int, int, int, int, T)

  /**
   * Fill a line (horizontal, vertical, diagonal) in the matrix with a value.
   *
   * @param startRow The starting row.
   * @param startCol The starting column.
   * @param deltaRow The row increment.
   * @param deltaCol The column increment.
   * @param endRow The ending row (exclusive).
   * @param endCol The ending column (exclusive).
   * @param val The value to fill the line with.
   * @throws IndexOutOfBoundsException if any index is out of bounds.
   */
  @Override
  public void fillLine(int startRow, int startCol, int deltaRow, int deltaCol, int endRow, int endCol, T val) {
    int row = startRow;
    int col = startCol;
    while (row < endRow && col < endCol) {
      values[row][col] = val;
      row += deltaRow;
      col += deltaCol;
    } // while
  } // fillLine(int, int, int, int, int, int, T)

  /**
   * Create a copy of the matrix.
   *
   * @return a copy of the matrix.
   */
  @Override
  public Matrix<T> clone() {
    MatrixV0<T> copy = new MatrixV0<>(this.width, this.height, this.defaultVal);
    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width; j++) {
        copy.set(i, j, this.values[i][j]);
      } // for
    } // for
    return copy;
  } // clone()

  /**
   * Determine if this object is equal to another object.
   *
   * @param other The object to compare.
   * @return true if the matrices are equal, false otherwise.
   */
  @Override
  public boolean equals(Object other) {
    if (!(other instanceof Matrix<?>)) {
      return false;
    } // if

    Matrix<?> otherMatrix = (Matrix<?>) other;

    // Check if dimensions are the same
    if (this.width != otherMatrix.width() || this.height != otherMatrix.height()) {
      return false;
    } // if

    // Compare elements in both matrices
    for (int row = 0; row < this.height; row++) {
      for (int col = 0; col < this.width; col++) {
        T thisValue = this.get(row, col);
        Object otherValue = otherMatrix.get(row, col);

        if (thisValue != null ? !thisValue.equals(otherValue) : otherValue != null) {
          return false;
        } // if
      } // for
    } // for

    return true;
  } // equals(Object)

  /**
   * Compute the hash code for the matrix.
   *
   * @return the hash code.
   */
  @Override
  public int hashCode() {
    int result = 31 * width + height;
    for (int i = 0; i < height; i++) {
      result = 31 * result + Arrays.hashCode(values[i]);
    } // for
    return result;
  } // hashCode()
} // class MatrixV0
