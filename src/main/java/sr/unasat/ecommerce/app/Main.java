package sr.unasat.ecommerce.app;

import sr.unasat.ecommerce.handlers.ActionHandler;

public class Main {
    public static void main(String[] args) {
        ActionHandler actionHandler = new ActionHandler();
        actionHandler.runInteractiveApp();
    }
}
