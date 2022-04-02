package co5.backflow.client;

import java.util.ArrayList;
import java.util.UUID;
import java.util.function.Function;

public interface Builder<W extends WorkUnit, T extends Enum> {
    // An ordered list of steps to perform on each request/payload 
    public ArrayList<StageDescriptor<W,T>> build();
    //A Function object that will authorize if a request will be accepted
    public Function<String,Boolean> getAuthorizer();
    //A Function object that will provide work units
    public Function<UUID,W> getWorkUnitFactory();
}
