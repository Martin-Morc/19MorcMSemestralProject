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

    public static int[] getDimensions(){
        int[] dimensions = new int[2];
        System.out.println("Pocet radku");
        dimensions[0] = sc.nextInt();
        System.out.println("Pocet sloupcu");
        dimensions[1] = sc.nextInt();
        
        return dimensions;
    }

    public static double[][] getMatrix(int rows, int columns){
        double[][] matrix = new double[rows][columns];
        sc.useLocale(Locale.GERMAN);

        System.out.println("Zadej matici");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = sc.nextDouble();
            }
        }
        return matrix;
    }

    public static int[] maxAbsValue(double[][] a){
        double maxAbsValue = a[0][0]; 
        int[] maxValCoords = new int[2];
        for (int i = 0; i < a.length; i++) { //iteruji pres radky
            for (int j = 0; j < a[i].length; j++) { //iteruji pres sloupce 
                if(Math.abs(a[i][j]) > Math.abs(maxAbsValue)){
                    maxAbsValue = a[i][j];     
                    maxValCoords[0] = i;
                    maxValCoords[1] = j;
                }
            }
        }
        return maxValCoords;
    }

    public static void swapColumnsRows(double[][]a, int[] coords){   
        double temp;
        double[] temparr;

        for (int i = 0; i < a.length; i++) { //iteruji pres radky
            temp = a[i][0]; // uschovam si promennou na puvodnim sloupci
            a[i][0] = a[i][coords[0]];
            a[i][coords[0]] = temp; //prohodim index sloupce s max hodnotou s puvodni promennou
        }

        //prohozeni radku v matici
        temparr = a[0];
        a[0] = a[coords[0]];
        a[coords[0]] = temparr;
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

    public static void run(){
        int[] dimensions = getDimensions();
        double[][] matrix = getMatrix(dimensions[0],dimensions[1]);
        int[] maxAbsValueCoordinates = maxAbsValue(matrix);
        swapColumnsRows(matrix, maxAbsValueCoordinates);
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
