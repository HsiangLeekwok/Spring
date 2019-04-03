package com.enjoy.cap11.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * <b>Author</b>: Hsiang Leekwok<br/>
 * <b>Date</b>: 2019/04/03<br/>
 * <b>Version</b>: 1.0<br/>
 * <b>Description</b>: DAO
 */
@Repository
public class OrderDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert() {
        String sql = "insert into `order` (ordertime,ordermoney,orderstatus) values(?,?,?)";
        jdbcTemplate.update(sql, new Date(), 20, 0);
    }
}
