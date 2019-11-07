package lasdamasrefactoring;

import lasdamasrefactoring.controllers.AllControllerTest;
import lasdamasrefactoring.models.AllModelTest;
import lasdamasrefactoring.views.AllViewTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;



@RunWith(Suite.class)
@Suite.SuiteClasses({ 
    AllModelTest.class, 
    AllControllerTest.class, 
    AllViewTest.class } )
public final class AllTest {
}