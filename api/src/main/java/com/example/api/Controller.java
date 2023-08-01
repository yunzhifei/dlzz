package com.example.api;

import com.example.dao.dao.UserAccountMapper;
import com.example.dao.dto.UserAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
public class Controller {

    private Logger logger = LoggerFactory.getLogger(Controller.class);

    @Resource
    private UserAccountMapper userAccountMapper;

    @RequestMapping(path = {"index","/"})
    public String index(){
        UserAccount userAccount = new UserAccount();
        userAccount.setCreated(new Date());
        userAccount.setModified(new Date());
        userAccount.setName("name");
        userAccount.setPwd("pwd");
        userAccount.setStatus(1);
//        userAccountMapper.insertSelective(userAccount);
        UserAccount userAccount1 = userAccountMapper.selectByPrimaryKey(1);

        logger.error("error");
        logger.info("info"+ userAccount1);
        logger.warn("warn");
        return "index";
    }


}
