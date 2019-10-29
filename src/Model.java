/*
Since we have already written code for TicTacToe, model just links board to the GUI
 */
public class Model {
    //keeps track of who is currently going
    private boolean player1Turn = true;

    //make a board object
    Board board = new Board();

    //getters and setters for board
    //flips the turn between 1 and 2
    public void setPlayer1Turn(){
        player1Turn = !player1Turn;
    }
    public boolean getPlayer1Turn() {
        return player1Turn;
    }
    public int getWins1(){
        return board.wins1;
    }
    public int getWins2(){
        return board.wins2;
    }
    public int getLosses1(){
        return board.losses1;
    }
    public int getLosses2(){
        return board.losses2;
    }
    public int getTotalMoves(){
        return board.totalmoves;
    }

    //makes a new board after clicking reset stats button
    public void resetGame(){
        board = new Board();
        //player1Turn = false;
    }
    //resets board for new game but not all data is "wiped"
    public void resetBoard(){
        board.resetBoard();
        player1Turn = false;
    }
    //main backend function passed to board
    public boolean calltoPlayerTurn(int a, int b, String c){
        return board.playerTurn(a,b,c);
    }
}
