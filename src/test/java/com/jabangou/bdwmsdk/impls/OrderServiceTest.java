package com.jabangou.bdwmsdk.impls;

import com.jabangou.bdwmsdk.ServiceTest;
import com.jiabangou.bdwmsdk.api.OrderService;
import com.jiabangou.bdwmsdk.exception.BdWmErrorException;
import com.jiabangou.bdwmsdk.model.OrderDelivery;
import com.jiabangou.bdwmsdk.model.OrderDetail;
import org.junit.Test;

/**
 * Created by wanglei on 16-8-19.
 */
public class OrderServiceTest extends ServiceTest {

    @Test
    public void confirmOrder() throws BdWmErrorException {
        OrderService orderService = this.getBdWmClient().getOrderService();
        orderService.confirm("14787568788189");

    }

    @Test
    public void completeOrder() throws BdWmErrorException {
        OrderService orderService = this.getBdWmClient().getOrderService();
        orderService.complete("14577747357622");

    }

    @Test
    public void cancel() throws BdWmErrorException {
        OrderService orderService = this.getBdWmClient().getOrderService();
        orderService.cancel("14793606388453", 1, "不在配送范围内");

    }

    @Test
    public void orderList() throws BdWmErrorException {
        OrderService orderService = this.getBdWmClient().getOrderService();
        orderService.getOrderLites(1457625600, 1458316800);

    }

    @Test
    public void getOrder() throws BdWmErrorException {
        OrderService orderService = this.getBdWmClient().getOrderService();
        OrderDetail orderDetail = orderService.getOrderDetail("14775646932353");
        System.out.print(orderDetail);
    }

    @Test
    public void getOrderDelivery() throws BdWmErrorException {
        OrderService orderService = this.getBdWmClient().getOrderService();
        OrderDelivery orderDelivery = orderService.getOrderDelivery("14775646932353");
        System.out.print(orderDelivery);
    }
}
