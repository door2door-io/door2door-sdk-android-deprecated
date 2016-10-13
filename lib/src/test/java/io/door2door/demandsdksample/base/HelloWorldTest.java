package io.door2door.demandsdksample.base;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class HelloWorldTest {

    private HelloWorld helloWorld;

    @Before
    public void setUp() {
        helloWorld = new HelloWorld();
    }

    @Test
    public void shouldGetHelloWorld() {
        // given

        // when
        String helloWorldString = helloWorld.getHelloWorld();

        // then
        assertThat(helloWorldString).isEqualTo("Hello World");
    }

}