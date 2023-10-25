package com.wlb.file.service.impl;

import com.wlb.file.pojo.Terminal;
import com.wlb.file.pojo.TerminalExcel;
import com.wlb.file.service.ITerminalExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: TerminalExcelServiceImpl
 * Package: com.wlb.file.service.impl
 * Description:
 *
 * @Author luboheng
 * @Create 2023/9/6 10:20
 * @Version 1.0
 */
@Service
public class TerminalExcelServiceImpl implements ITerminalExcelService {
    @Override
    public List<TerminalExcel> saveBatch(List<TerminalExcel> list) {
        return list;
    }
}
