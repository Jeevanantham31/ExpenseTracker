package com.expensetracker;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private List<Expense> expenses;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.expenses = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public List<Expense> getExpenses() {
        return expenses;
    }
    public void addExpense(Expense expense) {
        this.expenses.add(expense);
    }
    public boolean removeExpense(int index) { 
    	if (index >= 0 && index < expenses.size()) {
    		expenses.remove(index);
    		return true; 
    		} else {
    			return false; 
    			} 
    	}
    
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", expenses=" + expenses +
                '}';
    }
}
