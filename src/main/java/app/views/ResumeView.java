package app.views;

import app.utils.Message;
import app.utils.YesNoDialog;

public class ResumeView extends ConsoleView {
	private final YesNoDialog resumeDialog;

	public ResumeView() {
		this.resumeDialog = new YesNoDialog();
	}

	public boolean isResumed() {
		return this.resumeDialog.read(Message.DO_YOU_WANT_RESUME);
	}
}
