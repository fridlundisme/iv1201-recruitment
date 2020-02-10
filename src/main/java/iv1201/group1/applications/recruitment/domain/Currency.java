package iv1201.group1.applications.recruitment.domain;

public class Currency {
	private String currency_a;
	private String currency_b;
	private double amount;
	private double sum;

	public String getCurrency_a() {
		return currency_a;
	}

	public void setCurrency_a(String s) {
		this.currency_a = s;
	}

	public String getCurrency_b() {
		return currency_b;
	}

	public void setCurrency_b(String s) {
		this.currency_b = s;
	}

	public double getAmount(){
		return amount;
	}

	public void setAmount(double a){
		this.amount = a;
	}

	public double getSum(){
		return sum;
	}

	public void setSum(double s){
		this.sum = s;
	}
}
