package Moderate;

import java.util.ArrayList;

public class TicTacToeNByNOptimal {

    enum Piece{Empty, Cross, Zero};

    public Piece hasWon(Piece[][] board){
        int size = board.length;
        if(size != board[0].length){
            return Piece.Empty;
        }

        ArrayList<Check> instructions = new ArrayList<Check>();
        for(int i = 0; i < size; i++){
            instructions.add(new Check(i, 0, 0, 1));
            instructions.add(new Check(0, i, 1, 0));
        }
        instructions.add(new Check(0, 0, 1, 1));
        instructions.add(new Check(0, size - 1, 1, -1));

        for(Check instr : instructions){
            Piece winner = hasWon(board, instr);
            if(winner != Piece.Empty){
                return winner;
            }
        }
        return Piece.Empty;
    }

    private Piece hasWon(Piece[][] board, Check instr){
        Piece first = board[instr.row][instr.col];
        while(instr.inBounds(board.length)){
            if(first != board[instr.row][instr.col]){
                return Piece.Empty;
            }
            instr.increment();
        }
        return first;
    }

}