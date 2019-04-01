package com.enjoy.cap9.service;

import com.enjoy.cap9.dao.TestDao;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * <b>Author</b>: Hsiang Leekwok<br/>
 * <b>Date</b>: 2019/03/31 19:16<br/>
 * <b>Version</b>: v1.0<br/>
 * <b>Description</b>:
 */
@Service
public class TestService {

//    @Qualifier("testDao")
//    @Autowired
//    @Resource(name="testDao2")
    /*
     * 与Autowired的效果是一样的
     * 1、不能与Primary同用
     * 2、不支持Autowired=false
     */
    @Inject
    /*
     * 需要pos.xml额外引用javax.inject包，和Autowired功能差不多，支持Primary
     * 缺点：没有 Autowired 的 required = false
     */
    private TestDao testDao;

    public void println() {
        System.out.println(testDao);
    }
}
