package cars;

public class EliteTaxi extends Taxi {
    private String driverName;
    public EliteTaxi(String plate, String mark, String colour, int speed, double gas, int price, int passenger_count) {
        super(plate, mark, colour, speed, gas, price, passenger_count );
        Type = CarTypes.ELITETAXI;
        driverName = "Mykola";
    }
    @Override
    public String toString() {
        return super.toString() + ", Driver: " + driverName;
    }
}