package cn.liuzhiping.datasource;

import cn.liuzhiping.datasource.model.Example;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationStarter.class)
public class ApplicationTests {

    @Test
    public void contextLoads() {

    }

    @Ignore
    @Test
    public void getExampleTest() {
        String url = "http://localhost:8002/rest/api/1";
        RestTemplate template = new RestTemplate();
        Example example = template.getForObject(url, Example.class);
    }

    @Test
    public void getDataSource() {

    }
}
