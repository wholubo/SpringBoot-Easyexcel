package com.wlb.file.service;

import com.wlb.file.pojo.TerminalExcel;

import java.util.List;

/**
 * ClassName: ITerminalExcelService
 * Package: com.wlb.file.service
 * Description:
 *
 * @Author luboheng
 * @Create 2023/9/6 10:22
 * @Version 1.0
 */
public interface ITerminalExcelService {
    List<TerminalExcel> saveBatch(List<TerminalExcel> list);
}
