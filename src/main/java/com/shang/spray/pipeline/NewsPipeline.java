package com.shang.spray.pipeline;

import com.shang.spray.entity.News;
import com.shang.spray.entity.Sources;
import com.shang.spray.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.Date;
import java.util.Map;

/**
 * info:新闻
 * Created by shang on 16/8/22.
 */
@Repository
public class NewsPipeline implements Pipeline {

    @Autowired
    protected NewsRepository newsRepository;

    @Override
    public void process(ResultItems resultItems, Task task) {
        for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
            if (entry.getKey().contains("news")) {
                News news=(News) entry.getValue();
                news.setAuthor("水花");
                news.setTypeId(1);
                news.setSort(1);
                news.setStatus(1);
                news.setExplicitLink(true);
                news.setCreateDate(new Date());
                news.setModifyDate(new Date());
                newsRepository.save(news);
            }

        }
    }
}
