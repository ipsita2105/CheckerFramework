/*
 * This program solves the eight queens problem
 * Using a bracktracking approach
 * Output is an array displaying configurations
 * That is column number for each row
 */

/**
 *
 * @author ipsita
 */
 
import java.util.*;
import org.checkerframework.checker.nullness.qual.*;


public class AnnotatedEightQueens {
    
    private @NonNull List<Integer> queens = new ArrayList<Integer>();
    
    
    public @NonNull boolean checkAttack(@NonNull int x1,@NonNull int y1,@NonNull int x2,@NonNull int y2){        	    // If under attack returns true if safe returns false
    
		if(x1 == x2 || y1 == y2)                                    // Under attack if in same row or column
		    return true;
		
		else if((y2 - y1 == x2 - x1) || (y2 - y1 == x1 -x2 ))       // Under attack if on same diagonal i.e. slope +-1
		    return true;
		
		else
		    return false;   
    
    }
    
    @NonNull boolean PlaceQueen(@NonNull int x2,@NonNull int col){
        
        
        if(x2>queens.size())            				   // If trying to add queen on a row without previous row filled return false
            return false;
        
        for(int i=col;i<8;i++){
            
            int Escapeattack =0;        				   // Counts number of attacks escaped
        
            
		    for(int j=0;j<x2;j++){
		        
			       int x1 =j;                   		   // x1 ans y1 are coordinates of the queen already placed
			       int y1 =queens.get(j);
			       
			       if(!checkAttack(x1,y1,x2,i)){
				   
				   Escapeattack++;
			       }
		        
		    }
		    
		  if(Escapeattack == x2){
		    
		        queens.add(i);          			   // If number of attacks escaped are equal to previous number of row then queen can be placed
		        return true;
		   }
                       
            
        }
        
        return false;      
    
    }
    
    void PlaceAll2(){
    
        @NonNull boolean allPlaced = false;
        int curRow = 0;
        
        @NonNull boolean b = false;
        
        while(!allPlaced){
        
		    if(queens.size() == curRow){
		    
		       		b = PlaceQueen(curRow,0);
		    }
		    
		    else{
		    
				if(queens.size() == curRow+1){     	 // Reach here if came from backtrack
				
				    int curPos = queens.get(curRow);
				    queens.remove(curRow);
				    b = PlaceQueen(curRow,curPos+1);    //Find new position
				
				}
		    
		    }
		    
		    if(b){
		    
				if(curRow == 7)
				    allPlaced = true;
				
				else
				curRow++;
		    }
		    
		    else{
		    		curRow--;      			       // Go for backtracking
		    }
		    
        }
        
    
    }
    
   void PrintSolution(){
    
        System.out.println(Arrays.toString(queens.toArray()));
         
    }
    
    
    public static void main(String args[]){
    
        @NonNull AnnotatedEightQueens q = new AnnotatedEightQueens();
        q.PlaceAll2();
        q.PrintSolution();
        
    }
    
}
