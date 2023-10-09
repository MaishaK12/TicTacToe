package tictactoe;

import java.util.Scanner;

public class Processor {
    private Grid gameGrid;
    private Scanner scanner;
    
    public Processor() {
        gameGrid = new Grid();
        gameGrid.printGrid();
        scanner = new Scanner(System.in);
      //  play();
    }
    
    public void play() {
        char turn = 'X';
        
        for (int i = 0; i < 9; i++){
            // let current player make the move
            if (makeMove(turn)) {
                System.out.println(turn + " has won!");
                break;
            }
            
            // update the turn
            if (turn == 'X')
                turn = 'Y';
            else
                turn = 'X';
            
            if (i == 8) {
                System.out.println("It's a tie.");
            }
        }
        
        System.out.println("Would you like to play again?");
        if (scanner.next().equalsIgnoreCase("yes")) {
            restartGame();
        } else {
            System.out.println("Good bye!");
        }
    }
    
    public void restartGame() {
        gameGrid.initializeGrid();
        gameGrid.printGrid();
        play();
    }
    
    public boolean makeMove(char xy) {
        while (true) {
            System.out.println("\nPlease enter the coordinates for " + xy + ": ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            // check if the cell is not occupied
            if (gameGrid.isCellEmpty(row, col)) {
                // update the cell
                gameGrid.setCell(row, col, xy);
                gameGrid.printGrid();
                
                // check if current user has won
                if (gameGrid.isWinner(xy)) {
                    return true;
                }
                return false;
            } 
        }
    }
}