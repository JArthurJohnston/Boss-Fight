package input;

import org.junit.jupiter.api.Test;

import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.*;

class UserInputsTest {

    @Test
    public void testStoresInput() throws Exception {
        UserInputs userInputs = new UserInputs();

        assertFalse(userInputs.at(KeyEvent.VK_DOWN));

        userInputs.press(KeyEvent.VK_DOWN);

        assertTrue(userInputs.at(KeyEvent.VK_DOWN));

        userInputs.release(KeyEvent.VK_DOWN);

        assertFalse(userInputs.at(KeyEvent.VK_DOWN));
    }

}