package com.qst.crop.controller;

import com.github.pagehelper.PageInfo;
import com.qst.crop.common.Result;
import com.qst.crop.common.StatusCode;
import com.qst.crop.entity.Expert;
import com.qst.crop.entity.Question;
import com.qst.crop.service.ExpertService;
import com.qst.crop.service.QuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "question模块")
@RestController
@RequestMapping("/question")
@CrossOrigin
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private ExpertService expertService;

    //分页查询所有问题
    @ApiOperation(value = "分页查询所有问题")
    @GetMapping("/findAllQues/{pageNum}")
    public Result<PageInfo<Question>> findAllQues(@PathVariable Integer pageNum) {
        PageInfo<Question> questionPageInfo = questionService.selectByKeys(null,pageNum);
        return new Result(true, StatusCode.OK, "查询成功", questionPageInfo);
    }

    //分页条件查询问题
    @ApiOperation(value = "分页条件查询问题")
    @GetMapping("/findPageQues/{keys}/{pageNum}")
    public Result<PageInfo<Question>> findQuesByKeys(@PathVariable("keys") String keys, @PathVariable Integer pageNum) {
        PageInfo<Question> questionPageInfo = questionService.selectByKeys(keys,pageNum);
        return new Result(true, StatusCode.OK, "查询成功", questionPageInfo);
    }

    //分页查询所有专家
    @ApiOperation(value = "分页查询所有专家")
    @GetMapping("/findExpert/{pageNum}")
    public Result<PageInfo<Expert>> findAllExpert(@PathVariable Integer pageNum) {
        PageInfo<Expert> expertPageInfo = expertService.selectByKeys(null, pageNum);
        return new Result<PageInfo<Expert>>(true, StatusCode.OK, "查询成功", expertPageInfo);
    }

    //分页条件查询专家
    @ApiOperation(value = "分页条件查询专家")
    @GetMapping("/findExpertByKeys/{keys}/{pageNum}")
    public Result<PageInfo<Expert>> findExpertByKeys(@PathVariable("keys") String keys, @PathVariable Integer pageNum) {
        PageInfo<Expert> expertPageInfo = expertService.selectByKeys(keys,pageNum);
        return new Result<PageInfo<Expert>>(true, StatusCode.OK, "查询成功", expertPageInfo);
    }

    //根据ID查询问题内容
    @ApiOperation(value = "根据ID查询问题内容")
    @GetMapping("/selectId/{id}")
    public Result selectById(@PathVariable("id") Integer id) {
        Question question = questionService.selectById(id);
        return new Result(true, StatusCode.OK, "查询成功", question);
    }

    //添加问题
    @ApiOperation(value = "添加问题")
    @PostMapping("/add")
    public Result add(@Valid @RequestBody Question question, BindingResult bindingResult) {
        //检查项目
        if (bindingResult.hasErrors()) {
            return new Result<String>(false, StatusCode.ERROR, "添加失败");
        }
        questionService.insert(question);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    //根据id修改问题
    @ApiOperation(value = "根据id修改问题")
    @PutMapping("/update")
    public Result update(@Valid @RequestBody Question question, BindingResult bindingResult) {
        //检查项目
        if (bindingResult.hasErrors()) {
            return new Result<String>(false, StatusCode.ERROR, "修改失败");
        }
        questionService.update(question);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    //查询用户或专家的问题
    @ApiOperation(value = "查询用户或专家的问题")
    @GetMapping("/selectByKind/{type}")
    public Result selectByUserOrExpert(@PathVariable("type") String type) {
        List<Question> questions = questionService.selectByMan(type);
        return new Result(true, StatusCode.OK, "查询成功", questions);
    }

    //根据id删除问题
    @ApiOperation(value = "根据id删除问题")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable("id") Integer id) {
        questionService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
