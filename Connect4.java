//Importing the necessary classes
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Connect4 {
  JFrame mainWindow;
  JPanel introPanel;
  JLabel welcomeLabel;
  JLabel modeSelect; 
  JButton multiPlayerButton;
  JButton singlePlayerButton;
  JPanel buttonPanel;
  JComponent _1v1gamePanel; 
  JComponent _1vAIgamePanel;
  JLabel horizontalSpacer; 
  JLabel verticalSpacer; 
  ImageIcon connect4Logo;
  JLabel logoLabel; 
  JLabel nameLabel; 
  JPanel namePanel; 
  JPanel boardPanel; 
  ImageIcon boardImg;
  JLabel boardPlacement;
  JLabel instructionLabel;
  JButton _1v1columnButton1;
  JButton _1v1columnButton2; 
  JButton _1v1columnButton3; 
  JButton _1v1columnButton4; 
  JButton _1v1columnButton5; 
  JButton _1v1columnButton6; 
  JButton _1v1columnButton7;  

  //Make the constraints for a gridbaglayout to apply to all the connect 4 boards

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

  setUp1vAIGamePanel();
      mainWindow.add(_1v1gamePanel, BorderLayout.CENTER);

      setUp1v1GamePanel();
      mainWindow.add(_1v1gamePanel, BorderLayout.CENTER);
    

  }
//Change the parameters to be a gridbaglayout
  public JButton boardButtons(int xPosition, int yPosition) {
JButton columnButton = new JButton();
//columnButton.setContentAreaFilled(false); 
//columnButton.setBorderPainted(false);
columnButton.setVisible(true);   
columnButton.setBounds(xPosition, yPosition, 100, 600); 

  

columnButton.addActionListener(new ActionListener() {
  @Override 
  public void actionPerformed(ActionEvent evt) {
//When pressed, a piece will drop in the corresponding column. 
  }
  });

return columnButton;
}

public void setUp1v1GamePanel() {
instructionLabel = new JLabel("Click on a column to drop a piece. First to connect 4 wins!");
    instructionLabel.setHorizontalAlignment(JLabel.CENTER);
  instructionLabel.setFont(new Font("Sans_Serif", Font.BOLD, 24));
    _1v1gamePanel = new JPanel(new BorderLayout());
    _1v1gamePanel.setSize(1300, 1050);
    _1v1gamePanel.setVisible(false);

    boardPanel = new JPanel(new GridBagLayout()); 
        boardPanel.setBackground(Color.WHITE);

        
        ImageIcon boardImg = new ImageIcon("board.png");
        
        boardPlacement = new JLabel(boardImg, SwingConstants.CENTER);
        boardPlacement.setHorizontalAlignment(SwingConstants.CENTER);
        boardPlacement.setVerticalAlignment(SwingConstants.CENTER);
        boardPanel.add(boardPlacement);
        _1v1gamePanel.add(boardPanel, BorderLayout.CENTER);
        _1v1gamePanel.add(instructionLabel, BorderLayout.PAGE_START);

        _1v1columnButton1 = boardButtons(100, 100);
       _1v1columnButton2 = boardButtons(200, 100);
       _1v1columnButton3 = boardButtons(300, 100);
       _1v1columnButton4 = boardButtons(400, 100);
       _1v1columnButton5 = boardButtons(500, 100);
       _1v1columnButton6 = boardButtons(600, 100);
       _1v1columnButton7 = boardButtons(700, 100);

       //Add to the right gridbaglayout position
       boardPanel.add(_1v1columnButton1);
       boardPanel.add(_1v1columnButton2);
       boardPanel.add(_1v1columnButton3);
       boardPanel.add(_1v1columnButton4);
       boardPanel.add(_1v1columnButton5);
       boardPanel.add(_1v1columnButton6);
       boardPanel.add(_1v1columnButton7);


  }

  public void setUp1vAIGamePanel() {
    instructionLabel = new JLabel("Click on a column to drop a piece. First to connect 4 wins!");
    instructionLabel.setHorizontalAlignment(JLabel.CENTER);
    instructionLabel.setFont(new Font("Sans_Serif", Font.BOLD, 24)); 
    _1v1gamePanel = new JPanel(new BorderLayout());
    _1v1gamePanel.setSize(1300, 1050);
    _1v1gamePanel.setVisible(false);
    boardPanel = new JPanel(new GridBagLayout()); 
        boardPanel.setBackground(Color.WHITE);

      
        boardImg = new ImageIcon("board.png"); 
        
        boardPlacement = new JLabel(boardImg, SwingConstants.CENTER);
        boardPlacement.setHorizontalAlignment(SwingConstants.CENTER);
        boardPlacement.setVerticalAlignment(SwingConstants.CENTER);
        boardPanel.add(boardPlacement);
        _1v1gamePanel.add(boardPanel, BorderLayout.CENTER);
        _1v1gamePanel.add(instructionLabel, BorderLayout.PAGE_START);
        

  }
  
  // Setting up the intro panel
  public void setUpIntroPanel() {
    introPanel = new JPanel(new BorderLayout());
    introPanel.setPreferredSize(new Dimension(1300, 500));
    introPanel.setOpaque(true);
    introPanel.setVisible(true);

    welcomeLabel = new JLabel("Welcome To");
    welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
    welcomeLabel.setFont(new Font("ITC Avant Garde Gothic Bold", Font.BOLD, 45));
    introPanel.add(welcomeLabel, BorderLayout.PAGE_START);

    modeSelect = new JLabel("Select a game mode:");
    modeSelect.setHorizontalAlignment(JLabel.CENTER);
    modeSelect.setFont(new Font("ITC Avant Garde Gothic Bold", Font.BOLD, 30));
    introPanel.add(modeSelect, BorderLayout.PAGE_END);

    connect4Logo = new ImageIcon("Connect4Logo.png");
    logoLabel = new JLabel(connect4Logo); 
    introPanel.add(logoLabel, BorderLayout.CENTER);

  }


  public void setUpButtonPanel() {
    buttonPanel = new JPanel(new FlowLayout());
    buttonPanel.setPreferredSize(new Dimension(1300, 420));
    buttonPanel.setOpaque(true);
    buttonPanel.setVisible(true);

    multiPlayerButton = new JButton("1 v 1");
    multiPlayerButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    multiPlayerButton.setPreferredSize(new Dimension(400, 180));
    multiPlayerButton.setVisible(true);
    multiPlayerButton.setFont(new Font("Sans_Serif", Font.BOLD, 20));
    multiPlayerButton.setOpaque(true);


    singlePlayerButton = new JButton("1 v AI");
    singlePlayerButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    singlePlayerButton.setPreferredSize(new Dimension(400, 180));
    singlePlayerButton.setVisible(true);
    singlePlayerButton.setFont(new Font("Sans_Serif", Font.BOLD, 20));
    singlePlayerButton.setOpaque(true);
    singlePlayerButton.setVisible(true);

    Color backgroundColor = buttonPanel.getBackground();

    horizontalSpacer = new JLabel();
    horizontalSpacer.setPreferredSize(new Dimension(250, 200));
    horizontalSpacer.setBackground(backgroundColor);
    horizontalSpacer.setOpaque(true);
    horizontalSpacer.setVisible(true);

    verticalSpacer = new JLabel(); 
    verticalSpacer.setPreferredSize(new Dimension(920, 320)); 
    verticalSpacer.setBackground(backgroundColor);
    verticalSpacer.setOpaque(true);
    verticalSpacer.setVisible(true);

  
    nameLabel = new JLabel("By: Ben Elizur and Kiyan Sadr-Hayes");
    

    

    //Action Listener so when the single player button is clicked, the corresponding board will open
    singlePlayerButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent evt) {
       introPanel.setVisible(false);
          buttonPanel.setVisible(false);
          _1v1gamePanel.setVisible(true);
          
      }
    });

    multiPlayerButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent evt) {
       introPanel.setVisible(false);
          buttonPanel.setVisible(false);
          _1v1gamePanel.setVisible(true);

      }
    });


    buttonPanel.add(multiPlayerButton);
    buttonPanel.add(horizontalSpacer);
    buttonPanel.add(singlePlayerButton);
    buttonPanel.add(verticalSpacer);
    buttonPanel.add(nameLabel); 


  }


  
  

 

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
    

