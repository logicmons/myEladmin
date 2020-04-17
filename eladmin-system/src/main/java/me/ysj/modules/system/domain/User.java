package me.ysj.modules.system.domain;

import lombok.Getter;
import lombok.Setter;
import tk.mybatis.mapper.annotation.KeySql;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;

@Table(name = "user")
@Getter
@Setter
public class User {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String username;

    /** 用户昵称 */
    @NotBlank
    private String nickName;

    /** 性别 */
    private String sex;

    private UserAvatar userAvatar;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String phone;

    /**是否启用*/

    @NotNull
    private Boolean enabled;

    /** 密码*/
    private String password;

    /** 创建时间*/
    private Timestamp createTime;

    private Date lastPasswordResetTime;


    private Set<Role> roles;

    @OneToOne
    @JoinColumn(name = "job_id")
    private Job job;

}
