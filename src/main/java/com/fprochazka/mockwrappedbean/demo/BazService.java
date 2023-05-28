package com.fprochazka.mockwrappedbean.demo;

import org.springframework.stereotype.Service;

@Service
public class BazService
{

    private final FooService fooService;

    public BazService(
        final FooService fooService
    )
    {
        this.fooService = fooService;
    }

    public int businessAction()
    {
        int result = fooService.computation() - 1;
        return result;
    }

}
