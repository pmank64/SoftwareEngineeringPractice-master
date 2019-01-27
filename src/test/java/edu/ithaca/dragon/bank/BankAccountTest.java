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
        bankAccount.withdraw(901);
        assertEquals(900, bankAccount.getBalance());
        bankAccount.withdraw(-10);
        assertEquals(900, bankAccount.getBalance());
        bankAccount.withdraw(-901);
        assertEquals(900, bankAccount.getBalance());
        bankAccount.withdraw(899);
        assertEquals(1.00, bankAccount.getBalance());

        BankAccount bankAccount2 = new BankAccount("a@b.com", 1000);
        bankAccount2.withdraw(-10.12);
        assertEquals(1000, bankAccount.getBalance());
        bankAccount2.withdraw(-10.01);
        assertEquals(1000, bankAccount.getBalance());
        bankAccount2.withdraw(10.001);
        assertEquals(1000, bankAccount.getBalance());
        bankAccount2.withdraw(50.324322);
        assertEquals(1000, bankAccount.getBalance());
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
    @Test
    void isAmountValidTest(){
        assertTrue(BankAccount.isAmountValid(100));
        assertTrue(BankAccount.isAmountValid(0.01));
        assertTrue(BankAccount.isAmountValid(5000));
        assertTrue(BankAccount.isAmountValid(0));

        assertFalse( BankAccount.isAmountValid(-0.01));
        assertFalse( BankAccount.isAmountValid(-10));
        assertFalse( BankAccount.isAmountValid(-50000));
        assertFalse( BankAccount.isAmountValid(0.001));
        assertFalse( BankAccount.isAmountValid(10.24322));
    }

    //the constructor relies on other methods and code so it is not really a perfect unit test
    @Test
    void constructorTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals("a@b.com", bankAccount.getEmail());
        assertEquals(200, bankAccount.getBalance());
        //check for exception thrown correctly
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("", 100));

        //check for negative numbers
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("a@b.com", -100));
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("a@b.com", -100.17));
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("a@b.com", -0.01));


        //check for numbers with more than 2 decimal places
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("a@b.com", 100.001));
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("a@b.com", 0.001));
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("a@b.com", 10.67321));
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("a@b.com", -10.67321));

    }

}