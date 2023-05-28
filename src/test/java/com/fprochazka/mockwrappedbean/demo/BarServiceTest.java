package com.fprochazka.mockwrappedbean.demo;

import com.fprochazka.mockwrappedbean.testing.BaseTestCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

class BarServiceTest extends BaseTestCase
{

    @Autowired
    BarService barService;

    @Test
    public void subComputation()
    {
        int actual = barService.subComputation(5);
        assertThat(actual).isEqualTo(10);
    }

}
