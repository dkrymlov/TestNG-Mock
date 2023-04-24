package com.krymlov.tests;

import app.factory.Application;
import app.factory.Configurer;
import app.factory.buttons.LinuxButton;
import app.factory.buttons.MacOsButton;
import app.factory.buttons.WindowsButton;
import app.factory.factories.GUIFactory;
import app.factory.factories.LinuxFactory;
import app.factory.factories.MacOsFactory;
import app.factory.factories.WindowsFactory;
import app.factory.labels.LinuxLabel;
import app.factory.labels.MacOsLabel;
import app.factory.labels.WindowsLabel;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.*;

import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

public class GUIFactoryTests {

    @Mock
    Configurer guiConfig;

    @BeforeClass
    public void init(){
        MockitoAnnotations.openMocks(this);
    }

    @BeforeMethod
    public void checkMock(){
        assertNotNull(guiConfig);
    }

    @DataProvider(name = "factory-provider")
    public Object[][] dpMethod(){
        return new Object[][]
                {{new WindowsFactory(), "I am Windows styled button!", "I am Windows styled label!"},
                {new LinuxFactory(), "I am Linux styled button!", "I am Linux styled label!"},
                {new MacOsFactory(), "I am MacOs styled button!", "I am MacOs styled label!"} };
    }

    @Test(groups = "factory")
    public void createWindowsStyledApplication() throws Exception {

        when(guiConfig.configureApp()).thenReturn(spy(new Application(new WindowsFactory())));

        Application windowsApp = guiConfig.configureApp();

        verify(guiConfig, atLeast(2)).configureApp();

        assertTrue((windowsApp.getButton() instanceof WindowsButton));
        assertTrue((windowsApp.getLabel() instanceof WindowsLabel));

        verify(windowsApp).getButton();
        verify(windowsApp).getLabel();
    }

    @Test(groups = "factory")
    public void createMacOsStyledApplication() throws Exception {

        when(guiConfig.configureApp()).thenReturn(spy(new Application(new MacOsFactory())));

        Application macOsApp = guiConfig.configureApp();

        verify(guiConfig, atLeast(2)).configureApp();

        assertTrue((macOsApp.getButton() instanceof MacOsButton));
        assertTrue((macOsApp.getLabel() instanceof MacOsLabel));

        verify(macOsApp).getButton();
        verify(macOsApp).getLabel();
    }

    @Test(groups = "factory")
    public void createLinuxStyledApplication() throws Exception {

        when(guiConfig.configureApp()).thenReturn(spy(new Application(new LinuxFactory())));

        Application linuxApp = guiConfig.configureApp();

        verify(guiConfig, atLeast(2)).configureApp();

        assertTrue((linuxApp.getButton() instanceof LinuxButton));
        assertTrue((linuxApp.getLabel() instanceof LinuxLabel));

        verify(linuxApp).getButton();
        verify(linuxApp).getLabel();
    }

    @Test(expectedExceptions = Exception.class, priority = 1,groups = "factory")
    public void createUnknownSystemStyledApplication() throws Exception {
        when(guiConfig.configureApp()).thenThrow(new Exception("Unknown System!"));

        Application application = guiConfig.configureApp();

        verify(guiConfig, times(2)).configureApp();

        assertTrue((application.getButton() instanceof WindowsButton));
        assertTrue((application.getLabel() instanceof LinuxLabel));
    }

    @Test(dataProvider = "factory-provider", groups = "factory")
    public void checkSystemFunctions(GUIFactory factory, String buttonMessage, String labelMessage) throws Exception {
        when(guiConfig.configureApp()).thenReturn(spy(new Application(factory)));

        Application application = guiConfig.configureApp();

        verify(guiConfig, atLeast(1)).configureApp();

        assertNotNull(application.getButton());
        assertNotNull(application.getLabel());

        verify(application).getButton();
        verify(application).getLabel();

        assertEquals(buttonMessage, application.getButtonInfo());
        assertEquals(labelMessage, application.getLabelInfo());

        verify(application).getButtonInfo();
        verify(application).getLabelInfo();
    }

    @Test(groups = "factory")
    public void mockApplicationInfoTests(){

        Application application = mock(Application.class);
        assertNotNull(application);
        assertNull(application.getButton());
        assertNull(application.getLabel());

        when(application.getButton()).thenReturn(new MacOsButton());
        assertEquals("I am MacOs styled button!",application.getButton().info());
        when(application.getLabel()).thenReturn(new LinuxLabel());
        assertEquals("I am Linux styled label!", application.getLabel().info());

    }

}
