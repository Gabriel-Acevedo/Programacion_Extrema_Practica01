/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lasdamasrefactoring.models;


/**
 *
 * @author Gabri
 */
public class Checkers {
    
    private Board board;
    private Turn turn;
    
    public Checkers(Board board, Turn turn){
        this.board=board;
        this.turn=turn;
    }
    
    public Error GeneralMovementCheck(Coordinate origin, Coordinate target){
        if (!origin.isValid() || !target.isValid()) {
            return Error.OUT_COORDINATE;
	}
        if (board.isEmpty(origin)) {
            return Error.EMPTY_ORIGIN;
	}
        if (!this.board.isEmpty(target)) {
            return Error.NOT_EMPTY_TARGET;
	}
        if (!origin.isDiagonal(target)) {
            return Error.NOT_DIAGONAL;
	}
        
        Color color = this.board.getColor(origin);
	if (this.turn.getColor() != color) {
            return Error.OPPOSITE_PIECE;
	}       
        return null;
    }
    
    public Error PieceMovementCheck(){
        return null;  
    } 
    
}
