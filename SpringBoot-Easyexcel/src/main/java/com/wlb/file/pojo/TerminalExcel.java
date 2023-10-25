package com.wlb.file.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * ClassName: TerminalExcel
 * Package: com.wlb.file.pojo
 * Description:
 *
 * @Author luboheng
 * @Create 2023/9/5 18:04
 * @Version 1.0
 */
@Data
public class TerminalExcel {
    @ExcelProperty(value = "SN号", index = 0) // 定义表头名称和位置,0代表第一列
    private String devNo;
}
