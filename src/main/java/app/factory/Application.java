package app.factory;

import app.factory.buttons.Button;
import app.factory.factories.GUIFactory;
import app.factory.labels.Label;

public class Application {
    private Button button;
    private Label label;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        label = factory.createLabel();
    }

    public Button getButton() {
        return button;
    }

    public Label getLabel() {
        return label;
    }

    public String buttonClick(){
        return button.click();
    }

    public String getButtonInfo() {
        return button.info();
    }

    public String getLabelInfo() {
        return label.info();
    }

}
