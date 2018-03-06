/*
 * This program solves the eight queens problem
 * Using a bracktrackinh approach
 * Output is an array displaying configurations
 * That is column number for each row
 */

/**
 *
 * @author ipsita
 */
 
import java.util.*;


public class EightQueens {
    
    private List<Integer> queens = new ArrayList<Integer>();
    
    
    public boolean checkAttack(int x1,int y1,int x2,int y2){        	    // If under attack returns true if safe returns false
    
		if(x1 == x2 || y1 == y2)                                    // Under attack if in same row or column
		    return true;
		
		else if((y2 - y1 == x2 - x1) || (y2 - y1 == x1 -x2 ))       // Under attack if on same diagonal i.e. slope +-1
		    return true;
		
		else
		    return false;   
    
    }
    
    boolean PlaceQueen(int x2,int col){
        
        
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
    
        boolean allPlaced = false;
        int curRow = 0;
        
        boolean b = false;
        
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
    
        EightQueens q = new EightQueens();
        q.PlaceAll2();
        q.PrintSolution();
        
    }
    
}
