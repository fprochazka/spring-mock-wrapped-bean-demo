package com.fprochazka.mockbean.demo;

import com.fprochazka.mockbean.testing.BaseTestCase;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

class FooServiceTest extends BaseTestCase
{

    @Autowired
    ExternalService externalService;

    @Autowired
    FooService fooService;

    @Test
    public void computation()
    {
        Mockito.doReturn(42).when(externalService).fetchCounterExternally();

        int actual = fooService.computation();

        assertThat(actual).isEqualTo(94);

        Mockito.verify(externalService, Mockito.times(1)).fetchCounterExternally();
    }

}
