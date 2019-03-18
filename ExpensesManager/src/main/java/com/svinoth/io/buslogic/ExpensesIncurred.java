package com.svinoth.io.buslogic;

import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.stream.Collectors;

import com.svinoth.io.resource.UserTravelExpenses;
import com.svinoth.io.utils.AmountHightoLow;
import com.svinoth.io.utils.AmountLowtoHigh;

public class ExpensesIncurred {
	
	public void updatePayableList(List<UserTravelExpenses> userList) {
		
		PriorityQueue <UserTravelExpenses> Payer = new PriorityQueue<>(userList.size(), new AmountLowtoHigh());
		PriorityQueue <UserTravelExpenses> Creditor = new PriorityQueue<>(userList.size(), new AmountHightoLow());

		
		double DividedShare = (userList.stream().mapToDouble(u -> u.getAmount()).sum())/(userList.size());
		System.out.println("DividedShare per Person: " + DividedShare);

		userList.stream().forEach(e -> {
			if(DividedShare < e.getAmount()) {
				e.setBalance(e.getAmount() - DividedShare);
			}
			else if(DividedShare > e.getAmount()){
				e.setBalance(DividedShare - e.getAmount());
			}
		});
		
		/*Inserting the Users into the Sorting Queues - Creditor & Payer Queue,
		Streams not preferred below as the external objects used inside should be final it seems*/
		for(UserTravelExpenses user : userList) {
			if(DividedShare != user.getAmount())
				(DividedShare < user.getAmount() ? Creditor : Payer).add(user);
		}

		Iterator<UserTravelExpenses> creditor = Creditor.iterator();		
		while(creditor.hasNext()) {
			if((Creditor.peek().getBalance() != 0 || Payer.peek().getBalance() != 0)) {
				if(Creditor.peek().getBalance() < Payer.peek().getBalance()) {
					System.out.println("Mr." + Payer.peek().getUserName() + " have to pay a sum of Rs." + Creditor.peek().getBalance() + " to Mr." + Creditor.peek().getUserName());
					Payer.peek().setBalance(Payer.peek().getBalance() - Creditor.peek().getBalance());
					Payer.add(Payer.poll());	//Adding the polled element again to maintain the order
					//Creditor.peek().setBalance(0);
					Creditor.poll();
				}
				else if(Creditor.peek().getBalance() > Payer.peek().getBalance()) {
					System.out.println("Mr." + Payer.peek().getUserName() +" have to pay a sum of Rs."+ Payer.peek().getBalance() + " to Mr." + Creditor.peek().getUserName());
					Creditor.peek().setBalance(Creditor.peek().getBalance() - Payer.peek().getBalance());
					Creditor.add(Creditor.poll());		//Adding the polled element again to maintain the order
					//Payer.peek().setBalance(0);
					Payer.poll();

				}
				else {
					System.out.println("Mr." + Payer.peek().getUserName() + " have to pay a sum of Rs." + Payer.peek().getBalance() + " to Mr." + Creditor.peek().getUserName());
					//Creditor.peek().setBalance(0);
					Creditor.poll();
					//Payer.peek().setBalance(0);
					Payer.poll();
				}

			}
		}
	}
}
