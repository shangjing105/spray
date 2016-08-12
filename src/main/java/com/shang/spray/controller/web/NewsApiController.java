package com.shang.spray.controller.web;

import com.shang.spray.common.base.BaseApiResult;
import com.shang.spray.common.utils.ModelHelper;
import com.shang.spray.controller.BaseController;
import com.shang.spray.entity.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Map;

/**
 * info:精选controller
 * Created by shang on 16/7/8.
 */
@RestController
@RequestMapping("/api/news")
public class NewsApiController extends BaseController {


    @RequestMapping("")
    public Map<String,Object> index(BaseApiResult result,@RequestParam(defaultValue = "0")Integer page,@RequestParam(defaultValue = "15") Integer size) {
        Map<String,Object> map=createMap();
        try {
            Sort sort=new Sort(Sort.Direction.DESC,"placedTop","recommend","createDate","id").and(new Sort(Sort.Direction.ASC,"sort"));
            Specification<News> specification=new Specification<News>() {
                @Override
                public Predicate toPredicate(Root<News> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                    criteriaQuery.where(criteriaBuilder.equal(root.get("status"),News.StatusEnum.SHANGJIA.getCode()));
                    return null;
                }
            };
            Pageable pageable=new PageRequest(page,size,sort);
            Page<News> news= newsService.findAll(specification,pageable);
            map.put("news",news.getContent());
            map.put("last",news.isLast());
            map.put("result", ModelHelper.OK(result));
        } catch (Exception e) {
            _logger.error(getTrace(e));
            map.put("result",ModelHelper.ERROR(result));
        }
        return map;
    }


    @RequestMapping("/details/{id}")
    public Map<String,Object> details(BaseApiResult result,@PathVariable Integer id) {
        Map<String,Object> map=createMap();
        try {
            map.put("news",newsService.findOne(id));
            map.put("result", ModelHelper.OK(result));
        } catch (Exception e) {
            _logger.error(getTrace(e));
            map.put("result",ModelHelper.ERROR(result));
        }
        return map;
    }
}
