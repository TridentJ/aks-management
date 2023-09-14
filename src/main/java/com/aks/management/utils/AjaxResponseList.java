/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/8/21
 * Time: 19:56
 **/
package com.aks.management.utils;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "统一用于AJAX响应列表")
public class AjaxResponseList {
    
    @Schema( description = "响应类型码")
    private Integer code;
    @Schema(description = "响应描述")
    private String message;
    @Schema(description = "响应返回的具体数据")
    private Object data;
    //总条数
    @Schema(description = "列表总条数")
    private Integer total;
    //每页条数
    @Schema(description = "页数")
    private Integer pageSize;
    //当前页码
    @Schema(description = "页码")
    private Integer pageNum;

}
