package input;

import org.junit.jupiter.api.Test;

import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.*;

class InputMapTest {

    @Test
    public void testStoresInput() throws Exception {
        InputMap inputMap = new InputMap();

        assertFalse(inputMap.at(KeyEvent.VK_DOWN));

        inputMap.press(KeyEvent.VK_DOWN);

        assertTrue(inputMap.at(KeyEvent.VK_DOWN));

        inputMap.release(KeyEvent.VK_DOWN);

        assertFalse(inputMap.at(KeyEvent.VK_DOWN));
    }

}