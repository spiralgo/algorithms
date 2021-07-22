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
            // assume that all parametes input are valid
            this.root = new Trie();
            this.curNode = root;
            this.curChars = new StringBuilder();
            sentenceFreq = new HashMap<>();

            for (int i = 0; i < sentences.length; i++) {
                sentenceFreq.put(sentences[i], times[i]);
            }

            for (String sentence : sentences) {
                buildTrie(sentence);
            }
        }

        public List<String> input(char c) {
            if (c == '#') {
                String sentence = curChars.toString();
                sentenceFreq.put(sentence, sentenceFreq.getOrDefault(sentence, 0) + 1);
                buildTrie(sentence);

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

        private void buildTrie(String sentence) {
            Trie node = root;
            int freq = sentenceFreq.get(sentence);

            for (char c : sentence.toCharArray()) {
                int index = charToIndex(c);
                if (node.children[index] == null) {
                    node.children[index] = new Trie();
                }
                node = node.children[index];

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
                if (topThree.size() > 3)
                    topThree.remove(3);
            }
        }
    }

    int charToIndex(char c)
    {
        return c == ' ' ? 26 : c - 'a';
    }
    class Trie {
        List<String> topThree;
        Trie[] children;

        public Trie() {
            this.topThree = new ArrayList<>();
            children = new Trie[27];// Trie[26] is for empty char ' '
        }
    }

}
