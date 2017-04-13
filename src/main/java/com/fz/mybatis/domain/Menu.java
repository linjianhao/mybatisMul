package com.fz.mybatis.domain;

import lombok.Data;

/**菜单模型类
 * Created by Administrator on 2017/4/12.
 */
@Data
public class Menu extends  BaseDo {
    private String menuName;
    private Integer pId;
    private String menuUri;
    private String menuStyle;
    private String isMenu;
}
