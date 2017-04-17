package com.amy;

import com.amy.controller.HomeController;
import org.junit.Test;

import junit.framework.TestSuite;
import org.springframework.test.context.TestExecutionListeners;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class AppTest 
{
    @Test
    public void testApp() {
        HomeController hc = new HomeController();
        String result = hc.home();
        assertEquals( result, "Das Boot!");

    }
}
