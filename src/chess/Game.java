package chess;

import chess.Board;
import chess.*;
import chess.Board.*;
import chess.piece.*;
import chess.Letter;
import chess.piece.ChessPiece;

import java.util.ArrayList;

public class Game {

    public Game() {
        this.allMoves = new ArrayList<>();

    }

    private ArrayList<String> allMoves;


    public ArrayList<String> getMoves() {
        return this.allMoves;
    }

    public void setMoves(ChessPieceType type, int rowCur, int colCur, int rowDes, int colDes, boolean beatsPiece) {
        //String with moves
        String moveNotation = "";

        //text
        String text = "";
        switch (type) {
            case QUEEN:
                text += "Die Dame ";
                moveNotation += '\u2655';
                break;
            case BISHOP:
                text += "Der Läufer ";
                moveNotation += '\u2657';
                break;
            case KNIGHT:
                text += "Der Springer ";
                moveNotation += '\u2658';
                break;
            case ROOK:
                text += "Der Turm ";
                moveNotation += '\u2656';

                break;
            case PAWN:
                text += "Der Bauer ";
                moveNotation += '\u2659';

                break;
            case KING:
                text += "Der König ";
                moveNotation += '\u2654';

                break;
        }
        moveNotation += getPieceNotation(rowCur, colCur);
        moveNotation += "-";

        moveNotation += getPieceNotation(rowDes, colDes);
        allMoves.add(moveNotation);


        text += "auf ";
        text += moveNotation.substring(1, 3);
        text += " zieht nach ";
        text += moveNotation.substring(4, 6);

        if (beatsPiece) {
            text += " und schlägt dort ein gegnerischen Stein";
        }
        allMoves.add(text);
    }

    public String getPieceNotation(int row, int col) {
        String str = "";
        char colChar = 'a';
        colChar += col;
        str += colChar;
        int rowInt = 8 - row;
        str += rowInt;
        return str;
    }

    public void printMoves() {
        for ( int i = 0; i < getMoves().size(); i++ ) {
            System.out.print(getMoves().get(i));
            i++;
            System.out.print("    | ");
            System.out.println(getMoves().get(i));

        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        Board board = new Board();
        System.out.print(board);
        System.out.println();
        int x1, x2, y1, y2;
        x1 = 6;
        x2 = 5;
        y1 = 1;
        y2 = 1;

        boolean beatsPiece = board.beatsPiece(board.getBoard(), x2, y2);
        game.setMoves(board.getBoard()[x1][y1].getType(), x1, y1, x2, y2, beatsPiece);
        board.move(x1, y1, x2, y2);
        System.out.println(board);
        System.out.println();

        x1 = 7;
        y1 = 1;
        x2 = 5;
        y2 = 2;
        beatsPiece = board.beatsPiece(board.getBoard(), x2, y2);
        game.setMoves(board.getBoard()[x1][y1].getType(), x1, y1, x2, y2, beatsPiece);
        board.move(x1, y1, x2, y2);
        System.out.println();
        System.out.println(board);
        System.out.println();

        x1 = 7;
        y1 = 2;
        x2 = 5;
        y2 = 0;
        beatsPiece = board.beatsPiece(board.getBoard(), x2, y2);
        game.setMoves(board.getBoard()[x1][y1].getType(), x1, y1, x2, y2, beatsPiece);
        board.move(x1, y1, x2, y2);
        System.out.println(board);
        System.out.println();
        game.printMoves();


    }
}
