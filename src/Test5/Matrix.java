package Test5;

import java.util.Arrays;

public class Matrix {
    /* 成员变量 */
    private double[][] data;

    /* 构造器 */
    Matrix(int rows, int cols) throws IllegalArgumentException {
        if (rows < 1) {
            throw new IllegalArgumentException("行数过小");
        }
        if (cols < 1) {
            throw new IllegalArgumentException("列数过小");
        }
        data = new double[rows][cols];
    }

    Matrix() {
        data = new double[1][1];
    }

    Matrix(double[][] data) throws IllegalArgumentException {
        if (null == data) {
            throw new IllegalArgumentException("用于构成矩阵的二维数组不存在");
        }
        this.data = new double[data.length][data[0].length];
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getCols(); j++) {
                this.data[i][j] = data[i][j];
            }
        }
    }

    /* get */
    int getRows() {
        return data.length;
    }

    int getCols() {
        return data[0].length;
    }

    double getData(int rol, int col) throws IllegalIndexException {
        if (rol < 1 || col < 1 || rol > getRows() || col > getCols()) {
            throw new IllegalIndexException();
        }
        return data[rol - 1][col - 1];
    }

    /* set */

    /**
     * 修改指定数值
     * 
     * @param rol   行序号
     * @param col   列序号
     * @param value
     */
    void setData(int rol, int col, double value) throws IllegalIndexException {
        if (rol < 1 || col < 1 || rol > getRows() || col > getCols()) {
            throw new IllegalIndexException();
        }
        data[rol - 1][col - 1] = value;
    }
    /* 功能 */

    /**
     * 矩阵相乘
     * 
     * @param other 乘数
     * @return 返回结果矩阵
     */
    Matrix multiply(Matrix other) throws MatrixMultiplicationException {
        if (getCols() != other.getRows()) {
            throw new MatrixMultiplicationException();
        }
        Matrix result = null;
        try {
            result = new Matrix(getRows(), other.getCols());
            for (int i = 0; i < result.getRows(); i++) {
                for (int j = 0; j < result.getCols(); j++) {
                    for (int k = 0; k < getCols(); k++) {
                        result.data[i][j] += data[i][k] * other.data[k][j];
                    }
                }
            }

        } catch (Exception e) {

        }
        return result;
    }

    /**
     * 取转置阵
     * 
     * @return 返回转置得到的矩阵，不改变自身
     */
    Matrix transpose() {
        Matrix trans = null;
        try {
            trans = new Matrix(getCols(), getRows());
            for (int i = 0; i < getRows(); i++) {
                for (int j = 0; j < getCols(); j++) {
                    trans.data[j][i] = data[i][j];
                }
            }
        } catch (Exception e) {

        }
        return trans;
    }

    /**
     * 计算行列式
     * 
     * @return 计算结果
     */
    double determinant() throws IllegalArgumentException {
        if (getCols() != getRows()) {
            throw new IllegalArgumentException("非方阵，无法计算");
        }
        int n = getCols();
        if (n <= 2) {
            if (n == 2) {
                return data[0][0] * data[1][1] - data[0][1] * data[1][0];
            }
            if (n == 1) {
                return data[0][0];
            }
        }
        double re = 0;
        for (int i = 0; i < n; i++) {
            var t = new Matrix(n - 1, n - 1);
            for (int r = 0, rx = 0; r < n; r++) {
                if (r != i) {
                    for (int f = 1; f < n; f++) {
                        t.data[rx][f - 1] = data[r][f];
                    }
                    rx++;
                }
            }
            re += t.determinant() * data[i][0] * (i % 2 == 0 ? 1 : -1);
        }
        return re;

    }

    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < getRows(); i++) {
            res += "[";
            for (int j = 0; j < getCols(); j++) {
                res += "\t " + data[i][j];
            }
            res += "\t]\n";
        }
        return res;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Matrix matrix = (Matrix) o;
        if (matrix.getCols() != getCols() || matrix.getRows() != getRows()) {
            return false;
        }
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getCols(); j++) {
                if (data[i][j] != matrix.data[i][j])
                    return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(data);
    }
}
