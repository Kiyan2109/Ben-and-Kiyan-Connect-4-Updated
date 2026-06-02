//Importing the necessary classes
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Connect4 {
  JFrame mainWindow;
  JPanel introPanel;
  JLabel welcomeLabel;
  JButton multiPlayerButton;
  JButton singlePlayerButton;
  JPanel buttonPanel;

  // The classes main constructor method
  public Connect4() {
    mainWindow = new JFrame("Connect4");
    mainWindow.setSize(1300, 1050);
    mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainWindow.setResizable(false);
    mainWindow.setVisible(true);

    setUpIntroPanel();
    mainWindow.add(introPanel, BorderLayout.PAGE_START);

    setUpButtonPanel();
      mainWindow.add(buttonPanel, BorderLayout.PAGE_END);
  }
public void setUp1v1GamePanel() {
    JComponent _1v1gamePanel = new JPanel(new BorderLayout());
    _1v1gamePanel.setSize(1300, 1050);
    _1v1gamePanel.setBackground(Color.WHITE);
    
    _1v1gamePanel.setVisible(true);

  }

  public void setUp1vAIGamePanel() {
    JComponent _1vAIGamePanel = new JPanel(new BorderLayout());
    _1vAIGamePanel.setSize(1300, 1050);
    _1vAIGamePanel.setBackground(Color.WHITE);
    
    _1vAIGamePanel.setVisible(true);

  }
  // Setting up the intro panel
  public void setUpIntroPanel() {
    introPanel = new JPanel(new BorderLayout());
    introPanel.setPreferredSize(new Dimension(1300, 250));
    introPanel.setBackground(Color.BLUE);
    introPanel.setOpaque(true);
    introPanel.setVisible(true);

    welcomeLabel = new JLabel("CONNECT 4");
    welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
    welcomeLabel.setFont(new Font("ITC Avant Garde Gothic Bold", Font.BOLD, 45));
    introPanel.add(welcomeLabel, BorderLayout.PAGE_START);

  }


  public void setUpButtonPanel() {
    buttonPanel = new JPanel(new BorderLayout());
    buttonPanel.setPreferredSize(new Dimension(1300, 500));
    buttonPanel.setBackground(Color.GREEN);
    buttonPanel.setOpaque(true);
    buttonPanel.setVisible(true);

    multiPlayerButton = new JButton("1 v 1");
    multiPlayerButton.setBounds(200, 200, 200, 200);
    multiPlayerButton.setVisible(true);
    multiPlayerButton.setFont(new Font("Sans_Serif", Font.BOLD, 20));
    multiPlayerButton.setBackground(Color.RED);
    multiPlayerButton.setOpaque(true);
    multiPlayerButton.setVisible(true);


    singlePlayerButton = new JButton("1 v AI");
    singlePlayerButton.setBounds(500, 500, 200, 200);
    singlePlayerButton.setVisible(true);
    singlePlayerButton.setFont(new Font("Sans_Serif", Font.BOLD, 20));
    singlePlayerButton.setBackground(Color.BLUE);
    singlePlayerButton.setOpaque(true);
    singlePlayerButton.setVisible(true);

    //Action Listener so when the single player button is clicked, the corresponding board will open
    singlePlayerButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent evt) {
       introPanel.setVisible(false);
          buttonPanel.setVisible(false);
          setUp1v1GamePanel();
        System.out.println("Single Player Button Clicked");
      }
    });

    multiPlayerButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent evt) {
       introPanel.setVisible(false);
          buttonPanel.setVisible(false);
          setUp1vAIGamePanel();
      }
    });


    buttonPanel.add(multiPlayerButton, BorderLayout.WEST);
    buttonPanel.add(singlePlayerButton, BorderLayout.EAST);

  }


  //Panel that is created after starting the 1v1 game mode. poop 
 

  // Connect 4 Game Board Creation
  char [][] board = new char[6][7];

  private void initializeBoard() {
    for (int row = 0; row < 6; row++) {
      for (int col = 0; col < 7; col++) {
        board[row][col] = ' ';
      }
    }
  }

  //Print the board using a 2d array that checks if it has reached the end of the row and column and prints the appropriate character. 
  public static void printBoard(char[][] board) {
    for (int row = 0; row < 6; row++) {
      for (int col = 0; col < 7; col++) {
        System.out.print(board[row][col] + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    new Connect4();
  }

}
    

