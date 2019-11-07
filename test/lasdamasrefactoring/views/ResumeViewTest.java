package lasdamasrefactoring.views;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;
import lasdamasrefactoring.controllers.ResumeController;
import lasdamasrefactoring.utils.YesNoDialog;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import static org.mockito.Matchers.anyString;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;



@RunWith(MockitoJUnitRunner.class)
public class ResumeViewTest {

    @Mock
    ResumeController resumeController;

    @Mock
    YesNoDialog yesNoDialog;

    @InjectMocks
    ResumeView resumeView;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testInteract(){
        when(yesNoDialog.read(anyString())).thenReturn(true);
        resumeView.interact(resumeController);
        verify(resumeController).reset();
    }

}