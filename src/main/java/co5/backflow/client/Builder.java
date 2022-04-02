package co5.backflow.client;

import java.util.ArrayList;
import java.util.UUID;
import java.util.function.Function;

public interface Builder<W extends WorkUnit, T extends Enum> {
    public ArrayList<StageDescriptor<W,T>> build();
    public Function<String,Boolean> getAuthorizer();
    public Function<UUID,W> getWorkUnitFactory();
}
