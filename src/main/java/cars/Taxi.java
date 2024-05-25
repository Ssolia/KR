package cars;

public class Taxi extends Car {
    public int getPassengerCount() {
        return passenger_count;
    }

    int passenger_count;
    public Taxi(String plate, String mark, String colour, int speed, double gas , int price, int passenger_count )
    {
        super(plate,  mark,  colour,  speed,  gas , price);
        this.passenger_count = passenger_count;
        Type = CarTypes.TAXI;
    }

    @Override
    public String toString() {
        return super.toString() + ", Passenger Count: " + passenger_count;
    }

}