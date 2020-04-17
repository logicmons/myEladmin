package me.ysj.modules.system.rest;

import io.swagger.annotations.ApiOperation;
import me.ysj.modules.system.service.DeptService;
import me.ysj.modules.system.service.dto.DeptDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;

    @ApiOperation("查询部门")
    @GetMapping
    public ResponseEntity<Object> getDepts(){
        //
        List<DeptDto> deptDtos = deptService.queryAll();

        return ResponseEntity.ok(deptService.buildTree(deptDtos));
    }

}
