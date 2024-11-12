package ir.sharif.math.bp02_1.hex_chess.logic;

import ir.sharif.math.bp02_1.hex_chess.logic.piece.Piece;

public class Tile {
    private Tile tileUp ;
    private Tile tileDown ;
    private Tile tileUpLeft ;
    private Tile tileUpRight ;
    private Tile tileDownLeft ;
    private Tile tileDownRight ;

    private Piece piece;

    private int row;

    private char col;

    private boolean isSelected;



    public Tile(int row, char col,Piece piece) {
        this.row = row;
        this.col = col;
         this.piece = piece;
    }


    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public char getCol() {
        return col;
    }

    public void setCol(char col) {
        this.col = col;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public Piece getPiece() {
        return piece;
    }
    @Override
    public String toString(){
    return ""+row + col;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Tile getTileUp() {
        return tileUp;
    }

    public void setTileUp(Tile tileUp) {
        this.tileUp = tileUp;
    }

    public Tile getTileDown() {
        return tileDown;
    }

    public void setTileDown(Tile tileDown) {
        this.tileDown = tileDown;
    }

    public Tile getTileUpLeft() {
        return tileUpLeft;
    }

    public void setTileUpLeft(Tile tileUpLeft) {
        this.tileUpLeft = tileUpLeft;
    }

    public Tile getTileUpRight() {
        return tileUpRight;
    }

    public void setTileUpRight(Tile tileUpRight) {
        this.tileUpRight = tileUpRight;
    }

    public Tile getTileDownLeft() {
        return tileDownLeft;
    }

    public void setTileDownLeft(Tile tileDownLeft) {
        this.tileDownLeft = tileDownLeft;
    }

    public Tile getTileDownRight() {
        return tileDownRight;
    }

    public void setTileDownRight(Tile tileDownRight) {
        this.tileDownRight = tileDownRight;
    }
}
