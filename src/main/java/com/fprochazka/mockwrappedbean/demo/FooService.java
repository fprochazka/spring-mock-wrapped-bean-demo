package com.fprochazka.mockwrappedbean.demo;

import org.springframework.stereotype.Service;

@Service
public class FooService
{

    private final ExternalService externalService;
    private final BarService barService;

    public FooService(
        final ExternalService externalService,
        final BarService barService
    )
    {
        this.externalService = externalService;
        this.barService = barService;
    }

    public int computation()
    {
        int counterValue = externalService.fetchCounterExternally();
        int subComputation = barService.subComputation(counterValue);
        return logic(subComputation);
    }

    private int logic(final int value)
    {
        return value * 2;
    }

}
