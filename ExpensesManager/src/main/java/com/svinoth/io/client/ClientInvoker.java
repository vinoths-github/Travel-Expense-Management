package com.svinoth.io.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.svinoth.io.buslogic.ExpensesIncurred;
import com.svinoth.io.resource.UserTravelExpenses;

public class ClientInvoker {

	public static void main(String[] args) {
		ExpensesIncurred expenses = new ExpensesIncurred();
		
		List<UserTravelExpenses> UserList = new ArrayList<>();
		String username, flag = "y";
		double i;
		boolean friends = false;
		
		Scanner sc = new Scanner(System.in);

		while(!friends) {
			System.out.println("UserName :");
			username = sc.next();
			System.out.println("Total Amount Spent :");
			i = sc.nextDouble();
			UserList.add(new UserTravelExpenses(username, i));
			System.out.println("Want to add more Users for this Travel ?(y/n)");
			flag = sc.next();
			if(!(flag.charAt(0) == 'y' || flag.charAt(0) == 'Y'))
				friends =true;		
		}
		sc.close();
		expenses.updatePayableList(UserList);
	}
}
