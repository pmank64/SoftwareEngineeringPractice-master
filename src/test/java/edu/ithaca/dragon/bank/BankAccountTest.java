package edu.ithaca.dragon.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void getBalanceTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    void withdrawTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 1000);
        bankAccount.withdraw(100);
        assertEquals(900, bankAccount.getBalance());
        bankAccount.withdraw(900.01);
        assertEquals(900, bankAccount.getBalance());
        bankAccount.withdraw(-10);
        assertEquals(900, bankAccount.getBalance());
        bankAccount.withdraw(-900.01);
        assertEquals(900, bankAccount.getBalance());
        bankAccount.withdraw(899.99);
        assertEquals(0.01, bankAccount.getBalance());
    }

    @Test
    void isEmailValidTest(){
        assertTrue(BankAccount.isEmailValid( "a@b.com"));
        assertFalse( BankAccount.isEmailValid(""));
        assertFalse( BankAccount.isEmailValid("a@.com"));
        assertFalse( BankAccount.isEmailValid("@l.com"));
        assertFalse( BankAccount.isEmailValid("a@b."));
        assertFalse( BankAccount.isEmailValid("ab.com"));
        assertFalse( BankAccount.isEmailValid("q@abcom"));
        assertFalse( BankAccount.isEmailValid("abcd"));
    }

    //the constructor relies on other methods and code so it is not really a perfect unit test
    @Test
    void constructorTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals("a@b.com", bankAccount.getEmail());
        assertEquals(200, bankAccount.getBalance());
        //check for exception thrown correctly
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("", 100));
    }

}