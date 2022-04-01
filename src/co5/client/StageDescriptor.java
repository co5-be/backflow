package co5.client;

import java.util.function.UnaryOperator;

final public class StageDescriptor<W extends WorkUnit, T extends Enum> {
    
    /**
     * These will run until the stage is shut
     */
    public final byte fullTimeWorkers;
    /**
     * These will run until the stage's queue
     * is empty
     */
    public final byte partTimeWorkers;
    /**
     * do work
     */
    public final UnaryOperator<W> task;
    /**
     * How often workers check for work 
     */
    public final short runnersPause;
    /**
     * how often master checks for work, it must be bigger than runners'
     */
    public final short masterPause;
    /**
     * how many can the next queue hold (Oversized payloads)
     */
    public final byte wip;
    /**
     * Label for various workers
     */    
    public final T Label;
    
    public final Logging logger;

    public StageDescriptor(byte ftw, byte ptw, UnaryOperator<W> t, short mp, short rp, byte w, T l){
        fullTimeWorkers = ftw;
        partTimeWorkers = ptw;
        task = t;
        runnersPause = rp;
        masterPause = mp;
        wip = w;
        Label = l;
        logger = new Logging(null);
    }
    
    public StageDescriptor(byte ftw, byte ptw, UnaryOperator<W> t, short mp, short rp, T l){
        fullTimeWorkers = ftw;
        partTimeWorkers = ptw;
        task = t;
        runnersPause = rp;
        masterPause = mp;
        wip = 0;
        Label = l;
        logger = new Logging(null);
    }

}