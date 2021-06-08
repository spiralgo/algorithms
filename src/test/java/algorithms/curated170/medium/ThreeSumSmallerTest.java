package algorithms.curated170.medium;

import org.junit.Test;
import static org.junit.Assert.*;

public class ThreeSumSmallerTest {

    @Test
    public void testNumWays() {

        assertEquals(3, new ThreeSumSmallerIterative().threeSumSmaller(new int[] { 0, 1, 3, 4, 8, 9, 11, 12 }, 8));
        assertEquals(151, new ThreeSumSmallerIterative()
                .threeSumSmaller(new int[] { 3, 2, -2, 6, 2, -2, 6, -2, -4, 2, 3, 0, 4, 4, 1 }, 3));
        assertEquals(2, new ThreeSumSmallerIterative().threeSumSmaller(new int[] { -2, 0, 1, 3 }, 2));
        assertEquals(49,
                new ThreeSumSmallerIterative().threeSumSmaller(new int[] { 5, -2, 4, 7, -1, 4, 3, 9, 18, -5 }, 10));
        assertEquals(42, new ThreeSumSmallerIterative()
                .threeSumSmaller(new int[] { -4, 5, 6, 15, 11, -2, -2, 7, 10, 1, 3, 9 }, 7));
    }

}
