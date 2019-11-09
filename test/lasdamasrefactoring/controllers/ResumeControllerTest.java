package lasdamasrefactoring.controllers;

import lasdamasrefactoring.models.Session;
import lasdamasrefactoring.models.StateValue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;



public class ResumeControllerTest {

    @Test
    public void ResumeControllerResetTest() {
        Session session= new Session();
        ResumeController resumeController = new ResumeController(session);
        assertEquals(StateValue.INITIAL, session.getValueState());
        resumeController.next();
        assertEquals(StateValue.IN_GAME, session.getValueState());
        resumeController.next();
        assertEquals(StateValue.FINAL, session.getValueState());
        resumeController.reset();
        assertEquals(StateValue.INITIAL, session.getValueState());
    }

    @Test(expected = AssertionError.class)
    public void ResumeControllerExitingGameTest() {
        Session session= new Session();
        ResumeController resumeController = new ResumeController(session);
        assertEquals(StateValue.INITIAL, session.getValueState());
        resumeController.next();
        assertEquals(StateValue.IN_GAME, session.getValueState());
        resumeController.next();
        assertEquals(StateValue.FINAL, session.getValueState());
        resumeController.next();
        assertEquals(StateValue.EXIT, session.getValueState());
        resumeController.next();
    }
}