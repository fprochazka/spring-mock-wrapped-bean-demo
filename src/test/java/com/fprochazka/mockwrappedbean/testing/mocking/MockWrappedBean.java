package com.fprochazka.mockwrappedbean.testing.mocking;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Primary;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Using {@link MockBean} is problematic, because it "dirties" (not really, but the result is the same) the context.
 * Dirty context means slower tests, because the context has to be rebuilt for each test.
 * <p/>
 * So instead of defining mocks in individual tests, we'll replace services with delegating mocks globally,
 * and then we can easily configure expected behaviour and reset them between tests.
 * <p/>
 * See {@link MockWrappedBeanResetTestExecutionListener}
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Qualifier
@Primary
public @interface MockWrappedBean
{

}
