package com.paratusSoftware.input;

public class UserInputs {

    boolean[] keyPressedMap;

    public UserInputs(){
        keyPressedMap = new boolean[500];
    }

    public boolean at(int keyCode){
        return keyPressedMap[keyCode];
    }

    public void press(int keyCode){
        keyPressedMap[keyCode] = true;
    }

    public void release(int keyCode){
        keyPressedMap[keyCode] = false;
    }
}
