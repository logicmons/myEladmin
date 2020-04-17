package me.ysj;
import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"me.ysj.modules.system.dao"})
public class AppRun {
    public static void main(String[] args) {
        SpringApplication.run(AppRun.class);
    }
}
