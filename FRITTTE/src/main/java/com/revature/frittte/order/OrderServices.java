package com.revature.frittte.order;

import com.revature.frittte.customer.Customer;
import com.revature.frittte.food.Food;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class OrderServices {
    private OrderDao orderDao;

    @Autowired // not really necessary, but good practice
    public OrderServices(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public OrderData create(OrderData newOrder) {

        OrderData persistedOrder = orderDao.save(newOrder);
        return persistedOrder;
    }

    public List<OrderData> findAllMyOrders(String username) {
        List<OrderData> allOrders = (List<OrderData>) orderDao.findAll();


        ArrayList<OrderData> myOrders = new ArrayList<>();

        for (OrderData allOrder : allOrders) {
            if (Objects.equals(allOrder.getCustomer_username().getUsername(), username)) {
                myOrders.add(allOrder);

            }
        }
        return myOrders;
    }
    public boolean validateInput (OrderData orderData){
        if (orderData == null) return false;
//        if (orderData.getId() < 0) return false;
        if (orderData.getOrderDate() == null || orderData.getOrderDate().trim().equals("")) return false;
        if (orderData.getItemName() == null) return false;
        if (orderData.getCustomer_username() == null) return false;
        return orderData.getComment() != null || orderData.getComment() == null;
    }
}

