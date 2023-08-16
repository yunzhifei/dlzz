package com.example.api;

import com.example.dao.dao.UserAccountMapper;
import com.example.dao.dto.UserAccount;
import com.example.dao.second.LogRecordMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
public class Controller {

    private Logger logger = LoggerFactory.getLogger(Controller.class);

    @Resource
    private UserAccountMapper userAccountMapper;

    @Resource
    private LogRecordMapper logRecordMapper;

    @RequestMapping(path = {"index", "/"})
    @Transactional(transactionManager = "blogSqlTransactionManager", rollbackFor = Exception.class)
    public String index() {
        UserAccount userAccount = new UserAccount();
        userAccount.setCreated(new Date());
        userAccount.setModified(new Date());
        userAccount.setName("name");
        userAccount.setPwd("pwd");
        userAccount.setStatus(1);
        int i = userAccountMapper.insertSelective(userAccount);
        logger.info("i=" + userAccount.getId());
        throw new RuntimeException();

    }


}
