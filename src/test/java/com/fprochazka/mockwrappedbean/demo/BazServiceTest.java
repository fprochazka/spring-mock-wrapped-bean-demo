package com.fprochazka.mockwrappedbean.demo;

import com.fprochazka.mockwrappedbean.testing.BaseTestCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

class BazServiceTest extends BaseTestCase
{

    @Autowired
    BazService bazService;

    @Test
    public void businessAction()
    {
        // externalService is not mocked, the real method will be called

        int actual = bazService.businessAction();

        assertThat(actual).isEqualTo(17);
    }

}
