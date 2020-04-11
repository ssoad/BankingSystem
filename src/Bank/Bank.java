package Bank;
import java.io.Serializable;
import javax.swing.DefaultListModel;
import Exceptions.AccNotFound;
import Exceptions.InvalidAmount;
import Exceptions.MaxBalance;
import Exceptions.MaxWithdraw;

public class Bank implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BankAccount[] accounts= new BankAccount[100];
	public int addAccount(BankAccount acc)
	{
		int i=0;
		for(i=0;i<100;i++)
		{
			if(getAccounts()[i]==null)
			{
				break;
			}
		}
		getAccounts()[i]=acc;
		return i;
	}
	
	public int addAccount(String name, double balance, double maxWithLimit )
	{
		SavingsAccount acc=new SavingsAccount(name, balance, maxWithLimit);
		return this.addAccount(acc);
	}
	
	public int addAccount(String name, double balance, String tradeLicense) throws Exception
	{
		CurrentAccount acc = new CurrentAccount(name, balance,tradeLicense);
		return this.addAccount(acc);
	}
	
	public int addAccount(String name, String  institutionName, double balance, double min_balance)
	{
		StudentAccount acc= new StudentAccount(name,balance,institutionName);
		return this.addAccount(acc);
	}
	
	public BankAccount findAccount(String aacountNum)
	{
		int i;
		for(i=0;i<100;i++)
		{
			if(getAccounts()[i]==null)
			{
				break;
			}
			if(getAccounts()[i].acc_num.equals(aacountNum))
			{
				return getAccounts()[i];
			}
			
		}
		return null;
	}
	
	public void deposit(String aacountNum, double amt) throws InvalidAmount,AccNotFound
	
	{
		if(amt<0)
		{
			throw new InvalidAmount("Invalid Deposit amount");
		}
		BankAccount temp=findAccount(aacountNum);
		if(temp==null)
		{
			throw new AccNotFound("Account Not Found");
		}
		if(temp!=null)
		{
			temp.deposit(amt);
			
		}
		
	}
	
	
	public void withdraw(String aacountNum, double amt) throws MaxBalance,AccNotFound, MaxWithdraw, InvalidAmount
	{
		BankAccount temp=findAccount(aacountNum);
		
		if(temp==null)
		{
			throw new AccNotFound("Account Not Found");
		}
		
		if(amt<=0)
		{
			throw new InvalidAmount("Invalid Amount");
		}
		
		if(amt>temp.getbalance())
		{
			throw new MaxBalance("Insufficient Balance");
		}
		if(temp!=null)
		{
			temp.withdraw(amt);
		}
	}
	
	public DefaultListModel<String> display()
	{
		DefaultListModel<String> list=new DefaultListModel<String>();
		int i;
//		String type=null;
	
		for(i=0;i<100;i++)
		{
			if(getAccounts()[i]==null)
			{
				break;
			}
//			if(getAccounts()[i].getClass().toString().equals("class Bank.SavingsAccount"))
//			{
//				type="Type: Savings Account";
//			}
//			
//			else if(getAccounts()[i].getClass().toString().equals("class Bank.CurrentAccount"))
//			{
//				type="Type: Current Account";
//			}
//			
//			else if(getAccounts()[i].getClass().toString().equals("class Bank.StudentAccount"))
//			{
//				type="Type: Student Account";
//			}
			
			list.addElement(getAccounts()[i].toString());
			
			
		}
		
		return list;
	}

	public BankAccount[] getAccounts() {
		return accounts;
	}

	public void setAccounts(BankAccount[] accounts) {
		this.accounts = accounts;
	}
	
}
