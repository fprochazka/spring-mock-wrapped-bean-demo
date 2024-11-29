package com.fprochazka.mockbean.demo;

import com.fprochazka.mockbean.testing.BaseTestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;

class BazServiceTest extends BaseTestCase
{

    @Autowired
    BarService barService;

    @MockBean
    BazService bazService;

    @Autowired
    FooService fooService;

    @Test
    public void businessAction()
    {
        Assertions.assertNotNull(barService);
        Assertions.assertNotNull(bazService);
        Assertions.assertNotNull(fooService);
    }

}
