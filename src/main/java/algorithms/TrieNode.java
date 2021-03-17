package algorithms;

 
public class TrieNode {
    TrieNode[] children;
    char c;
    boolean isWord;

    public TrieNode(char c) {
       this.c = c;
       children = new TrieNode[26];
    }
    
}
