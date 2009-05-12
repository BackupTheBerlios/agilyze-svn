package edu.umich.med.michr.hb2.websvcs;

/**
 * @author pboisver
 *
 */
public class Status {

	private String currentStatus;

	/**
	 *
	 */
	public Status() {
		super();
		currentStatus = "OK";
	}

	/**
	 * @return the currentStatus
	 */
	public String getCurrentStatus() {
		return currentStatus;
	}

	/**
	 * @param currentStatus
	 *            the currentStatus to set
	 */
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

}
