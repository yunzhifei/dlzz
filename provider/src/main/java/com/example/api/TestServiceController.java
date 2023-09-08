package com.example.api;

import com.example.vo.BaseVO;
import com.example.vo.ReqVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("testService")
public class TestServiceController {
    @GetMapping("/test/list")
    @ApiOperation("测试接口")
    public BaseVO<ReqVO> get() {
        BaseVO baseVO =  new BaseVO<>();
        ReqVO reqVO = new ReqVO();
        reqVO.setValue("test");
        baseVO.setData(reqVO);
        return baseVO;
    }
}
