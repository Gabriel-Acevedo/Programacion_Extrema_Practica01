package lasdamasrefactoring.views;

import lasdamasrefactoring.controllers.Controller;
import lasdamasrefactoring.models.Color;
import lasdamasrefactoring.models.Coordinate;



public class GameView extends WithConsoleView {

    public void write(Controller controller) {
        final int DIMENSION = controller.getDimension();
        this.writeNumbersLine(DIMENSION);
        for(int i=0; i<DIMENSION; i++){
            this.console.write((i+1)+"");
            for(int j=0; j<DIMENSION; j++){
                Color color = controller.getColor(new Coordinate(i,j));
                if (color == null){
                    this.console.write(MessageView.COLORSChar[2]);
                } else {
                    this.console.write(MessageView.COLORSChar[color.ordinal()]);
                }
            }
            this.console.writeln((i+1)+"");
        }
        this.writeNumbersLine(DIMENSION);
    }

    private void writeNumbersLine(final int DIMENSION) {
        this.console.write(" ");
        for(int i=0; i<DIMENSION; i++){
            this.console.write((i+1)+"");
        }
        this.console.writeln();
    }

}
