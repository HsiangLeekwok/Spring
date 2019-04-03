package com.enjoy.cap11.service;

import com.enjoy.cap11.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <b>Author</b>: Hsiang Leekwok<br/>
 * <b>Date</b>: 2019/04/03<br/>
 * <b>Version</b>: 1.0<br/>
 * <b>Description</b>: Service类
 */
@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    @Transactional
    public void addOrder() {
        orderDao.insert();
        System.out.println("orderDao insert complete.");
        int i = 10 / 0;
    }
}
