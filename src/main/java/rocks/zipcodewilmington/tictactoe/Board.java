package rocks.zipcodewilmington.tictactoe;

import java.sql.Array;

/**
 * @author leon on 6/22/18.
 */
public class Board {
    private Character[][] matrix;
    public Board(Character[][] matrix) {
        this.matrix = matrix;
    }

    public Boolean isInFavorOfX() {
        // Winner has column, rows, and diagonals

        int counter = 0;
        int counter2 = 0;
        int counter3 = 0;
        int counter4 = 0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) { //This is filled to 3 before the rows
                if (j != 2 && matrix[i][j] == 'X' && matrix[i][j + 1] == 'X') {
                    counter++;
                }
                if (j != 2 && matrix[j][i] == 'X' && matrix[j + 1][i] == 'X') {
                    counter2++;
                }
                if (i == j && i != 2 && matrix[i][j] == 'X' && matrix[i + 1][j + 1] == 'X'){
                    counter3++;
                //00, 11, 22   \
                }
                if (i + j == 2 && i != 2 && matrix[i][j] == 'X' && matrix[i + 1][j - 1] == 'X') {
                    counter4++;
                }
                //02, 11, 20 /
            }
            if (counter == 2 || counter2 == 2 || counter3 == 2 || counter4 == 2) {
                return true;
            }
            counter2 = 0;
            counter = 0;
        }
        return false;
    }

    public Boolean isInFavorOfO() {

        int counter = 0;
        int counter2 = 0;
        int counter3 = 0;
        int counter4 = 0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) { //This is filled to 3 before the rows
                if (j != 2 && matrix[i][j] == 'O' && matrix[i][j + 1] == 'O') {
                    counter++;
                }
                if (j != 2 && matrix[j][i] == 'O' && matrix[j + 1][i] == 'O') {
                    counter2++;
                }
                if (i == j && i != 2 && matrix[i][j] == 'O' && matrix[i + 1][j + 1] == 'O'){
                    counter3++;
                    //00, 11, 22   \  The outer for loop will hit out of bounds
                    // the inner for loop will not go past 2 b/c it resets
                }
                if (i + j == 2 && i != 2 && matrix[i][j] == 'O' && matrix[i + 1][j - 1] == 'O') {
                    counter4++;
                }
                //02, 11, 20 /
            }
            if (counter == 2 || counter2 == 2 || counter3 == 2 || counter4 == 2) {
                return true;
            }
            counter2 = 0;
            counter = 0;
        }
        return false;
    }

    public Boolean isTie() {
        return !isInFavorOfO() && !isInFavorOfX();
    }

    public String getWinner() {
        if (isInFavorOfX()) {
            return "X";
        } else if (isInFavorOfO()) {
            return "O";
        }
        return "";
    }
}