package app.factory.buttons;

import app.factory.buttons.Button;

public class WindowsButton implements Button {
    @Override
    public String info() {
        return "I am Windows styled button!";
    }

    @Override
    public String click() {
        return "Clicked on Windows button!";
    }
}
