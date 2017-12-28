import cs1.Keyboard;

public class Woo{

public String[][] Board;

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


	public static void main(String[] args){
		Woo tic = new Woo();
		System.out.println(tic);


	}
}