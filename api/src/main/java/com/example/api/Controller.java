package com.example.api;

import com.example.dao.dao.UserAccountMapper;
import com.example.dao.dto.UserAccount;
import com.example.dao.second.LogRecordMapper;
import com.example.dao.seconddto.LogRecord;
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

    @Resource
    private LogRecordMapper logRecordMapper;

    @RequestMapping(path = {"index","/"})
    public String index(){
        UserAccount userAccount = new UserAccount();
        userAccount.setCreated(new Date());
        userAccount.setModified(new Date());
        userAccount.setName("name");
        userAccount.setPwd("pwd");
        userAccount.setStatus(1);
//        int i = userAccountMapper.insertSelective(userAccount);
//        logger.info("i=" + i);
        UserAccount userAccount1 = userAccountMapper.selectByPrimaryKey(1);

        LogRecord logRecord = new LogRecord();
        logRecord.setName("1");
        int insert = logRecordMapper.insert(logRecord);

        return "index";
    }


}
