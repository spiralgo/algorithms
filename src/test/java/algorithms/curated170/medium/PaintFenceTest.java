package algorithms.curated170.medium;

 
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Altay
 */
public class PaintFenceTest {
  
    @Test
    public void testNumWays() {
        PaintFence paintFence = new PaintFence();
        
        assertEquals(1, paintFence.numWays(1, 1));
        assertEquals(2, paintFence.numWays(1, 2));
        assertEquals(4, paintFence.numWays(2, 2));
        assertEquals(6, paintFence.numWays(3, 2));
        assertEquals(24, paintFence.numWays(3, 3));

    }
    
}
