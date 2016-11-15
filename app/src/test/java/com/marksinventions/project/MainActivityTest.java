package com.marksinventions.project;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Mark on 11/2/2016.
 */
public class MainActivityTest {
    @Test
    public void testTemp() throws Exception {
       assertEquals(MainActivity.temp(2,3), 6);

    }

}