package com.gotham.game.helper.classes_;

public class ShipUtil {

    private final String[] ships = {"Destroyer", "Cruiser", "Submarine", "Battleship", "Aircraft Carrier"}; 
    private int shipIdx; 
    private int shipSize; 
    
    public ShipUtil(){

        this.shipIdx = ships.length - 1;
        this.shipSize = ships.length;
        
    }

    public String[] getShips() {
        return ships;
    }

    public int getShipIdx() {
        return shipIdx;
    }

    public void setShipIdx(int shipIdx) {
        this.shipIdx = shipIdx;
    }

    public int getShipSize() {
        return shipSize;
    }

    public void setShipSize(int shipSize) {
        this.shipSize = shipSize;
    }
    
}
