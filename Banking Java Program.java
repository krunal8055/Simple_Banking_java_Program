import java.util.Scanner;

class Accounts {
	String customer_name;
	int account_no;
	double balance =5000;
	String type_of_account;
	int withdraw_amount;
	int deposite_amount;
/*
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

	void Deposit(int depo_amount) {
		deposite_amount = depo_amount;
		balance = balance + deposite_amount;
		
		UpdateBal();
	}
*/
	void Show_Account_Holder_Info() {
		customer_name = "Krunal";
		account_no = 1892594;
		type_of_account = "Saving Account";
		System.out.println("Cusomer Name = " + customer_name);
		System.out.println("Cusomer Account No = " + account_no);
		System.out.println("Cusomer's Balance = " + balance);
		System.out.println("Cusomer's Account Type = " + type_of_account);
		
	}

	void UpdateBal() {
		System.out.println("Updated Balance  = " + balance);
	}
}

class Current_Account extends Accounts {
	

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

	void Deposit(int depo_amount) {
		deposite_amount = depo_amount;
		balance = balance + deposite_amount;
		UpdateBal();
	}
	double min_balance = 100;
	double service_charge = 10;
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

class Saving_Account extends Accounts {
	double Compound_interest_rate = 2.49;
	
	void Compound_interest() {
		Double InterestAmount = (balance*Compound_interest_rate)/100;
		System.out.println("Interest Amount = " + InterestAmount);
		balance = balance + InterestAmount;
		UpdateBal();
	}
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

	void Deposit(int depo_amount) {
		deposite_amount = depo_amount;
		balance = balance + deposite_amount;
		UpdateBal();
	}

}

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
		int Acc_Type = s1.nextInt();
		System.out.println("********************BANKING OPTION********************");
		System.out.println("1.  Get Your Account Details ");
		System.out.println("2.  Deposit Money ");
		System.out.println("3.  Withdraw Money ");
		System.out.println("4.  Show Balance ");
		System.out.println("5.  Compute Interest ");
		System.out.println("6.  Exit ");
		int flag = 0;
		
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
			case 1:
				obj1.Show_Account_Holder_Info();
				break;
			case 2:
				if(Acc_Type == 1)
				{
					System.out.println("Enter A amount you want to deposite = ");
					deposite_amount = s1.nextInt();
					obj2.Deposit(deposite_amount);
					break;
				}
				else
				{
					System.out.println("Enter A amount you want to deposite = ");
					deposite_amount = s1.nextInt();
					obj3.Deposit(deposite_amount);
					break;
				}
			case 3:
				if(Acc_Type == 1)
				{
					System.out.println("Enter A amount you want to withdraw = ");
					withdraw_amount = s1.nextInt();
					obj2.Withdraw(withdraw_amount);
					break;
				}
				else
				{
					System.out.println("Enter A amount you want to withdraw = ");
					withdraw_amount = s1.nextInt();
					obj3.Withdraw(withdraw_amount);
					break;
				}
			case 4:
				if(Acc_Type == 1)
				{
					obj2.UpdateBal();
					break;
				}
				else
				{
					obj3.UpdateBal();
					break;
				}
			case 5:
				//Saving_Account obj2 = new Saving_Account();
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
		while (flag ==0);
	}

}
