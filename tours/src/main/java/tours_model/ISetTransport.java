package tours_model;

public interface ISetTransport {
    int AirplanePrice = 199;
    int BusPrice = 49;
    int TrainPrice = 99;
    int NoTransportPrice = 0;

    int setTransportType(int transportType) throws NoSuchTransportException;

}
