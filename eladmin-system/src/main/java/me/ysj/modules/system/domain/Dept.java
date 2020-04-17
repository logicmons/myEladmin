package me.ysj.modules.system.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.Objects;
import lombok.Getter;
import lombok.Setter;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Set;


@Getter
@Setter
@Table(name = "dept")
public class Dept {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;

    private String name;

    @NotNull
    private Boolean enabled;

    @NotNull
    private Long pid;

    @JsonIgnore
    private Set<Role> roles;

    private Timestamp createTime;

    public @interface Update{}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dept dept = (Dept) o;
        return Objects.equal(id, dept.id) &&
                Objects.equal(name, dept.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name);
    }

//

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", enabled=" + enabled +
                ", pid=" + pid +
                ", createTime=" + createTime +
                '}';
    }
}
