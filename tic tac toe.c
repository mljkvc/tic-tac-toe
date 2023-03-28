#include <stdio.h>

void upper(int *field_array){
    char c1 = ' ', c2 = ' ', c3 = ' ';

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

    printf("\n %c |  %c  | %c\n", c1, c2, c3);
}

void middle(int *field_array){
    char c1 = ' ', c2 = ' ', c3 = ' ';

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

    printf("\n %c |  %c  | %c\n", c1, c2, c3);
}

void lower(int *field_array){
    char c1 = ' ', c2 = ' ', c3 = ' ';

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
        
    printf("\n %c |  %c  | %c\n\n", c1, c2, c3);
}

void print_fields(int *filed_array) {
    if (filed_array[0] == 1) {
        printf("\n 1 |  2  | 3\n---|-----|----\n");
        printf(" 4 |  5  | 6\n---|-----|----\n");
        printf(" 7 |  8  | 9\n\n");
    }
    else {
        upper(filed_array);
        printf("---|-----|----");
        middle(filed_array);
        printf("---|-----|----");
        lower(filed_array);
    }
}

int have_won(int *field_array) {
    int n = 3, k = 1;
    int array_2D[n][n];

    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++, k++)
            array_2D[i][j] = field_array[k];

    int countV = 0, countH = 0, countD = 0, countD1 = 0;
    for (int i = 0; i < n; i++) {
        countV = 0, countH = 0;
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


int main() {

    printf("This is Tic Tac Toe:\n");

    char figure = 'x';
    int field;
    int field_array[10] = {0};

    field_array[0]++;
    print_fields(field_array);
    field_array[0]--;

    for (int i = 1; i <= 9 ; i++) {
        printf("Enter the field where you want to place %c (1-9): \n", figure);

        scanf("%d", &field);
        
        if(field < 1 || field > 9) {
            printf("You didn't enter a valid field!\n");
            i--;
            continue;
        }
        if(field_array[field] > 0) {
            printf("You have already entered this field!\n");
            i--;
            continue;
        }

        if(figure == 'x')
            field_array[field] = 1;
        else
            field_array[field] = 5;

        print_fields(field_array);

        if(have_won(field_array) == 1) {
            printf("X WON THE GAME!\n");
            break;
        }
        else if(have_won(field_array) == 2) {
            printf("O WON THE GAME!\n");
            break;
        }

        if(figure == 'x')
            figure = 'o';
        else
            figure = 'x';
    }

    if(have_won(field_array) == 0)
        printf("IT'S A TIE!\n");

    return 0;
}
