package com.fprochazka.mockbean.testing;

import com.fprochazka.mockbean.demo.BarService;
import com.fprochazka.mockbean.demo.BazService;
import com.fprochazka.mockbean.demo.ExternalService;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.SpyBean;

/**
 * <b>SERVICE MOCKING</b>: if you need to mock any service, add it here as {@link SpyBean}.
 * Do not add it anywhere else otherwise it's going to multiply spring contexts and slow down the test suite.
 * Once you define the {@link SpyBean} here, autowire the service normally.
 */
@SuppressWarnings("unused")
@TestConfiguration
public class TestOverridesConfiguration
{

    @SpyBean
    private BarService barService;

    @SpyBean
    private BazService bazService;

    @SpyBean
    private ExternalService externalService;

}
