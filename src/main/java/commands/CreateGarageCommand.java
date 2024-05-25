package commands;

import cars.TaxoPark;

import commands.Command;

public class CreateGarageCommand implements Command {
    private TaxoPark taxoPark;

    public CreateGarageCommand(TaxoPark taxoPark) {
        this.taxoPark = taxoPark;
    }

    @Override
    public void execute(String params) {
        taxoPark = new TaxoPark(params);
        System.out.println("Гараж '" + params + "' створено.");
    }

    @Override
    public String getCommandName() {
        return "create";
    }
}
