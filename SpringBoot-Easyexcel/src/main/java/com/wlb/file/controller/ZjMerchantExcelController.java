package com.wlb.file.controller;

import com.alibaba.excel.EasyExcel;
import com.wlb.file.listener.ZjMerchantDataListener;
import com.wlb.file.pojo.ZjMerchantExcel;
import com.wlb.file.service.impl.ZjMerchantServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * ClassName: ZjMerchantExcelController
 * Package: com.wlb.file.controller
 * Description:
 *
 * @Author luboheng
 * @Create 2023/8/31 16:20
 * @Version 1.0
 */
@Slf4j
@Controller
@RequestMapping("/zjMerchantExcel")
public class ZjMerchantExcelController {
    @Autowired
    private ZjMerchantServiceImpl zjMerchantService;

    @PostMapping("/upload")
    @ResponseBody
    public String upload(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), ZjMerchantExcel.class, new ZjMerchantDataListener(zjMerchantService)).sheet().doRead();
        return "上传成功";
    }

}
