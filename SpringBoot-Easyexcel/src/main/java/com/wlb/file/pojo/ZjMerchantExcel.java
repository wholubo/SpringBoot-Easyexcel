package com.wlb.file.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;



/**
 * ClassName: ZjMerchantExcel
 * Package: com.wlb.file.pojo
 * Description:
 *
 * @Author luboheng
 * @Create 2023/8/31 15:52
 * @Version 1.0
 */
@Data
public class ZjMerchantExcel {
    @ExcelProperty(value = "SN_CODE", index = 0) // 定义表头名称和位置,0代表第一列
    private String snCode;
    @ExcelProperty(value = "MCH_NO", index = 1)
    private String mchNo;
    @ExcelProperty(value = "MCH_NAME", index = 3)
    private String mchName;
    @ExcelProperty(value = "MCH_SHORT_NAME", index = 4)
    private String mchShortAme;
    @ExcelProperty(value = "CONTACT_TEL", index = 5)
    private String contactTel;
    @ExcelProperty(value = "CONTACT_NAME", index = 6)
    private String contactName;
    @ExcelProperty(value = "ID_NO_TYPE", index = 7)
    private String idNoType;
    @ExcelProperty(value = "ID_NO", index = 8)
    private String IdNo;
}
