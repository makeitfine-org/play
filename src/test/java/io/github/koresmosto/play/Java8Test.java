package io.github.koresmosto.play;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

interface ITemp {

    default String method() {
        return "default method";
    }
}

class Temp implements ITemp {

    @Override
    public String method() {
        return ITemp.super.method() + " override";
    }
}

class Java8Test {

    @Test
    public void newStringMethods() {
        assertEquals("default method", new ITemp() {
        }.method());

        assertEquals("default method override", new Temp().method());
    }
}
