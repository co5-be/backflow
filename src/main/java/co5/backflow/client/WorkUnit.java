package co5.backflow.client;

public abstract class WorkUnit {
    public final long startTime;
    public final String id;
    public boolean stop;
    public boolean done;    
    public byte[] payload;
    public boolean retry;
    public int httpStatus;
    
    public WorkUnit(){
        startTime = System.currentTimeMillis();
        stop = true;
        id = null;
    }
    
    public WorkUnit(boolean s, String i){
        startTime = System.currentTimeMillis();
        stop = s;
        id = i;
    }
}
