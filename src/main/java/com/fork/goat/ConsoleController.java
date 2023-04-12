package com.fork.goat;

import com.fork.goat.util.HttpClientUtil;
import com.fork.goat.util.MairuiSendUtil;
import com.fork.goat.util.ResultModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * 控制台
 * @Date 2023年4月12日23:46:47
 * @author bboyfork
 * */
@RequestMapping("console")
@RestController
public class ConsoleController {

    /**
     * 重载股票列表
     * */
    @RequestMapping("/refreshList")
    public ResultModel refreshStockList(){

        return ResultModel.success();
    }

    public static void main(String[] args) {

        // 基金当日数据
        String url = "http://api.mairui.club/jj/zxkx/sz159611/dn/04ef15732603020d2b";


        String send = MairuiSendUtil.send(url);
        System.out.println(send);
    }
}
