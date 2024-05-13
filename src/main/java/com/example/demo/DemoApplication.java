package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.*;
import java.security.SecureRandom;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.FileNotFoundException;
import java.net.Socket;

@SpringBootApplication
public class DemoApplication {

	// Create a scanner object
	private static final Scanner scanner = new Scanner(System.in);

	//Never Used Variable with Bad format example
	private String A_BAD_USER_NAME = "admin";
	private String A_BAD_USER_PASSWORD = "password123";  // Hard-coded password

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);

		// Print a message to the console
		System.out.println("Financial Calculator Started");

		Date date = new Date(); // Using deprecated constructor
		System.out.println("Current date is : " + date);

		while (true) {
			// Print a message to the console
			System.out.println("Enter command (LOAN, PVALUE, END):");
			// Read  input string  from the console
			String command = scanner.nextLine().trim().toUpperCase();
			//Switch case started
			switch (command) {
				case "LOAN":
					calculateLoan();
					//break;
					// Missing break statement here
				case "PVALUE":
					calculatePresentValue();
					break;
				case "END":
					System.out.println("Financial Calculator Ended");
					return;
				default:
					System.out.println("Invalid command. Please try again.");
			}
		}
	}

	//Loan calculation Method
	public static void calculateLoan() {
		System.out.println("Enter loan amount, interest rate, and number of periods (separated by space):");
		double loanAmount = scanner.nextDouble();
		double interestRate = scanner.nextDouble();
		int numberOfPeriods = scanner.nextInt();

		double monthlyInterestRate = interestRate / 12 / 100;
		double monthlyPayment = (loanAmount * monthlyInterestRate) /
				(1 - Math.pow(1 + monthlyInterestRate, -numberOfPeriods));

		System.out.printf("Monthly Payment: %.2f\n", monthlyPayment);
	}

	//present value calculation method
	public static void calculatePresentValue() {
		System.out.println("Enter cash flow amounts followed by interest rate (last input):");
		double totalValue = 0.0;
		double interestRate;
		while (true) {
			double input = scanner.nextDouble();
			if (input < 0) {
				interestRate = -input;
				break;
			}
			totalValue += input;
		}

		double presentValue = totalValue / (1 + interestRate / 100);
		System.out.printf("Present Value: %.2f\n", presentValue);
	}

	//Excessive String Concatenation Example
	public static void concatString() {
		String result = "";
		for (int i = 0; i < 1000; i++) {
			result += "some more data";
		}
	}

	//Long Complex Method example
	public static int overlyComplexMethod(int x) {
		int result = 0;
		if (x > 0) {
			if (x % 2 == 0) {
				for (int i = 0; i < x; i++) {
					if (i % 2 == 0) {
						result += i;
					} else {
						result -= i;
					}
				}
			} else {
				for (int i = 1; i < x; i++) {
					if (i % 2 == 0) {
						result += i;
					} else {
						result -= i;
					}
				}
			}
		} else {
			result = -1;
		}
		return result;
	}
	//Null Pointer Example
	public static void StringLength() {
		String str= null;
		int length = str.length();
		System.out.println("String length is : " + length);
	}

	//raw Type example
	public static void printList(List list) {  // Raw type List is used here
		for (Object item : list) {
			System.out.println(item);
		}
	}
	//Code Smell Example
	public static String findEmpSalary(String companyName, String country, String role) {
		String empSalary = "";
		if (companyName.equalsIgnoreCase("Accenture")) {
			if (country.equalsIgnoreCase("USA")) {
				if (role.equalsIgnoreCase("FTE")) {
					empSalary = "100K";
				}
			}
		}
		return empSalary;
	}
	// Code Duplicate Example
	public static int getSum(int n) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			// Similar logic here
			sum += i;
		}
		return sum;
	}
	// Code Duplicate Example
	public static int addNumbers(int x) {
		int result = 0;
		for (int i = 0; i < x; i++) {
			// Similar logic here
			result += i;
		}
		return result;
	}
	//Inefficient String Concatenation Example
	public static void InefficientStringConcatenation() {
		String result = "";
		for (int i = 0; i < 1000; i++) {
			result += i; // Inefficient string concatenation
		}
		System.out.println(result);
	}

	//Insecure Randomness Example
	public static void InsecureRandomness() {
		SecureRandom secureRandom = new SecureRandom(); // Secure random number generator

		byte[] secureRandomBytes = new byte[16]; // Generate secure random bytes
		secureRandom.nextBytes(secureRandomBytes);
		System.out.println("Secure random bytes: " + secureRandomBytes);
	}

	//Resource Leak Example
	public static void ResourceLeakError() throws IOException, SQLException {
		FileInputStream inputStream = new FileInputStream(new File("example.txt"));
		// Do something with inputStream
		// Forget to close the inputStream

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
		// Do something with the connection
		// Forget to close the connection

		Socket socket = new Socket("localhost", 8080);
		// Use the socket for communication
		// Forget to close the socket
	}

	// Exception Handling Example
	public static void ExceptionExample() throws FileNotFoundException {
		try {
			// Attempt to read from a file that doesn't exist
			File file = new File("nonexistentfile.txt");
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());
			}
			scanner.close();
		} catch (Exception e) {
			// Catching overly broad exception type
			System.out.println("An error occurred: " + e.getMessage());
		}

		// Unhandled checked exception
		throw new FileNotFoundException("File not found exception");
	}

	//memory leaks Example
	public static void loadData() {
		List<byte[]> cache = new ArrayList<>();
		byte[] largeData = new byte[1024 * 1024 * 100]; // 100MB
		cache.add(largeData);
	}

	//Performance Bottlenecks Example
	public static void arrayListPerformance() {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 1000000; i++) {
			list.add(i);
		}
	}
	//Excessive Local Variable Example
	public static void sumNumbers() {
		int a = 1;
		int b = 2;
		int c = 3;
		int d = 4;
		int e = 5;
		int f = 6;
		int g = 7;
		int h = 8;
		int i = 9;
		int j = 10;
		int k = 11;
		int l = 12;
		int m = 13;
		int n = 14;
		int o = 15;
		int p = 16;
		int q = 17;
		int r = 18;
		int s = 19;
		int t = 20;
		int u = 21;
		int v = 22;
		int w = 23;
		int x = 24;
		int y = 25;
		int z = 26;
		int aa = 27; // Unused variable
		int ab = 28; // Unused variable

		// Some operation using these variables
		int result = a + b + c + d + e + f + g + h + i + j + k + l + m + n + o + p + q + r + s + t + u + v + w + x + y + z;
		System.out.println("Result: " + result);
	}

	//Mutable Static Fields Example
	private static int counter = 0; // Mutable static field

	public static void MutableStaticFieldsExample() {
		Thread thread1 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				incrementCounter();
			}
		});

		Thread thread2 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				incrementCounter();
			}
		});

		thread1.start();
		thread2.start();

		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Counter value: " + counter);
	}

	private static void incrementCounter() {
		counter++; // Modifying mutable static field without synchronization
	}

}
