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
     * Purpose: subtracts parameter amount from the balance instance variable
     * @param amount the amount to be subtracted from the instance variable amount
     * @post reduces the balance by amount, no value will be subtracted if amount is negative and/or smaller than balance
     */
    public void withdraw (double amount)  {
        if (amount <= balance && amount > 0){
            balance -= amount;
        }
    }

    //static means you can call the method without the object, or without instantiating
    //can't refer to object, which means you can't use email and balance instance variables in this method
    //unit testing allows us to see that this specific method is working, and that it is not a problem with an object
    //this is a pure method because it does not change anything



    /** Purpose: to determine if an email is in the correct format. There must be at least one character followed by an @ sign
     * followed by at least one character and a period, and then at least one character after the period
     * @param email the email that will be validated in the form of a String
     * @return a boolean, true if the email is valid and false if it is not
     */
    public static boolean isEmailValid(String email){
        if (email.indexOf('@') == -1 || email.indexOf('.') == -1){
            return false;
        }
        else {
            if (email.indexOf('@') > 0 && email.indexOf('@') < (email.indexOf('.')-1) && email.indexOf('.') != email.length()-1){
                return true;
            }
            else{
                return false;
            }
        }
    }

    /**
     * Purpose: to ensure that a certain value has two decimal places or less and is not negative
     * @param amount the value to be checked
     * @return true if amount is valid, or false if it is not
     */
    public static boolean isAmountValid(double amount){
        if (amount < 0){
            return false;
        }
        else{
            String stringVal = String.valueOf(amount);
            int indexof = stringVal.indexOf(".");

            if (stringVal.length()>indexof+3){
                return false;
            }
            else{
                return true;
            }
        }
    }
}
