package edu.jsu.mcis;

public class TicTacToeView {

    private TicTacToeModel model;
    public String gameBoard;
    /* CONSTRUCTOR */
	
    public TicTacToeView(TicTacToeModel model) {
        
        this.model = model;
        
    }
	
    public void viewModel() {
        
        /* Print the board to the console (see examples) */
        gameBoard = new String("");
        gameBoard = gameBoard.concat("\n\n  ");
        for (int k=0; k < model.getWidth(); k++){
            gameBoard = gameBoard + k;
        }
        gameBoard = gameBoard.concat("\n\n");
        for (int i=0; i < model.getWidth(); i++){
            gameBoard = gameBoard + i;
            gameBoard = gameBoard.concat(" ");
            for (int j =0; j < model.getWidth(); j++){
                gameBoard = gameBoard + model.getMark(i,j).toString();
            }
            gameBoard = gameBoard.concat("\n");
        }  
        
        System.out.println(gameBoard);
    }

    public void showNextMovePrompt() {

        // Display a prompt for the player's next move (see examples) */

        if (model.isXTurn() == true){
            System.out.println("Player 1 (X) Move: ");
            System.out.println("Enter the row and column numbers, separated by a space: ");
        }
        else{
            System.out.println("Player 2 (0) Move: ");
            System.out.println("Enter the row and column numbers, separated by a space: ");
        }
    }

    public void showInputError() {

        /* Display an error if input is invalid (see examples) */

        System.out.println("This input is invalid. (Please try again): ");

    }

    public void showResult(String r) {

        /* Display final winner */

        System.out.println(r + "!");

    }
	
}