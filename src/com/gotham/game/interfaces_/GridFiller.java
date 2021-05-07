package com.gotham.game.interfaces_;

import java.util.Arrays;

public interface GridFiller {
    
    static void fill(char[][] grid){

        for(char[] row : grid)
            Arrays.fill(row, '~');
    
        
    };

    static void fill(int[][] grid){

        for(int[] row : grid)
            Arrays.fill(row, 0);

    };
    
}
