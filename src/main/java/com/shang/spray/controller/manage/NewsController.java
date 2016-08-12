package com.shang.spray.controller.manage;

import com.shang.spray.controller.BaseController;
import com.shang.spray.entity.News;
import com.shang.spray.entity.Sources;
import com.shang.spray.service.NewsService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;

/**
 * info:
 * Created by shang on 16/7/27.
 */
@RestController
@RequestMapping("/news")
public class NewsController extends BaseController {

    @RequestMapping("")
    public ModelAndView index(@RequestParam(defaultValue = "0")Integer page, @RequestParam(defaultValue = "10") Integer size,ModelAndView view) {
        try {
            Sort sort=new Sort(Sort.Direction.DESC,"placedTop","recommend","createDate","id").and(new Sort(Sort.Direction.ASC,"sort"));
            Pageable pageable=new PageRequest(page,size,sort);
            view.addObject("news",newsService.findAll(pageable));
        } catch (Exception e) {
            _logger.error(getTrace(e));
        }
        view.setViewName("news/list");
        return view;
    }


    @RequestMapping(value = "/addLink",method = RequestMethod.GET)
    public ModelAndView addLink(ModelAndView view,Integer id) {
        Specification<Sources> specification=new Specification<Sources>() {
            @Override
            public Predicate toPredicate(Root<Sources> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                criteriaQuery.where(criteriaBuilder.equal(root.get("status"),1));
                return criteriaQuery.getRestriction();
            }
        };
        view.addObject("sources",sourcesService.findAll(specification));
        if (id != null) {
            view.addObject("news",newsService.findOne(id));
        }
        view.setViewName("news/add_link");
        return view;
    }

    @RequestMapping(value = "/addLink",method = RequestMethod.POST)
    public ModelAndView addLink(News news,ModelAndView view) {
        news.setSources(sourcesService.findOne(news.getSources().getId()));
        news.setInfo(news.getTitle());
        news.setTypeId(1);
        news.setSort(1);
        news.setStatus(1);
        news.setExplicitLink(true);
        news.setCreateDate(new Date());
        news.setModifyDate(new Date());
        newsService.save(news);
        view.setViewName("redirect:/news");
        return view;
    }

    @RequestMapping(value = "/closeNews/{id}",method = RequestMethod.GET)
    public ModelAndView closeNews(@PathVariable Integer id, ModelAndView view) {
        News news=newsService.findOne(id);
        if (news.getStatus().equals(News.StatusEnum.SHANGJIA.getCode())) {
            news.setStatus(News.StatusEnum.XIAJIA.getCode());
        } else {
            news.setStatus(News.StatusEnum.SHANGJIA.getCode());
        }
        newsService.save(news);
        view.setViewName("redirect:/news");
        return view;
    }

    @RequestMapping(value = "/delNews/{id}",method = RequestMethod.GET)
    public ModelAndView delNews(@PathVariable Integer id, ModelAndView view) {
        newsService.delete(id);
        view.setViewName("redirect:/news");
        return view;
    }

}
