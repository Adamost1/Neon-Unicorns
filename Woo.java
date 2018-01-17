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
    }//end constructor


    public String toString(){ //returns String representation of tic-tac-toe board
	String retVal = "";

	for(String[] array: Board){
	    retVal += "\n";

	    for(String s: array){
		retVal += s + " |";
	    }
	    retVal = (retVal.substring(0,retVal.length() - 1) + " \n");
	    retVal += ("_________\n");
	}//end method


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
	}
	Board[x - 1][y - 1] = "O";
    }//end method


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
    }//end method


    public static void AIDiffH() {
	if (isEmpty(1,1)) { //checks to see if the middle is empty. If it is, then initiate board with "O" in the middle
	    Board[1][1] = "O";
	}
	else if (isEmpty(0,0) && isEmpty(0,2) && isEmpty(2,0) && isEmpty(2,2)) { //checks to see if diagonals are empty
	    if (Board[0][1].equals("X")) {  //if player responds with this placement, AI will place it in two possible places to set up the "death trap"
		int coin = (int) Math.random() * 2;
		if (coin == 0) {
		    Board[2][0] = "O";
		}
		else {
		    Board[2][2] = "O";
		}
	    }
	    
	    else if (Board[2][1].equals("X")) {//if player responds with this placement, AI will place it in two possible places to set up the "death trap"
		int coin = (int) Math.random() * 2;
		if (coin == 0) {
		    Board[0][0] = "O";
		}
		else {
		    Board[0][2] = "O";
		}
	    }

	    else if (Board[1][0].equals("X")) {//if player responds with this placement, AI will place it in two possible places to set up the "death trap"
		int coin = (int) Math.random() * 2;
		if (coin == 0) {
		    Board[0][2] = "O";
		}
		else {
		    Board[2][2] = "O";
		}
	    }

	    else if (Board[1][2].equals("X")) {//if player responds with this placement, AI will place it in two possible places to set up the "death trap"
		int coin = (int) Math.random() * 2;
		if (coin == 0) {
		    Board[0][0] = "O";
		}
		else {
		    Board[2][0] = "O";
		}
	    }

	    else {//if the sides of the tic-tac-toe board aren't occupied yet, the AI starts to set up the "death trap" by placing an "O" at a random diagonal
		int coin = 1 + (int) (Math.random() * 4);
		switch (coin) {
		case 1: Board[0][0] = "O";
		    break;
		case 2: Board[0][2] = "O";
		    break;
		case 3: Board[2][0] = "O";
		    break;
		case 4: Board[2][2] = "O";
		    break;
		}
	    }//close else	

	}
	else { //once the "death trap" is set up, it will proceed with the AIDiffM AI
	    AIDiffM();
	}   
    }//end method

    
    public static int PinputR() { //reads the user input for row and returns the input
	System.out.print("what row? ");
	int row = Keyboard.readInt();
	while (row != 1 && row != 2 && row != 3 && row != 47) {
	    System.out.println("Not a viable option");
	    System.out.println("Please input a row from 1-3");
	    System.out.print("What row? ");
	    row = Keyboard.readInt();
	}
	return row;
    } //end method


    public static int PinputC() { //reads the user input for column and returns the input
	System.out.print("what column? ");
	int column = Keyboard.readInt();
	while (column != 1 && column != 2 && column != 3 && column != 42) {
	    System.out.println("Not a viable option");
	    System.out.println("Please input a column from 1-3");
	    System.out.print("What column? ");
	    column = Keyboard.readInt();
	}
	return column;
    }//end method


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
    }//end method


    public static void chooseAIDifficulty(int difficulty){ //it executes the correct method according to the difficulty chosen
    	if(difficulty == 1){
	    AIDiffE();
    	}
    	if(difficulty == 2){
	    AIDiffM();
    	}
	if (difficulty == 3) {
	    AIDiffH();
	}
    }//end method


    public static void gameIfPlayerFirst(int difficulty){  //plays the game if player goes first
	Woo tic = new Woo();
	System.out.println(tic);
        outer:
	while (isFull() == false) {
	    while (isWin() == false ) { //while there aren't three in a row
		int row = PinputR();
		int column = PinputC();
		//CHEATS
		if (row == 47 && column == 42) {  //cheat codes section
		    for (int i = 0; i < Board.length; i++) {
			for (int j = 0; j < Board[0].length; j++) {
			    Board[i][j] = "X";
			}
		    }
		    System.out.println(tic);
		    System.out.println("YOU WIN!");
		    break outer;
		}//END CHEATS

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
	    }//close 2nd-inner while loop

	    if(isWin() == true){
		System.out.println("Game Over. You lose.");
		break outer;
	    }
	    
	}//close outer-most while loop

    }//end method


    public static void aiStart(int difficulty){ //initiates the board if AI goes first, based on the difficulty
    	if(difficulty == 3){
	    Board[1][1] = "O";
    	}
    	else{
	    Board[(int) (Math.random() * 3)][(int) (Math.random() * 3)] = "O";
	}
    }//end method


    public static void gameIfAIFirst(int difficulty){ //plays the game if AI goes first
	Woo tic = new Woo();
	aiStart(difficulty);
	System.out.println("AI Move:\n" + tic);
        outer:
	while (isFull() == false) {

	    while (isWin() == false ) { //while there aren't 3 in a row

		if (isFull() == true) { //checks for tie before the player moves because the AI will always be the one to fill up the board if it goes first
		    System.out.println("It's a tie");
		    break outer;
		}
		//CHEATS
		int row = PinputR();   //cheat codes section
		int column = PinputC();
		if (row == 47 && column == 42) {
		    for (int i = 0; i < Board.length; i++) {
			for (int j = 0; j < Board[0].length; j++) {
			    Board[i][j] = "X";
			}
		    }
		    System.out.println(tic);
		    System.out.println("YOU WIN!");
		    break outer;
		}//END CHEATS
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

    public static void startGame() { //starts off the game
	System.out.println("==================================================================");
	System.out.println("Choose your difficulty");
	System.out.println("1. Easy\n2. Medium\n3. Hard");
	int difficulty = Keyboard.readInt();
	
	while (difficulty != 1 && difficulty != 2 && difficulty != 3) {
	    System.out.println("Not a viable option");
	    System.out.println("Choose your difficulty from 1-3");
	    System.out.println("1. Easy\n2. Medium\n3. Hard");
	    difficulty = Keyboard.readInt();
	    
	}

	
	    
	int coin = (int) (Math.random() * 2); //randomly chooses who goes first
	    
	if (coin == 0) {
	    gameIfAIFirst(difficulty);
	}
	
	else {
	    gameIfPlayerFirst(difficulty);
	}
    }//end method



    public static void main(String[] args) { //main method
	int pa = 0;
	System.out.println("\n\n==================================================================\nWelcome to Neon Unicorn's Tic-Tac-Toe in the terminal!\n");
	startGame();
	System.out.println("\nPlay Again?");
	System.out.println("1: Yes\n2: No");
	pa = Keyboard.readInt();
	while (pa != 1 && pa != 2 ) {
	    System.out.println("Please enter either 1 or 2");
	    System.out.println("\nPlay Again?");
	    System.out.println("1: Yes\n2: No");
	    pa = Keyboard.readInt();
	}
	if (pa == 1) {
	    startGame();
	}

    }//close main method
    
    
}
