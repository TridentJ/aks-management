package com.aks.management;

import com.github.yitter.contract.IdGeneratorOptions;
import com.github.yitter.idgen.YitIdHelper;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.aks.management.dao")
public class AksManagementApplication {
    
    public static void main(String[] args) {
        
        try {
            /*
             * 雪花ID初始化
             * */
            IdGeneratorOptions options = new IdGeneratorOptions((short) 12);
            // options.WorkerIdBitLength = 10; // 默认值6，限定 WorkerId 最大值为2^6-1，即默认最多支持64个节点。
            // options.SeqBitLength = 6; // 默认值6，限制每毫秒生成的ID个数。若生成速度超过5万个/秒，建议加大 SeqBitLength 到 10。
            YitIdHelper.setIdGenerator(options);
            // 初始化后，在任何需要生成ID的地方，调用以下方法：
            //long newId = YitIdHelper.nextId();
            SpringApplication.run(AksManagementApplication.class, args);
        }catch (Exception e){
            e.printStackTrace();
        }
        
    }
    
    
}
