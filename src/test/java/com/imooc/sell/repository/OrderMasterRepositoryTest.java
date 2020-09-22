package com.imooc.sell.repository;

import com.imooc.sell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {
    @Autowired
    private OrderMasterRepository repository;
    @Test
    public void saveTest(){
        OrderMaster orderMaster=new OrderMaster();
        orderMaster.setOrderId("123457");
        orderMaster.setBuyerName("实习");
        orderMaster.setBuyerPhone("1333333333");
        orderMaster.setBuyerAddress("慕课网");
        orderMaster.setBuyerOpenid("113");
        orderMaster.setOrderAmount(new BigDecimal(23.5));
        OrderMaster result=repository.save(orderMaster);
        Assert.assertNotNull(result);
    }
    @Test
    public void findByBuyerOpenid() {
        PageRequest request=new PageRequest(0,2);
        Page<OrderMaster> result=repository.findByBuyerOpenid("113",request);
        System.out.println(result.getTotalElements());
    }
}