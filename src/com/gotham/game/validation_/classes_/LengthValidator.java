package com.gotham.game.validation_.classes_;

import com.gotham.game.helper.classes_.SetUp;
import com.gotham.game.validation_.interfaces_.Validator;

public class LengthValidator extends SetUp implements Validator {
    
    @Override
    public boolean validate(int rowStart, int rowEnd, int columnStart, int columnEnd) {
        
        int horizontalLength = Math.abs(rowStart - rowEnd) + 1;
        int verticalLength = Math.abs(columnStart - columnEnd) + 1;

        if(ships[shipIdx].equals("Cruiser") && horizontalLength == 3 || verticalLength == 3)
            return true;
        
        return horizontalLength == shipSize || verticalLength == shipSize;
        
    }

    @Override
    public boolean validate(char rowStart, char rowEnd, char columnStart, char columnEnd) {
        return false;
    }
}
