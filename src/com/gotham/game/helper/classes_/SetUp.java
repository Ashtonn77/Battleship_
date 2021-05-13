package com.gotham.game.helper.classes_;

import com.gotham.game.interfaces_.UserInput;
import com.gotham.game.main.classes_.Grid;
import com.gotham.game.validation_.classes_.AlphaNumericChecker;
import com.gotham.game.validation_.classes_.BoundaryValidator;
import com.gotham.game.validation_.classes_.LengthValidator;
import com.gotham.game.validation_.classes_.ProximityValidator;

public class SetUp{

    private final String[] prompts;

    Grid gridInstance;
    ShipUtil shipUtil;
    
    public SetUp(Grid gridInstance, ShipUtil shipUtil){

        this.gridInstance = gridInstance;
        this.shipUtil = shipUtil;
        
        prompts = new String[this.shipUtil.getShipSize()];
        for(int i = shipUtil.getShipSize() - 1; i >= 0; i--){

            if(i < 2){
                prompts[i] = "Enter the coordinates of the " + this.shipUtil.getShips()[i] + " (" + (i + 2) + " cells)";
                continue;
            }

            prompts[i] = "Enter the coordinates of the " + this.shipUtil.getShips()[i] + " (" + (i + 1) + " cells)";
            
        }
        
    }
               
    public void placeShips(){

        try{
            //TODO: change to < 0
            if(shipUtil.getShipIdx() < 4)
                return;

            System.out.println(prompts[shipUtil.getShipIdx()]);
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

            else if(!new LengthValidator(shipUtil).validate(rowStart, rowEnd, columnStart, columnEnd))
                displayErrorMessageAndRerun("\nError! Wrong length of the " + shipUtil.getShips()[shipUtil.getShipIdx()] + "! Try again:");           

            else if(!new ProximityValidator(gridInstance).validate(rowStart, rowEnd, columnStart, columnEnd))
                displayErrorMessageAndRerun("\nError! You placed it too close to another one. Try again:");

            else{                

                //TODO: update board
               new GridUtil(gridInstance, shipUtil).update(rowStart, rowEnd, columnStart, columnEnd);

                //TODO: display board
               new GridPrinter(gridInstance).print(gridInstance.getBattlefield());
   
               
               int shipSize = shipUtil.getShipIdx() >= 2 ? shipUtil.getShipSize() - 1 : shipUtil.getShipSize();
               shipUtil.setShipIdx(shipUtil.getShipIdx() - 1);
               shipUtil.setShipSize(shipSize);

            }

            placeShips();
                        
        }catch(Exception e){ System.out.println("Hit"); }        
        
    }

    //TODO: duplicated code -> fix
    private void displayErrorMessageAndRerun(String message){
        System.out.println(message);
        placeShips();
    }
    
    
    
}
