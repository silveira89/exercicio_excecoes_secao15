package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exception.DomainException;

public class Program {

	public static void main(String[] args) {
		
		try {
			Locale.setDefault(Locale.US);
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int number = sc.nextInt();
			sc.nextLine();
			System.out.print("Holder: ");
			String holder = sc.nextLine();
			System.out.print("Initial balance: ");
			double balance = sc.nextInt();
			System.out.print("Withdraw limit: ");
			double withDrawn = sc.nextDouble();
			Account c1 = new Account(number, holder, balance, withDrawn);
			System.out.println();
			System.out.print("Enter amount for withdraw: ");
			double amount = sc.nextDouble();
			c1.withDraw(amount);
			System.out.println("New balance: " + String.format("%.2f", c1.getBalance()));
			sc.close();
		} catch (DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
	}

}
