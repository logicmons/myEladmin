package me.ysj.modules.system.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Data
public class DeptDto implements Serializable {
    private Long id;

    private String name;

    @NotNull
    private Boolean enabled;

    private Long pid;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DeptDto> children;

    private Timestamp createTime;

    private String getLabel(){
        return name;
    }
}
