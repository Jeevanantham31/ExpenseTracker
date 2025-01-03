package com.expensetracker;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
        UserService userService = new UserService();
        User currentUser = null;

        System.out.println("\n----------------------------------------------------------------------");
        System.out.println("-------------------- Welcome to Expense Tracker-----------------------");
        System.out.println("----------------------------------------------------------------------");
        
        while(true) {
        	System.out.println();
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            
            int choice = s.nextInt();
            s.nextLine();
            
            switch(choice) {
            case 1:
                System.out.print("Enter username: ");
                String username = s.nextLine();
                System.out.print("Enter password: ");
                String password = s.nextLine();

                if (userService.registerUser(username, password)) {
                    System.out.println("Registration successful...!");
                } else {
                    System.out.println("Username already taken.");
                }
                break;
            case 2:
                System.out.print("Enter username: ");
                username = s.nextLine();
                
                System.out.print("Enter password: ");
                password = s.nextLine();
                
                currentUser = userService.loginUser(username, password);
                
                if (currentUser != null) {
                    System.out.println("Login successful...!");
                    manageExpenses(s, currentUser);
                } else {
                    System.out.println("Invalid credentials.");
                }
                break;
            case 3:
                System.out.println("Thank you...!");
                return;
            default:
                System.out.println("Invalid choice. Try again.");
            }
        }
	}

    private static void manageExpenses(Scanner s, User user) {
        while (true) {
        	System.out.println();
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Delete Expense");
            System.out.println("4. Logout");
            int choice = s.nextInt();
            s.nextLine();

            switch (choice) {
            case 1:
                System.out.print("Enter description: ");
                String description = s.nextLine();
                
                System.out.print("Enter amount: ");
                double amount = s.nextDouble();
                s.nextLine(); 
                
                System.out.print("Enter date (YYYY-MM-DD): ");
                String date = s.nextLine();
                
                Expense expense = new Expense(description, amount, date);
                user.addExpense(expense);
                break;
            case 2:
                if(user.getExpenses().isEmpty()) {
                	System.out.println("No Expenses found");
                }else {
                    System.out.println("Expenses:");
                	for (Expense e : user.getExpenses()) {
                		System.out.println(e);
                	}
                }
                break;
            case 3:
            	if (user.getExpenses().isEmpty()) {
            		System.out.println("No expenses to delete."); 
            		} else {
            			System.out.print("Enter the index of the expense to delete: ");
            			int index = s.nextInt(); 
            			s.nextLine(); 
            			if (user.removeExpense(index)) {
            				System.out.println("Expense deleted successfully."); 
            				} else {
            					System.out.println("Invalid index. Try again."); 
            				}
            			}
            	break;
            case 4:
            	return;
            default:
                System.out.println("Invalid choice. Try again.");
        }
      }
    }
}

