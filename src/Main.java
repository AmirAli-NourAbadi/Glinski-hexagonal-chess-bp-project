import ir.sharif.math.bp02_1.hex_chess.graphics.Application;
import ir.sharif.math.bp02_1.hex_chess.graphics.listeners.SystemOutEventListener;
import ir.sharif.math.bp02_1.hex_chess.logic.Board;
import ir.sharif.math.bp02_1.hex_chess.logic.GameManager;
import ir.sharif.math.bp02_1.hex_chess.logic.Tile;
import ir.sharif.math.bp02_1.hex_chess.logic.piece.*;
import ir.sharif.math.bp02_1.hex_chess.util.PieceName;

import java.awt.*;
import ir.sharif.math.bp02_1.hex_chess.graphics.models.StringColor;

public class Main {
    public static void main(String[] args) {

//        Application application = new Application();
//        application.registerEventListener(new SystemOutEventListener());
//        //GameManager gameManager = new GameManager(application);
////        application.registerEventListener(new SystemOutEventListener());
//        Bishop test = new Bishop(Color.white);
//        application.setCellProperties(1, 'a', PieceName.BLACK_QUEEN, Color.gray, test.color);
//
//        application.setCellProperties(2, 'l', PieceName.WHITE_BISHOP, null, Color.WHITE);
//        application.setRemovedPieces(new StringColor[]{
//                new StringColor(PieceName.BLACK_BISHOP, StringColor.BLACK),
//                new StringColor(PieceName.WHITE_BISHOP, StringColor.WHITE),
//                new StringColor(PieceName.WHITE_KNIGHT, StringColor.WHITE),
//                new StringColor(PieceName.BLACK_QUEEN, StringColor.BLACK),
//                new StringColor(PieceName.WHITE_BISHOP, StringColor.WHITE)
//        });
//        application.setMessage("White's Turn");/*
        GameManager mine = new GameManager();
//        mine.board.getTiles()[7][3].setPiece(new Pawn(Color.WHITE));
////        mine.board.getTiles()[7][3].getPiece().getPossibleTiles(8,'e',mine.getBoard());
//        mine.application.setCellProperties(8, 'e', PieceName.WHITE_PAWN ,null, Color.WHITE);

    }
}