package me.ysj.modules.system.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.awt.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

/**
 * 角色类
 */

@Table(name = "role")
@Getter
@Setter
public class Role implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    @NotNull(groups = {Update.class})
    private Long id;

    @Column(nullable = false)
    @NotBlank
    private String name;

    /** 数据权限类型：自定义 */
    @Column(name = "data_scope")
    private String dataScope = "本级";

    /** 数值越小，级别越大*/
    @Column(name = "level")
    private Integer level = 3;

    private String remark;

    /** 权限 */
    @Column(name = "permission")
    private String permission;

    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    @ManyToMany
    private Set<Menu> menus;

    private Timestamp createTime;

    public @interface Update{}

}
