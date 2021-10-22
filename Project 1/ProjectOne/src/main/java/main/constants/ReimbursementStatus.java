package main.constants;

/**
 * @author Nikita Patel
 *
 */
public enum ReimbursementStatus {
	PENDING(1), APPROVED(2), DENIED(3);

	private int value;

	/**
	 * @param i
	 */
	ReimbursementStatus(int i) {
		this.setValue(i);
	}
	
	/**
	 * @param id
	 * @return
	 */
	public static ReimbursementStatus fromInt(int id) {
		switch(id) {
		case 1:
			return PENDING;
		case 2:
			return APPROVED;
		case 3:
			return DENIED;
		}
		return null;
	}

	/**
	 * @return
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value
	 */
	public void setValue(int value) {
		this.value = value;
	}
	
}