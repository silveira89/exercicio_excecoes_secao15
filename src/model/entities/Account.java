package model.entities;

import model.exception.DomainException;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withDrawnLimit;
	
	public Account() {
		
	}

	public Account(Integer number, String holder, Double balance, Double withDrawnLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withDrawnLimit = withDrawnLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getWithDrawnLimit() {
		return withDrawnLimit;
	}

	public void setWithDrawnLimit(Double withDrawnLimit) {
		this.withDrawnLimit = withDrawnLimit;
	}

	public Double getBalance() {
		return balance;
	}
	
	public void deposit(Double amount) {
		balance += amount;
	}
	
	public void withDraw(Double amount) throws DomainException {
		if (amount > withDrawnLimit) {
			throw new DomainException("The amount exceeds withdraw limit.");
		} else if (amount > balance) {
			throw new DomainException("Not enough balence.");
		} else {
			balance -= amount;
		}
	}
	
}
