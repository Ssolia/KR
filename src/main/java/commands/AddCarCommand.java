package commands;

import cars.TaxoPark;

public class AddCarCommand implements Command {
    private TaxoPark taxoPark;

    public AddCarCommand(TaxoPark taxoPark) {
        this.taxoPark = taxoPark;
    }

    @Override
    public void execute(String params) {
        taxoPark.AddInteractive();
    }

    @Override
    public String getCommandName() {
        return "add";
    }
}
