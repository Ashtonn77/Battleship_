package com.gotham.game.main.classes_;

import com.gotham.game.interfaces_.GridFiller;

public class Grid {

    public static final int GRID_SIZE = 10;
    private final char[] firstColumn = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};    
    private final char[][] battlefield;
    private final char[][] hitGrid;
    private final int[][] pointGrid;

    private final char[][] blankGrid;

    public char[] getFirstColumn() {
        return firstColumn;
    }
    public char[][] getBattlefield() {
        return battlefield;
    }
    public char[][] getHitGrid() {
        return hitGrid;
    }
    public int[][] getPointGrid() { return pointGrid; }
    public char[][] getBlankGrid() { return blankGrid; }

    public Grid(){
        
        battlefield = new char[GRID_SIZE][GRID_SIZE];
        hitGrid = new char[GRID_SIZE][GRID_SIZE];
        pointGrid = new int[GRID_SIZE][GRID_SIZE];
        blankGrid = new char[GRID_SIZE][GRID_SIZE];
        
        GridFiller.fill(battlefield);
        GridFiller.fill(hitGrid);
        GridFiller.fill(pointGrid);
        GridFiller.fill(blankGrid);
        
    }
    
}
