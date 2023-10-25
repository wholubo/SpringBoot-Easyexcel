package com.wlb.file.service.impl;


import com.wlb.file.mapper.TerminalMapper;
import com.wlb.file.pojo.Terminal;
import com.wlb.file.pojo.TerminalExcel;
import com.wlb.file.service.ITerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zwh
 * @since 2022-06-26
 */
@Service
public class TerminalServiceImpl implements ITerminalService {
    @Autowired
    private TerminalMapper terminalMapper;

    @Override
    public void saveBatch(List<Terminal> list) {
        terminalMapper.saveBatch(list);
    }
}
