package MorcMSemestralProject;

import java.util.Scanner;

/**
 * 19. Program swaps the column and row with an absolute maximal value in matrix on indexes 0 and vice versa
 * @author Martin Morc
 * @version 9/12/22
 */

public class main {
    static int rows, columns;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int menu;
        do{
            System.out.println("1 - Semestralni prace");
            System.out.println("2 - Vanocni uloha");
            System.out.println("3 - Konec");

            menu = sc.nextInt();
            
            switch(menu){

                case 1:
                    MatrixMaxSwap.execute(); // executes all methods accordingly
                    break;
                case 2:
                    ChristmasMorcMartin.main(args);
                    break;
                case 3:
                    break;

            }
        }while(menu != 3);
        sc.close();
    }
}
