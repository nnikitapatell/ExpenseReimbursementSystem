package main.constants;

/**
 * @author niki3
 *
 */
public enum UserType {
	 MANAGER(1), EMPLOYEE(2);

	private int value;

	/**
	 * @param i
	 */
	UserType(int i) {
		this.value = i;
	}
	
	/**
	 * @param id
	 * @return
	 */
	public static UserType fromInt(int id) {
		switch(id) {
		case 1:
			return MANAGER;
			
		case 2:
			return EMPLOYEE;
		}
		return null;
	}
	
}
