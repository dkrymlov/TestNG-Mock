package app.factory.labels;

import app.factory.labels.Label;

public class MacOsLabel implements Label {
    @Override
    public String info() {
        return "I am MacOs styled label!";
    }
}
