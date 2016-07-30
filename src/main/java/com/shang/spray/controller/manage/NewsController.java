package com.shang.spray.controller.manage;

import com.shang.spray.controller.BaseController;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
            Sort sort=new Sort(Sort.Direction.DESC,"placedTop","recommend","sort","id");
            Pageable pageable=new PageRequest(page,size,sort);
            view.addObject("news",newsService.findAll(pageable));
        } catch (Exception e) {
            _logger.error(getTrace(e));
        }
        view.setViewName("news/list");
        return view;
    }


    @RequestMapping("/addLink")
    public ModelAndView addLink(ModelAndView view) {
        try {

        } catch (Exception e) {
            _logger.error(getTrace(e));
        }
        view.setViewName("news/add_link");
        return view;
    }

}
