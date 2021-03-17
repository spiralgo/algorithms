package algorithms;
 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import java.util.Queue;
import java.util.Set;

 

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.crawl("http://news.yahoo.com/news/topics/");
        
    }
    public List<String> crawl(String startUrl) {
        Set<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        String hostname = getHostname(startUrl);
        
        queue.offer(startUrl);
        set.add(startUrl);
        
        String[] listURL = new String[]{"http://news.yahoo.com",
              "http://news.yahoo.com/news",
              "http://news.yahoo.com/news/topics/",
              "http://news.google.com","http://news.yahoo.com/us"};
               
        
            for (String url : listURL) {
                if (url.contains(hostname) && !set.contains(url)) {
                    queue.offer(url);
                    set.add(url);
                }
            }
       
        
        return new ArrayList<String>(set);
    }
    
    private String getHostname(String Url) {
        String[] ss = Url.split("/");
        return ss[2];
    }
}