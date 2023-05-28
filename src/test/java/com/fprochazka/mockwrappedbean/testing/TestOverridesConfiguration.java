package com.fprochazka.mockwrappedbean.testing;

import com.fprochazka.mockwrappedbean.demo.BarService;
import com.fprochazka.mockwrappedbean.demo.ExternalService;
import com.fprochazka.mockwrappedbean.demo.FooService;
import com.fprochazka.mockwrappedbean.testing.mocking.MockWrappedBean;
import org.mockito.AdditionalAnswers;
import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class TestOverridesConfiguration
{

    @MockWrappedBean
    @Bean
    public ExternalService externalServiceMock(final ExternalService real)
    {
        return Mockito.mock(ExternalService.class, AdditionalAnswers.delegatesTo(real));
    }

    @MockWrappedBean
    @Bean
    public FooService fooServiceMock(final FooService real)
    {
        return Mockito.mock(FooService.class, AdditionalAnswers.delegatesTo(real));
    }

    @MockWrappedBean
    @Bean
    public BarService barServiceMock(final BarService real)
    {
        return Mockito.mock(BarService.class, AdditionalAnswers.delegatesTo(real));
    }

}
