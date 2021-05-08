package com.gotham.game.helper.classes_;

import com.gotham.game.interfaces_.UserInput;
import com.gotham.game.validation_.classes_.AlphaNumericChecker;
import com.gotham.game.validation_.classes_.BoundaryValidator;
import com.gotham.game.validation_.classes_.LengthValidator;
import com.gotham.game.validation_.classes_.ProximityValidator;

public class SetUp {

    protected String[] ships = {"Destroyer", "Cruiser", "Submarine", "Battleship", "Aircraft Carrier"};
    protected int shipIdx = ships.length - 1;
    protected int shipSize = ships.length;
    
    public void placeShips(){
        
        try{
            
            String[] userInput = UserInput.getInput();
            
            //TODO: if userInput > 2 -> invalid

            
//            if(!new AlphaNumericChecker().validate(
//                    userInput[0].charAt(0),
//                    userInput[1].charAt(0),
//                    userInput[0].charAt(1),
//                    userInput[1].charAt(1))){
//
//                //TODO: handle case
//                
//            }
            
            int rowStart = (int)Character.toUpperCase(userInput[0].charAt(0)) - 65;
            int rowEnd = (int)Character.toUpperCase(userInput[1].charAt(0)) - 65;

            int columnStart = Integer.parseInt(userInput[0].substring(1));
            int columnEnd = Integer.parseInt(userInput[1].substring(1));            
            
            
//            if(!new BoundaryValidator().validate(rowStart, rowEnd, columnStart, columnEnd)){
//                //TODO: handle case
//            }
            
//            
//            if(!new LengthValidator().validate(rowStart, rowEnd, columnStart, columnEnd)){
//                //TODO: test properly, handle case
//            }
            
            
            if(!new ProximityValidator().validate(rowStart, rowEnd, columnStart, columnEnd)){
                //TODO: test properly, handle case
            }
            

                        
        }catch(Exception e){
            
            //TODO: handle exception
        }        
        
    }
    
}
