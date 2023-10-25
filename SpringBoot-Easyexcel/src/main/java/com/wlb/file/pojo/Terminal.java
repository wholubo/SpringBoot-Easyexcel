package com.wlb.file.pojo;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zwh
 * @since 2022-06-27
 */

@Data
public class Terminal implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 机具号
     */
    private String devNo;

    /**
     * 商户名称
     */
    private String shopName;

    /**
     * 商户号
     */
    private String shopNo;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 添加时间
     */
    private Date addTime;

    private Date updateTime;

    private Integer chownUserId;

    private String agentNo;

    private String pAgentNo;

}
