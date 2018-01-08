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
	return Board[row - 1][column - 1].equals(" ");
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
	
	System.out.print("what row? ");
	int row = Keyboard.readInt();
	while (row != 1 && row != 2 && row != 3) {
	    System.out.println("Not a viable option");
	    System.out.println("Please input a row from 1-3");
	    row = Keyboard.readInt();
	}
	
	System.out.print("what column? ");
	int column = Keyboard.readInt();
	while (column != 1 && column != 2 && column != 3) {
	    System.out.println("Not a viable option");
	    System.out.println("Please input a column from 1-3");
	    column = Keyboard.readInt();
	}
	playerInput(row,column);
	System.out.print(tic);
	System.out.println(isEmpty(1,1));


    }
}
