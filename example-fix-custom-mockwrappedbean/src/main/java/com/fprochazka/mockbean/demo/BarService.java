package com.fprochazka.mockbean.demo;

import org.springframework.stereotype.Service;

@Service
public class BarService
{

    public int subComputation(final int value)
    {
        return value + 5;
    }

}
