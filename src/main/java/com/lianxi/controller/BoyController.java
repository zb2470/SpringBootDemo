package com.lianxi.controller;

import com.lianxi.domain.Boy;
import com.lianxi.domain.Result;
import com.lianxi.repository.BoyRepository;
import com.lianxi.service.BoyService;
import com.lianxi.utils.ResultUtil;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/boy")
public class BoyController {

    @Autowired
    private BoyRepository boyRepository;

    @Autowired
    private BoyService boyService;

    //查询
    @GetMapping("/getBoy")
    public Result getBoys() {
        List<Boy> list = boyRepository.findAll();
        return ResultUtil.success(list);
    }

    @GetMapping(value = "/getone/{id}")
    public Result boyFindone(@PathVariable("id") Integer id) {
        return ResultUtil.success(boyRepository.findById(id).get());
    }

    @GetMapping(value = "/age/{age}")
    public List<Boy> boyListByAge(@PathVariable("age") Integer age) {
        return boyRepository.findByAge(age);
    }

    //增
    @PostMapping(value = "/insert")
    public Result<Boy> insertBoy(@Valid Boy boy, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        boy.setName(boy.getName());
        boy.setAge(boy.getAge());
        boy = boyRepository.save(boy);
        ;
        return ResultUtil.success(boy);
    }

    //改
    @PostMapping(value = "/update/{id}")
    public Result<Boy> boyUpdate(@PathVariable("id") Integer id,
                         @RequestParam("age") Integer age,
                         @RequestParam("name") String name) {

        Boy boy=new Boy();
        boy.setId(id);
        boy.setAge(age);
        boy.setName(name);
        return ResultUtil.success(boyRepository.save(boy));
    }

    //删
    @DeleteMapping(value = "/delete/{id}")
    public void boyDelete(@PathVariable("id") Integer id){
        boyRepository.delete(boyRepository.getOne(id));
    }

    //一些列封装
    @GetMapping(value = "/getByAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception{
        boyService.getAge(id);
    }

}
