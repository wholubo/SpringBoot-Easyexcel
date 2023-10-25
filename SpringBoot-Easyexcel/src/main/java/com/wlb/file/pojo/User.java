package com.wlb.file.pojo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Data;

import java.util.Date;

@Data
public class User {
    // 主键id
    @ExcelIgnore // 生成报表时忽略，不生成次字段
    private Integer id;
    @ExcelProperty(value = "姓名", index = 0) // 定义表头名称和位置,0代表第一列
    private String name;
    @ExcelProperty(value = "性别", index = 1)
    private String sex;
    @ExcelProperty(value = "年龄", index = 2)
    private Integer age;
    //@ColumnWidth(20) // 定义列宽,使用自适应列宽则注释，不使用则可靠此注解自定义
    @DateTimeFormat(value = "yyyy-MM-dd")
    @ExcelProperty(value = "出生日期", index = 3)
    private Date birthday;
}
