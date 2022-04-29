package com.example.pbt;

import com.example.pbt.ereditance.Circle;
import com.example.pbt.strategy.Service;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StrategyTest {

    @Autowired
    Service service;

    @Test
    public void testConstructor() {
        Assert.assertEquals("Err",service.execute(Service.AvailableComm.ERR));
        Assert.assertEquals("Out",service.execute(Service.AvailableComm.OUT));
    }


}
