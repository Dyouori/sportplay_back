package com.deyunjiaoyu.sportplay;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class test {
    @Test
    public void testWithSelenium() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        try {
            driver.get("https://www.baidu.com");
            // 执行你的测试代码
        } finally {
            driver.quit(); // 确保最后关闭浏览器
        }
    }
}

