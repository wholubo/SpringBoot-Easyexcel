package com.wlb.file.mapper;

import com.wlb.file.pojo.ZjMerchantExcel;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ClassName: ZjMerchantMapper
 * Package: com.wlb.file.mapper
 * Description:
 *
 * @Author luboheng
 * @Create 2023/8/31 16:26
 * @Version 1.0
 */
@Component
public interface ZjMerchantMapper {
    void saveBatch(List<ZjMerchantExcel> list);
}
