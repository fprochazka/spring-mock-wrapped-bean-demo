package com.fprochazka.mockbean.testing;

import com.fprochazka.mockbean.testing.mocking.MockWrappedBeanResetBeanProcessor;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class TestsConfiguration
{

    @Bean
    public MockWrappedBeanResetBeanProcessor mockWrappedBeanResetBeanProcessor()
    {
        return new MockWrappedBeanResetBeanProcessor();
    }

}
