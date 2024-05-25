package commands;

import cars.TaxoPark;

public class SortByGasCommand implements Command {
    private TaxoPark taxoPark;

    public SortByGasCommand(TaxoPark taxoPark) {
        this.taxoPark = taxoPark;
    }

    @Override
    public void execute(String params) {
        taxoPark.SortByGas();
    }

    @Override
    public String getCommandName() {
        return "sort";
    }
}