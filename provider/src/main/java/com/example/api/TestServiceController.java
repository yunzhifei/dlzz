package com.example.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vo.BaseVO;
import com.example.vo.ReqVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api("testService")
public class TestServiceController {
    @GetMapping("/test/list")
    @ApiOperation("测试接口")
    /***
     *
     * @author yunzhifei
     * @date 2023/09/11 15:22
     * @return com.example.vo.BaseVO<com.example.vo.ReqVO>
     */
    public BaseVO<ReqVO> get() {
        BaseVO baseVO =  new BaseVO<>();
        ReqVO reqVO = new ReqVO();
        reqVO.setValue("test");
        baseVO.setData(reqVO);
        return baseVO;
    }
}
