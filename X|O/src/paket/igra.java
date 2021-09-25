package paket;

import java.util.Scanner;

public class igra
{

    public static void upper(int[] field_array)
    {
        char c1 = ' ';
        char c2 = ' ';
        char c3 = ' ';

        if(field_array[1] == 1)
            c1 = 'x';
        if(field_array[1] == 5)
            c1 = 'o';

        if(field_array[2] == 1)
            c2 = 'x';
        if(field_array[2] == 5)
            c2 = 'o';

        if(field_array[3] == 1)
            c3 = 'x';
        if(field_array[3] == 5)
            c3 = 'o';

        System.out.println("\n "+ c1 +" |  "+ c2 +"  | "+ c3);
    }

    public static void middle(int[] field_array)
    {
        char c1 = ' ';
        char c2 = ' ';
        char c3 = ' ';

        if(field_array[4] == 1)
            c1 = 'x';
        if(field_array[4] == 5)
            c1 = 'o';

        if(field_array[5] == 1)
            c2 = 'x';
        if(field_array[5] == 5)
            c2 = 'o';

        if(field_array[6] == 1)
            c3 = 'x';
        if(field_array[6] == 5)
            c3 = 'o';
        System.out.println(" "+ c1 +" |  "+ c2 +"  | "+ c3);
    }

    public static void lower(int[] field_array)
    {
        char c1 = ' ';
        char c2 = ' ';
        char c3 = ' ';

        if(field_array[7] == 1)
            c1 = 'x';
        if(field_array[7] == 5)
            c1 = 'o';

        if(field_array[8] == 1)
            c2 = 'x';
        if(field_array[8] == 5)
            c2 = 'o';

        if(field_array[9] == 1)
            c3 = 'x';
        if(field_array[9] == 5)
            c3 = 'o';
        System.out.println(" "+ c1 +" |  "+ c2 +"  | "+ c3 +"\n");
    }

    public static void print_fields(int[] filed_array) {
        if (filed_array[0] == 1) {
            System.out.println("\n 1 |  2  | 3\n---|-----|----");
            System.out.println(" 4 |  5  | 6\n---|-----|----");
            System.out.println(" 7 |  8  | 9\n");
        }
        else {
            upper(filed_array);
            System.out.println("---|-----|----");
            middle(filed_array);
            System.out.println("---|-----|----");
            lower(filed_array);
        }
    }

    public static int have_won(int[] field_array) {
        int n = 3, k = 1;
        int[][] array_2D = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++, k++)
                array_2D[i][j] = field_array[k];

        int countV = 0, countH = 0, countD = 0, countD1 = 0;
        for (int i = 0; i < n; i++) {
            countV = 0;
            countH = 0;
            for (int j = 0; j < n; j++) {
                countH += array_2D[i][j];
                countV += array_2D[j][i];
                countD += (i == j) ? array_2D[i][i] : 0;
                countD1 += (i + j == 2) ? array_2D[i][j] : 0;
            }
            if(countV == 3 || countH == 3 || countD == 3 || countD1 == 3)
                return 1;
            else if(countV == 15 || countH == 15 || countD == 15 || countD1 == 15)
                return 2;
        }
        return 0;
    }


    public static void main(String[] args) {

        System.out.println("This is Tic Tac Toe:");

        char figure = 'x';
        int field;
        int[] field_array = new int[10];

        field_array[0]++;
        print_fields(field_array);
        field_array[0]--;

        for (int i = 1; i <= 9 ; i++) {
            System.out.print("Enter the field where you want to place "+ figure +" (1-9): ");

            Scanner sc = new Scanner(System.in);
            field = sc.hasNextInt() ? sc.nextInt() : 0;

            if(field < 1 || field > 9) {
                System.out.println("You didn't enter a valid field!");
                i--;
                continue;
            }
            if(field_array[field] > 0) {
                System.out.println("You have already entered this field!");
                i--;
                continue;
            }

            if(figure == 'x')
                field_array[field] = 1;
            else
                field_array[field] = 5;

            print_fields(field_array);

            if(have_won(field_array) == 1) {
                System.out.println("X WON THE GAME!");
                break;
            }
            else if(have_won(field_array) == 2) {
                System.out.println("O WON THE GAME!");
                break;
            }

            if(figure == 'x')
                figure = 'o';
            else
                figure = 'x';
        }

        if(have_won(field_array) == 0)
            System.out.println("IT'S A TIE!");
    }
}
