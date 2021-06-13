package algorithms.curated170.medium;

import java.util.NoSuchElementException;

public class Flatten2DVector {
    class Vector2D {

        int[][] vec;
        int i = 0, j = 0;

        public Vector2D(int[][] vec) {
            this.vec = vec;
            i = 0;
            j = 0;
        }

        public int next() {

            if (hasNext()) {
                return vec[i][j++];
            } else {
                throw new NoSuchElementException();
            }

        }

        private boolean checkArrays() {
            j = 0;
            do {
                i++;
                if (i >= vec.length) {
                    return false;
                }
            } while (vec[i].length == 0);
            return true;
        }

        public boolean hasNext() {
            if (vec.length > 0 &&  j < vec[i].length) {
                return true;
            }

            return checkArrays();
        }
    }

}
