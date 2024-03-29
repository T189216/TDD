package com.ll.ttd;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
class AccountTest {
    private Account account;

    @Test
    @DisplayName("계좌 생성")
    public void testAccount() throws Exception {
        setup();

        if (account == null) {
            try {
                throw new Exception("계좌생성 실패");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    @DisplayName("잔고 조회")
    public void testGetBalance() throws Exception {
        setup();
        assertEquals(10000, account.getBalance());

        account = new Account(1000);
        assertEquals(1000, account.getBalance());

        account = new Account(0);
        assertEquals(0, account.getBalance());
    }

    public void setup() {
        account = new Account(10000);
    }

    @Test
    @DisplayName("입금")
    public void testDeposit() throws Exception {
        setup();
        account.deposit(1000);
        assertEquals(11000, account.getBalance());
    }

    @Test
    @DisplayName("출금")
    public void testWithdraw() throws Exception {
        setup();
        account.withdraw(1000);
        assertEquals(9000, account.getBalance());
    }
}