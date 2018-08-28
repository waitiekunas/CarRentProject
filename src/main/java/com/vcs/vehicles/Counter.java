package com.vcs.vehicles;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
@Qualifier("counter")
public class Counter {


    private static int counter = 0;


    public int increasesCounter() {
        counter++;
        return counter;
    }
}
