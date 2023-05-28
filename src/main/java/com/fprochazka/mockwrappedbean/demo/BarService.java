package com.fprochazka.mockwrappedbean.demo;

import org.springframework.stereotype.Service;

@Service
public class BarService
{

    public int subComputation(final int value)
    {
        return value + 5;
    }

}
