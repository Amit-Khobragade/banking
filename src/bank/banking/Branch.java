package bank.banking;
import java.util.Scanner;
import java.util.ArrayList;

public class Branch {
	Branch( String name ){
		this.name = name;
	}
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////// for customer ////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	public boolean deposit( String name, double amount ) {
		int j = this.findPos(this.findCustomerPositions(name));
		if( j == -1 ) {
			System.out.println( "no records found");
			return false;
		}
		return customer.get(j).deposit(amount);
	}
	public boolean withdrwal( String name, double amount ) {
		int j = this.findPos(this.findCustomerPositions(name));
		if( j == -1 ) {
			System.out.println( "no records found");
			return false;
		}
		return customer.get(j).withdrawal(amount);
	}
	public void printCustomerDetails( String name ) {
		int j = this.findPos(this.findCustomerPositions(name));
		if( j == -1 ) {
			System.out.println( "no records found");
			return;
		}
		customer.get(j).printCustomer();
	}
	public void printTransaction( String name ) {
		int j = this.findPos(findCustomerPositions(name) );
		if(  j == -1 ) {
			System.out.println( "no records found");
			return;
		}
		customer.get(j).printTransactions();
	}
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////// for branch //////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	public void addCustomer( String name, double initialBalance ) {
		customer.add(new Customer( name, initialBalance ));
	}
	public void deleteCustomer( String name ) {
		int j = this.findPos( this.findCustomerPositions(name));
		if( j == -1 ) {
			System.out.println( "no records found");
			return;
		}
		customer.remove(j);
	}
	public boolean checkName( String name ) {
		return this.name.contains(name);
	}
	public void printBranch() {
		System.out.println( "Name:: " + this.name);
	}
	public void printAllCustomer() {
		for( Customer item : this.customer)
			item.printCustomer();
	}
	//////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////// private methods ////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	private int findPos( ArrayList<Integer> list) {
		if( list.isEmpty())  
			return -1;
		int j = 1;
		for (int i: list ) {
			System.out.println( j + "::");
			customer.get(i).printCustomer();;
			j++;
		}
		System.out.println("choose a customer Position");
		j = sc.nextInt();
		return list.get(j-1);
	}
	private ArrayList<Integer> findCustomerPositions( String name ) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < customer.size(); ++i ) {
			if(customer.get(i).checkName(name))
				list.add(i);
		}
		return list;
	}
	//////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////// private variables //////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	private String name;
	private static Scanner sc = new Scanner(System.in);
	private ArrayList<Customer> customer = new ArrayList<Customer>();
}
