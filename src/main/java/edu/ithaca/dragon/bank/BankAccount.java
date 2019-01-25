package edu.ithaca.dragon.bank;

public class BankAccount {

    private String email;
    private double balance;

    /**
     * @throws IllegalArgumentException if email is invalid
     */
    public BankAccount(String email, double startingBalance){
        if (isEmailValid(email)){
            this.email = email;
            this.balance = startingBalance;
        }
        else {
            throw new IllegalArgumentException("Email address: " + email + " is invalid, cannot create account");
        }
    }

    public double getBalance(){
        return balance;
    }

    public String getEmail(){
        return email;
    }

    /**
     * @post reduces the balance by amount if amount is non-negative and smaller than balance
     */
    public void withdraw (double amount)  {
        balance -= amount;

    }

    //static means you can call the method without the object, or without instantiating
    //can't refer to object, which means you can't use email and balance instance variables in this method
    //unit testing allows us to see that this specific method is working, and that it is not a problem with an object
    //this is a pure method because it does not change anything


    /* Purpose: to determine if an email is in the correct format. There must be at least one character followed by an @ sign
     * followed by at least one character and a period, and then at least one character after the period
     * @param the email that will be validated in the form of a String
     * @return a boolean, true if the email is valid and false if it is not
     */
    public static boolean isEmailValid(String email){
        if (email.indexOf('@') == -1){
            return false;
        }
        else {
            return true;
        }
    }
}
