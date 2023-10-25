package com.wlb.file.service;

import com.wlb.file.pojo.ZjMerchantExcel;

import java.util.List;

/**
 * ClassName: IZjMerchantService
 * Package: com.wlb.file.service
 * Description:
 *
 * @Author luboheng
 * @Create 2023/8/31 16:25
 * @Version 1.0
 */
public interface IZjMerchantService {
    void saveBatch(List<ZjMerchantExcel> list);
}
