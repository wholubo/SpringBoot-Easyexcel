package com.wlb.file.service.impl;

import com.wlb.file.mapper.ZjMerchantMapper;
import com.wlb.file.pojo.ZjMerchantExcel;
import com.wlb.file.service.IZjMerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: ZjMerchantServiceImpl
 * Package: com.wlb.file.service.impl
 * Description:
 *
 * @Author luboheng
 * @Create 2023/8/31 16:24
 * @Version 1.0
 */
@Service
public class ZjMerchantServiceImpl implements IZjMerchantService {

    @Autowired
    private ZjMerchantMapper zjMerchantMapper;
    @Override
    public void saveBatch(List<ZjMerchantExcel> list) {
        zjMerchantMapper.saveBatch(list);
    }
}
