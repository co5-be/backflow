package co5.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.logging.Logger;

public class Logging {
    
    private final Gson serializer;
    private final Logger log;
    
    public Logging() {
    	this(null);
    }
    
    public Logging(Logger l){
        serializer = new GsonBuilder().create();
        log = l;
    }
    
    public void print(LogData ld){
        if (log == null){
            System.out.println(serializer.toJson(ld));
        }
        else{
            log.info(serializer.toJson(ld));
        }
    }
}
