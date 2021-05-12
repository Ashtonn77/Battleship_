package com.gotham.game.validation_.classes_;

import com.gotham.game.helper.classes_.ShipUtil;
import com.gotham.game.validation_.interfaces_.Validator;

public class LengthValidator implements Validator {
    
    ShipUtil shipUtil;
    public LengthValidator(ShipUtil shipUtil){
        this.shipUtil = shipUtil;
    }
    
    @Override
    public boolean validate(int rowStart, int rowEnd, int columnStart, int columnEnd) {
        
        int verticalLength = Math.abs(rowStart - rowEnd) + 1;
        int horizontalLength = Math.abs(columnStart - columnEnd) + 1;

        if(shipUtil.getShips()[shipUtil.getShipIdx()].equals("Cruiser") && (horizontalLength == 3 || verticalLength == 3))
            return true;
        System.out.println(shipUtil.getShips()[shipUtil.getShipIdx()]+ "::" + shipUtil.getShipSize() + "::" + horizontalLength + "::" + verticalLength);
        return horizontalLength == shipUtil.getShipSize() || verticalLength == shipUtil.getShipSize();
        
    }

    @Override
    public boolean validate(char rowStart, char rowEnd, char columnStart, char columnEnd) {
        return false;
    }
}
