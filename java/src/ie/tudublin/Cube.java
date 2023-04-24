package ie.tudublin;

import processing.core.PVector;

public class Cube {
  public static float[][] vecToMatrix(PVector v) {
    float[][] m = new float[3][1];
    m[0][0] = v.x;
    m[1][0] = v.y;
    m[2][0] = v.z;
    return m;
  }

  public static PVector matrixToVec(float[] r) {
    return new PVector(r[0], r[1], r[2]);
  }

  public static void logMatrix(float[][] m) {
    int cols = m[0].length;
    int rows = m.length;
    System.out.println(rows + "x" + cols);
    System.out.println("----------------");
    for (int i = 0; i < rows; i++) {
      String s = "";
      for (int j = 0; j < cols; j++) {
        s += (m[i][j] + " ");
      }
      System.out.println(s);
    }
    System.out.println();
  }

  public static PVector matmulvec(float[][] a, PVector vec) {
    float[][] m = vecToMatrix(vec);
    PVector r = matrixToVec(matmul(a, m));
    return r;
  }

  private static PVector matrixToVec(PVector matmul) {
    return null;
}

public static PVector matmul(float[][] a, float[][] b) {
    if (b.length == 1 && b[0].length == 3) {
      return matmulvec(a, new PVector(b[0][0], b[0][1], b[0][2]));
    }

    int colsA = a[0].length;
    int rowsA = a.length;
    int colsB = b[0].length;
    int rowsB = b.length;

    if (colsA != rowsB) {
      System.err.println("Columns of A must match rows of B");
      return null;
    }

    float[][] result = new float[rowsA][colsB];
    for (int j = 0; j < rowsA; j++) {
      for (int i = 0; i < colsB; i++) {
        float sum = 0;
        for (int n = 0; n < colsA; n++) {
          sum += a[j][n] * b[n][i];
        }
        result[j][i] = sum;
      }
    }
    return matrixToVec(result);
  }

private static PVector matrixToVec(float[][] result) {
    return null;
}
}