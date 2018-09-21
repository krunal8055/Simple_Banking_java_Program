import java.util.Scanner;

class Accounts {
	String customer_name;
	int account_no;
	double balance =5000; //Initial Balance
	String type_of_account;
	int withdraw_amount;
	int deposite_amount;
	
	//Method to show Account Information
	void Show_Account_Holder_Info() {
		customer_name = "Brian";
		account_no = 18925940000;
		type_of_account = "Saving Account";
		System.out.println("Cusomer Name = " + customer_name);
		System.out.println("Cusomer Account No = " + account_no);
		System.out.println("Cusomer's Balance = " + balance);
		System.out.println("Cusomer's Account Type = " + type_of_account);
		
	}
	//Method for Update Balance
	void UpdateBal() {
		System.out.println("Updated Balance  = " + balance);
	}
}

//Current Account Class
class Current_Account extends Accounts {
	
	//Method for Withdraw in Current Account
	void Withdraw(int wdraw_amount) {
		if(balance >0)
		{
		withdraw_amount = wdraw_amount;
		balance = balance - withdraw_amount;
		min_bal_check();
		}
		else
		{
			System.out.println("You do not have any balance. you can not withdraw.");
		}
	}
	//Method for deposit in Current Account
	void Deposit(int depo_amount) {
		deposite_amount = depo_amount;
		balance = balance + deposite_amount;
		UpdateBal();
	}
	double min_balance = 100;
	double service_charge = 10;
	
	//Method to check minimum balance
	void min_bal_check() {
		if(balance<min_balance)
		{
			System.out.println("Your Account balance is less then Minimun.");
			balance = balance - service_charge;
			UpdateBal();
		}
		else
		{
		UpdateBal();
		}

	}

}

//Class for Saving Account
class Saving_Account extends Accounts {
	double Compound_interest_rate = 2.49; //Interest Rate
	
	//Method to count Interest and Add Interest in Balance
	void Compound_interest() {
		Double InterestAmount = (balance*Compound_interest_rate)/100;
		System.out.println("Interest Amount = " + InterestAmount);
		balance = balance + InterestAmount;
		UpdateBal();
	}
	
	//Method for Withdraw in Saving Account
	void Withdraw(int wdraw_amount) {
		if(balance >0)
		{
		withdraw_amount = wdraw_amount;
		balance = balance - withdraw_amount;
		UpdateBal();
		}
		else
		{
			System.out.println("You do not have any balance. you can not withdraw.");
		}
	}
	
	//Method for deposit in Saving Account
	void Deposit(int depo_amount) {
		deposite_amount = depo_amount;
		balance = balance + deposite_amount;
		UpdateBal();
	}

}

//Main Class
public class Question2 extends Accounts{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int withdraw_amount;
		int deposite_amount;
		Scanner s1 = new Scanner(System.in);
		System.out.println("********************Account Type********************");
		System.out.println("1.  Saving Account ");
		System.out.println("2.  Current Account ");
		System.out.println("Enter Your Account type :");
		
		int Acc_Type = s1.nextInt(); //It will take input from user for Account type.
		
		System.out.println("********************BANKING OPTION********************");
		System.out.println("1.  Get Your Account Details ");
		System.out.println("2.  Deposit Money ");
		System.out.println("3.  Withdraw Money ");
		System.out.println("4.  Show Balance ");
		System.out.println("5.  Compute Interest ");
		System.out.println("6.  Exit ");
		
		int flag = 0; //flag for exit
		
//Objects
		Accounts obj1 = new Accounts();
		Saving_Account obj2 = new Saving_Account();
		Current_Account obj3 = new Current_Account();
		
		System.out.println("*******************************************************");
		
		do 
		{
		System.out.println("Enter Your Input :");
		int InputFromUser=  s1.nextInt();
		
		switch(InputFromUser)
			{
			case 1: //for Just show Account Info
				obj1.Show_Account_Holder_Info();
				break;
				
			case 2: //for Deposite 
				if(Acc_Type == 1) //Saving Deposite
				{
					System.out.println("Enter A amount you want to deposite = ");
					deposite_amount = s1.nextInt();
					obj2.Deposit(deposite_amount);
					break;
				}
				else . //Current Deposite
				{
					System.out.println("Enter A amount you want to deposite = ");
					deposite_amount = s1.nextInt();
					obj3.Deposit(deposite_amount);
					break;
				}
				
			case 3: //for Withdraw
				if(Acc_Type == 1) //Saving Withdraw
				{
					System.out.println("Enter A amount you want to withdraw = ");
					withdraw_amount = s1.nextInt();
					obj2.Withdraw(withdraw_amount);
					break;
				}
				else //current withdraw
				{
					System.out.println("Enter A amount you want to withdraw = ");
					withdraw_amount = s1.nextInt();
					obj3.Withdraw(withdraw_amount);
					break;
				}
			case 4: //update balance
				if(Acc_Type == 1) //update balance for saving
				{
					obj2.UpdateBal();
					break;
				}
				else //update balance for current
				{
					obj3.UpdateBal();
					break;
				}
			case 5: //Interest for Saving Account only
				obj2.Compound_interest();
				break;
			case 6:
				System.out.println("Bye Bye . Thank you");
				flag =1;
				break;
			default :
				System.out.println("You havent give any Input");
				break;
		
			}
		}
		while (flag == 0);
	}

}
