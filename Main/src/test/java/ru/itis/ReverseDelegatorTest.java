package ru.itis;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by KFU-user on 03.11.2016.
 */
public class ReverseDelegatorTest {

    private ReverseDelegator delegator;
    @Before
    public void setUp() throws Exception {
        delegator = new ReverseDelegator();
    }

    @Test
    public void reverse() throws Exception {
        String expected = "abc";
        String actual = delegator.reverse("cba");

        assertEquals(expected, actual);
    }

}