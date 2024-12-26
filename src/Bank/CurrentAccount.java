package Bank;

public class CurrentAccount extends BankAccount {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String tradeLicenseNumber;
//	String type;

	public CurrentAccount(String name, double balance,String tradeLicenseNumber) throws Exception {
		super(name, balance, 5000);
		this.tradeLicenseNumber= tradeLicenseNumber;
//		this.type="Current Account";
	}
	
	
}
