package bank.banking;
import java.util.ArrayList;

public class Customer {
	public Customer( String name, double initialBalance ) {
		this.name = name;
		this.balance = initialBalance;
	}
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////// for customer ////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	public void printCustomer() {
		System.out.println( "Name:: " + this.name);
		System.out.println( "balance:: " + this.balance);
	}
	
	public boolean deposit( double amount ) {
		if( amount <= 0 ) {
			System.out.println( "Error: amount smaller than / equal to zero" );
			System.out.println( "withdraw using the withdraw function" );
			return false;
		}
		this.balance += amount;
		transaction.add(amount);
		System.out.println( "Deposit Sucessfull" );
		return true;
	}
	public boolean withdrawal( double amount ) {
		if( amount <= 0 ) {
			System.out.println( "Error: amount smaller than / equal to zero" );
			System.out.println( "deposit using the deposit function" );
			return false;
		}
		if( amount > this.balance ) {
			System.out.println( "Error: amount greater than balance" );
			return false;
		}
		transaction.add((-amount));
		this.balance -= amount;
		System.out.println( "Withdrawal Sucessfull" );
		return true;		
	}
	public boolean checkName( String name ) {
		return name.contains(name);
	}
	public void printTransactions() {
		if(transaction.isEmpty()) {
			System.out.println( "no records found..." );
			return;
		}
		for(double item : transaction )
			System.out.println( item );
	}
	//////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////// private variables //////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	private String name;
	private double balance;
	private ArrayList<Double> transaction = new ArrayList<Double>();
}
