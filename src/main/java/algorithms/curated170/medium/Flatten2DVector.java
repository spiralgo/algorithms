package algorithms.curated170.medium;

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
            if (j < vec[i].length) {
                return vec[i][j++];
            }
            j = 0;
            i++;
            while (vec[i].length == 0) {
                i++;
            }
            return vec[i][j++];
        }

        public boolean hasNext() {
            if (i >= vec.length) {
                return false;
            } else if (j >= vec[i].length) {
                j = 0;
                i++;
                while (vec[i].length == 0) {
                    i++;
                    if (i >= vec.length) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
    
}
