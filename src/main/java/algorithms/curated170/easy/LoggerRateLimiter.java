package algorithms.curated170.easy;

import java.util.HashMap;
import java.util.Map;

 
public class LoggerRateLimiter {
class Logger {
    private Map<String, Integer> clock = new HashMap<>();
    
    /** Initialize your data structure here. */
    public Logger() {
        
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (timestamp < this.clock.getOrDefault(message, 0)) {
            return false;
        }
        this.clock.put(message, timestamp + 10);
        return true;
    }
}

}
