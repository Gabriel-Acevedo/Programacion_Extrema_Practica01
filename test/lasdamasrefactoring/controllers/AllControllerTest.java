package lasdamasrefactoring.controllers;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
    PlayControllerTest.class, 
    ResumeControllerTest.class, 
    StartControllerTest.class } )
public final class AllControllerTest {
}