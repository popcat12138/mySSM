package cn.edu.bistu.quickssmdemo.controller;

import cn.edu.bistu.quickssmdemo.common.Result;
import cn.edu.bistu.quickssmdemo.entity.BookEntity;
import cn.edu.bistu.quickssmdemo.entity.CaseEntity;
import cn.edu.bistu.quickssmdemo.service.ICaseService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@EnableAutoConfiguration
@RequestMapping("/case")
public class CaseController {
    @Resource
    private ICaseService caseService;

    @RequestMapping("caseManagePage")
    public Result findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam(defaultValue = "") String caseTitle,@RequestParam(defaultValue = "") Integer userId){
        pageNum=(pageNum-1)*pageSize;
        List<CaseEntity> data=caseService.findPage(pageNum, pageSize, caseTitle,userId);
        Integer total=caseService.findPageTotal(caseTitle,userId);

        Map<String,Object> res=new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return Result.success(res);
    }

    @RequestMapping("addOrUpdateCase")
    public Result updateInfo(@RequestBody CaseEntity caseEntity){
        if(caseEntity.getCaseId()!=null){
            caseService.updateCaseInfo(caseEntity);
        }else{
            caseService.addCase(caseEntity);
        }
        return Result.success(caseEntity);
    }


    @RequestMapping("/getCase/{id}")
    public Result getCase(@PathVariable Integer id){
        System.out.println("ckkck");
        CaseEntity caseEntity=caseService.findCaseById(id);
        return Result.success(caseEntity);
    }

    @RequestMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
        caseService.deleteCase(id);
        return Result.success();
    }

    @RequestMapping("moreCollect")
    public Result moreCollect(){
        Map<String,Object> res=new HashMap<>();
        List<CaseEntity> data=caseService.findMoreCollect();
        res.put("data",data);
        return Result.success(res);
    }
}
