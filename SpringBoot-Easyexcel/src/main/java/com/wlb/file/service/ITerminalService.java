package com.wlb.file.service;


import com.wlb.file.pojo.Terminal;
import com.wlb.file.pojo.TerminalExcel;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zwh
 * @since 2022-06-26
 */
public interface ITerminalService{
    void saveBatch(List<Terminal> list);
}
