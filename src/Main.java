import bank.banking.Bank;
import java.util.Scanner;
import option.printer.Choice;

public class Main {

	public static void main(String[] args) {
		createMenu();
		Bank bank = new Bank();
		int login = 0;
		int option = 0;
		String branchName = null;
		String customerName = null;
		do {
			if( login == 0 || login > 4 || login < 0)
				login = mainMenu.getInt();
			if( login == 1 ) {
				option = bankMainMenu.getInt();
				String name = null;
				if( option == 1 || option == 2)
					name = getName( "branch");
				switch( option ) {
				case 1:
					bank.addBranch(name);
					break;
				case 2:
					bank.deleteBranch(name);
					break;
				case 3:
					bank.printAllBranches();
					break;
				case 4:
					login = 0;
					break;
				case 5: 
					login = 4;
					break;
				default:
					System.out.println("invalid option");
					break;
				}
			}
			else if( login == 2) {
				if( branchName == null )
					branchName = getName( "branch" );
				option = branchMainMenu.getInt();
				String name = null;
				int initialBalance = 0;
				if( option == 1 || option == 2) {
					name = getName( "customer");
					if (option == 1) {
						System.out.println("enter the intial balance:: ");
						initialBalance = sc.nextInt();
					}
				}
				switch( option ) {
				case 1:
					bank.addCustomer(branchName, name, initialBalance);
					break;
				case 2:
					bank.deleteCustomer(branchName, name);
					break;
				case 3:
					bank.printAllCustomers(branchName);
					break;
				case 4:
					login = 0;
					branchName = null;
					break;
				case 5: 
					login = 4;
					break;
				default:
					System.out.println("invalid option");
					break;
				}
			}
			else if( login == 3) {
				if( branchName == null )
					branchName = getName( "branch" );
				if( customerName == null )
					customerName = getName( "customer" );
				option = customerMainMenu.getInt();
				int amount = 0;
				if( option == 1 || option == 2 ) {
					System.out.println("enter the amount:: ");
					amount =  sc.nextInt();
				}
				switch( option ) {
				case 1:
					bank.deposit(branchName, customerName, amount);
					break;
				case 2:
					bank.withdrawal(branchName, customerName, amount);
					break;
				case 3:
					bank.printCustomerDetails(branchName, customerName);
				case 4:
					login = 0;
					branchName = null;
					customerName = null;
					break;
				case 5: 
					login = 4;
					break;
				default:
					System.out.println("invalid option");
					break;
				}
			}
			else if( login == 4 ) 
				System.out.println( "thanks for using the app");
			else
				System.out.println( "Wrong choice try again..");
		}
		while( login != 4 );
	}
	public static void createMenu() {
		mainMenu.clearItems();
		mainMenu.add("1:: Bank");
		mainMenu.add("2:: Branch");
		mainMenu.add("3:: customer");
		mainMenu.add("4:: exit");
		bankMainMenu.clearItems();
		bankMainMenu.add("1:: Add Branch");
		bankMainMenu.add("2:: delete Branch");
		bankMainMenu.add("3:: print All Branch");
		bankMainMenu.add("4:: logout");
		bankMainMenu.add("5:: exit");
		branchMainMenu.clearItems();
		branchMainMenu.add("1:: add customer");
		branchMainMenu.add("2:: delete customer");
		branchMainMenu.add("3:: print All customer");
		branchMainMenu.add("4:: logout");
		branchMainMenu.add("5:: exit");
		customerMainMenu.clearItems();
		customerMainMenu.add("1:: deposit");
		customerMainMenu.add("2:: withdrawal");
		customerMainMenu.add("3:: print customer details");
		customerMainMenu.add("4:: logout");
		customerMainMenu.add("5:: exit");
		
		
	}
	public static String getName( String item ) {
		String name = null; 
		System.out.println("Enter the " + item + " name:: ");
		name = stringSc.nextLine();
		return name;
	}
	public static Choice mainMenu = new Choice("how do you want to login");
	public static Choice bankMainMenu = new Choice();
	public static Choice branchMainMenu = new Choice();
	public static Choice customerMainMenu = new Choice();
	public static Scanner stringSc = new Scanner( System.in );
	public static Scanner sc = new Scanner( System.in );
}
