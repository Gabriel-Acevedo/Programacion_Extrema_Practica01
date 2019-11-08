package lasdamasrefactoring.views;

import lasdamasrefactoring.controllers.StartController;

public class StartView extends SubView {

    public StartView(){
        super();
    }

    public void interact(StartController startController) {
        this.console.writeln(MessageView.TITLE.getMessage());
        new GameView().write(startController);
        startController.start();
    }
}
