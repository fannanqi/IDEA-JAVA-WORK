package com.example.work8;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.work8.utils.MD5Util.convertMD5;
import static com.example.work8.utils.MD5Util.string2MD5;

@SpringBootTest(classes = Work8Application.class)
class Work8ApplicationTests {

    @Test
    void contextLoads() {
        String s = "Kodak";
        System.out.println("原始：" + s);
        System.out.println("MD5后：" + string2MD5(s));
        System.out.println("加密的：" + convertMD5(s));
        System.out.println("解密的：" + convertMD5(convertMD5(s)));
    }

}
