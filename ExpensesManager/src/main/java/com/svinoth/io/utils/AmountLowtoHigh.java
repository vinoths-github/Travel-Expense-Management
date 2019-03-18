package com.svinoth.io.utils;

import java.util.Comparator;

import com.svinoth.io.resource.UserTravelExpenses;

public class AmountLowtoHigh implements Comparator<UserTravelExpenses>{
	
	public int compare(UserTravelExpenses s1, UserTravelExpenses s2) {
        if (s1.getAmount() > s2.getAmount())
            return 1;
        else if (s1.getAmount() < s2.getAmount())
            return -1;
        return 0; 
    }

}
