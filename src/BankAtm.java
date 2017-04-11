
public abstract class BankAtm {
	/**
	 * @Making instance variable as private so that they can only be access via
	 *         getters and setter outside of the class
	 */

	private int atmId;
	public String bankName;
	public String location;
	private static double balance = 0;

	/** @Abstract method needs to be overridden */

	abstract double withdraw(double balance) throws BankAtmException;

	abstract double deposit(double balance);

	/** @Getters and setters to access private members */

	public static double getBalance() {
		return balance;
	}

	public static void setBalance(double balance) {
		BankAtm.balance = balance;
	}
}