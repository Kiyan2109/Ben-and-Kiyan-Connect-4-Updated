//Importing the necessary classes
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.GridBagLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
  int getHeight = 0;
  int getWidth = 0;
  int BackgroundSize = 0;
  GridBagConstraints gbc;
  JButton resetButton; 
  ImageIcon goBackImg; 
  JLabel chipPlacement;


  // The classes main constructor method
  public Connect4() {
    mainWindow = new JFrame("Connect4");
    mainWindow.setSize(1300, 1050);
    mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainWindow.setResizable(false);
    mainWindow.setVisible(true);

    gbc = new GridBagConstraints(); 
  gbc.weightx = 1;
  gbc.weighty = 1;
    gbc.fill = GridBagConstraints.VERTICAL; 
    gbc.gridheight = 3; 
    //this line doesnt do anything for some reasion
    gbc.gridwidth = 1;
    
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
  public JButton boardButtons(int xPosition) {
    //this line isnt doing anything
    gbc.gridx = xPosition; 
JButton columnButton = new JButton();
//columnButton.setContentAreaFilled(false); 
//columnButton.setBorderPainted(false);
columnButton.setVisible(true);   

    ImageIcon yellowPiece = new ImageIcon("YellowPiece-Photoroom.png");      
  

columnButton.addActionListener(new ActionListener() {
  @Override 
  public void actionPerformed(ActionEvent evt) {
    
      ImageIcon redPiece = new ImageIcon("RedPiece-Photoroom.png");
      System.out.println(redPiece.getIconWidth());

      boardPlacement.setLayout(null);


      JLabel redPiecePlacement = new JLabel(redPiece);
      

      //Doesn't show up yet, waiting for array values to equate the two. 
      boardPlacement.add(redPiecePlacement);
      boardPlacement.revalidate();
      boardPlacement.repaint();


      
      


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

    
    boardPanel = new JPanel();
    boardPanel.setLayout(null);
    boardPanel.setBackground(Color.WHITE);

        
        ImageIcon boardImg = new ImageIcon("board.png");
        

        boardPlacement = new JLabel(boardImg, SwingConstants.CENTER);
        boardPlacement.setHorizontalAlignment(SwingConstants.CENTER);
        boardPlacement.setVerticalAlignment(SwingConstants.CENTER);
        boardPlacement.setBounds((1300 - boardImg.getIconWidth()) / 2, (1000 - boardImg.getIconHeight()) /2, boardImg.getIconWidth(), boardImg.getIconHeight());
        boardPanel.add(boardPlacement);
        _1v1gamePanel.add(boardPanel, BorderLayout.CENTER);
        _1v1gamePanel.add(instructionLabel, BorderLayout.PAGE_START);

        //_1v1columnButton1 = boardButtons(1);
        //boardPanel.add(_1v1columnButton1, gbc);
       //_1v1columnButton2 = boardButtons(2);
              //boardPanel.add(_1v1columnButton2, gbc);
       //_1v1columnButton3 = boardButtons(3);
       //boardPanel.add(_1v1columnButton3, gbc);
       //_1v1columnButton4 = boardButtons(4);
        //boardPanel.add(_1v1columnButton4, gbc);
       //_1v1columnButton5 = boardButtons(5);
       //boardPanel.add(_1v1columnButton5, gbc);
       //_1v1columnButton6 = boardButtons(6);
       //boardPanel.add(_1v1columnButton6, gbc);
       //_1v1columnButton7 = boardButtons(2);
       //boardPanel.add(_1v1columnButton7, gbc);


      for (int i = 0; i < 7; i++) {

      JButton boardButtons = new JButton("67");

      boardButtons.setBounds(175 + (i * 135), 195, 135, 610);
  

      boardButtons.setOpaque(false);
      boardButtons.setContentAreaFilled(false);
      boardButtons.setBorderPainted(false);
      
      

      boardButtons.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Button clicked!");
           ImageIcon redPiece = new ImageIcon("RedPiece-Photoroom.png");
           chipPlacement = new JLabel(redPiece, SwingConstants.CENTER);
           _1v1gamePanel.add(chipPlacement);

           _1v1gamePanel.revalidate(); 
          _1v1gamePanel.repaint();

        }
      });

      boardPanel.add(boardButtons);
}
       
       
      




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
        
        ImageIcon boardImg = new ImageIcon("board.png");
        

        boardPlacement = new JLabel(boardImg, SwingConstants.CENTER);
        boardPlacement.setHorizontalAlignment(SwingConstants.CENTER);
        boardPlacement.setVerticalAlignment(SwingConstants.CENTER);
        boardPlacement.setBounds((1300 - boardImg.getIconWidth()) / 2, (1000 - boardImg.getIconHeight()) /2, boardImg.getIconWidth(), boardImg.getIconHeight());
        boardPanel.add(boardPlacement);
        _1v1gamePanel.add(boardPanel, BorderLayout.CENTER);
        _1v1gamePanel.add(instructionLabel, BorderLayout.PAGE_START);

        //_1v1columnButton1 = boardButtons(1);
        //boardPanel.add(_1v1columnButton1, gbc);
       //_1v1columnButton2 = boardButtons(2);
              //boardPanel.add(_1v1columnButton2, gbc);
       //_1v1columnButton3 = boardButtons(3);
       //boardPanel.add(_1v1columnButton3, gbc);
       //_1v1columnButton4 = boardButtons(4);
        //boardPanel.add(_1v1columnButton4, gbc);
       //_1v1columnButton5 = boardButtons(5);
       //boardPanel.add(_1v1columnButton5, gbc);
       //_1v1columnButton6 = boardButtons(6);
       //boardPanel.add(_1v1columnButton6, gbc);
       //_1v1columnButton7 = boardButtons(2);
       //boardPanel.add(_1v1columnButton7, gbc);


      for (int i = 0; i < 7; i++) {

      JButton boardButtons = new JButton("67");

      boardButtons.setBounds(175 + (i * 135), 195, 135, 610);
  

      boardButtons.setOpaque(false);
      boardButtons.setContentAreaFilled(false);
      boardButtons.setBorderPainted(false);
      
      

      boardButtons.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Button clicked!");
        }
      });

      boardPanel.add(boardButtons);
    }
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
    

//I wonder if this works. 
//Entering this to commit.