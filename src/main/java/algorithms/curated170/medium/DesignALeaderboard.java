package algorithms.curated170.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class DesignALeaderboard {

    public static class LeaderboardSimple {
        public HashMap<Integer, Integer> leaderboard = new HashMap<>();

        public void addScore(int id, int score) {
            if (leaderboard.get(id) != null) {
                score += leaderboard.get(id);
            }
            leaderboard.put(id, score);
        }

        public int top(int K) {
            ArrayList<Integer> list = new ArrayList<>(leaderboard.values());
            Collections.sort(list, Collections.reverseOrder());
            int total = 0;

            for (int i = 0; i < K; i++) {

                total = total + list.get(i);
            }
            return total;
        }
        public void reset(int playerId) {
            leaderboard.put(playerId, 0);
        }
    }
    public static class Leaderboard {
        /*To understand how this solution works, it is important
        to know about the linked list data structure, especially
        the doubly linked list.*/
        //This solution is faster

        class Node {
            int score; //total score of the player
            Node next; // node with the lower score
            Node prev; // node with the higher score
            
            //Constructor methods
            Node(int score) { 
                this.score = score;
            }
            Node(){}
        }
        
        Node head = new Node(); //A placeholder node, whose next node will be the top score.
        HashMap<Integer, Node> board = new HashMap<>(); //Key: player ids
        
        public Leaderboard() {//Constructor method
                
        }
        
        public void addScore(int playerId, int score) {
            if (board.containsKey(playerId)) {
                /*If we have a player with the same id 
                we add the score of the old player to the given score*/
                Node oldNode = board.get(playerId);
                score += oldNode.score;
                /*Since nodes are linked by next and prev variables, 
                we have to delete the old node with a method */
                remove(oldNode);
            }
            
            //We create a new node
            Node node = new Node(score);
            //Because of the links, we have to appropriately add this node in the method
            add(node);
            board.put(playerId, node);
        }
        
        public int top(int K) {
            Node curr = head.next; 
            int sum = 0;
            /*We loop through K nodes starting from head.next (the first node) 
            and add up the scores.*/
            while (curr != null && K > 0) {
                sum += curr.score;
                curr = curr.next;
                K--;
            }
            return sum;
        }
        
        public void reset(int playerId) {
            //We remove it from the board and the nodes
            if (board.containsKey(playerId)) {
                Node node = board.remove(playerId);
                remove(node);
            }
        }
        
        private void add(Node node) {
            //With this method, it is made possible that player scores are sorted.
            if (head.next == null) {
                //If this is null, that means that we do not have any data.
                //head's next becomes the node, which means that it becomes the top scored.
                head.next = node;
                node.prev = head;
                return;
            }
            /*Else, we iterate through the linked nodes until they
            end or we come across a score lower than ours */
            Node curr = head.next;
            Node prev = head;
            while (curr != null && curr.score > node.score) {
                prev = curr;
                curr = curr.next;
            }
            //When the loop ends, this means that we have found a suitable to insert our node in

            //We update  the links
            prev.next = node;
            node.next = curr;
            node.prev = prev;
            if (curr != null) {
                curr.prev = node;
            }
        }
        
        private void remove(Node node) {
            //This must be self-explanatory
            node.prev.next = node.next;
            if (node.next != null) {
                node.next.prev = node.prev;
            }
        }
    }

    public static void main(String[] args) {
        //Testing LeaderboardSimple
        System.out.println("LeaderboardSimple: ");
        var leaderboard0 = new LeaderboardSimple();
        leaderboard0.addScore(1, 94);
        leaderboard0.addScore(1, 45);
        leaderboard0.addScore(2, 95);
        leaderboard0.addScore(3, 96);
        System.out.println(leaderboard0.top(2));
        leaderboard0.reset(1);
        System.out.println(leaderboard0.top(3));
        leaderboard0.addScore(4, 98);
        System.out.println(leaderboard0.top(1));
        
        //Testing Leaderboard
        System.out.println("Leaderboard: ");
        var leaderboard1 = new Leaderboard();
        leaderboard1.addScore(1, 94);
        leaderboard1.addScore(1, 45);
        leaderboard1.addScore(2, 95);
        leaderboard1.addScore(3, 96);
        System.out.println(leaderboard1.top(2));
        leaderboard1.reset(1);
        System.out.println(leaderboard1.top(3));
        leaderboard1.addScore(4, 98);
        System.out.println(leaderboard1.top(1));
    }
}