package lasdamasrefactoring.controllers;

import java.util.HashMap;
import java.util.Map;
import lasdamasrefactoring.models.Session;
import lasdamasrefactoring.models.StateValue;


public class Logic {

    private Session session;
    private StartController startController;
    private PlayController playController;
    private ResumeController resumeController;
    private Map<StateValue, Controller> controllers;

    public Logic() {
        this.session = new Session();
        this.controllers = new HashMap<StateValue, Controller>();
        this.startController = new StartController(this.session);
        this.playController = new PlayController(this.session);
        this.resumeController = new ResumeController(this.session);
        this.controllers.put(StateValue.INITIAL, this.startController);
        this.controllers.put(StateValue.IN_GAME, this.playController);
        this.controllers.put(StateValue.FINAL, this.resumeController);
        this.controllers.put(StateValue.EXIT, null);
    }

    public Controller getController() {
        return this.controllers.get(this.session.getValueState());
    }

}
