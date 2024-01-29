package com.ll.ttd;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AccountTest {

    @Test
    void testAccount() {
        Account account = new Account();

        if (account == null) {
            try {
                throw new Exception("계좌생성 실패");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}