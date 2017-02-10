/*
score: 9 + 1(extra credit)
comments: good coding!Try to consider more about corner cases
/**
 * Created by Rose on 1/21/17. Assignment for your lecture 2. Please finish all
 * the questions under 'Assignment'. Assignment 2 includes 3 interview prepare
 * questions. They are similar to what you will meet during your technical
 * interviews.Write some tests as practice. Please try to think the extra credit
 * question. The deadline of this assignment is 01/26/2017 23:59 PST. Please
 * feel free to contact me for any questions.
 */

class Employee {
	String name;
	int age;
	Gender gender;
	double salary;// salary per month

	public Employee(String name, int age, Gender gender, double salary) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void raiseSalary(double byPercent) {
		salary = salary * byPercent;
	}
}

enum Gender {
	MALE, FEMALE;
}

public class Assignment2 {
	// Assignment

	/**
	 * Write a method to calculate the Social Security Tax of an employee and
	 * print it. If the salary is less than or equal to 8900, the Social
	 * Security Tax is 6.2% of the salary. If the salary is more than 8900, the
	 * Social Security Tax is 6.2% of 106,800.
	 */
	public static double socialSecurityTax(Employee employee) {            //correct
		double ssTax = 0.0;
		double eSalary = employee.salary;
		if (eSalary <= 8900 && eSalary > 0) {
			ssTax = 0.062 * eSalary;
		}
		if (eSalary > 8900)
			ssTax = 0.062 * 106800;
		return ssTax;
		// write your code here
	}

	/**
	 * Write a method to calculate an employee's contribution for insurance
	 * coverage and print it. Amount of deduction is computed as follows: If the
	 * employee is under 35, rate is 3% of salary; if the employee is between 35
	 * and 50(inclusive), rate is 4% of salary; If the employee is between 50
	 * and 60(exclusive), rate is 5% of salary; If the employee is above 60,
	 * rate is 6% of salary.
	 */
	public static double insuranceCoverage(Employee employee) {                        //correct
		double iCoverage = 0.0;
		int eAge = employee.age;
		double eSalary = employee.salary;
		if (eAge < 35) {
			iCoverage = 0.03 * eSalary;
		}
		if (eAge > 35 && eAge <= 50) {
			iCoverage = 0.04 * eSalary;
		}
		if (eAge > 50 && eAge < 60) {
			iCoverage = 0.05 * eSalary;
		}
		if (eAge > 60) {
			iCoverage = 0.06 * eSalary;
		}
		return iCoverage;// write your code here
	}

	/**
	 * Write a method to sort three employees' salary from low to high, and then
	 * print their name in order. For example, Alice's salary is 1000, John's
	 * salary is 500, Jenny's salary is 1200, you should print: John Alice Jenny
	 */

	public static void sortSalary(Employee e1, Employee e2, Employee e3) {                    //correct
		Employee[] EmployeeArray = new Employee[3];
		EmployeeArray[0] = e1;
		EmployeeArray[1] = e2;
		EmployeeArray[2] = e3;
		Employee temp;
		for (int i = 0; i < 3; i++) {
			int key = i;
			for (int j = 2; j > i; j--) {
				if (EmployeeArray[j].salary < EmployeeArray[key].salary)
					key = j;
			}
			temp = EmployeeArray[i];
			EmployeeArray[i] = EmployeeArray[key];
			EmployeeArray[key] = temp;
		}
		System.out.println("Salary from low to high is:" + EmployeeArray[0].name + " " + EmployeeArray[1].name + " "
				+ EmployeeArray[2].name);
	}
	// write your code here

	/**
	 * Write a method to raise an employee's salary to three times of his/her
	 * original salary. Eg: original salary was 1000/month. After using this
	 * method, the salary is 3000/month. Do not change the input of this method.
	 * Try to add a new method in Employee class: public void raiseSalary(double
	 * byPercent)
	 */
	public static void tripleSalary(Employee employee) {                        //correct
		employee.salary = 3 * employee.salary;
		System.out.println(employee.name + "'s salary raising to three times is " + employee.salary);// write
																										// your
																										// code
																										// here
	}

	// Interview prepare questions

	/**
	 * Write a method to determine whether a number is prime
	 */

	public static boolean isPrime(int n) {                  //correct
		int x = 2;
		if (n == 1) {
			return false;
		}
		while (x <= n / 2) {
			if (n % x == 0) {
				return false;
			} else {
				x++;
			}
		}
		return true;
	}
	// write your code here

	/**
	 * Given a non-negative integer n, repeatedly add all its digits until the
	 * result has only one digit. For example: Given n = 38, the process is
	 * like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
	 */
	public static int addDigits(int n) {                               //correct

		while (n >= 10) {
			int tensDigit = (int) (n / 10);
			int unitDigit = n - tensDigit * 10;
			n = tensDigit + unitDigit;
		}
		return n;
		// write your code here
	}

	/**
	 * Write a program to check whether a given number is an ugly number. Ugly
	 * numbers are positive numbers whose prime factors only include 2, 3, 5.
	 * For example, 6, 8 are ugly, while 14 is not ugly since it includes
	 * another prime factor 7. Note that 1 is typically treated as an ugly
	 * number.
	 */
	public static boolean isUgly(int n) {                 //miss one corner case: if n is 0, you cannot jump out the first while loop
		while (n % 2 == 0) {
			n = n / 2;
		}
		while (n % 3 == 0) {
			n = n / 3;
		}
		while (n % 5 == 0) {
			n = n / 5;
		}
		if (n == 1) {
			return true;
		} else {
			return false;
		}
		// write your code here
	}

	// Extra credit

	/**
	 * I have written some code below. What I want is to swap two Employee
	 * objects. One is Jenny and one is John. But after running it, I got the
	 * result below: Before: a=Jenny Before: b=John After: a=Jenny After: b=John
	 * There is no change after swap()! Do you know the reason why my swap
	 * failed? Write your understanding of the reason and explain it.
	 */
	
	//correct
	/*
	 * write your understanding here. Java expresses the value of reference, not
	 * the object itself. So when we write a function to swap the Employee 
	 * object, their reference really exchanged, but the object is still the
	 * original one. If the println sentence is added to the swap() function, we
	 * can see that the reference value indeed changed. But when we use the object
	 * variables in the main(), it's still the same. 
	 */
	public static void main(String[] args) {
		Employee a = new Employee("Jenny", 20, Gender.FEMALE, 2000);
		Employee b = new Employee("John", 30, Gender.MALE, 2500);
		System.out.println("Before: a=" + a.getName());
		System.out.println("Before: b=" + b.getName());
		swap(a, b);
		System.out.println("After: a=" + a.getName());
		System.out.println("After: b=" + b.getName());

		Employee c = new Employee("Lily", 35, Gender.FEMALE, 9000); // create a new object to test.
		/*
		 * add some sentences to test the functions above. 
		 */
		System.out.println("Social Security Tax of " + a.name + " is " + socialSecurityTax(a));
		System.out.println("Social Security Tax of " + c.name + " is " + socialSecurityTax(c));
		System.out.println("The contribution for insurance of " + b.name + " is " + insuranceCoverage(b) + ".");
		sortSalary(a, b, c);
		tripleSalary(b);

		System.out.println("Add all digits of 15 is " + addDigits(15));
		System.out.println("Add all digits of 97 is " + addDigits(97));
		System.out.println("Add all digits of 388 is " + addDigits(388));

		System.out.println("Is 7 a prime? " + isPrime(7));
		System.out.println("Is 14 a prime? " + isPrime(14));
		System.out.println("Is 3 a prime? " + isPrime(3));
		System.out.println("Is 5 a prime? " + isPrime(5));
		System.out.println("Is 2 a prime? " + isPrime(2));
		System.out.println("Is 1 a prime? " + isPrime(1));

		System.out.println("Is 1 a ugly number? " + isUgly(1));
		System.out.println("Is 6 a ugly number? " + isUgly(6));
		System.out.println("Is 100 a ugly number? " + isUgly(100));
		System.out.println("Is 33 a ugly number? " + isUgly(33));
		System.out.println("Is 14 a ugly number? " + isUgly(14));
	}

	public static void swap(Employee x, Employee y) {
		Employee temp = x;
		x = y;
		y = temp;
		System.out.println("After:a=" + x.name);
		System.out.println("After:b=" + y.name);
	}// I have modified your function so that the output will be what we would
		// like to see.
}
