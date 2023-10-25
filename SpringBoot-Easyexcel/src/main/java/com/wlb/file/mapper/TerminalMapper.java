package com.wlb.file.mapper;

import com.wlb.file.pojo.Terminal;

import java.util.List;

/**
 * ClassName: TerminalMapper
 * Package: com.wlb.file.mapper
 * Description:
 *
 * @Author luboheng
 * @Create 2023/9/6 15:23
 * @Version 1.0
 */
public interface TerminalMapper {
    void saveBatch(List<Terminal> list);
}
