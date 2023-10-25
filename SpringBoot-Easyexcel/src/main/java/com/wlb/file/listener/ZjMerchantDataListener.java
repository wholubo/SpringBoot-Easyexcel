package com.wlb.file.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.wlb.file.pojo.User;
import com.wlb.file.pojo.ZjMerchantExcel;
import com.wlb.file.service.impl.ZjMerchantServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: ZjMerchantDataListener
 * Package: com.wlb.file.listener
 * Description:
 *
 * @Author luboheng
 * @Create 2023/8/31 16:27
 * @Version 1.0
 */
@Slf4j
public class ZjMerchantDataListener extends AnalysisEventListener<ZjMerchantExcel> {

    private ZjMerchantServiceImpl zjMerchantService;
    public ZjMerchantDataListener(ZjMerchantServiceImpl zjMerchantService){
        this.zjMerchantService = zjMerchantService;
    }

    private static final int BATCH_COUNT = 5;
    List<ZjMerchantExcel> list = new ArrayList<>();

    @Override
    public void invoke(ZjMerchantExcel data, AnalysisContext analysisContext) {
        log.info("解析到一条数据:{}", JSON.toJSONString(data));
        list.add(data);
        if (list.size() >= BATCH_COUNT) {
            saveData();
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveData();
        log.info("所有数据解析完成！");
    }


    /**
     * 加上存储数据库
     */
    private void saveData() {
        log.info("{}条数据，开始存储数据库！", list.size());
        if (!CollectionUtils.isEmpty(list)) {
            zjMerchantService.saveBatch(list);
        }
        log.info("存储数据库成功！");
    }
}
