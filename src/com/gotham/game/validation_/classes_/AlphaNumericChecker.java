package com.gotham.game.validation_.classes_;

import com.gotham.game.classes_.Grid;
import com.gotham.game.validation_.interfaces_.Validator;

public class AlphaNumericChecker implements Validator {
    
    @Override
    public boolean validate(int rowStart, int rowEnd, int columnStart, int columnEnd) {
        return false;
    }

    @Override
    public boolean validate(char rowStart, char rowEnd, char columnStart, char columnEnd) {
        return Character.isAlphabetic(rowStart)
                && Character.isAlphabetic(rowEnd)
                && Character.isDigit(columnStart)
                && Character.isDigit(columnEnd); 
    }

}
