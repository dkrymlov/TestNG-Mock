package app.factory.factories;

import app.factory.buttons.Button;
import app.factory.buttons.WindowsButton;
import app.factory.labels.Label;
import app.factory.labels.WindowsLabel;
import org.testng.annotations.Factory;

public class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Label createLabel() {
        return new WindowsLabel();
    }
}
