package cars;

public class TaxiBus extends Car {
    public double getVolume() {
        return volume;
    }

    public double getWeight() {
        return weight;
    }

    double volume; //Об'єм
    double weight; //Вага

    public TaxiBus(String plate, String mark, String colour, int speed, double gas, int price, double volume , double weight) {
        super(plate, mark, colour, speed, gas, price);
        this.volume = volume;
        this.weight = weight;

        Type = CarTypes.TAXIBUS;
    }
    @Override
    public String toString() {
        return super.toString() + ", Volume: " + volume + ", Weight: " + weight;
    }
}