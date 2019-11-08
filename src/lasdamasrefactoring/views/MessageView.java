/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lasdamasrefactoring.views;

/**
 *
 * @author Gabri
 */
public enum MessageView {
    TITLE("Las Damas"),
    MOVE("Mueven las ##color:"),
    RESUME("¿Queréis jugar otra"),
    END_GAME("Derrota!!! No puedes mover tus fichas!!!");
    
    private String message;
    
    private MessageView(String message) {
	this.message = message;
    }
    
    public String getMessage() {
    	return this.message;
    }
}
