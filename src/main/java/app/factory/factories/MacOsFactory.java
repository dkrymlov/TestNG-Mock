package app.factory.factories;

import app.factory.buttons.Button;
import app.factory.buttons.MacOsButton;
import app.factory.labels.Label;
import app.factory.labels.MacOsLabel;

public class MacOsFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new MacOsButton();
    }

    @Override
    public Label createLabel() {
        return new MacOsLabel();
    }
}
