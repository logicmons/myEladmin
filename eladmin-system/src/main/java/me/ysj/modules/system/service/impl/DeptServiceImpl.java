package me.ysj.modules.system.service.impl;

import me.ysj.modules.system.dao.DeptMapper;
import me.ysj.modules.system.domain.Dept;
import me.ysj.modules.system.service.DeptService;
import me.ysj.modules.system.service.dto.DeptDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service("deptService")
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<DeptDto> queryAll() {
        return deptMapper.selectAll();
    }

    @Override
    public Object buildTree(List<DeptDto> deptDtos) {
        LinkedHashSet<DeptDto> trees = new LinkedHashSet<>();
        LinkedHashSet<DeptDto> depts = new LinkedHashSet<>();
        List<String> deptNames = deptDtos.stream().map(DeptDto::getName).collect(Collectors.toList());
        boolean isChildren;
        for (DeptDto deptDto : deptDtos) {
            isChildren = false;
            if ("0".equals(deptDto.getPid().toString())){
                trees.add(deptDto);
            }
            for (DeptDto dto : deptDtos) {
                //子部门
                if (dto.getPid().equals(deptDto.getId())){
                    isChildren = true;
                    if (deptDto.getChildren() == null){
                        deptDto.setChildren(new ArrayList<>());
                    }
                    deptDto.getChildren().add(dto);
                }

            }

            if (isChildren){
                depts.add(deptDto);
            }else if (!deptNames.contains(deptMapper.selectNameById(deptDto.getPid()))){
                depts.add(deptDto);
            }

            if (CollectionUtils.isEmpty(trees)){
                trees = depts;
            }
            Integer totalElements = deptDtos.size();

            Map<String, Object> map = new HashMap<>(2);
            map.put("totalElements",totalElements);
            map.put("content",CollectionUtils.isEmpty(trees)? deptDtos : trees );
            return map;
        }

        return null;
    }
}
