package com.gotham.game.main.classes_;

import com.gotham.game.helper.classes_.SetUp;
import com.gotham.game.helper.classes_.ShipUtil;

public class Main {

    public static void main(String[] args) {

       Grid gridInstance = new Grid();
       ShipUtil shipUtil = new ShipUtil(); 
       
       // new User().fire();
        new SetUp(gridInstance, shipUtil).placeShips();
        
        new User(1, gridInstance).fire();
        
    }
    
}
