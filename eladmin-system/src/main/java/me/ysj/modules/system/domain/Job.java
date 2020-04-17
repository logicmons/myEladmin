package me.ysj.modules.system.domain;

import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;

@Table(name = "table")
public class Job implements Serializable     {
    @Id
    @KeySql(useGeneratedKeys = true)
    @NotNull(groups = Update.class)
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    @Column(unique = true)
    private Long sort;

    private Boolean enabled;

    @OneToOne
    @JoinColumn(name = "dept_id")
    private Dept dept;

    @Column(name = "create_time")
    private Timestamp createTime;

    public @interface Update{};

}
