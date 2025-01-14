package ir.sharif.math.bp02_1.hex_chess.graphics.panel;

import ir.sharif.math.bp02_1.hex_chess.graphics.models.StringColor;
import ir.sharif.math.bp02_1.hex_chess.graphics.util.Config;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class RemovedPiecesPanel extends JPanel {
    private ArrayList<StringColor> pieces = new ArrayList<>();
    final int size = Config.CELL_SIZE * 2;
    final int countPerRow = 4;

    public RemovedPiecesPanel() {
        setLayout(null);
        setBackground(Color.decode("#31591d"));
        setPreferredSize(new Dimension(size * countPerRow, 0));
    }

    public void setPieces(ArrayList pieces) {
        this.pieces = pieces;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g.setFont(Config.PIECE_FONT);
        FontMetrics fm = g.getFontMetrics();
        ArrayList<StringColor> paintPieces = pieces;
        for (int i = 0; i < paintPieces.size(); i++) {
            StringColor p = paintPieces.get(i);
            g.setColor(p.getColor());
            int x = size * (i % countPerRow) + (size - fm.stringWidth(p.getText())) / 2;
            int y = size * (1 + i / countPerRow) + (size - fm.getHeight()) / 2;
            g2.setColor(p.getColor());
            g2.drawString(p.getText(), x, y);
        }
    }
}
