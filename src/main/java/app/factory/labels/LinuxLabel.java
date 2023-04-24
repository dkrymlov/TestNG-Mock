package app.factory.labels;

import app.factory.labels.Label;

public class LinuxLabel implements Label {
    @Override
    public String info() {
        return "I am Linux styled label!";
    }
}
