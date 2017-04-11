
/**@Import Scanner Package*/
import java.util.Scanner;

/** @Create a class Atm and Extends to BankAtm */
public class Atm extends BankAtm {
	/** @Main Method */
	public static void main(String[] args) {

		/** @Scanner to take input from user */

		Scanner scanner = new Scanner(System.in);
		/** @Creating a object of Atm class */
		Atm atm1 = new Atm();
		/** @Writing our logic in try catch block to handle Exception */
		try {
			while (true) {
				System.out.println("Enter 1 to deposit and 2 for withdrawl");
				int choice = scanner.nextInt();
				switch (choice) {

				case 1:
					System.out.println("Enter the amount to be deposit");
					double amount = scanner.nextDouble();
					double total_balance = atm1.deposit(amount);
					BankAtm.setBalance(total_balance);
					System.out.println("Now your available balance is " + BankAtm.getBalance());
					break;

				case 2:
					System.out.println("Enter amount to be withdrawn");
					double amount1 = scanner.nextDouble();

					double withdrawl_amt = atm1.withdraw(amount1);
					if (withdrawl_amt < 0) {
						/** @Throwing our created user defined exception */
						throw new BankAtmException("Insufficient fund in your Account");
					} else if (withdrawl_amt < 10000) {
						throw new BankAtmException("Amount left is less than 10000");
					} else {
						System.out.println("Withdrawl is successfull amount left in your account is " + withdrawl_amt);
					}
					break;
				/** @To exit from the program */
				default:
					System.exit(0);
				}
			}

		} catch (BankAtmException e) {
			System.out.println(e);
		}

	}

	/** @Implementing overridden methods of BankAtm class */

	@Override
	double withdraw(double balance) throws BankAtmException {

		return BankAtm.getBalance() - balance;
	}

	@Override
	double deposit(double balance) {
		/** @TODO Auto-generated method stub */
		double available_balance = balance + BankAtm.getBalance();

		return available_balance;
	}

}