package com.luxin;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
// 添加 mapper 加载时 扫描 mapper
@MapperScan("com.luxin.mapper")
class CmsApplicationTests {

    @Test
    void contextLoads() {
    }

}
