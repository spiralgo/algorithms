package algorithms.curated170.medium;

import java.util.NoSuchElementException;

public class Flatten2DVector {

    class Vector2D {

        int[][] vec;
        int i = 0, j = 0;

        public Vector2D(int[][] v) {
            this.vec = v;
        }

        public int next() {
            if (hasNext()) {
                return vec[i][j++];
            } else {
                throw new NoSuchElementException();
            }
        }

        public boolean hasNext() {
            while (i < vec.length && j >= vec[i].length) {
                i++;
                j = 0;
            }

            return i < vec.length;
        }
    }

}
