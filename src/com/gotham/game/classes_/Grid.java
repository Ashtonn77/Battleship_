package com.gotham.game.classes_;

import com.gotham.game.interfaces_.GridFiller;

public class Grid {

    public static final int GRID_SIZE = 10;
    char[] firstColumn = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
    
    protected char[][] battlefield;
    protected int[][] hitGrid;

    public Grid(){
        
        battlefield = new char[GRID_SIZE][GRID_SIZE];
        hitGrid = new int[GRID_SIZE][GRID_SIZE];
        
        GridFiller.fill(battlefield);
        GridFiller.fill(hitGrid);
        
    }
    
}
