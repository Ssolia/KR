package cars;

import main.DatabaseManager;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Клас TaxoPark представляє таксопарк і містить функціонал для роботи з автомобілями.
public class TaxoPark  {
    public boolean showCarSetBySpeedCalled;
    public int showCarSetBySpeedMinSpeed;
    public int showCarSetBySpeedMaxSpeed;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Car> garage;

    Scanner scanf;
    private String garageName;

    public TaxoPark(String name)
    {
        scanf = new Scanner(System.in);
        this.name = name;
        garage = new ArrayList<>();

        garage.add(new Taxi("ВС 2054 АР","Nissan", "CYAN", 120, 15, 500000, 4));
        garage.add(new EliteTaxi("ВС 2054 АР","Nissan", "RED", 260, 5, 150000, 2));
        garage.add(new TaxiBus("ВС 2054 АР","Nissan", "WHITE", 100, 10, 800000, 8, 7));
    }


    private final static Logger LOGGER = Logger.getLogger(TaxoPark.class.getName());
    static {
        try {
            FileHandler fileHandler = new FileHandler("TaxoPark.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fileHandler);
        } catch (IOException e) {
            LOGGER.warning("Помилка у файлі: " + e.getMessage());
        }
    }

    public TaxoPark() {

    }

    public int GetTotalPrice()
    {
        int totalPrice = 0;
        for (Car car : garage)
        {
            totalPrice += car.getPrice();
        }

        LOGGER.info("Total Price: " + totalPrice);
        return totalPrice;
    }

//Метод для виведення інформації про автомобілі в таксопарку.

    public void Show() {
        System.out.println(name + ":");
        LOGGER.info("Taxopark info" + name + ":");
        for (Car car : garage) {
            System.out.println(car);
            LOGGER.info(car.toString());
        }
    }

    public void ShowCarSetBySpeed(int speedFrom, int speedTo)
    {
        System.out.println("Speed diapason (" + speedFrom + " - " + speedTo + ") :");
        LOGGER.info("Speed diapason (" + speedFrom + " - " + speedTo + ") :");
        for (Car car : garage)
        {
            if (car.getSpeed() >= speedFrom && car.getSpeed() <= speedTo) {
                car.Show();
                LOGGER.info(car.toString());
                System.out.println();
            }
        }


    }

    //Метод для інтерактивного додавання нового автомобіля до таксопарку.
    public void AddInteractive() {
        System.out.println("Номер :");
        String plate = scanf.nextLine();
        System.out.println("Марка:");
        String mark = scanf.nextLine();
        System.out.println("Колір:");
        String colour = scanf.nextLine();
        System.out.println("Швидкість:");
        int speed = scanf.nextInt();
        scanf.nextLine();
        System.out.println("Витрата пального:");
        double gas = scanf.nextDouble();
        System.out.println("Ціна:");
        int price = scanf.nextInt();
        scanf.nextLine();
        System.out.println("Виберіть тип авто\n1.Taxi\n2.EliteTaxi\n3.TaxiBus:");
        int choice = scanf.nextInt();
        scanf.nextLine();

        CarTypes type = CarTypes.values()[choice - 1];

        int passengerCount = 0;
        double volume = 0;
        double weight = 0;

        if (type == CarTypes.TAXI || type == CarTypes.ELITETAXI) {
            System.out.println("Кількість пасажирів:");
            passengerCount = scanf.nextInt();
            scanf.nextLine();
        } else if (type == CarTypes.TAXIBUS) {
            System.out.println("Вантажопідйомність:");
            weight = scanf.nextDouble();
            scanf.nextLine();
            System.out.println("Об'єм:");
            volume = scanf.nextDouble();
            scanf.nextLine();
        }

        Add(plate, mark, colour, speed, gas, price, type, passengerCount, volume, weight);
    }

    public void Add(String plate, String mark, String colour, int speed, double gas, int price, CarTypes type, int passengerCount, double volume, double weight) {
        Car newCar = null;
        switch (type) {
            case TAXI:
                newCar = new Taxi(plate, mark, colour, speed, gas, price, passengerCount);
                break;
            case ELITETAXI:
                newCar = new EliteTaxi(plate, mark, colour, speed, gas, price, passengerCount);
                break;
            case TAXIBUS:
                newCar = new TaxiBus(plate, mark, colour, speed, gas, price, volume, weight);
                break;
            default:
                throw new IllegalArgumentException("Невідомий тип автомобіля");
        }

        if (newCar != null) {
            garage.add(newCar);
            saveCarToDatabase(newCar);  // збереження в базу даних
            LOGGER.info("В гараж додана машина: " + newCar.toString());
        }

    }
    public void SortByGas()
    {
        System.out.println("Sort by gas");
        LOGGER.info("Sort by gas");
        garage.sort(Comparator.comparingDouble(Car::getGas));

        Show();
    }
    public void loadCarsFromDatabase() {
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM cars");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Car car = createCarFromResultSet(rs);
                garage.add(car);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveCarToDatabase(Car car) {
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO cars (type, plate, mark, colour, speed, gas, price, passenger_count, volume, weight) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

            stmt.setString(1, car.getType().name());
            stmt.setString(2, car.getPlate());
            stmt.setString(3, car.getMark());
            stmt.setString(4, car.getColour());
            stmt.setInt(5, car.getSpeed());
            stmt.setDouble(6, car.getGas());
            stmt.setInt(7, car.getPrice());

            if (car instanceof Taxi) {
                stmt.setInt(8, ((Taxi) car).getPassengerCount());
                stmt.setDouble(9, 0);
                stmt.setDouble(10, 0);
            } else if (car instanceof TaxiBus) {
                stmt.setInt(8, 0);
                stmt.setDouble(9, ((TaxiBus) car).getVolume());
                stmt.setDouble(10, ((TaxiBus) car).getWeight());
            } else {
                stmt.setInt(8, 0);
                stmt.setDouble(9, 0);
                stmt.setDouble(10, 0);
            }

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Car createCarFromResultSet(ResultSet rs) throws SQLException {
        String type = rs.getString("type");
        String plate = rs.getString("plate");
        String mark = rs.getString("mark");
        String colour = rs.getString("colour");
        int speed = rs.getInt("speed");
        double gas = rs.getDouble("gas");
        int price = rs.getInt("price");

        Car car;
        switch (CarTypes.valueOf(type)) {
            case TAXI:
                int passengerCount = rs.getInt("passenger_count");
                car = new Taxi(plate, mark, colour, speed, gas, price, passengerCount);
                break;
            case ELITETAXI:
                car = new EliteTaxi(plate, mark, colour, speed, gas, price, rs.getInt("passenger_count"));
                break;
            case TAXIBUS:
                double volume = rs.getDouble("volume");
                double weight = rs.getDouble("weight");
                car = new TaxiBus(plate, mark, colour, speed, gas, price, volume, weight);
                break;
            default:
                car = new Car(plate, mark, colour, speed, gas, price);
                break;
        }

        return car;
    }

}