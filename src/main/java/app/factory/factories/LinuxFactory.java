package app.factory.factories;

import app.factory.buttons.Button;
import app.factory.buttons.LinuxButton;
import app.factory.labels.Label;
import app.factory.labels.LinuxLabel;

public class LinuxFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new LinuxButton();
    }

    @Override
    public Label createLabel() {
        return new LinuxLabel();
    }
}
