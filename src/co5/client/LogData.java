package co5.client;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class LogData {
    public String co5Id;
    public String stage;
    public String message;
    public String[] items;
    public Map<String,Object> traceData = new HashMap<String, Object>();

    public Long executionTime;
    public Long startTime;
    
    public LogData(String s, String m, String[] i){
        stage = s;
        message = m;
        items = i;
    }

    public LogData(UUID id, String m){
        co5Id = id.toString();
        message = m;
    }
    
    public LogData(String s, String m){
        stage = s;
        message = m;
    }
    
    public LogData(String s, String id, String m){
        stage = s;
        co5Id = id;
        message = m;
    }
    
    public LogData(String s, String i, long et, long ldt){
        stage = s;
        co5Id = i;
        executionTime = et;
        startTime = ldt;
    }
}
