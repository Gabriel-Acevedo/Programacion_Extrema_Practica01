package lasdamasrefactoring.views;

import lasdamasrefactoring.controllers.ResumeController;
import lasdamasrefactoring.utils.YesNoDialog;

public class ResumeView extends WithConsoleView {
    
    private YesNoDialog yesNoDialog;

    public ResumeView(){
        super();
        this.yesNoDialog = new YesNoDialog();
    }

    public void interact(ResumeController resumeController) {
        if (this.yesNoDialog.read(MessageView.RESUME.getMessage())){
            resumeController.reset();
        } else {
            resumeController.next();
        }

    }
}
