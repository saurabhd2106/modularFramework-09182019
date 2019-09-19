package comonLibs.implementation;

import comonLibs.contracts.IAlert;

public class AlertControl implements IAlert{

	@Override
	public void acceptAlert() throws Exception {
		
		
	}

	@Override
	public void rejectAlert() throws Exception {
		
		
	}

	@Override
	public String getMessageFromAlert() throws Exception {
		
		return null;
	}

	@Override
	public boolean checkAlertPresent(int timeoutInseconds) throws Exception {
		
		return false;
	}

}
