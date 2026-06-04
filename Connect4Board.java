import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Connect4Board {
    JFrame mainWindow;

    public Connect4Board() {
        mainWindow = new JFrame("Connect4Board");
        mainWindow.setSize(1300, 1050);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setResizable(false);

        JPanel boardPanel = new JPanel();
        boardPanel.setBackground(Color.WHITE);

        mainWindow.add(boardPanel);

        mainWindow.setVisible(true);
    

    ImageIcon boardImg = new ImageIcon("Board.png"); 
    JLabel boardLabel = new JLabel(boardImg);
    
   
    
    boardPanel.add(boardLabel);
    mainWindow.add(boardPanel);
    mainWindow.setVisible(true);
}

    public static void main(String[] args) {
        new Connect4Board();
    }
}
