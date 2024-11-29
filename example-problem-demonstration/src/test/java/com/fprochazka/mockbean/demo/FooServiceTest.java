package com.fprochazka.mockbean.demo;

import com.fprochazka.mockbean.testing.BaseTestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;

class FooServiceTest extends BaseTestCase
{

    @MockBean
    ExternalService externalService;

    @Autowired
    FooService fooService;

    @MockBean
    BarService barService;

    @MockBean
    BazService bazService;

    @Test
    public void computation()
    {
        Assertions.assertNotNull(externalService);
        Assertions.assertNotNull(barService);
        Assertions.assertNotNull(bazService);
        Assertions.assertNotNull(fooService);
    }

}
