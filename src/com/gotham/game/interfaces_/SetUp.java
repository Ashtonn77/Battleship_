package com.gotham.game.interfaces_;

import com.gotham.game.validation_.classes_.AlphaNumericChecker;
import com.gotham.game.validation_.classes_.BoundaryValidator;

public interface SetUp {

    String[] ships = {"Destroyer", "Cruiser", "Submarine", "Battleship", "Aircraft Carrier"};
    
    static void placeShips(){
        
        try{
            
            String[] userInput = UserInput.getInput();
            
            //TODO: if userInput > 2 -> invalid


            
            if(!new AlphaNumericChecker().validate(
                    userInput[0].charAt(0),
                    userInput[1].charAt(0),
                    userInput[0].charAt(1),
                    userInput[1].charAt(1))){

                //TODO: handle case
                
            }
            
            int rowStart = (int)Character.toUpperCase(userInput[0].charAt(0)) - 65;
            int rowEnd = (int)Character.toUpperCase(userInput[1].charAt(0)) - 65;

            int columnStart = Integer.parseInt(userInput[0].substring(1));
            int columnEnd = Integer.parseInt(userInput[1].substring(1));            
            
            
            if(!new BoundaryValidator().validate(rowStart, rowEnd, columnStart, columnEnd)){
                //TODO: handle case
            }
            
            //TODO: check if length is valid for current length of ship
            
            //TODO: check if ship is placed to close to another

                        
        }catch(Exception e){
            
            //TODO: handle exception
        }        
        
    }
    
}
