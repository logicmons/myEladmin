package me.ysj.modules.system.domain;

import cn.hutool.core.util.ObjectUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tk.mybatis.mapper.annotation.KeySql;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

@Setter
@Getter
@NoArgsConstructor
@Table(name = "user_avatar")
public class UserAvatar implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;

    private String realName;

    private String path;

    private String size;

    private Timestamp createTime;

    public UserAvatar(UserAvatar userAvatar,String realName,String path,String size){
        this.id = ObjectUtil.isNotEmpty(userAvatar) ? userAvatar.getId() : null;
        this.realName = realName;
        this.size = size;
        this.path = path;
    }
}
