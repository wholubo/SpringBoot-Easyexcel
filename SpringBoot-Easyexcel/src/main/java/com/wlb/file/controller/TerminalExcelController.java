package com.wlb.file.controller;

import com.alibaba.excel.EasyExcel;
import com.wlb.file.listener.TerminalDataListener;
import com.wlb.file.pojo.TerminalExcel;
import com.wlb.file.service.impl.TerminalServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


/**
 * ClassName: TerminalExcelController
 * Package: com.wlb.file.controller
 * Description:
 *
 * @Author luboheng
 * @Create 2023/9/5 19:31
 * @Version 1.0
 */
@Slf4j
@Controller
@RequestMapping("/terminalExcel")
public class TerminalExcelController {
    @Autowired
    private TerminalServiceImpl terminalService;

    @PostMapping("/upload")
    @ResponseBody
    public String upload(MultipartFile file,String pAgentNo,String agentNo, Long productId) throws IOException {
        TerminalDataListener terminalDataListener = new TerminalDataListener(terminalService,pAgentNo,agentNo,productId);
        EasyExcel.read(file.getInputStream(), TerminalExcel.class, terminalDataListener).sheet().doRead();
        return "上传成功";
    }
}
