import cs1.Keyboard;

public class Woo{

    public static String[][] Board;

    public Woo(){
	Board = new String[3][3];

	for(int row = 0; row < Board.length; row ++){
	    for(int col = 0; col < Board.length; col ++){
		Board[row][col] = " ";
	    }
	}
    }


    public String toString(){
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
    }

    public static void playerInput(int row, int column) {
	Board[row - 1][column - 1] = "X";
    }

    public static boolean isEmpty(int row, int column) {
	return Board[row][column].equals(" ");
    }

    public static void AIDiffE() { //AI strategy for easy mode
	int x = (int)(Math.random() * (Board.length) + 1);
	int y = (int)(Math.random() * (Board[0].length) + 1);
	while ( !(isEmpty(x - 1, y - 1)) ) {
	    x = (int)(Math.random() * (Board.length) + 1);
	    y = (int)(Math.random() * (Board[0].length) + 1);
	    System.out.println("===========debugging==========\n" + x + "\t" + y + "\n===================");
	}
	Board[x - 1][y - 1] = "O";
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

    public static boolean isWin(){
    	for(String[] array: Board){

	    if(array[0].equals(array[1]) && array[1].equals(array[2]) ){
		if(array[0].equals(" ")){
		    return false;
		}
		else{
		    return true;
		}

	    }
    		
    	}


    	for(int c = 0; c < Board.length; c ++){

	    if(Board[0][c].equals(Board[1][c]) && Board[1][c].equals(Board[2][c]) ){
		if(Board[0][c].equals(" ")){
		    return false;
		}
		else{
		    return true;
		}
	    }
    		
    	}

    	return false;
    }

    public static void main(String[] args) {


	System.out.println("Choose your difficulty");
	System.out.println("1. Easy\n2. Medium\n3. Hard");
	int difficulty = Keyboard.readInt();
	
	while (difficulty != 1 && difficulty != 2 && difficulty != 3) {
	    System.out.println("Not a viable option");
	    System.out.println("Choose your difficulty from 1-3");
	    System.out.println("1. Easy\n2. Medium\n3. Hard");
	    difficulty = Keyboard.readInt();
	    
	}


	Woo tic = new Woo();
	System.out.println(tic);


	
        outer:
	for(int counter = 0; counter <= 9; counter ++){
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
		if(isWin()){
		    System.out.println("YOU WIN!");
		    break outer;
		}
		AIDiffE();
		System.out.println("AI Move:");
		System.out.print(tic);
	

	    }
	    if(isWin() == true){
	    System.out.println("Game Over. You lose.");
	    break outer;
	    }
	    else{
		System.out.println("It's a tie...");
		break outer;
	    }
	    
	}
    }
    
    
}
