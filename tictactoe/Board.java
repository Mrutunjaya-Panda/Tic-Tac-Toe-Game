package tictactoe;

public class Board {
    private char board[][];
    private int boardSize = 3;
    private char p1Symbol, p2Symbol;
    private int count; // represents the no. of cells that have been filled.
    private static final char Empty = ' ';
    //for a layman person not knowing anything about the code, we should declare constatant values which will declare
    //it's purpose.
    public static final int PLAYER1WINS = 1;
    public static final int PLAYER2WINS = 2;
    public static final int DRAW = 3;
    public static final int INCOMPLETE = 4;
    public static final int INVALIDMOVE = 5;

    public Board(char p1Symbol, char p2Symbol){
        board = new char[boardSize][boardSize];
        for(int i=0;i<boardSize;i++){
            for(int j=0;j<boardSize;j++){
                board[i][j] = Empty;
            }
        }
        this.p1Symbol = p1Symbol;
        this.p2Symbol = p2Symbol;
    }

    public int move(char symbol, int x, int y) {
        //first check if valid move or not.
        if(x<0 || x>=boardSize || y<0 || y>=boardSize || board[x][y]!= Empty){
            return INVALIDMOVE;
        }
        //make the move
        board[x][y] = symbol;
        count++;
        //check row first
        if(board[x][0] == board[x][1] && board[x][0] == board[x][2]){
            //return who won.
            return symbol == p1Symbol ? PLAYER1WINS : PLAYER2WINS;
        }

        //check column
        if(board[0][y] == board[1][y] && board[0][y] == board[2][y]){
            //return who won.
            return symbol == p1Symbol ? PLAYER1WINS : PLAYER2WINS;
        }

        //check diagonals.
        //another check, you should be cautious about, if wheather the move you are doing is on the diagonals or not.
        if(board[0][0]!= Empty && board[0][0] == board[1][1] && board[0][0] == board[2][2]){
            //return who won.
            return symbol == p1Symbol ? PLAYER1WINS : PLAYER2WINS;
        }
        if(board[0][2]!= Empty && board[0][2] == board[1][1] && board[0][2] == board[2][0]){
            //return who won.
            return symbol == p1Symbol ? PLAYER1WINS : PLAYER2WINS;
        }

        //now if no one has won, either it's incomplete or is draw.
        if(count == boardSize*boardSize){
            return DRAW;
        }

        //the game is still on..
        return INCOMPLETE;
    }

    //print method.
    public void print(){
        System.out.println("-------------");
        for(int i=0;i<boardSize;i++){
            for(int j=0;j<boardSize;j++){
                System.out.print("| " + board[i][j] + " |");
            }
            System.out.println();
            
        }
        System.out.println("-------------");
    }

    
}
