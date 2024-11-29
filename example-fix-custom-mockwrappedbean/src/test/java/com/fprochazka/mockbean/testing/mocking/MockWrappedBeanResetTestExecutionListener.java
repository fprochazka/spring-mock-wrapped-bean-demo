package com.fprochazka.mockbean.testing.mocking;

import org.mockito.Mockito;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

/**
 * See {@link MockWrappedBean} for explanation.
 */
public class MockWrappedBeanResetTestExecutionListener extends AbstractTestExecutionListener
{

    private final Map<ApplicationContext, List<String>> beanNamesCache = Collections.synchronizedMap(new IdentityHashMap<>());

    @Override
    public void beforeTestMethod(final TestContext testContext)
    {
        Mockito.reset(
            getBeansForCurrentContext(testContext.getApplicationContext())
        );
    }

    @Override
    public void afterTestMethod(final TestContext testContext)
    {
        Mockito.reset(
            getBeansForCurrentContext(testContext.getApplicationContext())
        );
    }

    private Object[] getBeansForCurrentContext(final ApplicationContext applicationContext)
    {
        var beanNames = getBeanNamesForCurrentContext(applicationContext);
        return beanNames.stream()
            .map(applicationContext::getBean)
            .toArray(Object[]::new);
    }

    private List<String> getBeanNamesForCurrentContext(final ApplicationContext applicationContext)
    {
        return beanNamesCache.computeIfAbsent(
            applicationContext,
            c -> findMockWrappedBeanNames(applicationContext)
        );
    }

    private List<String> findMockWrappedBeanNames(
        final ApplicationContext applicationContext
    )
    {
        return List.of(applicationContext.getBeanNamesForAnnotation(MockWrappedBean.class));
    }

}
