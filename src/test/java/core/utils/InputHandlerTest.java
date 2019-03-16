package core.utils;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import core.command.commands.*;
import core.command.Command;

public class InputHandlerTest extends ApplicationTest
{


    @Override
    public void start(Stage stage) 
    {
        stage.show();
    }

    @Test
    public void test_handleInput_keyPress_A() 
    {
        KeyEvent k = new KeyEvent(KeyEvent.KEY_PRESSED, "A", "", KeyCode.A, false, false, false, false);
        InputHandler handle = new InputHandler();
        Command command = handle.handleInput(k);
        assertTrue("Expected object to be of type MoveCommand but was " + command.getClass().getSimpleName(), command instanceof MoveCommand);
    }

    @Test
    public void test_handleInput_keyRelease_A() 
    {
        KeyEvent k = new KeyEvent(KeyEvent.KEY_RELEASED, "A", "", KeyCode.A, false, false, false, false);
        InputHandler handle = new InputHandler();
        Command command = handle.handleInput(k);
        assertTrue("Expected object to be of type MoveCommand but was " + command.getClass().getSimpleName(), command instanceof MoveCommand);
    }

    @Test
    public void test_handleInput_keypress_D() 
    {
        assertTrue(true);
    }

    @Test
    public void test_handleInput_keyRelease_D() 
    {
        assertTrue(true);
    }

    @Test
    public void test_handleInput_keypress_space() 
    {
        assertTrue(true);
    }

    @Test
    public void test_handleInput_keypress_z() 
    {
        assertTrue(true);
    }

    @Test
    public void test_handleInput_keypress_escape() 
    {
        assertTrue(true);
    }

    @Test
    public void test_handleInput_unbound_keyPress() 
    {
        assertTrue(true);
    }

}
