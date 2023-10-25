package com.wlb.file.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.wlb.file.pojo.AdminUser;
import com.wlb.file.pojo.Terminal;
import com.wlb.file.pojo.TerminalExcel;
import com.wlb.file.service.impl.TerminalServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ClassName: TerminalDataListener
 * Package: com.wlb.file.listener
 * Description:
 *
 * @Author luboheng
 * @Create 2023/9/5 19:41
 * @Version 1.0
 */
@Slf4j
public class TerminalDataListener  extends AnalysisEventListener<TerminalExcel> {
    private TerminalServiceImpl terminalService;
    private String pAgentNo;
    private String agentNo;
    private long productId;
    public TerminalDataListener(TerminalServiceImpl terminalService,String pAgentNo,String agentNo,Long productId){
        this.terminalService = terminalService;
        this.pAgentNo = pAgentNo;
        this.agentNo = agentNo;
        this.productId = productId;
    }

    private static final int BATCH_COUNT = 5;
    List<TerminalExcel> list = new ArrayList<>();
    @Override
    public void invoke(TerminalExcel data, AnalysisContext analysisContext) {
        log.info("解析到一条数据:{}", JSON.toJSONString(data));
        list.add(data);
        if (list.size() >= BATCH_COUNT) {
            saveData(pAgentNo,agentNo,productId);
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
//        saveData(pAgentNo,agentNo,productId);
//        log.info("所有数据解析完成！");
    }

    public void saveData(String pAgentNo,String agentNo, Long productId) {
        log.info("{}条数据，开始存储数据库！", list.size());
        if (!CollectionUtils.isEmpty(list)) {
            saveTerminalData(list, pAgentNo, agentNo, productId);
        }
    }
    public void saveTerminalData(List<TerminalExcel> terminalExcels, String pAgentNo,String agentNo, Long productId){
        List<Terminal> terminals =new ArrayList<>();
        //遍历terminalExcels
        for (TerminalExcel te : terminalExcels) {
            //取出devNo
            String devNo = te.getDevNo();
            //把devNo,pAgentNo,agentNo保存到terminal
//            QueryWrapper<AdminUser> wrapper = new QueryWrapper<>();
//            wrapper.lambda().eq(AdminUser::getuNumber,agentNo);
//            AdminUser user = adminUserMapper.selectOne(wrapper);
            Terminal terminal = new Terminal();
            terminal.setId(devNo + productId);
            terminal.setDevNo(devNo);
            terminal.setProductId(productId);
//            terminal.setUserId();
            terminal.setAddTime(new Date());
//            terminal.setUpdateTime();
//            terminal.setChownUserId();
            terminal.setAgentNo(agentNo);
            terminal.setPAgentNo(pAgentNo);
            //将terminal加入terminals
            terminals.add(terminal);
        }
        terminalService.saveBatch(terminals);
        log.info("存储数据库成功！");
    }

}
