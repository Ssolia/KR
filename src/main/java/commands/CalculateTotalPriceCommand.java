package commands;

import cars.TaxoPark;

public class CalculateTotalPriceCommand implements Command {
    private TaxoPark taxoPark;

    public CalculateTotalPriceCommand(TaxoPark taxoPark) {
        this.taxoPark = taxoPark;
    }

    @Override
    public void execute(String params) {
        System.out.println("Загальна вартість =  " + taxoPark.GetTotalPrice());
    }

    @Override
    public String getCommandName() {
        return "calculate";
    }
}