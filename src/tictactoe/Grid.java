package tictactoe;

public class Grid {
    private char[][] grid;
    
    public Grid() {
        grid = new char[3][3];
        initializeGrid();
    }
    
    public void initializeGrid() {
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                grid[row][col] = '-';
    }
    
    public void printGrid() {
        System.out.println();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++)  
                System.out.print(grid[row][col] + " ");
            System.out.println();
        }
    }
    
    public void setCell(int row, int col, char xy) {
        grid[row][col] = xy;
    }
    
    public boolean isCellEmpty(int row, int col) {
        if (grid[row][col] == '-')
            return true;
        
        return false;
    }
    
    public boolean isWinner(char xy) {
        for (int row = 0; row < 3; row++) {
            if (grid[row][0] == xy && grid[row][1] == xy && grid[row][2] == xy)
                return true;
        }

        for (int col = 0; col < 3; col++) {
            if (grid[0][col] == xy && grid[1][col] == xy && grid[2][col] == xy)
                return true;
        }
        
        if (grid[0][0] == xy && grid[1][1] == xy && grid[2][2] == xy)
            return true;

        if (grid[0][2] == xy && grid[1][1] == xy && grid[2][0] == xy)
            return true;
        
        return false;
    }
}