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
            checkArrays();

            return vec[i][j++];
        }

        private void checkArrays() {
            j = 0;
            do {
                i++;
            } while (vec[i].length == 0);
        }

        public boolean hasNext() {
            if (j < vec[i].length) {
                return true;
            }

            checkArrays();
            if (i > vec.length) {
                return false;
            } else {
                return true;
            }

        }
    }

}
