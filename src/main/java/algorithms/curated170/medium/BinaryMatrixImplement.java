package algorithms.curated170.medium;

import java.util.ArrayList;
import java.util.List;

public class BinaryMatrixImplement implements BinaryMatrix {

    int[][] mat = {{0,0},
                   {0,1}};

    @Override
    public int get(int row, int col) {
        return mat[row][col];
    }

    @Override
    public List<Integer> dimensions() {
        List dimensions = new ArrayList<Integer>();
        dimensions.add(mat.length);
        dimensions.add(mat[0].length);
        return dimensions;
    }

}
