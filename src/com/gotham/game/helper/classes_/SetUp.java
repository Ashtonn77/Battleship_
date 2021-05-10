package com.gotham.game.helper.classes_;

import com.gotham.game.interfaces_.UserInput;
import com.gotham.game.main.classes_.Grid;
import com.gotham.game.validation_.classes_.AlphaNumericChecker;
import com.gotham.game.validation_.classes_.BoundaryValidator;
import com.gotham.game.validation_.classes_.LengthValidator;
import com.gotham.game.validation_.classes_.ProximityValidator;

public class SetUp extends Grid{

    protected static String[] ships = {"Destroyer", "Cruiser", "Submarine", "Battleship", "Aircraft Carrier"};
    protected static int shipIdx = ships.length - 1;
    protected static int shipSize = ships.length;
    private final String[] prompts;

    public SetUp(){ 

        prompts = new String[shipSize];
        for(int i = shipSize - 1; i >= 0; i--){
            
            if(i < 2){
                prompts[i] = "Enter the coordinates of the " + ships[i] + " (" + (i + 2) + " cells)";
                continue;
            }
            
            prompts[i] = "Enter the coordinates of the " + ships[i] + " (" + (i + 1) + " cells)";
        }
        
    }

    Grid gridInstance = new Grid();
            
    public void placeShips(){
       
        try{
            
            if(shipIdx < 0)
                return;
            
            System.out.println(prompts[shipIdx]);
            String[] userInput = UserInput.getInput();
            
            if(userInput.length > 2){
                System.out.println("Error: Invalid input! Try Again");
                placeShips();
            }
            
            
            if(!new AlphaNumericChecker().validate(
                    userInput[0].charAt(0),
                    userInput[1].charAt(0),
                    userInput[0].charAt(1),
                    userInput[1].charAt(1))){

                displayErrorMessageAndRerun("Error: Invalid input! Try Again");

            }
            
            int rowStart = (int)Character.toUpperCase(userInput[0].charAt(0)) - 65;
            int rowEnd = (int)Character.toUpperCase(userInput[1].charAt(0)) - 65;

            int columnStart = Integer.parseInt(userInput[0].substring(1))-1;
            int columnEnd = Integer.parseInt(userInput[1].substring(1))-1;            
            
            
            if(!new BoundaryValidator().validate(rowStart, rowEnd, columnStart, columnEnd))
                displayErrorMessageAndRerun("\nError! Wrong ship location! Try again:");            
            
            else if(!new LengthValidator().validate(rowStart, rowEnd, columnStart, columnEnd))
                displayErrorMessageAndRerun("\nError! Wrong length of the " + ships[shipIdx] + "! Try again:");           

            else if(!new ProximityValidator(gridInstance).validate(rowStart, rowEnd, columnStart, columnEnd))
                displayErrorMessageAndRerun("\nError! You placed it too close to another one. Try again:");
            
            else{                
             
                //TODO: update board
               new GridUtil(gridInstance).update(rowStart, rowEnd, columnStart, columnEnd);
                
                //TODO: display board
                new GridPrinter(gridInstance).print(gridInstance.getBattlefield());
                System.out.println("-----------------------");
               // new GridPrinter(gridInstance).print(gridInstance.getHitGrid());

               shipSize = shipIdx >= 2 ? shipSize - 1 : shipSize;                
               shipIdx--;
                
            }
            
            placeShips();
                        
        }catch(Exception e){ System.out.println(e.getMessage()); }        
        
    }
    
    private void displayErrorMessageAndRerun(String message){
        System.out.println(message);
        placeShips();
    }
    
    
    
}
