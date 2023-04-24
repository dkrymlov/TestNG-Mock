package app.factory.factories;

import app.factory.buttons.Button;
import app.factory.labels.Label;

public interface GUIFactory {
    Button createButton();
    Label createLabel();
}
