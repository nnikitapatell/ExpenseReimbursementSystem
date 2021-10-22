package main.constants;

/**
 * @author niki3
 *
 */
public enum ReimbursementType {
	
		LODGING(1), TRAVEL(2), FOOD(3), OTHER(4);

		private int value;

		/**
		 * @param i
		 */
		ReimbursementType(int i) {
			this.value = i;
		}
		/**
		 * @param id
		 * @return
		 */
		public static ReimbursementType fromInt(int id) {
			switch(id) {
			case 1:
				return LODGING;
			case 2:
				return TRAVEL;
			case 3:
				return FOOD;
			case 4:
				return OTHER;
			}
			return null;
		}
}
