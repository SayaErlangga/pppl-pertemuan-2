import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WalletTest {

    @Test
    void setOwner() {
        Wallet wallet = new Wallet("Losi");
        assertEquals("Losi", wallet.setOwner());
    }

    @Test
    void addCard() {
        Wallet wallet = new Wallet();
        wallet.addCard("Bank Jago");
        assertTrue(wallet.listKartu.contains("Bank Jago"));
    }

    @Test
    void removeCard() {
        Wallet wallet = new Wallet();
        wallet.addCard("Line Bank");
        assertTrue(wallet.listKartu.contains("Line Bank"));
        wallet.removeCard("Line Bank");
        assertFalse(wallet.listKartu.contains("Line Bank"));
    }

    @Test
    void depositLembaran() {
        Wallet wallet = new Wallet();
        wallet.deposit(1500);
        assertTrue(wallet.listUangLembaran.contains(1500));
    }

    @Test
    void depositKoin() {
        Wallet wallet = new Wallet();
        wallet.deposit(500);
        assertTrue(wallet.listUangKoin.contains(500));
    }

    @Test
    void withdrawLembaran() {
        Wallet wallet = new Wallet();
        wallet.deposit(1000);
        wallet.withdraw(1000);
        assertFalse(wallet.listUangLembaran.contains(1000));
    }

    @Test
    void withdrawKoin() {
        Wallet wallet = new Wallet();
        wallet.deposit(500);
        wallet.withdraw(500);
        assertFalse(wallet.listUangLembaran.contains(500));
    }

    @Test
    void tampilkanUang() {
        Wallet wallet = new Wallet();
        wallet.deposit(1000);
        wallet.deposit(500);
        assertEquals(1500, wallet.tampilkanUang());
    }
}