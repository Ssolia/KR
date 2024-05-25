package main;

import cars.*;
import commands.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Головний клас програми
public class Main {
    public static void main(String[] args) {
        TaxoPark bolt = new TaxoPark("Bolt Taxi");
        Scanner scanner = new Scanner(System.in);
        Map<String, Command> commands = new HashMap<>();

        // Додавання команд до мапи
        commands.put("create", new CreateGarageCommand(bolt));
        commands.put("show", new ShowCarsCommand(bolt));
        commands.put("add", new AddCarCommand(bolt));
        commands.put("calculate", new CalculateTotalPriceCommand(bolt));
        commands.put("sort", new SortByGasCommand(bolt));
        commands.put("find", new FindCarBySpeedCommand(bolt));

        while (true) {
            System.out.println("Введіть команду (або help для довідки): ");
            String input = scanner.nextLine();

            // Розділення введення на команду та параметри
            String[] inputParts = input.split(" ", 2);
            String commandName = inputParts[0].toLowerCase();
            String params = inputParts.length > 1 ? inputParts[1] : "";

            if (commandName.equals("help")) {
                // Виведення довідки по командам
                System.out.println("Список команд:");
                for (Command command : commands.values()) {
                    System.out.println(command.getCommandName());
                }
            } else if (commands.containsKey(commandName)) {
                // Виклик відповідної команди
                commands.get(commandName).execute(params);
            } else {
                // Невідома команда
                System.out.println("Невідома команда. Введіть 'help' для списку команд.");
            }
        }
    }
}
