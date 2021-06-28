package com.JavaBasicQuestions;

import java.util.Date;

public final class Check {
	private final int amount;
    private final Date dateTime;
 
    public Check(int amount, Date dateTime) {
        this.amount = amount;
        this.dateTime = dateTime;
    }
 
    public int getAmount() {
        return amount;
    }
 
    public Date getDateTime() {
        return dateTime;
    }
}
