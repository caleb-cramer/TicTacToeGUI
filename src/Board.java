//this is the board for the game
public class Board {
    private Cell[][] board;
    int wins1;
    int wins2;
    int losses1;
    int losses2;
    private int totalmoves;



    //main constructor
    public Board() {
        wins1 = wins2 = losses1 = losses2 = totalmoves = 0;
        this.board = new Cell[3][3];
        //fill the board with "-"
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.board[i][j]=new Cell(new Coordinates(i,j), "-");
            }
        }
    }



    @Override
    public String toString() {
        String returnBoard = " ";
        for (int i = 1; i <= 3; i++) {
            returnBoard=returnBoard+" " +Integer.toString(i);
        }
        returnBoard+="\n";
        for (int i = 1; i <= 3; i++) {
            returnBoard+= Integer.toString(i);
            for (int j = 1; j <= 3; j++) {
                returnBoard = returnBoard + " " + board[i-1][j-1].toString();
            }
            returnBoard+="\n";
        }
        return returnBoard;
    }
    //checks if move is okay and then fills the spot with the correct symbol
    public void makeMove(Coordinates coordinates, String playerSymbol){
        //if(isValidMove(coordinates)){

        (board[coordinates.getRow()][coordinates.getColumn()]).setSymbol(playerSymbol);

        //}
    }

    public void resetBoard(){
        totalmoves = 0;
        this.board = new Cell[3][3];
        //fill the board with "-"
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.board[i][j]=new Cell(new Coordinates(i,j), "-");
            }
        }
    }

    //checks to see if playerSymbol is a winner
    //checks row win, column win, diag win, anti diag win
    public boolean isWinner(Coordinates guess, String playerSymbol){
        //idea for antidiag win test from
        // https://stackoverflow.com/questions/1056316/algorithm-for-determining-tic-tac-toe-game-over
        for (int i = 0; i < 3; i++) {
            if (board[guess.getRow()][i].getSymbol() != playerSymbol) {
                break;
            }
            if (i == 3 - 1) {
                return true;
            }
        }

        for (int j = 0; j < 3; j++) {
            if (board[j][guess.getColumn()].getSymbol() != playerSymbol) {
                break;
            }
            if (j==3-1) {
                return true;
            }
        }

        if (guess.getColumn()==guess.getRow()){
            for(int k = 0; k < 3; k++){
                if(board[k][k].getSymbol() != playerSymbol)
                    break;
                if(k == 3-1){
                    return true;
                }
            }
        }

        if (guess.getColumn()+guess.getRow()==3-1){
            for (int l = 0; l < 3; l++) {
                if(board[l][3-1-l].getSymbol()!= playerSymbol){
                    break;
                }
                if (l==3-1){
                    return true;
                }
            }
        }

        return false;
    }

    //method to control the player turn
    public boolean playerTurn(int col, int row, String pSymbol){
        Coordinates guess = new Coordinates(row, col);

        makeMove(guess, pSymbol);
        totalmoves++;
        boolean win = isWinner(guess,pSymbol);
        System.out.println(toString());
        if (win){
            if(pSymbol == "X"){
                wins1++;
                losses2++;
            }
            else{
                losses1++;
                wins2++;
            }
            System.out.println(wins1);
        }
        else if(totalmoves==9){
            losses1++;
            losses2++;
            System.out.println("scratch");
        }
        return win;
    }
}
