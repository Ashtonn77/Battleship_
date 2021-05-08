package com.gotham.game.validation_.classes_;

import com.gotham.game.main.classes_.Grid;
import com.gotham.game.validation_.interfaces_.Validator;

public class BoundaryValidator implements Validator {
    
    @Override
    public boolean validate(int rowStart, int rowEnd, int columnStart, int columnEnd) {
        
        return rowStart > 0 && rowStart < Grid.GRID_SIZE
                && rowEnd > 0 && rowEnd < Grid.GRID_SIZE
                && columnStart > 0 && columnStart < Grid.GRID_SIZE
                && columnEnd > 0 && columnEnd < Grid.GRID_SIZE;
        
    }

    @Override
    public boolean validate(char rowStart, char rowEnd, char columnStart, char columnEnd) {
        return false;
    }
}
