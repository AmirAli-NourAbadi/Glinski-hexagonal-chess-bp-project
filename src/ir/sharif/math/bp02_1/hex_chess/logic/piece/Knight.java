package ir.sharif.math.bp02_1.hex_chess.logic.piece;

import java.awt.*;

public class Knight extends Piece{

    public Knight(Color colorPiece) {
        super(colorPiece);
    }

    @Override
    public String toString() {
        return super.getClass().getName();
    }
}
