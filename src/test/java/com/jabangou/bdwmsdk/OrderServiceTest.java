package com.jabangou.bdwmsdk;

import com.jiabangou.bdwmsdk.api.OrderService;
import com.jiabangou.bdwmsdk.exception.BdWmErrorException;
import com.jiabangou.bdwmsdk.model.OrderDetail;
import org.junit.Test;

/**
 * Created by wanglei on 16-8-19.
 */
public class OrderServiceTest extends ServiceTest {

    @Test
    public void confirmOrder() throws BdWmErrorException {
        OrderService orderService = this.getBdWmClient().getOrderService();
        orderService.confirm("14577747357622");

    }

    @Test
    public void completeOrder() throws BdWmErrorException {
        OrderService orderService = this.getBdWmClient().getOrderService();
        orderService.complete("14577747357622");

    }

    @Test
    public void cancel() throws BdWmErrorException {
        OrderService orderService = this.getBdWmClient().getOrderService();
        orderService.cancel("14576969553529", 1, "不在配送范围内");

    }

    @Test
    public void orderList() throws BdWmErrorException {
        OrderService orderService = this.getBdWmClient().getOrderService();
        orderService.getOrderLites(1457625600, 1458316800);

    }

    @Test
    public void getOrder() throws BdWmErrorException {
        OrderService orderService = this.getBdWmClient().getOrderService();
        OrderDetail orderDetail = orderService.getOrderDetail("14601106253275");
        System.out.print(1);
    }
}
