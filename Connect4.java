
//Importing the necessary classes
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.GridBagLayout;
import java.awt.CardLayout;
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
import javax.swing.Timer;

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
  JPanel aigamePanel;
  ImageIcon boardImg;
  JLabel _1v1boardPlacement;
  JLabel _AIboardPlacement;
  JLabel instructionLabel; 
  JPanel gameContainer;
  int getHeight = 0;
  int getWidth = 0;
  int BackgroundSize = 0;
  JButton _1v1resetButton; 
  JButton _AIresetButton;
  JButton _1v1homeButton;
  JButton _AIhomeButton;
  ImageIcon homeImg; 
  ImageIcon goBackImg; 
  JLabel chipPlacement;
  ImageIcon yellowPiece; 
  ImageIcon redPiece; 
  int [][] board = new int [6][7]; 
  boolean redTurn = true; 
    int row = 6;
    int column = 7; 
    int r = 0;
    int c = 0;
   final int redPieceNum = 1; 
    final int yellowPieceNum = 2; 
    final int emptyPieceNum = 0;
    int[][] winningCells = new int[4][2];
    JLabel[][] chipLabels = new JLabel[6][7];
    boolean gameOver = false;


    






  // The classes main constructor method
  public Connect4() {
    for (int i = 0; i < board.length; i++) {
    for (int j = 0; j < board[i].length; j++) {
        board[i][j] = emptyPieceNum;
    }
}
   mainWindow = new JFrame("Connect4");
mainWindow.setSize(1300, 1050);
mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
mainWindow.setResizable(false);

setUpIntroPanel();
mainWindow.add(introPanel, BorderLayout.PAGE_START);

setUp1v1GamePanel();
setUp1vAIGamePanel();

gameContainer = new JPanel(new CardLayout());

gameContainer.add(_1v1gamePanel, "1V1");
gameContainer.add(_1vAIgamePanel, "AI");

gameContainer.setVisible(false);

mainWindow.add(gameContainer, BorderLayout.CENTER);

setUpButtonPanel();
mainWindow.add(buttonPanel, BorderLayout.PAGE_END);

mainWindow.setVisible(true);
  }

public void setUpBoardButtons() {      
  for (int i = 0; i < 7; i++) {

       final int column = i;   
      JButton boardButtons = new JButton("");

      boardButtons.setBounds(175 + (i * 135), 195, 135, 610);
  

      boardButtons.setOpaque(false);
      boardButtons.setContentAreaFilled(false); 
      boardButtons.setBorderPainted(false);


  

      

      boardPanel.add(boardButtons);

       boardButtons.addActionListener(new ActionListener() {   
        @Override
        public void actionPerformed(ActionEvent e) {

             if (gameOver) {
            System.out.println("Game is over. No more moves allowed.");
            return;
        }





          for (int r = 5; r >= 0; r--) {
       if (board[r][column] == 0) {
       row = r;
        break;
    }
} 
        
if (redTurn == true) { 
            System.out.println("Red Button clicked!");
           redPiece = new ImageIcon("RedPiece-Photoroom.png");
           chipPlacement = new JLabel(redPiece, SwingConstants.CENTER);
           chipPlacement.setBounds(175 + (column * 135), 197 + (row * 99), 135, 100);
          chipLabels[row][column] = chipPlacement;
          board[row][column] = redPieceNum;  
           boardPanel.add(chipPlacement);
            
           
          if (checkForWin(redPieceNum)) {
          System.out.println("Red wins!");
          winningPieceFlourish();
          gameOver = true;
          
          }
        
          redTurn = false;

          boardPanel.repaint();
            for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println(); 
        }

            }
        else {

            System.out.println("Yellow Button clicked!");
           yellowPiece = new ImageIcon("YellowPiece-Photoroom.png");
           chipPlacement = new JLabel(yellowPiece, SwingConstants.CENTER);
           chipPlacement.setBounds(175 + (column * 135), 197 + (row * 99), 135, 100);
           chipLabels[row][column] = chipPlacement;

           board[row][column] = yellowPieceNum; 
           boardPanel.add(chipPlacement);

           if (checkForWin(yellowPieceNum)) {
            System.out.println("Yellow wins!");
            winningPieceFlourish();
            gameOver = true;
            
            
           }

           redTurn = true; 

          boardPanel.repaint();
            for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println(); 
        }

            }
      }
    });
    }
  }


public void setUp1v1GamePanel() {
instructionLabel = new JLabel("Click on a column to drop a piece. Turns will alternate between red and yellow. First to connect 4 wins!");
    instructionLabel.setHorizontalAlignment(JLabel.CENTER);
  instructionLabel.setFont(new Font("Sans_Serif", Font.BOLD, 24));
    _1v1gamePanel = new JPanel(new BorderLayout());
    _1v1gamePanel.setSize(1300, 1050);
    

    
    boardPanel = new JPanel();
    boardPanel.setLayout(null);
    boardPanel.setBackground(Color.WHITE);
Color backgroundColor = boardPanel.getBackground();
  instructionLabel.setBackground(backgroundColor);
        
        boardImg = new ImageIcon("board.png");
        
        goBackImg = new ImageIcon("GoBack (1).png");
_1v1resetButton = new JButton(goBackImg);
_1v1resetButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    _1v1resetButton.setVisible(true);
    _1v1resetButton.setOpaque(true);
    _1v1resetButton.setBounds(1150, 5, 100, 100);

homeImg = new ImageIcon("homeIcon (1).png");
_1v1homeButton = new JButton(homeImg);
_1v1homeButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    _1v1homeButton.setVisible(true);
    _1v1homeButton.setOpaque(true);
    _1v1homeButton.setBounds(1050, 5, 100, 100);

        _1v1boardPlacement = new JLabel(boardImg, SwingConstants.CENTER);
        _1v1boardPlacement.setHorizontalAlignment(SwingConstants.CENTER);
        _1v1boardPlacement.setVerticalAlignment(SwingConstants.CENTER);
        _1v1boardPlacement.setBounds((1300 - boardImg.getIconWidth()) / 2, (1000 - boardImg.getIconHeight()) /2, boardImg.getIconWidth(), boardImg.getIconHeight());
        boardPanel.add(_1v1boardPlacement);
        _1v1gamePanel.add(boardPanel, BorderLayout.CENTER);
        _1v1gamePanel.add(instructionLabel, BorderLayout.PAGE_START);
        boardPanel.add(_1v1resetButton); 
        boardPanel.add(_1v1homeButton);
        setUpBoardButtons(); 


    

       _1v1resetButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Go Back Button clicked!");
           boardPanel.removeAll(); 
           for (int i = 0; i < board.length; i++) {
    for (int j = 0; j < board[i].length; j++) {
        board[i][j] = emptyPieceNum;
    }
}
gameOver = false; 
             boardPanel.revalidate();  
            boardPanel.repaint(); 
            setUpBoardButtons();
            boardPanel.add(_1v1resetButton); 
        boardPanel.add(_1v1homeButton);
        boardPanel.add(_1v1boardPlacement);
        boardPanel.revalidate();  
            boardPanel.repaint(); 


           


        }
      });

      _1v1homeButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Home Button clicked!");
           boardPanel.removeAll(); 
           for (int i = 0; i < board.length; i++) {
    for (int j = 0; j < board[i].length; j++) {
        board[i][j] = emptyPieceNum;

        
    }

    gameContainer.setVisible(false);

        introPanel.setVisible(true);
        buttonPanel.setVisible(true);
}
gameOver = false; 
             boardPanel.revalidate();  
            boardPanel.repaint(); 
            setUpBoardButtons();
            boardPanel.add(_1v1resetButton); 
        boardPanel.add(_1v1homeButton);
        boardPanel.add(_1v1boardPlacement);
        boardPanel.revalidate();  
            boardPanel.repaint(); 
            _1v1gamePanel.setVisible(false);
            boardPanel.setVisible(false);
            introPanel.setVisible(true);
            buttonPanel.setVisible(true);
            
            
           
           


        }
      });
}
       
      public boolean checkForWin(int player) {
        for (int r = 0;  r < board.length; r++) {
            for (int c = 0; c < board[0].length - 3; c++) {
              if (board[r][c] == player && board[r][c+1] == player && board[r][c+2] == player && board[r][c+3] == player) {
                

                winningCells[0] = new int[]{r, c};
                winningCells[1] = new int[]{r, c+1};
                winningCells[2] = new int[]{r, c+2};
                winningCells[3] = new int[]{r, c+3};

                return true;
                
                 
              }
            }
        }
       
      
      
        for (int r = 0; r < board.length - 3; r++) {
          for (int c = 0; c < board[0].length; c++) {
            if (board[r][c] == player && board[r+1][c] == player && board[r+2][c] == player && board[r+3][c] == player) {

              winningCells[0] = new int[]{r, c};
              winningCells[1] = new int[]{r+1, c};
              winningCells[2] = new int[]{r+2, c};
              winningCells[3] = new int[]{r+3, c};

              return true;
            }
          }
       }


        for (int r = 0; r < board.length - 3; r++) {
          for (int c = 0; c < board[0].length - 3; c++) {
            if (board[r][c] == player && board [r+1][c+1] == player && board[r+2][c+2] == player && board[r+3][c+3] == player) {

              winningCells[0] = new int[]{r, c};
              winningCells[1] = new int[]{r+1, c+1};
              winningCells[2] = new int[]{r+2, c+2};
              winningCells[3] = new int[]{r+3, c+3};

              return true;
            }
          }
       }

        for (int r = 3; r < board.length; r++) {
          for (int c = 0; c < board[0].length - 3; c++){
            if (board[r][c] == player && board [r-1][c+1] == player && board[r-2][c+2] == player && board[r-3][c+3] == player) {

              winningCells[0] = new int[]{r, c};
              winningCells[1] = new int[]{r-1, c+1};
              winningCells[2] = new int[]{r-2, c+2};
              winningCells[3] = new int[]{r-3, c+3};

              return true;
       }
      }
      }

      return false;
      }









public void winningPieceFlourish() {

  Timer winningTimer = new Timer(300, null);

    

  winningTimer.addActionListener(new ActionListener() {

    

    boolean visible = true;
    int count = 0;

    @Override 
    public void actionPerformed(ActionEvent e) {

      visible = !visible;

       for (int i = 0; i < 4; i++) {
          int r = winningCells[i][0];
          int c = winningCells[i][1];
        
          chipLabels[r][c].setVisible(visible);
        }

        count++;

        if (count >= 10) {
          winningTimer.stop();

          for (int i = 0; i < 4; i++) {

            int r = winningCells[i][0];
            int c = winningCells[i][1];
        
          chipLabels[r][c].setVisible(true);
          }
    }
    }
  });

  winningTimer.start();

  if (gameOver || winningTimer != null) return;
}


      

  public void setUp1vAIGamePanel() {
    instructionLabel = new JLabel("Click on a column to drop a piece. First to connect 4 wins!");
    instructionLabel.setHorizontalAlignment(JLabel.CENTER);
    instructionLabel.setFont(new Font("Sans_Serif", Font.BOLD, 24)); 
    _1vAIgamePanel = new JPanel(new BorderLayout());
    _1vAIgamePanel.setSize(1300, 1050);
    aigamePanel = new JPanel();
        aigamePanel.setLayout(null);
        aigamePanel.setBackground(Color.WHITE);
      
        
      goBackImg = new ImageIcon("GoBack (1).png");
_AIresetButton = new JButton(goBackImg);
_AIresetButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    _AIresetButton.setVisible(true);
    _AIresetButton.setOpaque(true);
    _AIresetButton.setBounds(1150, 5, 100, 100);

homeImg = new ImageIcon("homeIcon (1).png");
_AIhomeButton = new JButton(homeImg);
_AIhomeButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    _AIhomeButton.setVisible(true);
    _AIhomeButton.setOpaque(true);
    _AIhomeButton.setBounds(1050, 5, 100, 100);


    aigamePanel.add(_AIresetButton);
aigamePanel.add(_AIhomeButton);


        ImageIcon boardImg = new ImageIcon("board.png");
        

        _AIboardPlacement = new JLabel(boardImg, SwingConstants.CENTER);
        _AIboardPlacement.setHorizontalAlignment(SwingConstants.CENTER);
        _AIboardPlacement.setVerticalAlignment(SwingConstants.CENTER);
        _AIboardPlacement.setBounds((1300 - boardImg.getIconWidth()) / 2, (1000 - boardImg.getIconHeight()) /2, boardImg.getIconWidth(), boardImg.getIconHeight());
        aigamePanel.add(_AIboardPlacement);


        _1vAIgamePanel.add(aigamePanel, BorderLayout.CENTER);
        _1vAIgamePanel.add(instructionLabel, BorderLayout.PAGE_START);


        


      for (int i = 0; i < 7; i++) {

      JButton aiboardButtons = new JButton("");

      aiboardButtons.setBounds(175 + (i * 135), 195, 135, 610);
  

      aiboardButtons.setOpaque(false);
      aiboardButtons.setContentAreaFilled(false);
      aiboardButtons.setBorderPainted(false);
      aigamePanel.add(aiboardButtons);
      

      aiboardButtons.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Button clicked!");

        }
      });
      }


      _AIhomeButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        gameContainer.setVisible(false);
        introPanel.setVisible(true);
        buttonPanel.setVisible(true);
    }
});

_AIresetButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Reset clicked");
    }
});

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
        boardPanel.setVisible(true);
       
        

        gameContainer.setVisible(true);

        CardLayout cl = (CardLayout) gameContainer.getLayout();
        cl.show(gameContainer, "AI");
          
      }
    });

    multiPlayerButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent evt) {
       introPanel.setVisible(false);
        buttonPanel.setVisible(false);
        boardPanel.setVisible(true);

        gameContainer.setVisible(true);

        CardLayout cl = (CardLayout) gameContainer.getLayout();
        cl.show(gameContainer, "1V1");
      }
    });


    buttonPanel.add(multiPlayerButton);
    buttonPanel.add(horizontalSpacer);
    buttonPanel.add(singlePlayerButton);
    buttonPanel.add(verticalSpacer);
    buttonPanel.add(nameLabel); 


  
  }


  public static void main(String[] args) {
    new Connect4();
  }

}
    
    
//For Ben. For Kiyan. 
//For Ben.