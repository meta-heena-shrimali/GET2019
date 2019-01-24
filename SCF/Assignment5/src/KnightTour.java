/**
 * Implement knights-tour-problem for n*n matrix
 * @author Admin
 */
import java.util.Random;
class KnightTour { 
    static int N = 8; 
    static int last_x;
	static int last_y;
    /*
     * @param sol is the solution matrix
     * @param x and y are the coordinates at chess board
     * @returns return true if knight can move to that place 
     */
    static boolean isSafe(int x, int y, int sol[][]) { 
        return (x >= 0 && x < N && y >= 0 &&  y < N && sol[x][y] == -1); 
    } 
  
    /*
     * @param sol is the solution matrix that has to be printed
     */
    static void printSolution(int sol[][]) { 
        for (int x = 0; x < N ; x++) { 
            for (int y = 0; y < N ; y++) 
                System.out.print(sol[x][y] + " "); 
            System.out.println();
        } 
    } 
    
  /*
   * @return returns true if solution exist else return false 
   */
    static boolean knightTourSolution() { 
        int sol[][] = new int[8][8], next_x, next_y, x, y; 
        boolean status= false;
        for (x = 0; x < N ; x++) 
            for (y = 0; y < N ; y++) 
                sol[x][y] = -1; 
        
        int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2}; 
        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1}; 
        Random rand = new Random();
        x=rand.nextInt(N);
        y=rand.nextInt(N);
        sol[x][y] = 0; 
        
        if (!nextStepKT(x,y, 1, sol, xMove, yMove)) { 
            System.out.println("Solution does not exist"); 
            return false; 
        }
        else {
        	
            printSolution(sol);
            for (int k = 0; k < 8 ; k++) { 
            	next_x = last_x + xMove[k]; 
                next_y = last_y + yMove[k]; 
                
                if (next_x >= 0 && next_x < N && next_y >= 0 &&  next_y < N && sol[next_x][next_y] == 1)
                	status=true;
                }  
            if (status)
         	   System.out.println(" Closed Path "); 
            else
         	   System.out.println(" Open Path ");
            
        }
        return true; 
    } 
  
    /*
     * @param x and @param y are the current position of knight on the chess board
     * @param xMove and @param YMove are the array of possible next moves of the knight
     * @param sol is the solution matrix
     * @return returns true path to the whole tour can be done else returns false
     */
    static boolean nextStepKT(int x, int y, int step, int sol[][], int xMove[], int yMove[]) { 
        int k, next_x, next_y; 
        if (step == N * N) 
            return true; 
        
        for (k = 0; k < 8 ; k++) { 
            next_x = x + xMove[k]; 
            next_y = y + yMove[k]; 
            if (isSafe(next_x, next_y, sol)) { 
            	if(step == N * N - 1 ) {
                	last_x = next_x;
                	last_y = next_y;
                }
            	sol[next_x][next_y] = step; 
                if (nextStepKT(next_x, next_y, step + 1, 
                                sol, xMove, yMove)) 
                    return true; 
                else
                    sol[next_x][next_y] = -1;// backtracking 
            } 
        } 
        return false; 
    } 
} 