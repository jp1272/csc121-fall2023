/* A bank offers three kinds of accounts:
   a checking account with a minimum balance
   a savings account
   a certificate of deposit account with maturity date

The customer can withdraw all money from the savings account. 
When withdrawing from the checking account, the minimum balance must remain.
The customer cannot withdraw from a CD account, if is has not matured.
*/


/** Represents bank accounts */
interface IAccount {}


/** Represents a checking account */
class Checking implements IAccount {
	String name;
	int id;
	int balance;
	int minBalance;
	
	Checking(String name, int id, int balance, int minBalance) {
		this.name = name;
		this.id = id;
		this.balance = balance;
		this.minBalance = minBalance;
	}	
}


/** Represents a savings account */
class Savings implements IAccount {
	String name;
	int id;
	int balance;
	double interestRate;
	
	Savings(String name, int id, int balance, double interestRate) {
		this.name = name;
		this.id = id;
		this.balance = balance;
		this.interestRate = interestRate;
	}	
}


/** Represents a certificate of deposit account */
class CD implements IAccount {
	String name;
	int id;
	int balance;
	boolean matured;
	
	CD(String name, int id, int balance, boolean matured) {
		this.name = name;
		this.id = id;
		this.balance = balance;
		this.matured = matured;
	}	
}
