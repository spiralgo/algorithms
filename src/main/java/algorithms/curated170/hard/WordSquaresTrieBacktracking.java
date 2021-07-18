package algorithms.curated170.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordSquaresTrieBacktracking {
   public static class Solution {
       public final static int LETTER_a = 97;

       public List<List<String>> wordSquares(String[] words) {
           TrieNode root = buiildTrie(words);
           int n = words[0].length();
           TrieNode[] trieNodeState = new TrieNode[n];
           Arrays.fill(trieNodeState, root);
           List<List<String>> ans = new ArrayList<>();
           dfs(0, new char[n][n], ans, trieNodeState);
           return ans;
       }
       void dfs(int rowIndex, char[][] matrix, List<List<String>> ans, TrieNode[] trieNodeState) {
           if (rowIndex == matrix.length) {
               ans.add(convertMatrixToList(matrix, rowIndex));
               return;
           }
           TrieNode[] trieNodeStateNext = new TrieNode[trieNodeState.length];
           for (String candidate : trieNodeState[rowIndex].list) {

               if (isSymmetric(matrix, candidate, rowIndex, trieNodeState, trieNodeStateNext)){
                   dfs(rowIndex + 1, matrix, ans, trieNodeStateNext);
               }
           }
       }

       private boolean isSymmetric(char[][] matrix, String candidate, int rowIndex,
                                   TrieNode[] trieNodeState, TrieNode[] trieNodeStateNext) {

           int i = rowIndex;
           while (i < matrix.length) {
               char ch = candidate.charAt(i);
               matrix[rowIndex][i] = ch;
               if (i > rowIndex) {
                   matrix[i][rowIndex] = ch;
                   int letterIndex = letterIndex(ch);
                   if (trieNodeState[i].children[letterIndex] == null) break;
                   trieNodeStateNext[i] = trieNodeState[i].children[letterIndex];
               }
               i++;
           }
           return (i == matrix.length);
       }

       TrieNode buiildTrie(String[] words){
           TrieNode root = new TrieNode();
           for (String w : words) {
               root.list.add(w);
               TrieNode tn = root;
               for (char ch : w.toCharArray()) {
                   int index = letterIndex(ch);
                   if (tn.children[index] == null){
                       tn.children[index] = new TrieNode();
                   }
                   tn = tn.children[index];
                   tn.list.add(w);
               }
           }
           return root;
       }
       private List<String> convertMatrixToList(char[][] matrix, int rowIndex) {
           List<String> words = new ArrayList<>(rowIndex);
           for (char[] ca : matrix) words.add(new String(ca));
           return words;
       }


       private int letterIndex(char ch)
       {
           return (ch - LETTER_a);
       }

       class TrieNode {
           List<String> list;
           TrieNode[] children;
           TrieNode() {
               list = new ArrayList<>();
               children = new TrieNode[26];
           }
       }
   }
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.wordSquares(new String[]{ "area","lead","wall","lady","ball"});
    }
}
