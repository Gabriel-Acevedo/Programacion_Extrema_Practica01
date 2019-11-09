/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lasdamasrefactoring;

import lasdamasrefactoring.controllers.Controller;
import lasdamasrefactoring.controllers.Logic;
import lasdamasrefactoring.views.View;

/**
 *
 * @author Gabri
 */
public class LasDamasRefactoring {

 private View view;

    private Logic logic;

    private LasDamasRefactoring(){
        this.view = new View();
        this.logic = new Logic();
    }

    private void play() {
        Controller controller;
        do {
            controller = this.logic.getController();
            if (controller != null){
                this.view.interact(controller);
            }
        } while (controller != null); 
    }

    public static void main(String[] args){
        new LasDamasRefactoring().play();
    }
    
}
