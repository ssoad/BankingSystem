package Bank;
import java.io.Serializable;

import Exceptions.MaxBalance;
import Exceptions.MaxWithdraw;

public class BankAccount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private double balance;
	private double min_balance;
	private String acc_num;
	//String type;
	
	
	public BankAccount(String name, double balance, double min_balance) throws Exception {
    if (balance < min_balance) {
        throw new Exception("Initial balance cannot be less than the minimum required balance: " + min_balance);
    }
    this.name = name;
    this.balance = balance;
    this.min_balance = min_balance;
    this.acc_num = 10000 + (int) (Math.random() * 89999) + "";
}


	public void deposit(double amount) throws InvalidAmount
	{
		if (amount <= 0){
			throw new InvalidAmount("Deposit amount must be greater than zero.");
		}
		balance+=amount;
	}
	
	public void withdraw(double amount) throws MaxWithdraw, MaxBalance
	{
		if((balance-amount)>=min_balance && amount<balance)
		{
			balance-=amount;
			
		}
		
		else
		{
			throw new MaxBalance("Insufficient Balance");
		}
	}
	
	public double getbalance()
	{
		return balance;
	}
	
	@Override
	public String toString() {
		return "Name: " + name + ", Id: " + acc_num + ", Balance: " + balance +"Type:"+this.getClass();
	}
}
