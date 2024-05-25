package commands;

import cars.TaxoPark;

import commands.Command;
import java.util.Scanner;

public class FindCarBySpeedCommand implements Command {
    private TaxoPark taxoPark;

    public FindCarBySpeedCommand(TaxoPark taxoPark) {
        this.taxoPark = taxoPark;
    }

    @Override
    public void execute(String params) {
        Scanner scanner = new Scanner(params);
        System.out.println("Введіть швидкість від: ");
        int SpeedFrom = scanner.nextInt();
        System.out.println("Введіть швидкість до: ");
        int SpeedTo = scanner.nextInt();
        taxoPark.ShowCarSetBySpeed(SpeedFrom, SpeedTo);
    }

    @Override
    public String getCommandName() {
        return "find";
    }
}