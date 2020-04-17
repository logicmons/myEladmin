package me.ysj.modules.system.service;



import me.ysj.modules.system.service.dto.DeptDto;

import java.util.List;

public interface DeptService {
    List<DeptDto> queryAll();
    /**返回页面的树*/
    Object buildTree(List<DeptDto> deptDtos);
}
