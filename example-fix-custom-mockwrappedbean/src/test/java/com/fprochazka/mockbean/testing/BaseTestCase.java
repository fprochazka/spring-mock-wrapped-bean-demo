package com.fprochazka.mockbean.testing;

import com.fprochazka.mockbean.demo.DemoApplication;
import com.fprochazka.mockbean.testing.mocking.MockWrappedBeanResetTestExecutionListener;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

@SpringBootTest(
    classes = {
        // import main application context
        DemoApplication.class,
        // test configs
        TestsConfiguration.class,
        // application overrides for tests
        TestOverridesConfiguration.class,
    }
)
@TestExecutionListeners(
    listeners = {
        DependencyInjectionTestExecutionListener.class,
        MockWrappedBeanResetTestExecutionListener.class,
    },
    inheritListeners = true
)
public abstract class BaseTestCase
{

}
