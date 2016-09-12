package com.shang.spray.pipeline;

import com.shang.spray.entity.Funny;
import com.shang.spray.repository.FunnyRepository;
import com.shang.spray.service.FunnyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.Date;
import java.util.Map;

/**
 * info:笑话
 * Created by shang on 16/8/30.
 */
@Repository
public class FunnyPipeline implements Pipeline {
    @Autowired
    private FunnyRepository funnyRepository;

    @Override
    public void process(ResultItems resultItems, Task task) {
        for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
            if (entry.getKey().equals("funny")) {
                Funny funny=(Funny) entry.getValue();
                funny.setTypeId(1);
                funny.setAuthor("水花");
                funny.setCreateDate(new Date());
                funny.setStatus(1);
                funny.setModifyDate(new Date());
                funnyRepository.save(funny);
            }

        }
    }
}
