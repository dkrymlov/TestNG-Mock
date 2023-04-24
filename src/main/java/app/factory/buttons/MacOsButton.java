package app.factory.buttons;

import app.factory.buttons.Button;

public class MacOsButton implements Button {
    @Override
    public String info() {
        return "I am MacOs styled button!";
    }

    @Override
    public String click() {
        return "Clicked on MacOs button!";
    }
}
