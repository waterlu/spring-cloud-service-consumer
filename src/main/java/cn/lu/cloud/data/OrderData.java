package cn.lu.cloud.data;

import cn.lu.cloud.entity.Order;
import com.google.common.base.Strings;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by lutiehua on 2017/10/10.
 */
public class OrderData {

    private static Map<String, Order> orderMap = new HashMap<>();

    public static Order add(Order order) {
        if (Strings.isNullOrEmpty(order.getProductUuid())) {
            return null;
        }

        if (Strings.isNullOrEmpty(order.getUserUuid())) {
            return null;
        }

        if (Strings.isNullOrEmpty(order.getAccountUuid())) {
            return null;
        }

        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replaceAll("-", "");
        order.setOrderUuid(uuid);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        Date now = new Date();
        String date = dateFormat.format(now);
        String orderCode = String.format("PO%s%05d", date, orderMap.size() + 1);
        order.setOrderCode(orderCode);
        order.setDate(now);

        orderMap.put(uuid, order);
        return order;
    }

    public static Order get(String orderUuid) {
        return orderMap.get(orderUuid);
    }

    public static List<Order> getAll() {
        List<Order> orderList = new ArrayList<>();
        orderList.addAll(orderMap.values());
        Collections.sort(orderList, new Comparator<Order>() {
            @Override
            public int compare(Order order1, Order order2) {
                return order1.getOrderCode().compareTo(order2.getOrderCode());
            }
        });
        return orderList;
    }

}
