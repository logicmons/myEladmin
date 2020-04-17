package me.ysj.modules.system.dao;

import me.ysj.modules.system.service.dto.DeptDto;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface DeptMapper extends Mapper<DeptDto> {
    @Select("SELECT `name` from `dept`")
    String selectNameById(Long pid);
}
