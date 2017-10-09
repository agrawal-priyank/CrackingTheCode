package Moderate;

public class TicTacToeNByN {

    enum Piece {Empty, Cross, Zero};

    public Piece hasWon(Piece[][] board){
        int size = board.length;
        if(size != board[0].length){
            return Piece.Empty;
        }
        Piece first;
        // Check for rows
        for(int i = 0; i < size; i++){
            first = board[i][0];
            if(first == Piece.Empty){
                continue;
            }
            for(int j = 1; j < size; j++){
                if(board[i][j] != first){
                    break;
                } else if(j == size - 1){
                    return first;
                }
            }
        }
        // Check for columns
        for(int i = 0; i < size; i++){
            first = board[0][i];
            if(first == Piece.Empty){
                continue;
            }
            for(int j = 1; j < size; j++){
                if(board[j][i] != first){
                    break;
                } else if(j == size - 1){
                    return first;
                }
            }
        }
        // Check for diagonals
        first = board[0][0];
        if(first != Piece.Empty){
            for(int i = 1; i < size; i++){
                if(board[i][i] != first){
                    break;
                } else if(i == size - 1){
                    return first;
                }
            }
        }
        first = board[0][size - 1];
        if(first != Piece.Empty){
            for(int i = 1; i < size; i++){
                if(board[i][size - i - 1] != first){
                    break;
                } else if( i == size - 1){
                    return first;
                }
            }
        }
        return Piece.Empty;
    }

}