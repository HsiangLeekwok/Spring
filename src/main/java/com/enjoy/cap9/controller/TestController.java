package com.enjoy.cap9.controller;

import com.enjoy.cap9.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <b>Author</b>: Hsiang Leekwok<br/>
 * <b>Date</b>: 2019/03/31 19:16<br/>
 * <b>Version</b>: v1.0<br/>
 * <b>Description</b>:
 */
@Controller
public class TestController {

    @Autowired
    private TestService testService;
}
