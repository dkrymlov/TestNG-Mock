package app.factory;

import app.factory.factories.GUIFactory;
import app.factory.factories.LinuxFactory;
import app.factory.factories.MacOsFactory;
import app.factory.factories.WindowsFactory;

public class Configurer {

    public Application configureApp() throws Exception {
        Application app;
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            factory = new MacOsFactory();
        } else if (osName.contains("windows")){
            factory = new WindowsFactory();
        }else if (osName.contains("linux")) {
            factory = new LinuxFactory();
        }else throw new Exception("System info is not defined properly!");
        app = new Application(factory);
        return app;
    }

}
