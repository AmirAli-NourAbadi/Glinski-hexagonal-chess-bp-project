package ir.sharif.math.bp02_1.hex_chess.logic;

import ir.sharif.math.bp02_1.hex_chess.graphics.Application;
import ir.sharif.math.bp02_1.hex_chess.graphics.models.StringColor;
import ir.sharif.math.bp02_1.hex_chess.logic.piece.*;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;


public class GameManager {
    public Board board;
    public int pastRow = -1;
    public char pastCol = '*';
    private Color colorTurn = Color.WHITE;

    public Application application;
    private EventListenerClass listener;
    public ArrayList<StringColor> removedPiece = new ArrayList<>();


    public GameManager() {
        //super();
        this.application = new Application();
        listener = new EventListenerClass(this);
        this.application.registerEventListener(listener);
        this.board = new Board(this.application);
        syncGUIWithLogicalBoard();
        application.setMessage("White's Turn");
    }


    public void clicked(int row, char col) {
        Piece selectedPiece = board.getTiles()[row - 1][Board.getInt(col)].getPiece();
        System.out.println("Clicked on " + col + "->" + row);
        if (selectedPiece != null && selectedPiece.getColor() == colorTurn) {
            if (pastRow != -1 && pastCol != '*') {
                if (board.getTiles()[pastRow - 1][Board.getInt(pastCol)].getPiece() != null) {
                    unSelect(pastRow, pastCol);
                }
            }
            if (pastRow == row && pastCol == col) {
                if (board.getTiles()[row - 1][Board.getInt(col)].getPiece() != null) {
                    unSelect(row, col);
                }
            }
            if (pastRow != row || pastCol != col) {
                if (board.getTiles()[row - 1][Board.getInt(col)].getPiece() != null) {
                    application.setCellProperties(row, col, board.getTiles()[row - 1][Board.getInt(col)].getPiece().getPieceType(),
                            Color.orange, board.getTiles()[row - 1][Board.getInt(col)].getPiece().getColor());
                    for (Tile possibleTile : board.getTiles()[row - 1][Board.getInt(col)].getPiece().getPossibleTiles(row, col, board)) {
                        if (possibleTile.getPiece() == null)
                            application.setCellProperties(possibleTile.getRow(), possibleTile.getCol(), null, Color.BLUE, null);
                        else
                            application.setCellProperties(possibleTile.getRow(), possibleTile.getCol(), possibleTile.getPiece().getPieceType(), Color.RED, possibleTile.getPiece().getColor());
                    }
                }
                pastRow = row;
                pastCol = col;
            } else {
                pastCol = '*';
                pastRow = -1;
            }
        } else {
            if (pastRow != -1 && pastCol != '*') {
                Tile pastTile = board.getTiles()[pastRow - 1][Board.getInt(pastCol)];
                Tile selectedTile = board.getTiles()[row - 1][Board.getInt(col)];
                if (pastTile.getPiece().getPossibleTiles(pastRow, pastCol, board).contains(selectedTile)) {
                    if (selectedTile.getPiece() != null) {
                        selectedTile.getPiece().setKilled(true);
                        removedPiece.add(new StringColor(selectedTile.getPiece().getPieceType(), selectedTile.getPiece().getColor()));
                        application.setRemovedPieces(removedPiece);
                    }
                    selectedTile.setPiece(pastTile.getPiece());
                    pastTile.setPiece(null);
                    syncGUIWithLogicalBoard();
                    if (colorTurn == Color.BLACK) colorTurn = Color.WHITE;
                    else colorTurn = Color.BLACK;
                    if (colorTurn == Color.BLACK)
                        application.setMessage("Black's Turn");
                    else application.setMessage("White's Turn");
                    if (selectedTile.getPiece() instanceof Pawn) {
                        if (selectedTile.getPiece().getColor() == Color.BLACK) {
                            if (selectedTile.getTileDown() == null) {
                                String result = application.showPromotionPopup();
                                Piece newPiece = null;
                                switch (result) {
                                    case "Knight" -> newPiece = new Knight(selectedTile.getPiece().getColor());
                                    case "Queen" -> newPiece = new Queen(selectedTile.getPiece().getColor());
                                    case "Bishop" -> newPiece = new Bishop(selectedTile.getPiece().getColor());
                                    case "Rook" -> newPiece = new Rook(selectedTile.getPiece().getColor());
                                }
                                selectedTile.setPiece(newPiece);
                                syncGUIWithLogicalBoard();

                            }
                        } else {
                            if (selectedTile.getTileUp() == null) {
                                String result = application.showPromotionPopup();
                                Piece newPiece = null;
                                switch (result) {
                                    case "Knight" -> newPiece = new Knight(selectedTile.getPiece().getColor());
                                    case "Queen" -> newPiece = new Queen(selectedTile.getPiece().getColor());
                                    case "Bishop" -> newPiece = new Bishop(selectedTile.getPiece().getColor());
                                    case "Rook" -> newPiece = new Rook(selectedTile.getPiece().getColor());
                                }
                                selectedTile.setPiece(newPiece);
                                syncGUIWithLogicalBoard();
                            }
                        }
                    }

                    pastRow = -1;
                    pastCol = '*';
                }
            }
        }
    }

    public void saveGame(String name) throws IOException {
        FileWriter fileWriter = new FileWriter("./m" + name);
        String color = colorTurn.getBlue() == 0 ? "Black" : "White";
        fileWriter.write(color);
        fileWriter.write("\n");
        for (Tile[] row : board.getTiles()) {
            for (Tile tile : row) {
                if (tile == null || tile.getPiece() == null) continue;
                String pieceData = "";
                color = tile.getPiece().getColor().getBlue() == 0 ? "Black" : "White";
                pieceData += tile.getRow() + " " + tile.getCol() + " " +
                        tile.getPiece().getClass().getSimpleName() + " " + color;
                fileWriter.write(pieceData);
                fileWriter.write("\n");
            }
        }
        fileWriter.close();
        fileWriter = new FileWriter("./k" + name);
        for (StringColor stringColor : removedPiece) {
            String pieceData = "";
            color = stringColor.getColor().getBlue() == 0 ? "Black" : "White";
            pieceData = stringColor.getText() + " " + color;
            fileWriter.write(pieceData);
            fileWriter.write("\n");
        }
        fileWriter.close();

    }

    public void loadGame(String name) throws IOException {
        this.board = new Board(this.application);
        board.setupThisBoardForRelevantApplication();
        String input = readFile("m" + name);
        String[] data = input.split("\n");
        colorTurn = data[0].equals("Black") ? Color.BLACK : Color.WHITE;
        application.setMessage(data[0] +"'s Turn");
        for (int i = 1; i < data.length; i++) {
            String[] features = data[i].split(" ");
            int row = Integer.parseInt(features[0]);
            char col = features[1].charAt(0);
            Color color = features[3].equals("Black") ? Color.BLACK : Color.WHITE;
            Piece newPiece = null;
            switch (features[2]) {
                case "Knight" -> newPiece = new Knight(color);
                case "Queen" -> newPiece = new Queen(color);
                case "Bishop" -> newPiece = new Bishop(color);
                case "Rook" -> newPiece = new Rook(color);
                case "Pawn" -> newPiece = new Pawn(color);
                case "King" -> newPiece = new King(color);
            }
            board.getTiles()[row-1][Board.getInt(col)].setPiece(newPiece);
        }
        removedPiece.clear();
        input = readFile("k" + name);
        data = input.split("\n");
        for (String datum : data) {
            String[] features = datum.split(" ");
            Color color = features[1].equals("Black") ? Color.BLACK : Color.WHITE;
            removedPiece.add(new StringColor(features[0],color));
            application.setRemovedPieces(removedPiece);


        }
        syncGUIWithLogicalBoard();
    }

    private static String readFile(String name) throws IOException {
        int ch;
        ArrayList<Character> load = new ArrayList<>();
        FileReader fileReader = new FileReader("./" + name);
        while ((ch = fileReader.read()) != -1)
            load.add((char) ch);
        char[] in = new char[load.size()];
        for (int i = 0; i < load.size(); i++) {
            in[i] = load.get(i);
        }
        String input = String.valueOf(in);
        return input;
    }

    private void unSelect(int r, char c) {
        application.setCellProperties(r, c, board.getTiles()[r - 1][Board.getInt(c)].getPiece().getPieceType(),
                null, board.getTiles()[r - 1][Board.getInt(c)].getPiece().getColor());
        for (Tile possibleTile : board.getTiles()[r - 1][Board.getInt(c)].getPiece().getPossibleTiles(r, c, board)) {
            if (possibleTile.getPiece() == null)
                application.setCellProperties(possibleTile.getRow(), possibleTile.getCol(), null, null, null);
            else
                application.setCellProperties(possibleTile.getRow(), possibleTile.getCol(), possibleTile.getPiece().getPieceType(), null, possibleTile.getPiece().getColor());
        }
    }

    public void newGame() {
        this.board = new Board(this.application);
        board.setupThisBoardForRelevantApplication();
        board.initializePieces();
        application.setMessage("White's Turn");
        colorTurn = Color.WHITE;
        removedPiece.clear();
        syncGUIWithLogicalBoard();
    }




    public void syncGUIWithLogicalBoard() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 11; j++) {
                if (board.getTiles()[i][j].getPiece() == null)
                    application.setCellProperties(i + 1, Board.getChar(j), null,
                            null, null);
                else
                    application.setCellProperties(i + 1, Board.getChar(j), board.getTiles()[i][j].getPiece().getPieceType(),
                            null, board.getTiles()[i][j].getPiece().getColor());
            }
        }
        for (int i = 6; i < 11; i++) {
            for (int j = 1 + (i - 6); j < 10 + (6 - i); j++) {
                if (board.getTiles()[i][j].getPiece() == null)
                    application.setCellProperties(i + 1, Board.getChar(j), null,
                            null, null);
                else
                    application.setCellProperties(i + 1, Board.getChar(j), board.getTiles()[i][j].getPiece().getPieceType(),
                            null, board.getTiles()[i][j].getPiece().getColor());
            }
        }
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public EventListenerClass getListener() {
        return listener;
    }

    public void setListener(EventListenerClass listener) {

        this.listener = listener;
    }
}
