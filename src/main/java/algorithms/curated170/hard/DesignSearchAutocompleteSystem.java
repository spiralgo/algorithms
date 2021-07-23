package algorithms.curated170.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DesignSearchAutocompleteSystem {

    class AutocompleteSystem {
        private Trie root;
        private Trie curNode;
        private StringBuilder curChars;
        private Map<String, Integer> sentenceFreq;

        public AutocompleteSystem(String[] sentences, int[] times) {
            this.root = new Trie();
            this.curNode = root;
            this.curChars = new StringBuilder();
            sentenceFreq = new HashMap<>();

            for (int i = 0; i < sentences.length; i++) {
                sentenceFreq.put(sentences[i], times[i]);
            }

            for (String sentence : sentences) {
                addToTrie(sentence);
            }
        }

        public List<String> input(char c) {
            if (c == '#') {
                String sentence = curChars.toString();
                sentenceFreq.merge(sentence, 1, Integer::sum);
                addToTrie(sentence);

                this.curNode = root;
                this.curChars = new StringBuilder();
                return new ArrayList<>();
            } else {
                curChars.append(c);
                if (curNode != null) {
                    curNode = curNode.children[charToIndex(c)];
                }
                return curNode != null ? curNode.topThree : new ArrayList<>();
            }
        }

        private void addToTrie(String sentence) {
            Trie node = root;
            int freq = sentenceFreq.get(sentence);
            char[] data = sentence.toCharArray();

            for (char c : data) {
                int index = charToIndex(c);
                if (node.children[index] == null) {
                    node.children[index] = new Trie();
                }
                node = node.children[index];

                insertIntoNewPosition(sentence, node, freq);
            }
        }

        private void insertIntoNewPosition(String sentence, Trie node, int freq) {
            List<String> topThree = node.topThree;
            topThree.remove(sentence);

            for (int i = 0; i < 3; i++) {
                if (i == topThree.size()) {
                    topThree.add(sentence);
                    break;
                }
                String preSentence = topThree.get(i);
                int preFreq = sentenceFreq.get(preSentence);

                if (preFreq < freq || preFreq == freq && sentence.compareTo(preSentence) < 0) {
                    topThree.add(i, sentence);
                    break;
                }
            }
            if (topThree.size() > 3) {
                topThree.remove(3);
            }
        }

        int charToIndex(char c) {
            return c == ' ' ? 26 : c - 'a';
        }

    }

    class Trie {
        List<String> topThree;
        Trie[] children;

        public Trie() {
            this.topThree = new ArrayList<>();
            children = new Trie[27];
        }
    }

}
