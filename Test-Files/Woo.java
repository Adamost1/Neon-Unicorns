import cs1.Keyboard;

public class Woo{

    public static String[][] Board;

    public Woo(){ //constructor 
	Board = new String[3][3];

	for(int row = 0; row < Board.length; row ++){ //fills the whole array with spaces
	    for(int col = 0; col < Board.length; col ++){
		Board[row][col] = " ";
	    }
	}
    }


    public String toString(){ //returns String representation of tic-tac-toe board
	String retVal = "";

	for(String[] array: Board){
	    retVal += "\n";

	    for(String s: array){
		retVal += s + " |";
	    }
	    retVal = (retVal.substring(0,retVal.length() - 1) + " \n");
	    retVal += ("_________\n");
	}

	return retVal.substring(0, retVal.length() - 10);
    }//end method

    public static void playerInput(int row, int column) {
	Board[row - 1][column - 1] = "X";
    }//end method

    public static boolean isEmpty(int row, int column) {
	return Board[row][column].equals(" ");
    }//end method


    public static void AIDiffE() { //AI strategy for easy mode
	int x = (int)(Math.random() * (Board.length) + 1);
	int y = (int)(Math.random() * (Board[0].length) + 1);
	while ( !(isEmpty(x - 1, y - 1))) {
	    x = (int)(Math.random() * (Board.length) + 1);
	    y = (int)(Math.random() * (Board[0].length) + 1);
	    System.out.println("===========debugging==========\n" + x + "\t" + y + "\n===================");
	}
	Board[x - 1][y - 1] = "O";
    }

    public static void AIDiffM(){


    	for(int r = 0; r < Board.length; r ++){//checks row by row for two in a row

	    if(
	       (Board[r][0].equals(Board[r][1]) && !(Board[r][0].equals(Board[r][2])) && !(Board[r][0].equals(" ")) ) ||
	       (Board[r][0].equals(Board[r][2]) && !(Board[r][0].equals(Board[r][1])) && !(Board[r][0].equals(" ")) ) ||
	       (Board[r][1].equals(Board[r][2]) && !(Board[r][1].equals(Board[r][0])) && !(Board[r][1].equals(" ")) )     			
	       )
    		{
		    for(int c = 0; c < Board.length; c ++){
			if(Board[r][c].equals(" ")){
			    Board[r][c] = "O";
			    return;
			}
		    }
    		}//close if
	}//close for

    	for(int c = 0; c < Board.length; c ++){//checks column by column for two in a column

	    if(
	       (Board[0][c].equals(Board[1][c]) && !(Board[0][c].equals(Board[2][c])) && !(Board[0][c].equals(" ")) ) ||
	       (Board[0][c].equals(Board[2][c]) && !(Board[0][c].equals(Board[1][c])) && !(Board[0][c].equals(" ")) ) ||
	       (Board[1][c].equals(Board[2][c]) && !(Board[1][c].equals(Board[0][c])) && !(Board[1][c].equals(" ")) )     			
	       )
    		{
		    for(int r = 0; r < Board.length; r ++){
			if(Board[r][c].equals(" ")){
			    Board[r][c] = "O";
			    return;
			}
		    }
    		}//close if
	}//close for

	    if ( //checks the first diagonal, going from top left to bottom right, for 2 elements 
		(Board[0][0].equals(Board[1][1]) && !(Board[0][0].equals(Board[2][2])) && !(Board[0][0].equals(" ")) ) ||
		(Board[0][0].equals(Board[2][2]) && !(Board[0][0].equals(Board[1][1])) && !(Board[0][0].equals(" ")) ) ||
		(Board[1][1].equals(Board[2][2]) && !(Board[1][1].equals(Board[0][0])) && !(Board[1][1].equals(" ")) )
		) 
		{
		for(int i = 0; i < Board.length; i ++) {
		    if (Board[i][i].equals(" ")) {
			Board[i][i] = "O";
			return;
		    }
		}
	    }// closes if

	    if (		
		(Board[0][2].equals(Board[1][1]) && !(Board[0][2].equals(Board[2][0])) && !(Board[0][2].equals(" ")) ) ||
		(Board[0][2].equals(Board[2][0]) && !(Board[0][2].equals(Board[1][1])) && !(Board[0][2].equals(" ")) ) ||
		(Board[1][1].equals(Board[2][0]) && !(Board[1][1].equals(Board[0][2])) && !(Board[1][1].equals(" ")) )
		)
		{
		    for(int i = 0; i < Board.length; i ++){
			if (Board[i][2 - i].equals(" ")){
			    Board[i][2 - i] = "O";
			    return;
			}
		    }
		}
	
	

	AIDiffE(); //resorts to AIDiffE(), or random moves when there are not two elements in a row or column



    }
    
    public static int PinputR() { //reads the user input for row and returns the input
	System.out.print("what row? ");
	int row = Keyboard.readInt();
	while (row != 1 && row != 2 && row != 3) {
	    System.out.println("Not a viable option");
	    System.out.println("Please input a row from 1-3");
	    System.out.print("What row? ");
	    row = Keyboard.readInt();
	}
	return row;
    }
    public static int PinputC() { //reads the user input for column and returns the input
	System.out.print("what column? ");
	int column = Keyboard.readInt();
	while (column != 1 && column != 2 && column != 3) {
	    System.out.println("Not a viable option");
	    System.out.println("Please input a column from 1-3");
	    System.out.print("What column? ");
	    column = Keyboard.readInt();
	}
	return column;
    }

    public static boolean isWin(){ //checks to see if there is a 3-in-a-row
    	for(String[] array: Board){ //checks across the rows to see if there is 3-in-a-row

	    if(array[0].equals(array[1]) && array[1].equals(array[2]) ){ //checks to see if the indeces contain the same String

		if(array[0].equals(" ")){ //checks to see if the indeces are just spaces
		    return false;
		}
		else{
		    return true;
		}

	    }//close if loop  		
    	}//close for loop


    	for(int c = 0; c < Board.length; c ++){ //checks down the columns to see if there is 3-in-a-row

	    if(Board[0][c].equals(Board[1][c]) && Board[1][c].equals(Board[2][c]) ){

		if(Board[0][c].equals(" ")){
		    return false;
		}
		else{
		    return true;
		}

	    }//close if loop
    		
    	}//close for loop

	if ((Board[0][0].equals(Board[1][1]) && Board[1][1].equals(Board[2][2])) || (Board[0][2].equals(Board[1][1]) && Board[1][1].equals(Board[2][0]))) {
	    if (Board[1][1].equals(" ")) {
		return false;
	    }// close nested-if loop
	    else {
		return true;
	    }// close else
	}// close if loop

    	return false;


    }//end method

    public static boolean isFull() { //checks to see if the Board is full of non-spaces
	for (String[] row : Board) {
	    for (String c : row) {
		if (c.equals(" ")) {
		    return false;
		}
	    }
	}
	return true;
    }


    public static void chooseAIDifficulty(int difficulty){ //it executes the correct method according to the difficulty chosen
    	if(difficulty == 1){
	    AIDiffE();
    	}
    	if(difficulty == 2){
	    AIDiffM();
    	}
    }

    public static void gameIfPlayerFirst(int difficulty){  //plays the game if player goes first
	Woo tic = new Woo();
	System.out.println(tic);

        outer:
	while (isFull() == false) {
	    while (isWin() == false ) {
		int row = PinputR();
		int column = PinputC();

		while(  isEmpty(row - 1, column - 1) == false ){    //prints message if the player chooses coordinates of an occupied spot
		    System.out.println( "Pick an empty spot!");
		    row = PinputR();
		    column = PinputC();
		}

		playerInput(row,column);
		System.out.println("Your Move:");
		System.out.print(tic);
		if(isWin() == true){
		    System.out.println("YOU WIN!");
		    break outer;
		}
		if (isFull() == true) {
		    System.out.println("It's a tie");
		    break outer;
		}

		chooseAIDifficulty(difficulty); //uses parameter to choose difficulty
		System.out.println("AI Move:");
		System.out.print(tic);
	

	    }
	    if(isWin() == true){
		System.out.println("Game Over. You lose.");
		break outer;
	    }
	    
	}

    }//end method

    public static void aiStart(int difficulty){ 

    	if(difficulty == 3){
	    Board[2][2] = "O";
    	}
    	else{
	    Board[(int) (Math.random() * 3)][ (int) (Math.random() * 3)] = "O";
	}
    }

    public static void gameIfAIFirst(int difficulty){ //plays the game if AI goes first
	Woo tic = new Woo();
	aiStart(difficulty);
	System.out.println("AI Move:\n" + tic);

        outer:
	while (isFull() == false) {
	    while (isWin() == false ) {

		if (isFull() == true) { //checks for tie before the player moves because the AI will always be the one to fill up the board if it goes first
		    System.out.println("It's a tie");
		    break outer;
		}

		int row = PinputR();
		int column = PinputC();

		while(  isEmpty(row - 1, column - 1) == false ){    //prints message if the player chooses coordinates of an occupied spot
		    System.out.println( "Pick an empty spot!");
		    row = PinputR();
		    column = PinputC();
		}

		playerInput(row,column);
		System.out.println("Your Move:");
		System.out.print(tic);
		if(isWin()){ //if 3-in-a-row after player moves, it means the player wins
		    System.out.println("YOU WIN!");
		    break outer;
		}
		//dont need to check isFull() here because if AI goes first, the player will never be the last one to fill up the board

		chooseAIDifficulty(difficulty);
		System.out.println("AI Move:");
		System.out.print(tic);
	

	    }
	    if(isWin() == true){ //if 3-in-a-row after AI moves, it means the AI wins
		System.out.println("Game Over. You lose.");
		break outer;
	    }

	    
	}

    }//end method

    public static void startGame() {
	System.out.println("Choose your difficulty");
	System.out.println("1. Easy\n2. Medium\n3. Hard");
	int difficulty = Keyboard.readInt();
	
	while (difficulty != 1 && difficulty != 2 && difficulty != 3) {
	    System.out.println("Not a viable option");
	    System.out.println("Choose your difficulty from 1-3");
	    System.out.println("1. Easy\n2. Medium\n3. Hard");
	    difficulty = Keyboard.readInt();
	    
	}

	int coin = (int) (Math.random() * 2);

	if (coin == 0) {
	    gameIfAIFirst(difficulty);
	}

	else {
	    gameIfPlayerFirst(difficulty);
	}
    }



    public static void main(String[] args) {


	startGame();


	//====================================IF PLAYER GOES FIRST==============
	//gameIfPlayerFirst(difficulty);
	//==================================================================================
    }
    
    
}
