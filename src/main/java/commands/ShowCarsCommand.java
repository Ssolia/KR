package commands;

import cars.TaxoPark;

public class ShowCarsCommand implements Command {
    private TaxoPark taxoPark;

    public ShowCarsCommand(TaxoPark taxoPark) {
        this.taxoPark = taxoPark;
    }

    @Override
    public void execute(String params) {
        taxoPark.Show();
    }

    @Override
    public String getCommandName() {
        return "show";
    }
}