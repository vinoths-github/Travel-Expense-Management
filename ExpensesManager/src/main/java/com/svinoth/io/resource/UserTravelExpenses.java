package com.svinoth.io.resource;

public class UserTravelExpenses extends UserDetails {
	private double Amount;
	private double Balance;
	/*private double BeneficiaryCredit;
	private double PayerDebit;*/

	
	public UserTravelExpenses(String userName, double amount) {
		super(userName);
		Amount = amount;
		/*BeneficiaryCredit = 0;
		PayerDebit = 0;*/
		Balance = 0;
	}
		
	public double getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}	
	public double getBalance() {
		return Balance;
	}
	public void setBalance(double d) {
		Balance = d;
	}
	/*public double getBeneficiaryCredit() {
		return BeneficiaryCredit;
	}
	public void setBeneficiaryCredit(double beneficiaryCredit) {
		BeneficiaryCredit = beneficiaryCredit;
	}
	
	public double getPayerDebit() {
		return PayerDebit;
	}
	public void setPayerDebit(double payerDebit) {
		PayerDebit = payerDebit;
	}*/

	@Override
	public String toString() {
		return "UserTravelExpenses [Amount=" + Amount + ", Balance=" + Balance + "]";
	}
}
