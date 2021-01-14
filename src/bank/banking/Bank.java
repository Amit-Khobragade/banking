package bank.banking;
import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////// for bank ////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	public void addBranch( String name ) {
		branch.add(new Branch(name));
	}
	public void deleteBranch( String name ) {
		int i = this.findPos(this.findBranchPositions(name));
		if( i == -1 ) {
			System.out.println( "no branch found");
			return;
		}
		branch.remove(i);
	}
	public void printAllBranches() {
		for( int i = 0; i < branch.size(); ++i ) {
			System.out.print((i + 1) + "::");
			branch.get(i).printBranch();
		}
	}
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////// for customer ////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	public void deposit( String branchName, String cusName, double amount ) {
		int i = this.findPos(this.findBranchPositions(branchName));
		if( i == -1 ) {
			System.out.println( "no branch found");
			return;
		}
		branch.get(i).deposit(cusName, amount);
	}
	public void withdrawal( String branchName, String cusName, double amount ) {
		int i = this.findPos(this.findBranchPositions(branchName));
		if( i == -1 ) {
			System.out.println( "no branch found");
			return;
		}
		branch.get(i).withdrwal(cusName, amount);
	}
	public void printCustomerDetails(String branchName, String cusName) {
		int i = this.findPos(this.findBranchPositions(branchName));
		if( i == -1 ) {
			System.out.println( "no branch found");
			return;
		}
		branch.get(i).printCustomerDetails(cusName);
	}
	public void printCustomerTranscations(String branchName, String cusName) {
		int i = this.findPos(this.findBranchPositions(branchName));
		if( i == -1 ) {
			System.out.println( "no branch found");
			return;
		}
		branch.get(i).printTransaction(cusName);
	}
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////// for branch //////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	public void addCustomer( String branchName, String cusName, double initialBalance ) {
		int i = this.findPos(this.findBranchPositions(branchName));
		if( i == -1 ) {
			System.out.println( "no branch found");
			return;
		}
		branch.get(i).addCustomer(cusName, initialBalance);
	}
	public void deleteCustomer( String branchName, String cusName ) {
		int i = this.findPos(this.findBranchPositions(branchName));
		if( i == -1 ) {
			System.out.println( "no branch found");
			return;
		}
		branch.get(i).deleteCustomer(cusName);
	}
	public void printAllCustomers( String branchName ) {
		int i = this.findPos(this.findBranchPositions(branchName));
		if( i == -1 ) {
			System.out.println( "no branch found");
			return;
		}
		branch.get(i).printAllCustomer();;
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
			branch.get(i).printBranch();
		j++;
		}
		System.out.println("choose a branch Position");
		j = sc.nextInt();
		return list.get(j-1);
	}
	private ArrayList<Integer> findBranchPositions( String name ) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < branch.size(); ++i ) {
			if(branch.get(i).checkName(name))
			list.add(i);
		}
		return list;
	}
	//////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////// private variables //////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	private ArrayList<Branch> branch = new ArrayList<Branch>();
	private static Scanner sc = new Scanner(System.in);

}
