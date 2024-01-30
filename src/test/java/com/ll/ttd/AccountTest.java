package com.ll.ttd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
class AccountTest {

    @Test
    @DisplayName("계좌 생성")
    public void testAccount() throws Exception {
        Account account = new Account(10000);

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
        Account account = new Account(10000);

        if (account.getBalance() != 10000) {
            fail("getBalance() => " + account.getBalance() );
        }

        account = new Account(1000);
        if (account.getBalance() != 1000) {
            fail();
        }

        account = new Account(0);
        if (account.getBalance() != 0) {
            fail();
        }
    }
}