import java.io.FileNotFoundException;
import java.util.Scanner;

import java.io.File;

 /*
 Program that takes a file as input and caculates the row, column, and diaganol sum
 of the square matrix
  */
public class Matrix {

    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("C:\\Users\\Ethan Evans\\LearnX\\noobchain\\src\\luna.txt");
        int[][] twoArray = retArray(f);
        if (twoArray.length != twoArray[0].length) {
            System.out.println("Not a valid square matrix");
        }
        else {
            int size = countRows(f);
            if (checkDig(twoArray, size) && checkColumn(twoArray, size) && checkRow(twoArray, size)) {
                System.out.println("Same sum");
            }
            else {
                System.out.println("Not same sum");
            }
        }
    }

    public static int[][] retArray(File f) throws FileNotFoundException  {
        Scanner fileScan = new Scanner(f);

        int i = 0;
        int[][] matrix = new int[countRows(f)][countRows(f)];

        while (fileScan.hasNextLine()) {
            String s = fileScan.nextLine();
            String[] row = new String[countRows(f)];
            row = s.split("\t");
            for (int x = 0; x < row.length; x++) {
                matrix[i][x] = Integer.parseInt(row[x]);
            }
            i++;
        }
        return matrix;
    }

    public static boolean checkColumn(int[][] retArray, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            int tempSum = 0;
            for (int j = 0; j < size; j++) {
                tempSum += retArray[j][i];
            }
            if (i > 0) {
                if (tempSum != sum) {
                    return false;
                }
                else {
                    sum = tempSum;
                }
            }
            else {
                sum = tempSum;
            }
        }
        return true;
    }

    public static boolean checkDig(int[][] retArray, int size) throws  FileNotFoundException {
        int tempSumOne = 0;
        int tempSumTwo = 0;

        for (int i = 0; i < size; i++) {
            tempSumOne += retArray[i][i];
        }

        for (int i = size-1; i >= 0; i--) {
            tempSumTwo += retArray[i][i];
        }

        return tempSumOne == tempSumTwo;
    }

    public static boolean checkRow(int[][] retArray, int size) throws FileNotFoundException {

        int sum = 0;

        for (int i = 0; i < size; i++) {
            int tempSum = 0;
            for (int j = 0; j < size; j++) {
                tempSum += retArray[i][j];
            }
            if (i > 0) {
                if (tempSum != sum) {
                    return false;
                }
                else {
                    sum = tempSum;
                }
            }
            else {
                sum = tempSum;
            }
        }
        return true;
    }

    public static int countRows(File f) throws FileNotFoundException {
        int countRow = 0;
        Scanner fileScan = new Scanner(f);
        while (fileScan.hasNextLine()) {
            String s = fileScan.nextLine();
            countRow++;
        }
        fileScan.close();
        return countRow;
    }

}
