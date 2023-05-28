package com.fprochazka.mockwrappedbean.testing.mocking;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.core.type.MethodMetadata;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * See {@link MockWrappedBean} for explanation.
 */
public class MockWrappedBeanResetBeanProcessor implements BeanFactoryPostProcessor
{

    @Override
    public void postProcessBeanFactory(final ConfigurableListableBeanFactory beanFactory)
    {
        if (!(beanFactory instanceof BeanDefinitionRegistry)) {
            throw new IllegalArgumentException(String.format("Expected beanFactory %s to be instance of %s", beanFactory.getClass(), BeanDefinitionRegistry.class));
        }

        for (String mockWrapperBeanName : beanFactory.getBeanNamesForAnnotation(MockWrappedBean.class)) {
            BeanDefinition mockWrapperBeanDefinition = beanFactory.getBeanDefinition(mockWrapperBeanName);
            if (!(mockWrapperBeanDefinition instanceof AnnotatedBeanDefinition annotatedBeanDefinition)) {
                throw new IllegalStateException("Definition for bean '%s' was expected to be of type %s, but %s found".formatted(mockWrapperBeanName, AnnotatedBeanDefinition.class, mockWrapperBeanDefinition.getClass()));
            }

            MethodMetadata factoryMethodMetadata = annotatedBeanDefinition.getFactoryMethodMetadata();
            if (factoryMethodMetadata == null) {
                throw new IllegalStateException("Definition for bean '%s' is missing factoryMethodMetadata".formatted(mockWrapperBeanName));
            }

            String realImplCandidateName = getRealImplCandidateNameNaively(beanFactory, mockWrapperBeanName, mockWrapperBeanDefinition);
            BeanDefinition realImplBeanDefinition = beanFactory.getBeanDefinition(realImplCandidateName);

            // disable autowiring into catch-all collections
            realImplBeanDefinition.setAutowireCandidate(false);

            // but since we've disabled autowiring, we now have to help Spring find the correct delegate
            mockWrapperBeanDefinition.getConstructorArgumentValues()
                .addGenericArgumentValue(new RuntimeBeanReference(realImplCandidateName));

            // prevents cyclic dependencies
            mockWrapperBeanDefinition.setDependsOn(realImplCandidateName);
        }
    }

    /**
     * This method is most of the reason why this is not a lib yet. Suggestions for improvements are welcome.
     */
    private static String getRealImplCandidateNameNaively(
        final ListableBeanFactory beanFactory,
        final String mockWrapperBeanName,
        final BeanDefinition mockWrapperBeanDefinition
    )
    {
        Set<String> realImplCandidateNames = new HashSet<>(Arrays.asList(beanFactory.getBeanNamesForType(mockWrapperBeanDefinition.getResolvableType())));
        realImplCandidateNames.remove(mockWrapperBeanName);

        if (realImplCandidateNames.size() != 1) {
            throw new IllegalStateException("We've tried to naively autowire real impl for bean factory '%s', which turned up %s, but we need exactly one candidate.".formatted(mockWrapperBeanName, realImplCandidateNames));
        }

        return realImplCandidateNames.iterator().next();
    }

}
