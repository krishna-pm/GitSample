package com;


abstract class Employee{
	
	private String employeeId;
	private String employeeName;
	protected double salary;
	
	static final String COMPANY_NAME ="EY";
	
	
	Employee(String employeeId,String employeeName,double salary){
		
		this.employeeId=employeeId;
		this.employeeName=employeeName;
		this.salary=salary;
	}
	
	abstract double calculateSalary();
	
	void employeeDetails() {
		System.out.println("Company Name : "+COMPANY_NAME);
		System.out.println("Employee ID : "+employeeId);
		System.out.println("Name : "+employeeName);
		System.out.println("Total salary : "+calculateSalary());
	}
}


class Manager extends Employee{
	
	double bonusAmount;

	Manager(String employeeId, String employeeName, double salary,double bonusAmount) {
		super(employeeId, employeeName, salary);
		this.bonusAmount=bonusAmount;	
	}

	@Override
	double calculateSalary() {
		
		return salary+bonusAmount;
	}
	
}


class Staff extends Employee{
	
	boolean targetAchieved;
	double incentive;
	
	Staff(String employeeId,String employeeName,double salary,boolean targetAchieved,double incentive){
		super(employeeId,employeeName,salary);
		this.targetAchieved=targetAchieved;
		this.incentive=incentive;
	}
	
	@Override
	double calculateSalary() {
		
		if(targetAchieved) {
		return salary+incentive;
		}
		return salary;
		
	}
	
	
}


public class EmployeeInformation {

	public static void main(String[] args) {

		
		Employee employeeOne = new Manager("EMP01","Ann Mary",50000,10000);
		
		employeeOne.employeeDetails();
		
		Employee employeeTwo = new Staff("EMP02","Arun S",20000,false,0);
		
		employeeTwo.employeeDetails();
		
		Employee employeeThree = new Staff("EMP02","Manu R",20000,true,5000);
		
		employeeThree.employeeDetails();
	}

}
