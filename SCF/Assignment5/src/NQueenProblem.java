/**
 * Implement N Queens Problem using Recursion
 * @author Admin
 *
 */
public class NQueenProblem { 	
	/*
	 * @param board array is the N*N board in which queens are placed
	 * This function print the board if queens are placed correctly
	 */
	void printSolution(int board[][], int N) { 
		for (int i = 0 ; i < N ; i++) { 
			for (int j = 0 ; j < N ; j++) 
				System.out.print(" " + board[i][j] + " "); 
			System.out.println(); 
		} 
	} 

	/*
	 * @param  board is a N*N matrix @param col and row are column and row index taken to check safe position   
	 * @return returns True if queen position safe for particular column and row else returns false
	 */
	boolean isSafe(int board[][], int row, int col, int N) { 
		int i, j; 
		for (i = 0 ; i < col ; i++) 
			if (board[row][i] == 1) 
				return false; 
		for (i=row, j=col ; i>=0 && j>=0 ; i--, j--) 
			if (board[i][j] == 1) 
				return false; 
		for (i=row, j=col ; j>=0 && i<N ; i++, j--) 
			if (board[i][j] == 1) 
				return false; 
		return true; 
	} 
	
	/*
	 * @param  board is a N*N matrix @param col is a column index taken to calculate safe position   
	 * @return returns True if queen position is correct for column col else returns false
	 */
	boolean solveNQRec(int board[][], int col, int N) 
	{ 
		if (col >= N)  
			return true; 
		for (int i = 0 ; i < N ; i++) { 
			if (isSafe(board, i, col, N)) { 
				board[i][col] = 1; 			
				if (solveNQRec(board, col + 1, N) == true) 
					return true; 	
				board[i][col] = 0;
			} 
		} 
		return false;
	} 

	/*
	 * @param N is the no. of Queens to be placed on N*N matrix
	 * @return returns True if solution exist else returns false
	 */
	boolean solveNQ( int N) throws Exception { 
		if(N==0)
			throw new Exception("Zero no. of Queens");
		int board[][] = new int[N][N];
		if (solveNQRec(board, 0, N) == false) { 
			System.out.print("Solution does not exist"); 
			return false; 
		} 
		printSolution(board, N); 
		return true; 
	} 

} 
