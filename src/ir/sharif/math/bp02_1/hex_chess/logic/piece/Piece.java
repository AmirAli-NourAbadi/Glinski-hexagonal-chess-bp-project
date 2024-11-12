package ir.sharif.math.bp02_1.hex_chess.logic.piece;

import ir.sharif.math.bp02_1.hex_chess.logic.Board;
import ir.sharif.math.bp02_1.hex_chess.logic.Tile;
import ir.sharif.math.bp02_1.hex_chess.util.PieceName;

import java.awt.*;
import java.util.ArrayList;

public abstract class Piece {


    private boolean killed = false;


    private Color color;

    protected Piece(Color pieceColor) {
        this.color = pieceColor;
    }


    public boolean isKilled() {
        return killed;
    }

    public void setKilled(boolean killed) {
        this.killed = killed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public final ArrayList<Tile> getPossibleTiles(int currentRow, char currentCol, Board board) { // Will return an array of cells based on GUI Scale
        ArrayList<Tile> possibilities = new ArrayList<>();
        int currentColInt = Board.getInt(currentCol);
        int colF = 5;
        Tile thisTile = board.getTiles()[currentRow - 1][Board.getInt(currentCol)];

        //possibilities.add("1c");
        if (this.getPieceType() == PieceName.WHITE_ROOK || this.getPieceType() == PieceName.BLACK_ROOK) {
            Tile next = thisTile;

            while ((next = next.getTileUp()) != null) {
                if (next.getPiece() == null) {
                    possibilities.add(next);
                } else {
                    if (thisTile.getPiece().getColor() == next.getPiece().getColor()) break;
                    if (thisTile.getPiece().getColor() != next.getPiece().getColor()) {
                        possibilities.add(next);
                        break;
                    }
                }
            }
            next = thisTile;
            while ((next = next.getTileDown()) != null) {
                if (next.getPiece() == null) {
                    possibilities.add(next);
                } else {
                    if (thisTile.getPiece().getColor() == next.getPiece().getColor()) break;
                    if (thisTile.getPiece().getColor() != next.getPiece().getColor()) {
                        possibilities.add(next);
                        break;
                    }
                }
            }

            next = thisTile;
            while ((next = next.getTileDownLeft()) != null) {
                if (next.getPiece() == null) {
                    possibilities.add(next);
                } else {
                    if (thisTile.getPiece().getColor() == next.getPiece().getColor()) break;
                    if (thisTile.getPiece().getColor() != next.getPiece().getColor()) {
                        possibilities.add(next);
                        break;
                    }
                }
            }

            next = thisTile;
            while ((next = next.getTileDownRight()) != null) {
                if (next.getPiece() == null) {
                    possibilities.add(next);
                } else {
                    if (thisTile.getPiece().getColor() == next.getPiece().getColor()) break;
                    if (thisTile.getPiece().getColor() != next.getPiece().getColor()) {
                        possibilities.add(next);
                        break;
                    }
                }
            }

            next = thisTile;
            while ((next = next.getTileUpLeft()) != null) {
                if (next.getPiece() == null) {
                    possibilities.add(next);
                } else {
                    if (thisTile.getPiece().getColor() == next.getPiece().getColor()) break;
                    if (thisTile.getPiece().getColor() != next.getPiece().getColor()) {
                        possibilities.add(next);
                        break;
                    }
                }
            }

            next = thisTile;
            while ((next = next.getTileUpRight()) != null) {
                if (next.getPiece() == null) {
                    possibilities.add(next);
                } else {
                    if (thisTile.getPiece().getColor() == next.getPiece().getColor()) break;
                    if (thisTile.getPiece().getColor() != next.getPiece().getColor()) {
                        possibilities.add(next);
                        break;
                    }
                }
            }
        }
        else if (this.getPieceType() == PieceName.WHITE_PAWN) {
            if ((currentRow-1 == 0 && Board.getInt(currentCol) == 1) || (currentRow-1 == 1 && Board.getInt(currentCol) == 2) || (currentRow-1 == 2 && Board.getInt(currentCol) == 3) ||
                    (currentRow-1 == 3 && Board.getInt(currentCol) == 4) || (currentRow-1 == 4 && Board.getInt(currentCol) == 5) || (currentRow-1 == 3 && Board.getInt(currentCol) == 6) ||
                    (currentRow-1 == 2 && Board.getInt(currentCol) == 7) || (currentRow-1 == 1 && Board.getInt(currentCol) == 8) || (currentRow-1 == 0 && Board.getInt(currentCol) == 9) )
            {
                   Tile next = thisTile.getTileUp();
                    if (next != null) {

                    addToPossibiltiesPawn(possibilities, thisTile, thisTile.getTileUp());
                        if (thisTile.getTileUp().getPiece() != null);
                        else
                            addToPossibiltiesPawn(possibilities, next, next.getTileUp());
                     }
            }
            else {
                    addToPossibiltiesPawn(possibilities, thisTile, thisTile.getTileUp());
            }
            if (thisTile.getTileUpRight() != null) {
                    if (thisTile.getTileUpRight().getPiece() != null) {
                        if (thisTile.getTileUpRight().getPiece().getColor() == thisTile.getPiece().getColor());
                        else if (thisTile.getTileUpRight().getPiece().getColor() != thisTile.getPiece().getColor())
                            addToPossibilties(possibilities , thisTile , thisTile.getTileUpRight());
                    }
            }
            if (thisTile.getTileUpLeft() != null) {
                    if (thisTile.getTileUpLeft().getPiece() != null) {
                        if (thisTile.getTileUpLeft().getPiece().getColor() == thisTile.getPiece().getColor());
                        else if (thisTile.getTileUpLeft().getPiece().getColor() != thisTile.getPiece().getColor())
                                addToPossibilties(possibilities , thisTile , thisTile.getTileUpLeft());
                    }
            }
        }
        else if (this.getPieceType() == PieceName.BLACK_PAWN) {
            if ((currentRow-1 == 6 && Board.getInt(currentCol) == 1) || (currentRow-1 == 6 && Board.getInt(currentCol) == 2) || (currentRow-1 == 6 && Board.getInt(currentCol) == 3) ||
                    (currentRow-1 == 6 && Board.getInt(currentCol) == 4) || (currentRow-1 == 6 && Board.getInt(currentCol) == 5) || (currentRow-1 == 6 && Board.getInt(currentCol) == 6) ||
                    (currentRow-1 == 6 && Board.getInt(currentCol) == 7) || (currentRow-1 == 6 && Board.getInt(currentCol) == 8) || (currentRow-1 == 6 && Board.getInt(currentCol) == 9) ) {
                Tile next = thisTile.getTileDown();
                if (thisTile.getTileDown() != null) {
                    addToPossibiltiesPawn(possibilities, thisTile, thisTile.getTileDown());
                    if (thisTile.getTileDown().getPiece() != null);
                    else
                     addToPossibiltiesPawn(possibilities, next, next.getTileDown());
                }
            }
            else {
                    addToPossibiltiesPawn(possibilities, thisTile, thisTile.getTileDown());
            }
            if (thisTile.getTileDownRight() != null) {
                    if (thisTile.getTileDownRight().getPiece() != null) {
                        if (thisTile.getTileDownRight().getPiece().getColor() == thisTile.getPiece().getColor());
                        else if (thisTile.getTileDownRight().getPiece().getColor() != thisTile.getPiece().getColor())
                            addToPossibilties(possibilities, thisTile, thisTile.getTileDownRight());
                    }

                }
                if (thisTile.getTileDownLeft() != null) {
                    if (thisTile.getTileDownLeft().getPiece() != null) {
                        if (thisTile.getTileDownLeft().getPiece().getColor() == thisTile.getPiece().getColor());
                        else if (thisTile.getTileDownLeft().getPiece().getColor() != thisTile.getPiece().getColor())
                            addToPossibilties(possibilities, thisTile, thisTile.getTileDownLeft());
                    }
                }
        }
        else if (this.getPieceType() == PieceName.WHITE_KNIGHT || this.getPieceType() == PieceName.BLACK_KNIGHT) {
             Tile temp = thisTile.getTileUp(), next;
            if ((temp) != null) {
                if((temp= temp.getTileUp()) != null)
                    if ((next = temp.getTileUpRight()) != null)
                        addToPossibilties(possibilities, temp, next);
            }

             temp = thisTile.getTileUp();
            if ((temp) != null) {
                if((temp= temp.getTileUp()) != null)
                    if ((next = temp.getTileUpLeft()) != null) addToPossibilties(possibilities, temp, next);
            }

            temp = thisTile.getTileUpLeft();
            if ((temp) != null) {
                if((temp= temp.getTileUpLeft()) != null)
                    if ((next = temp.getTileUp()) != null) addToPossibilties(possibilities, temp, next);
            }

            temp = thisTile.getTileUpLeft();
            if ((temp) != null) {
                if((temp= temp.getTileUpLeft()) != null)
                    if ((next = temp.getTileDownLeft()) != null) addToPossibilties(possibilities, temp, next);
            }

            temp = thisTile.getTileUpRight();
            if ((temp) != null) {
                if((temp= temp.getTileUpRight()) != null)
                    if ((next = temp.getTileUp()) != null) addToPossibilties(possibilities, temp, next);
            }

            temp = thisTile.getTileUpRight();
            if ((temp) != null) {
                if((temp= temp.getTileUpRight()) != null)
                    if ((next = temp.getTileDownRight()) != null) addToPossibilties(possibilities, temp, next);
            }

            temp = thisTile.getTileDownRight();
            if ((temp) != null) {
                if((temp= temp.getTileDownRight()) != null)
                    if ((next = temp.getTileUpRight()) != null) addToPossibilties(possibilities, temp, next);
            }

            temp = thisTile.getTileDownRight();
            if ((temp) != null) {
                if((temp= temp.getTileDownRight()) != null)
                    if ((next = temp.getTileDown()) != null) addToPossibilties(possibilities, temp, next);
            }

            temp = thisTile.getTileDown();
            if ((temp) != null) {
                if((temp= temp.getTileDown()) != null)
                    if ((next = temp.getTileDownRight()) != null) addToPossibilties(possibilities, temp, next);
            }

            temp = thisTile.getTileDown();
            if ((temp) != null) {
                if((temp= temp.getTileDown()) != null)
                    if ((next = temp.getTileDownLeft()) != null) addToPossibilties(possibilities, temp, next);
            }

            temp = thisTile.getTileDownLeft();
            if ((temp) != null) {
                if((temp= temp.getTileDownLeft()) != null)
                    if ((next = temp.getTileUpLeft()) != null) addToPossibilties(possibilities, temp, next);
            }

            temp = thisTile.getTileDownLeft();
            if ((temp) != null) {
                if((temp= temp.getTileDownLeft()) != null)
                    if ((next = temp.getTileDown()) != null) addToPossibilties(possibilities, temp, next);
            }
        }
        else if (this.getPieceType() == PieceName.WHITE_BISHOP || this.getPieceType() == PieceName.BLACK_BISHOP) {
            Tile next = thisTile, temp;
            while (true) {
                temp = next.getTileUp();
                if ((temp) != null) {
                    if ((next = temp.getTileUpRight()) != null) {
                        if (next.getPiece() == null) {
                            possibilities.add(next);
                        } else {
                            if (thisTile.getPiece().getColor() == next.getPiece().getColor()) break;
                            if (thisTile.getPiece().getColor() != next.getPiece().getColor()) {
                                possibilities.add(next);
                                break;
                            }
                        }
                    } else break;
                } else break;
            }


            next = thisTile;
            while (true) {
                temp = next.getTileUp();
                if ((temp) != null) {
                    if ((next = temp.getTileUpLeft()) != null) {
                        if (next.getPiece() == null) {
                            possibilities.add(next);
                        } else {
                            if (thisTile.getPiece().getColor() == next.getPiece().getColor()) break;
                            if (thisTile.getPiece().getColor() != next.getPiece().getColor()) {
                                possibilities.add(next);
                                break;
                            }
                        }
                    } else break;
                } else break;
            }

            next = thisTile;
            while (true) {
                temp = next.getTileDownLeft();
                if ((temp) != null) {
                    if ((next = temp.getTileDown()) != null) {
                        if (next.getPiece() == null) {
                            possibilities.add(next);
                        } else {
                            if (thisTile.getPiece().getColor() == next.getPiece().getColor()) break;
                            if (thisTile.getPiece().getColor() != next.getPiece().getColor()) {
                                possibilities.add(next);
                                break;
                            }
                        }
                    } else break;
                } else break;
            }

            next = thisTile;
            while (true) {
                temp = next.getTileDownLeft();
                if ((temp) != null) {
                    if ((next = temp.getTileUpLeft()) != null) {
                        if (next.getPiece() == null) {
                            possibilities.add(next);
                        } else {
                            if (thisTile.getPiece().getColor() == next.getPiece().getColor()) break;
                            if (thisTile.getPiece().getColor() != next.getPiece().getColor()) {
                                possibilities.add(next);
                                break;
                            }
                        }
                    } else break;
                } else break;
            }

            next = thisTile;
            while (true) {
                temp = next.getTileDownRight();
                if ((temp) != null) {
                    if ((next = temp.getTileUpRight()) != null) {
                        if (next.getPiece() == null) {
                            possibilities.add(next);
                        } else {
                            if (thisTile.getPiece().getColor() == next.getPiece().getColor()) break;
                            if (thisTile.getPiece().getColor() != next.getPiece().getColor()) {
                                possibilities.add(next);
                                break;
                            }
                        }
                    } else break;
                } else break;
            }


            next = thisTile;
            while (true) {
                temp = next.getTileDownRight();
                if ((temp) != null) {
                    if ((next = temp.getTileDown()) != null) {
                        if (next.getPiece() == null) {
                            possibilities.add(next);
                        } else {
                            if (thisTile.getPiece().getColor() == next.getPiece().getColor()) break;
                            if (thisTile.getPiece().getColor() != next.getPiece().getColor()) {
                                possibilities.add(next);
                                break;
                            }
                        }
                    } else break;
                } else break;
            }

        }
        else if (this.getPieceType() == PieceName.WHITE_QUEEN || this.getPieceType() == PieceName.BLACK_QUEEN) {
//            bishop move
            Tile next = thisTile, temp;
            while (true) {
                temp = next.getTileUp();
                if ((temp) != null) {
                    if ((next = temp.getTileUpRight()) != null) {
                        if (next.getPiece() == null) {
                            possibilities.add(next);
                        } else {
                            if (thisTile.getPiece().getColor() == next.getPiece().getColor()) break;
                            if (thisTile.getPiece().getColor() != next.getPiece().getColor()) {
                                possibilities.add(next);
                                break;
                            }
                        }
                    } else break;
                } else break;

            }

            next = thisTile;
            while (true) {
                temp = next.getTileUp();
                if ((temp) != null) {
                    if ((next = temp.getTileUpLeft()) != null) {
                        if (next.getPiece() == null) {
                            possibilities.add(next);
                        } else {
                            if (thisTile.getPiece().getColor() == next.getPiece().getColor()) break;
                            if (thisTile.getPiece().getColor() != next.getPiece().getColor()) {
                                possibilities.add(next);
                                break;
                            }
                        }
                    } else break;
                } else break;

            }

            next = thisTile;
            while (true) {
                temp = next.getTileDownLeft();
                if ((temp) != null) {
                    if ((next = temp.getTileDown()) != null) {
                        if (next.getPiece() == null) {
                            possibilities.add(next);
                        } else {
                            if (thisTile.getPiece().getColor() == next.getPiece().getColor()) break;
                            if (thisTile.getPiece().getColor() != next.getPiece().getColor()) {
                                possibilities.add(next);
                                break;
                            }
                        }
                    } else break;
                } else break;

            }

            next = thisTile;
            while (true) {
                temp = next.getTileDownLeft();
                if ((temp) != null) {
                    if ((next = temp.getTileUpLeft()) != null) {
                        if (next.getPiece() == null) {
                            possibilities.add(next);
                        } else {
                            if (thisTile.getPiece().getColor() == next.getPiece().getColor()) break;
                            if (thisTile.getPiece().getColor() != next.getPiece().getColor()) {
                                possibilities.add(next);
                                break;
                            }
                        }
                    } else break;
                } else break;

            }

            next = thisTile;
            while (true) {
                temp = next.getTileDownRight();
                if ((temp) != null) {
                    if ((next = temp.getTileUpRight()) != null) {
                        if (next.getPiece() == null) {
                            possibilities.add(next);
                        } else {
                            if (thisTile.getPiece().getColor() == next.getPiece().getColor()) break;
                            if (thisTile.getPiece().getColor() != next.getPiece().getColor()) {
                                possibilities.add(next);
                                break;
                            }
                        }
                    } else break;
                } else break;

            }

            next = thisTile;
            while (true) {
                temp = next.getTileDownRight();
                if ((temp) != null) {
                    if ((next = temp.getTileDown()) != null) {
                        if (next.getPiece() == null) {
                            possibilities.add(next);
                        } else {
                            if (thisTile.getPiece().getColor() == next.getPiece().getColor()) break;
                            if (thisTile.getPiece().getColor() != next.getPiece().getColor()) {
                                possibilities.add(next);
                                break;
                            }
                        }
                    } else break;
                } else break;

            }


//          Rook move
             next = thisTile;
            while ((next = next.getTileUp()) != null) {
                if (next.getPiece() == null) {
                    possibilities.add(next);
                } else {
                    if (thisTile.getPiece().getColor() == next.getPiece().getColor()) break;
                    if (thisTile.getPiece().getColor() != next.getPiece().getColor()) {
                        possibilities.add(next);
                        break;
                    }
                }
            }
            next = thisTile;
            while ((next = next.getTileDown()) != null) {
                if (next.getPiece() == null) {
                    possibilities.add(next);
                } else {
                    if (thisTile.getPiece().getColor() == next.getPiece().getColor()) break;
                    if (thisTile.getPiece().getColor() != next.getPiece().getColor()) {
                        possibilities.add(next);
                        break;
                    }
                }
            }

            next = thisTile;
            while ((next = next.getTileDownLeft()) != null) {
                if (next.getPiece() == null) {
                    possibilities.add(next);
                } else {
                    if (thisTile.getPiece().getColor() == next.getPiece().getColor()) break;
                    if (thisTile.getPiece().getColor() != next.getPiece().getColor()) {
                        possibilities.add(next);
                        break;
                    }
                }
            }

            next = thisTile;
            while ((next = next.getTileDownRight()) != null) {
                if (next.getPiece() == null) {
                    possibilities.add(next);
                } else {
                    if (thisTile.getPiece().getColor() == next.getPiece().getColor()) break;
                    if (thisTile.getPiece().getColor() != next.getPiece().getColor()) {
                        possibilities.add(next);
                        break;
                    }
                }
            }

            next = thisTile;
            while ((next = next.getTileUpRight()) != null) {
                if (next.getPiece() == null) {
                    possibilities.add(next);
                } else {
                    if (thisTile.getPiece().getColor() == next.getPiece().getColor()) break;
                    if (thisTile.getPiece().getColor() != next.getPiece().getColor()) {
                        possibilities.add(next);
                        break;
                    }
                }
            }

            next = thisTile;
            while ((next = next.getTileUpLeft()) != null) {
                if (next.getPiece() == null) {
                    possibilities.add(next);
                } else {
                    if (thisTile.getPiece().getColor() == next.getPiece().getColor()) break;
                    if (thisTile.getPiece().getColor() != next.getPiece().getColor()) {
                        possibilities.add(next);
                        break;
                    }
                }
            }
        }
        else if (this.getPieceType() == PieceName.WHITE_KING || this.getPieceType() == PieceName.BLACK_KING) {
            Tile next;
            Tile temp;
            if ((next = thisTile.getTileUp()) != null) addToPossibilties(possibilities, thisTile, next);
            if ((next = thisTile.getTileDown()) != null) addToPossibilties(possibilities, thisTile, next);
            if ((next = thisTile.getTileUpRight()) != null) addToPossibilties(possibilities, thisTile, next);
            if ((next = thisTile.getTileUpLeft()) != null) addToPossibilties(possibilities, thisTile, next);
            if ((next = thisTile.getTileDownRight()) != null) addToPossibilties(possibilities, thisTile, next);
            if ((next = thisTile.getTileDownLeft()) != null) addToPossibilties(possibilities, thisTile, next);

            temp = thisTile.getTileUp();
            if ((temp) != null) {
                if ((next = temp.getTileUpRight()) != null) addToPossibilties(possibilities, thisTile, next);
            }
            if ((temp) != null) {
                if ((next = temp.getTileUpLeft()) != null) addToPossibilties(possibilities, thisTile, next);
            }

            temp = thisTile.getTileDownRight();
            if ((temp) != null) {
                if ((next = temp.getTileDown()) != null) addToPossibilties(possibilities, thisTile, next);
            }
            if ((temp) != null) {
                if ((next = temp.getTileUpRight()) != null) addToPossibilties(possibilities, thisTile, next);
            }

            temp = thisTile.getTileDownLeft();
            if ((temp) != null) {
                if ((next = temp.getTileDown()) != null)
                    addToPossibilties(possibilities, thisTile, next);
            }
            if ((temp) != null) {
                if ((next = temp.getTileUpLeft()) != null)
                    addToPossibilties(possibilities, thisTile, next);
            }


        }
        return possibilities;
    }

    private static void addToPossibilties(ArrayList<Tile> possibilities, Tile thisTile, Tile next) {
        if (next.getPiece() == null) {
            possibilities.add(next);
        } else {
            if(thisTile.getPiece().getColor() == next.getPiece().getColor());
            else if (thisTile.getPiece().getColor() != next.getPiece().getColor()) {
                possibilities.add(next);
            }
        }
    }
    private static void addToPossibiltiesPawn(ArrayList<Tile> possibilities, Tile thisTile, Tile next) {
        if (next.getPiece() == null) {
            possibilities.add(next);
        }
    }

    public String getPieceType() {
        if (color == Color.BLACK) {
            if (this instanceof Bishop)
                return PieceName.BLACK_BISHOP;
            else if (this instanceof King)
                return PieceName.BLACK_KING;
            else if (this instanceof Queen)
                return PieceName.BLACK_QUEEN;
            else if (this instanceof Pawn)
                return PieceName.BLACK_PAWN;
            else if (this instanceof Knight)
                return PieceName.BLACK_KNIGHT;
            else if (this instanceof Rook)
                return PieceName.BLACK_ROOK;

            return null;
        } else { // While
            if (this instanceof Bishop)
                return PieceName.WHITE_BISHOP;
            else if (this instanceof King)
                return PieceName.WHITE_KING;
            else if (this instanceof Queen)
                return PieceName.WHITE_QUEEN;
            else if (this instanceof Pawn)
                return PieceName.WHITE_PAWN;
            else if (this instanceof Knight)
                return PieceName.WHITE_KNIGHT;
            else if (this instanceof Rook)
                return PieceName.WHITE_ROOK;

            return null;
        }

    }
}
