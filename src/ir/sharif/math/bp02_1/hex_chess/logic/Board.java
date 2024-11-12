package ir.sharif.math.bp02_1.hex_chess.logic;

import ir.sharif.math.bp02_1.hex_chess.graphics.Application;
import ir.sharif.math.bp02_1.hex_chess.logic.piece.*;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Board {

    private static final HashMap<Integer, Character> itc = new HashMap<>();
    private static final HashMap<Character, Integer> cti = new HashMap<>();
    private Tile[][] tiles = new Tile[11][11];

    public Board(Application application) {
        makeBoard();
        setupThisBoardForRelevantApplication();
        initializePieces();
    }

    private void makeBoard() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 11; j++) {
                tiles[i][j] = new Tile(i + 1, Board.getChar(j), null);
            }
        }
        for (int i = 6; i < 11; i++) {
            for (int j = 1 + (i - 6); j < 10 + (6 - i); j++) {
                tiles[i][j] = new Tile(i + 1, Board.getChar(j), null);
            }
        }
    }

    private void makeNeighbors() {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (tiles[i][j] == null) continue;

                if (i != 10 && tiles[i + 1][j] != null)
                    tiles[i][j].setTileUp(tiles[i + 1][j]);


                if (i != 0 && tiles[i - 1][j] != null)
                    tiles[i][j].setTileDown(tiles[i - 1][j]);

                if (j < 5) {
                    tiles[i][j].setTileUpRight(tiles[i + 1][j + 1]);
                } else if (i != 10 && j < 10 && tiles[i][j + 1] != null)
                    tiles[i][j].setTileUpRight(tiles[i][j + 1]);

                if (j > 5)
                    tiles[i][j].setTileUpLeft(tiles[i + 1][j - 1]);
                else if (j > 0 && tiles[i][j - 1] != null)
                    tiles[i][j].setTileUpLeft(tiles[i][j - 1]);


                if (j > 5)
                    tiles[i][j].setTileDownLeft(tiles[i][j - 1]);
                else if (j > 0 && i > 0 && tiles[i - 1][j - 1] != null) {
                    tiles[i][j].setTileDownLeft(tiles[i - 1][j - 1]);
                }

                if (j < 5)
                    tiles[i][j].setTileDownRight(tiles[i][j + 1]);
                else if (i != 0 && j < 10 && tiles[i - 1][j + 1] != null) {
                    tiles[i][j].setTileDownRight(tiles[i - 1][j + 1]);
                }
            }
        }
    }

    public void setupThisBoardForRelevantApplication() {
        makeBoard();
        makeNeighbors();
        //Setup Pieces on logical table
        // And setup graphical board
    }

    public void initializePieces() {
        tiles[0][1].setPiece(new Pawn(Color.WHITE));
        tiles[1][2].setPiece(new Pawn(Color.WHITE));
        tiles[2][3].setPiece(new Pawn(Color.WHITE));
        tiles[3][4].setPiece(new Pawn(Color.WHITE));
        tiles[4][5].setPiece(new Pawn(Color.WHITE));
        tiles[3][6].setPiece(new Pawn(Color.WHITE));
        tiles[2][7].setPiece(new Pawn(Color.WHITE));
        tiles[1][8].setPiece(new Pawn(Color.WHITE));
        tiles[0][9].setPiece(new Pawn(Color.WHITE));


//        initialize white bishop

        tiles[0][5].setPiece(new Bishop(Color.WHITE));
        tiles[1][5].setPiece(new Bishop(Color.WHITE));
        tiles[2][5].setPiece(new Bishop(Color.WHITE));


//        initialize white rook

        tiles[0][2].setPiece(new Rook(Color.WHITE));
        tiles[0][8].setPiece(new Rook(Color.WHITE));


//       initialize white knight

        tiles[0][7].setPiece(new Knight(Color.WHITE));
        tiles[0][3].setPiece(new Knight(Color.WHITE));


//        initialize white king

        tiles[0][6].setPiece(new King(Color.WHITE));


//        initialize white queen

        tiles[0][4].setPiece(new Queen(Color.WHITE));


        //        initialize black pawn
        tiles[6][1].setPiece(new Pawn(Color.BLACK));
        tiles[6][2].setPiece(new Pawn(Color.BLACK));
        tiles[6][3].setPiece(new Pawn(Color.BLACK));
        tiles[6][4].setPiece(new Pawn(Color.BLACK));
        tiles[6][5].setPiece(new Pawn(Color.BLACK));
        tiles[6][6].setPiece(new Pawn(Color.BLACK));
        tiles[6][7].setPiece(new Pawn(Color.BLACK));
        tiles[6][8].setPiece(new Pawn(Color.BLACK));
        tiles[6][9].setPiece(new Pawn(Color.BLACK));


//        initialize black bishop

        tiles[8][5].setPiece(new Bishop(Color.BLACK));
        tiles[9][5].setPiece(new Bishop(Color.BLACK));
        tiles[10][5].setPiece(new Bishop(Color.BLACK));


//        initialize black rook

        tiles[7][2].setPiece(new Rook(Color.BLACK));

        tiles[7][8].setPiece(new Rook(Color.BLACK));


//       initialize black knight

        tiles[8][7].setPiece(new Knight(Color.BLACK));

        tiles[8][3].setPiece(new Knight(Color.BLACK));


//        initialize black king

        tiles[9][6].setPiece(new King(Color.BLACK));


//        initialize black queen

        tiles[9][4].setPiece(new Queen(Color.BLACK));
    }

    static {
        itc.put(0, 'a');
        itc.put(1, 'b');
        itc.put(2, 'c');
        itc.put(3, 'd');
        itc.put(4, 'e');
        itc.put(5, 'f');
        itc.put(6, 'g');
        itc.put(7, 'h');
        itc.put(8, 'i');
        itc.put(9, 'k');
        itc.put(10, 'l');
        for (Map.Entry<Integer, Character> e : itc.entrySet()) {
            cti.put(e.getValue(), e.getKey());
        }
    }

    public static char getChar(Integer i) {
        if (i < 0 || i > 10)
            throw new RuntimeException("invalid number!" + i);
        return itc.get(i);
    }

    public static int getInt(char c) {
        if (cti.containsKey(c)) return cti.get(c);
        else
            throw new RuntimeException("invalid character!");
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public void setTiles(Tile[][] tiles) {
        this.tiles = tiles;
    }
}
