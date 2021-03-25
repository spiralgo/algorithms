package algorithms.curated170.medium;

 
public class NumberOfCornerRectangles {

    public static void main(String[] args) {
        NumberOfCornerRectangles nocr = new NumberOfCornerRectangles();
        int[][] grid = {{1, 0, 0, 1, 0},
                        {0, 0, 1, 0, 1},
                        {0, 0, 0, 1, 0},
                        {1, 0, 1, 0, 1}};
        
        nocr.countCornerRectangles(grid);
    }
    
 public int countCornerRectangles(int[][] grid) {
      int count = 0;
      int x = 0, y = 0;
     
      int distance = 1;
      while(y +distance < grid.length && x+distance < grid[y].length){
       
          if(grid[x][y] == 1 && grid[x+distance][y] == 1 
                  && grid[x][y+distance] == 1 && grid[x+distance][y+distance] == 1){
                count++;  
             }
        distance++;
      
      }
      return count;
      
 }
}
