package com.miaoshaproject;
import com.miaoshaproject.dao.UserDOMapper;
import com.miaoshaproject.dataobject.UserDO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
//@EnableAutoConfiguration//springboot会自动启动一个内嵌的tomcat容器将配置自动加载进项目
@SpringBootApplication(scanBasePackages = {"com.miaoshaproject"} )//自动扫描包下内容
@RestController//实现xml等配置功能
@MapperScan("com.miaoshaproject.dao")
public class App 
{

    @Autowired@SuppressWarnings("all")
    UserDOMapper userDOMapper;


    @RequestMapping("/")//通过访问http://localhost:8080/这种方式都可以进行访问
    public String home() {
        UserDO userDO = userDOMapper.selectByPrimaryKey(1);
        if(userDO == null) {
            return "用户对象不存在";
        } else {
            return userDO.getName();
        }

    }
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SpringApplication.run(App.class,args);
    }
}
