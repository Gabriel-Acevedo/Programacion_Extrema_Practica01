package lasdamasrefactoring.views;

import lasdamasrefactoring.controllers.PlayController;
import lasdamasrefactoring.models.Coordinate;
import lasdamasrefactoring.models.Error;



public class PlayView extends WithConsoleView {

    public PlayView(){
        super();
    }

    public void interact(PlayController playController) {
        String color = MessageView.COLORS[playController.getColor().ordinal()];
        Error error = null;
        GameView gameView = new GameView();
        do {
            String command = this.console.readString(MessageView.MOVE.getMessage().replaceFirst("##color", color));
            int origin = Integer.parseInt(command.substring(0, 2));
            int target = Integer.parseInt(command.substring(3, 5));
            error = playController.move(new Coordinate(origin/10-1, origin%10-1), new Coordinate(target/10-1, target%10-1));
            if (error != null){
                console.writeln("Error!!!" + error.name());
            gameView.write(playController);
            }
        } while (error != null); 
        if (playController.isBlocked()){
            this.console.write(MessageView.END_GAME.getMessage());
        }
    }

}