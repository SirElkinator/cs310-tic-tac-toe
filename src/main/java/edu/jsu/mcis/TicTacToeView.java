package edu.jsu.mcis;
 
import java.awt. *;
import java.awt.event. *;
import javax.swing. *;
import java.util.Scanner;

public class TicTacToeView extends JPanel implements ActionListener{

    TicTacToeModel model;

    private JButton[][] squares;
    private JLabel resultLabel;
    private JPanel squaresPanel;
	
    public TicTacToeView(TicTacToeModel model) {
        this.model = model;

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        squares = new JButton[model.getWidth()][model.getWidth()];
        squaresPanel = new JPanel(new GridLayout(model.getWidth(),model.getWidth()));
        
        
        resultLabel = new JLabel();
        resultLabel.setName("ResultLabel");

            for (int i =0; i < model.getWidth(); i++){
                for (int j =0; j < model.getWidth(); j++){
                    squares[i][j] = new JButton();
                    squares[i][j].setPreferredSize(new Dimension(64, 64));
                    squares[i][j].addActionListener(this);
                    squares[i][j].setName("Square" + i + j);
                    squaresPanel.add(squares[i][j]);
                    
                }
            }
        updateSquares();
        this.add(squaresPanel);
        this.add(resultLabel);
        resultLabel.setText("Welcome to Tic-Tac-Toe!");

    }
    
    
    @Override
    public void actionPerformed(ActionEvent event) { 
        
        String name = ((JButton) event.getSource()).getName();
        int row = Integer.parseInt(String.valueOf(name.charAt(6)));
        int col = Integer.parseInt(String.valueOf(name.charAt(7)));

        updateSquares();
        if (model.makeMark(row,col) == true){
            
        }
        updateSquares();
        if (model.isGameover() == true) {
            showResult(model.getResult().toString()); 
        }

    }
        

    /*public void viewModel() {
       add(squaresPanel);
       
    }*/

    public void updateSquares() {

        /* Loop through all View buttons and (re)set the text of each button
           to reflect the grid contents (use the Model's "getMark()" method). */
           
            for (int i =0; i < model.getWidth(); i++){
                for (int j =0; j < model.getWidth(); j++){
                    squares[i][j].setText(model.getMark(i,j).toString());
                }
            }

    }

    public void showResult(String r) {

        // Display final winner
       
        resultLabel.setText(r.toUpperCase());
        
    }
	
}