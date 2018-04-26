package vehicle_prototype;

public abstract class EnginePrototype {
    int id;

    public EnginePrototype(int id) {
        this.id = id;
    }
    public abstract void engineLaunch();
}
