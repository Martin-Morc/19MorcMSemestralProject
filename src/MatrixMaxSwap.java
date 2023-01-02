package MorcMSemestralProject;

import java.util.*;

/**
 * 19. Program swaps the column and row with an absolute maximal value in matrix on indexes 0 and vice versa
 * @author Martin Morc
 * @version 9/12/22
 */

public final class MatrixMaxSwap {
    private MatrixMaxSwap(){}

    static Scanner sc = new Scanner(System.in);
    static int[] coords = new int[2];
    static double[][] matrix;
    static int rows, columns, maxValRow, maxValCol;

    public static void getDimensions(){
        System.out.println("Pocet radku");
        rows = sc.nextInt();
        if(rows < 0) return;
        System.out.println("Pocet sloupcu");
        columns = sc.nextInt(); 
    }

    public static double[][] getMatrix(int rows, int columns){
        matrix = new double[rows][columns];
        sc.useLocale(Locale.GERMAN);

        System.out.println("Zadej matici");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = sc.nextDouble();
            }
        }
        return matrix;
    }

    public static void maxAbsValue(double[][] a){
        double maxAbsValue = a[0][0]; 

        for (int i = 0; i < a.length; i++) { //iteruji pres radky
            for (int j = 0; j < a[i].length; j++) { //iteruji pres sloupce 
                if(Math.abs(a[i][j]) > Math.abs(maxAbsValue)){
                    maxAbsValue = a[i][j];     
                    maxValRow = i;
                    maxValCol = j;
                }
            }
        }
    }

    public static void swapColumnsRows(double[][]a){   
        double temp;

        for (int i = 0; i < a.length; i++) { //iteruji pres radky
            temp = a[i][0]; // uschovam si promennou na puvodnim sloupci
            a[i][0] = a[i][maxValCol];
            a[i][maxValCol] = temp; //prohodim index sloupce s max hodnotou s puvodni promennou
        }

        for (int i = 0; i < a[0].length; i++) { //iteruji pres sloupce
            temp = a[0][i];
            a[0][i] = a[maxValRow][i];
            a[maxValRow][i] = temp;
        }
    }

    public static void showMatrix(double[][] a){
        Locale.setDefault(Locale.GERMAN);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(String.format("%.2f", a[i][j])+ " "); //vypisuji vyslednou matici, zaokrouhleno na dve des. mista
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        getDimensions();
        if(rows < 0 || columns < 0) return;
        getMatrix(rows,columns);
        maxAbsValue(matrix);
        swapColumnsRows(matrix);
        showMatrix(matrix);
    }

    /*test main
    public static void main(String[] args) {
        double[][] testMatrix = {{26,12.6,123.8,4.1},
                              {0,-136.4,12,5},
                              {15,19,11,-3}};

        swapColumns(testMatrix);
        showMatrix(testMatrix);
    }
    */
}
