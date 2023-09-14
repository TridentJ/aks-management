/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/2/25
 * Time: 19:00
 **/
package com.aks.management.utils;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "统一用于AJAX响应")
public class AjaxResponse {
    
    @Schema( description = "用于描述响应类型")
    private Integer code;
    @Schema(description = "描述响应状态")
    private String message;
    @Schema(description = "响应返回的具体数据")
    private Object data;
    
}
