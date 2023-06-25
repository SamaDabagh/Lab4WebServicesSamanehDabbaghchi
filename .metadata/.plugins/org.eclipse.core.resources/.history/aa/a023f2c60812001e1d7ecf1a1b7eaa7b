package webFacultyREST;

public class Faculty {


	
	private int f_id ;
	private String f_Lname;
	private String f_Fname;
	private double f_Salary;
	private double f_BonusRate;
	
	public Faculty() {

		this.f_id = 0;
		this.f_Lname = "";
		this.f_Fname = "";
		this.f_Salary = 0.0;
		this.f_BonusRate =0.0;
	}
	public Faculty(int f_id, String f_Lname, String f_Fname, double f_Salary, double f_BonusRate) {
		super();
		this.f_id = f_id;
		this.f_Lname = f_Lname;
		this.f_Fname = f_Fname;
		this.f_Salary = f_Salary;
		this.f_BonusRate = f_BonusRate;
	}
	public int getF_id() {
		return f_id;
	}
	public void setF_id(int f_id) {
		this.f_id = f_id;
	}
	public String getF_Lname() {
		return f_Lname;
	}
	public void setF_Lname(String f_Lname) {
		this.f_Lname = f_Lname;
	}
	public String getF_Fname() {
		return f_Fname;
	}
	public void setF_Fname(String f_Fname) {
		this.f_Fname = f_Fname;
	}
	public double getF_Salary() {
		return f_Salary;
	}
	public void setF_Salary(double f_Salary) {
		this.f_Salary = f_Salary;
	}
	public double getF_BonusRate() {
		return f_BonusRate;
	}
	public void setF_BonusRate(double f_BonusRate) {
		this.f_BonusRate = f_BonusRate;
	}
	
	@Override
	public String toString() {
		return "Faculty [f_id= "+f_id + ",  f_Lname= "+ f_Lname +",  f_Fname= " 
				+f_Fname +",  f_Salary= " +f_Salary +"$,  f_BonusRate= " +f_BonusRate + "%,  Faculty Bonus= "+ doCalc_Bonus()+"$,  Faculty Tax Bonus= "+doBonus_tax()+"$]";
	}

	//Concrete Methods

	public double doCalc_Bonus() 
	{
		double bonus =  f_Salary  * f_BonusRate/100.00;
	
	return bonus;
	}
	
	public double doBonus_tax() 
	{
		double f_tax  = 0.075;
		double p_tax  = 0.06;

		double bonus_tax =  (doCalc_Bonus()   * f_tax) + (doCalc_Bonus()   * p_tax);
	
	return bonus_tax;
	}
}
