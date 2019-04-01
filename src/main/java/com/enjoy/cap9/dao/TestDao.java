package com.enjoy.cap9.dao;

import org.springframework.stereotype.Repository;

/**
 * <b>Author</b>: Hsiang Leekwok<br/>
 * <b>Date</b>: 2019/03/31 19:16<br/>
 * <b>Version</b>: v1.0<br/>
 * <b>Description</b>:
 */
@Repository
public class TestDao {

    private String flag ="1";

    public TestDao() {
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "TestDao{" +
                "flag='" + flag + '\'' +
                '}';
    }
}
