package com.gotham.game.helper.classes_;

import com.gotham.game.interfaces_.Update;
import com.gotham.game.main.classes_.Grid;

public class GridUtil implements Update {
    
    private int min;
    private int max;
    Grid grid;
    ShipUtil shipUtil;
    
    public GridUtil(Grid grid, ShipUtil shipUtil){
        this.grid = grid;
        this.shipUtil = shipUtil;
    }
    
    public GridUtil(int min, int max){
        
        this.min = min;
        this.max = max;
        
    }

    private int[] getMinMax(GridUtil util){

        int t = Math.max(util.min, util.max);
        util.min = Math.min(util.min, util.max);
        util.max = t;

        return new int[]{util.min, util.max};

    }
    
    @Override
    public void update(int rowStart, int rowEnd, int columnStart, int columnEnd) {
            
            int[] rows = getMinMax(new GridUtil(rowStart, rowEnd));
            int[] columns = getMinMax(new GridUtil(columnStart, columnEnd));
                   
            for(int i = rows[0]; i <= rows[1]; i++)
                for (int j = columns[0]; j <= columns[1]; j++) {
                    grid.getBattlefield()[i][j] = 'O';
                    grid.getHitGrid()[i][j] = shipUtil.getShipIdx() < 1 ? 1 : shipUtil.getShipSize();
                }
    }
}
