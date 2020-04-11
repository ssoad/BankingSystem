package Bank;
import Exceptions.MaxBalance;
import Exceptions.MaxWithdraw;

public class SavingsAccount extends BankAccount {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	float rate= .05f;
	double maxWithLimit;
//	String type;
	
	public SavingsAccount(String name, double balance,double maxWithLimit) {
		super(name, balance, 2000);
		this.maxWithLimit= maxWithLimit;
//		this.type="Savings Account";
	}
	
	public double getNetBalance()
	{
		double NetBalance= getbalance()+(getbalance()*rate);
		return NetBalance;
	}
	
	public void withdraw(double amount) throws MaxWithdraw, MaxBalance
	{
		if(amount<maxWithLimit)
		{
			super.withdraw(amount);
			
		}
		else
		{
			throw new MaxWithdraw("Maximum Withdraw Limit Exceed");
		}
		
	}
	
	
}
