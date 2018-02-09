package cn.liuzhiping.intergration.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class DemoSchedule {

    //@Scheduled(fixedRate = 3000)
    public void mockIntervalSchedule() {
        log.error("mockIntervalSchedule" + new Date());
        //System.out.println("mockIntervalSchedule" + new Date());
    }

}
