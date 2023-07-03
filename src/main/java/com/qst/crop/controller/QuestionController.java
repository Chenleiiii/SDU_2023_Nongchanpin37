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
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author QST
 * @Description 问题模块
 * @Date 2021-08-24
 */
@Api(tags = "问题模块接口")
@RestController
@RequestMapping("/question")
@CrossOrigin
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private ExpertService expertService;

    //根据ID查询询问情况
    @ApiOperation(value = "根据ID查询询问情况")
    @GetMapping("/selectId/{id}")
    public Result selectById(@PathVariable("id") Integer id) {
        Question question = questionService.selectById(id);
        return new Result(true, StatusCode.OK, "查询成功", question);
    }

    //添加询问情报
    @ApiOperation(value = "添加询问情报")
    @PostMapping("/add")
        public Result add(@RequestBody Question question, BindingResult bindingResult) {
        //检查项目
        if (bindingResult.hasErrors()) {
            StringBuffer stringBuffer = new StringBuffer();
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError objectError : allErrors) {
                stringBuffer.append(objectError.getDefaultMessage()).append("; ");
            }
            String s = stringBuffer.toString();
            System.out.println(s);
            return new Result<String>(false, StatusCode.ERROR, "添加失败",s);
        }
        questionService.insert(question);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    //根据id修改询问情报
    @ApiOperation(value = "根据id修改询问情报")
    @PutMapping("/update")
    public Result update(@RequestBody Question question, BindingResult bindingResult) {
        //检查项目
        if (bindingResult.hasErrors()) {
            StringBuffer stringBuffer = new StringBuffer();
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError objectError : allErrors) {
                stringBuffer.append(objectError.getDefaultMessage()).append("; ");
            }
            String s = stringBuffer.toString();
            System.out.println(s);
            return new Result<String>(false, StatusCode.ERROR, "修改失败",s);
        }
        questionService.updateById(question);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    //根据id删除询问情报
    @ApiOperation(value = "根据id删除询问情报")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable("id") Integer id) {
        questionService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    //根据用户查询询问情况
    @ApiOperation(value = "根据用户查询询问情况")
    @GetMapping("/selectByKind/{kind}")
    public Result selectByKind(@PathVariable("kind") String kind) {
        List<Question> questions = questionService.selectByQuestion(kind);
        System.out.println(questions);
        return new Result(true, StatusCode.OK, "查询成功", questions);
    }
    //按条件分页条件查询所有问答情况
    @ApiOperation(value = "分页条件查询所有问答情况")
    @GetMapping("/findPageQues/{keys}/{pageNum}")
    public Result<PageInfo<Question>> findPageQues(@PathVariable("keys") String keys,@PathVariable Integer pageNum) {
            PageInfo<Question>  questionPageInfo = questionService.selectByKeys(keys,pageNum);
        return new Result(true, StatusCode.OK, "查询成功", questionPageInfo);
    }
    //分页查询所有问答情况
    @ApiOperation(value = "分页查询所有问答情况")
    @GetMapping("/findAllQues/{pageNum}")
    public Result<PageInfo<Question>> findAllQues(@PathVariable Integer pageNum) {
        PageInfo<Question>  questionPageInfo = questionService.selectByKeys(null,pageNum);
        return new Result(true, StatusCode.OK, "查询成功", questionPageInfo);
    }
    //分页查询所有专家
    @ApiOperation(value = "分页查询所有专家")
    @GetMapping("/findExpert/{pageNum}")
    public Result<PageInfo<Expert>> findPage(@PathVariable Integer pageNum) {
        PageInfo<Expert> expertPageInfo = expertService.findPage(pageNum);
        return new Result<PageInfo<Expert>>(true, StatusCode.OK, "查询成功", expertPageInfo);
    }
    //分页条件查询专家
    @ApiOperation(value = "分页条件查询专家")
    @GetMapping("/findExpertByKeys/{keys}/{pageNum}")
        public Result<PageInfo<Expert>> findExpertByKeys(@PathVariable("keys") String keys,@PathVariable Integer pageNum) {
        PageInfo<Expert> expertPageInfo = expertService.findPageByKeys(keys,pageNum);
        return new Result<PageInfo<Expert>>(true, StatusCode.OK, "查询成功", expertPageInfo);
    }
}
