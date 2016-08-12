package com.shang.spray.controller.manage;

import com.shang.spray.controller.BaseController;
import com.shang.spray.entity.Beautiful;
import com.shang.spray.entity.News;
import com.shang.spray.entity.Sources;
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
import java.util.Map;

/**
 * info:
 * Created by shang on 16/7/27.
 */
@RestController
@RequestMapping("/beautiful")
public class BeautifulController extends BaseController {

    @RequestMapping("")
    public ModelAndView index(@RequestParam(defaultValue = "0")Integer page, @RequestParam(defaultValue = "12") Integer size,ModelAndView view) {
        Map<String, Object> map = createMap();
        try {
            Sort sort = new Sort(Sort.Direction.DESC, "placedTop", "recommend", "id");
            Pageable pageable = new PageRequest(page, size, sort);
            view.addObject("beautiful",beautifulService.findAll(pageable));
        } catch (Exception e) {
            _logger.error(getTrace(e));
        }
        view.setViewName("beautiful/list");
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
            view.addObject("beautiful",beautifulService.findOne(id));
        }
        view.setViewName("beautiful/add_link");
        return view;
    }

    @RequestMapping(value = "/addLink",method = RequestMethod.POST)
    public ModelAndView addLink(Beautiful beautiful, ModelAndView view) {
        beautiful.setSources(sourcesService.findOne(beautiful.getSources().getId()));
        beautiful.setTypeId(1);
        beautiful.setStatus(1);
        beautiful.setCreateDate(new Date());
        beautiful.setModifyDate(new Date());
        beautifulService.save(beautiful);
        view.setViewName("redirect:/beautiful");
        return view;
    }

    @RequestMapping(value = "/closeBeautiful/{id}",method = RequestMethod.GET)
    public ModelAndView closeBeautiful(@PathVariable Integer id, ModelAndView view) {
        Beautiful beautiful=beautifulService.findOne(id);
        if (beautiful.getStatus().equals(News.StatusEnum.SHANGJIA.getCode())) {
            beautiful.setStatus(Beautiful.StatusEnum.XIAJIA.getCode());
        } else {
            beautiful.setStatus(Beautiful.StatusEnum.SHANGJIA.getCode());
        }
        beautifulService.save(beautiful);
        view.setViewName("redirect:/beautiful");
        return view;
    }

    @RequestMapping(value = "/delBeautiful/{id}",method = RequestMethod.GET)
    public ModelAndView delBeautiful(@PathVariable Integer id, ModelAndView view) {
        beautifulService.delete(id);
        view.setViewName("redirect:/beautiful");
        return view;
    }
}
