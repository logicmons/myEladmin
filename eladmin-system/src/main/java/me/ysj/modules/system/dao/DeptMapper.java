package me.ysj.modules.system.dao;

import me.ysj.modules.system.domain.Dept;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface DeptMapper extends Mapper<Dept> {
    @Select("SELECT `name` from `dept`")
    String selectNameById(Long pid);
}
