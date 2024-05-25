package cars;

public class Car {
    public CarTypes Type = CarTypes.TAXI;
    protected String plate;
    protected String mark;
    protected String colour;
    protected int speed;
    protected double gas;
    protected int price;

    public Car() {}

    public Car(String plate, String mark, String colour, int speed, double gas, int price) {
        this.plate = plate;
        this.mark = mark;
        this.colour = colour;
        this.speed = speed;
        this.gas = gas;
        this.price = price;
    }

    public CarTypes getType() {
        return Type;
    }

    public void setType(CarTypes type) {
        Type = type;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getGas() {
        return gas;
    }

    public void setGas(double gas) {
        this.gas = gas;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Type: " + Type + ", Plate: " + plate + ", Mark: " + mark +
                ", Color: " + colour + ", Speed: " + speed + ", Gas: " + gas + ", Price: " + price;
    }

    public void Show() {
        System.out.print(this.toString());
    }
}
