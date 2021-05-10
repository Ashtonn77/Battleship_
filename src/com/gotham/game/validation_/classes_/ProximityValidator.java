package com.gotham.game.validation_.classes_;

import com.gotham.game.main.classes_.Grid;
import com.gotham.game.validation_.interfaces_.Validator;

public class ProximityValidator implements Validator{
    
    private int min;
    private int max;
    Grid grid;
    
    public ProximityValidator(Grid grid) { 
        this.grid = grid;
    }

    public ProximityValidator(int min, int max) {
        this.min = min;
        this.max = max;
    }

    private int[] getMinMax(ProximityValidator pv){

        int t = Math.max(pv.min, pv.max);
        pv.min = Math.min(pv.min, pv.max);
        pv.max = t;

        return new int[]{pv.min, pv.max};

    }
    
    @Override
    public boolean validate(int rowStart, int rowEnd, int columnStart, int columnEnd) {
                
        int[] rows = getMinMax(new ProximityValidator(rowStart, rowEnd));
        int[] columns = getMinMax(new ProximityValidator(columnStart, columnEnd));

                for(int i = rows[0] - 1; i <= rows[1] + 1; i++){
                    
                        if(i < 0) continue; if(i > 9) return true;
                    
                    for(int j = columns[0] - 1; j <= columns[1] + 1; j++){

                        if(j < 0) continue; if(j > 9) return true;
                        
                        if(grid.getBattlefield()[i][j] == 'O')
                            return false;
                        
                    }
                                        
                } 
        
        return true;
    }

    @Override
    public boolean validate(char rowStart, char rowEnd, char columnStart, char columnEnd) {
        return false;
    }

    
}
