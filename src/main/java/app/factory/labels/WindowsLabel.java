package app.factory.labels;

import app.factory.labels.Label;

public class WindowsLabel implements Label {
    @Override
    public String info() {
        return "I am Windows styled label!";
    }
}
