package com.fprochazka.mockwrappedbean.demo;

import org.springframework.stereotype.Service;

@Service
public class ExternalService
{

    public int fetchCounterExternally()
    {
        return 4; // https://xkcd.com/221/
    }

}
