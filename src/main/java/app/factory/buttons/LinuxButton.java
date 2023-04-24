package app.factory.buttons;

import app.factory.buttons.Button;

public class LinuxButton implements Button {
    @Override
    public String info() {
        return "I am Linux styled button!";
    }

    @Override
    public String click() {
        return "Clicked on Linux button!";
    }
}
