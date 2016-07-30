package com.shang.spray.controller.manage;

import com.shang.spray.controller.BaseController;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
}
