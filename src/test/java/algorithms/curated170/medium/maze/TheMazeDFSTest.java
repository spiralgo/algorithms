package algorithms.curated170.medium.maze;
 
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Altay
 */
public class TheMazeDFSTest {
    int[][] directions = {{0, -1}, {1, 0}, {-1, 0}, {0, 1}};
    int[][] maze;
    int[] destination;
    int[] start;
    boolean visited[][];
    
    @Before
    public void setUp() {
        int[][] maze = {{0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 0},
                        {1, 1, 0, 1, 1},
                        {0, 0, 0, 0, 0}};
        int[] start = {0, 4}, destination = {4, 4};
         visited = new boolean[maze.length][maze[0].length];
         this.maze = maze;
         this.destination = destination;
         this.start = start;
    }
 

    /**
     * Test of hasPath method, of class TheMazeDFS.
     */
    @Test
    public void testHasPath() {
        System.out.println("hasPath");
        TheMazeDFS instance = new TheMazeDFS();
        instance.destination = destination;
        boolean expResult = true;
        boolean result = instance.hasPath(maze, start, destination);
        assertEquals(expResult, result);
    
        
    }

    /**
     * Test of dfs method, of class TheMazeDFS.
     */
    @Test
    public void testDfs() {
        System.out.println("dfs");
     
        TheMazeDFS instance = getFreshInstance(new int[]{4, 4});
          
        boolean result = instance.dfs(0, 4);
        assertEquals(true, result);
     
        instance = getFreshInstance(new int[]{1, 2});
        result = instance.dfs(0, 4);
        assertEquals(true, result);
     
        instance = getFreshInstance(new int[]{3, 2});
        result = instance.dfs(0, 4);
        assertEquals(false, result);
    }
   TheMazeDFS getFreshInstance(int[] destination){
          TheMazeDFS instance = new TheMazeDFS();
          instance.maze = maze;
          instance.visited = new boolean[maze.length][maze[0].length];
          instance.destination = destination;
          
          return instance;
                  
   }
    /**
     * Test of canPass method, of class TheMazeDFS.
     */
    @Test
    public void testCanPass() {
        System.out.println("canPass");
      
        TheMazeDFS instance = getFreshInstance(destination);
      
      
        int nextX = 0;
        int nextY = 0;
        boolean result = instance.canPass(nextX, nextY);
        
        assertEquals(true, result);
        
         nextX = 0;
         nextY = 2;
         result = instance.canPass(nextX, nextY);
         assertNotEquals(true, result);

    
    }
    
}
