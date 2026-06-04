import javax.swing.*;
import java.awt.*;

public class Connect4Board {
    private JFrame mainWindow;

    public Connect4Board() {
        mainWindow = new JFrame("Connect4Board");
        mainWindow.setSize(1300, 1050);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setResizable(false);

        
        JPanel boardPanel = new JPanel(new GridBagLayout()); 
        boardPanel.setBackground(Color.WHITE);

      
        ImageIcon boardImg = new ImageIcon("Board.png"); 
        
        JLabel boardPlacement = new JLabel(boardImg, SwingConstants.CENTER);
        boardPlacement.setHorizontalAlignment(SwingConstants.CENTER);
        boardPlacement.setVerticalAlignment(SwingConstants.CENTER);

        mainWindow.setLayout(new BorderLayout());
        boardPanel.add(boardPlacement);
        mainWindow.add(boardPanel, BorderLayout.CENTER);
        
        
        mainWindow.setSize(1300, 1050);
        mainWindow.setVisible(true);
    }


    public static void main(String[] args) {
        new Connect4Board();
    }
}
