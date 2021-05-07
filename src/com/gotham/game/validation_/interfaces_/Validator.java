package com.gotham.game.validation_.interfaces_;

public interface Validator {
    
    boolean validate(int rowStart, int rowEnd, int columnStart, int columnEnd);

    boolean validate(char rowStart, char rowEnd, char columnStart, char columnEnd);
    
}
