package algorithms.curated170.hard.rangesumquery2dmutable;

public class RangeSumQuery2DMutableSegmentTree {

    class NumMatrix {
        final int M, N;
        int[][] segTree;
        int[][] _matrix;
        public NumMatrix(int[][] matrix) {
            M=matrix.length;
            N=matrix[0].length;
            this._matrix=matrix;
            
            segTree=new int[M][4*N];    
            for(int i=0;i<M;i++){
                insert(i,matrix[i],0,0,N-1);
            }
        }
        
        private void insert(int segTreeNum, int[] arr,int treeIdx,int lo, int hi){
            if(lo==hi){
                segTree[segTreeNum][treeIdx]=arr[lo];
                return;
            }
            int mid=lo+(hi-lo)/2;
            insert(segTreeNum,arr,2*treeIdx+1,lo,mid);    
            insert(segTreeNum,arr,2*treeIdx+2,mid+1,hi);
            
            segTree[segTreeNum][treeIdx]=segTree[segTreeNum][2*treeIdx+1]+segTree[segTreeNum][2*treeIdx+2];
        }
        
        
        private void update(int segTreeNum,int arrIdx,int treeIdx, int lo, int hi ){
            if(lo==hi){
                segTree[segTreeNum][treeIdx]=_matrix[segTreeNum][arrIdx];
                return;
            }
            int mid=lo+(hi-lo)/2;
            if(arrIdx<=mid){
                update(segTreeNum,arrIdx,2*treeIdx+1,lo,mid);    
            }else{
                update(segTreeNum,arrIdx,2*treeIdx+2,mid+1,hi);
            }
            segTree[segTreeNum][treeIdx]=segTree[segTreeNum][2*treeIdx+1]+segTree[segTreeNum][2*treeIdx+2];
        }
        
        public void update(int row, int col, int val) {
            _matrix[row][col]=val;
            update(row,col,0,0,N-1);
        }
        
        public int sumRegion(int row1, int col1, int row2, int col2) {
            int ans=0;
            for(int r = row1; r<=row2; r++){
                ans+=query(r,0,0,N-1,col1,col2);
            }
            return ans;
        }
        
        private int query(int segTreeNum,int treeIdx, int lo, int hi, int ql, int qr){
            if(lo>qr||hi<ql){return 0;}
            if(ql<=lo && qr>=hi){return segTree[segTreeNum][treeIdx];}
            
            int mid = lo+(hi-lo)/2;
            
            if(qr<=mid){
                return query(segTreeNum,2*treeIdx+1,lo,mid,ql,qr); 
            }else if(ql>mid){
                return query(segTreeNum,2*treeIdx+2,mid+1,hi,ql,qr);
            }
            
            int left=query(segTreeNum,2*treeIdx+1,lo,mid,ql,mid);
            int right=query(segTreeNum,2*treeIdx+2,mid+1,hi,mid+1,qr);
            
            return left+right;
        }
    }
}
