package com.fprochazka.mockbean.testing;

import com.fprochazka.mockbean.demo.DemoApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import org.springframework.boot.test.mock.mockito.ResetMocksTestExecutionListener;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

@SpringBootTest(
    classes = {
        // import main application context
        DemoApplication.class,
        // application overrides for tests
        TestOverridesConfiguration.class,
    }
)
@TestExecutionListeners(
    listeners = {
        DependencyInjectionTestExecutionListener.class,
        MockitoTestExecutionListener.class,
        ResetMocksTestExecutionListener.class,
    },
    inheritListeners = true
)
public abstract class BaseTestCase
{

}
