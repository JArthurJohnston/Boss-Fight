package com.paratusSoftware.input;

import java.awt.event.KeyEvent;

public enum InputDirection {
    UP, UP_RIGHT, UP_LEFT,
    DOWN, DOWN_RIGHT, DOWN_LEFT,
    RIGHT, LEFT, NONE;

    public static InputDirection getDirectionFrom(final UserInputs inputs) {
        if (inputs.at(KeyEvent.VK_DOWN) & inputs.at(KeyEvent.VK_RIGHT)) {
            return DOWN_RIGHT;
        } else if (inputs.at(KeyEvent.VK_DOWN) & inputs.at(KeyEvent.VK_LEFT)) {
            return DOWN_LEFT;
        } else if (inputs.at(KeyEvent.VK_UP) & inputs.at(KeyEvent.VK_RIGHT)) {
            return UP_RIGHT;
        } else if (inputs.at(KeyEvent.VK_UP) & inputs.at(KeyEvent.VK_LEFT)) {
            return UP_LEFT;
        } else if (inputs.at(KeyEvent.VK_UP)) {
            return UP;
        } else if (inputs.at(KeyEvent.VK_DOWN)) {
            return DOWN;
        } else if (inputs.at(KeyEvent.VK_RIGHT)) {
            return RIGHT;
        } else if (inputs.at(KeyEvent.VK_LEFT)) {
            return LEFT;
        } else {
            return NONE;
        }
    }
}
