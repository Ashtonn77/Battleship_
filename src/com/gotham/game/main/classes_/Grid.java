package com.gotham.game.main.classes_;

import com.gotham.game.interfaces_.GridFiller;

public class Grid {

    public static final int GRID_SIZE = 10;
    private char[] firstColumn = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};    
    private char[][] battlefield;
    private int[][] hitGrid;

    public char[] getFirstColumn() {
        return firstColumn;
    }
    public char[][] getBattlefield() {
        return battlefield;
    }
    public int[][] getHitGrid() {
        return hitGrid;
    }

    

    public Grid(){
        
        battlefield = new char[GRID_SIZE][GRID_SIZE];
        hitGrid = new int[GRID_SIZE][GRID_SIZE];
        
        GridFiller.fill(battlefield);
        GridFiller.fill(hitGrid);
        
    }
    
}
