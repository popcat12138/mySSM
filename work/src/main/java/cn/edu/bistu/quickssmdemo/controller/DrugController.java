package cn.edu.bistu.quickssmdemo.controller;

import cn.edu.bistu.quickssmdemo.common.Result;
import cn.edu.bistu.quickssmdemo.dao.IDrugDao;
import cn.edu.bistu.quickssmdemo.entity.CaseEntity;
import cn.edu.bistu.quickssmdemo.entity.DrugEntity;
import cn.edu.bistu.quickssmdemo.service.IDrugService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@EnableAutoConfiguration
@RequestMapping("/drug")
public class DrugController {
    @Resource
    private IDrugService drugService;

    @RequestMapping("drugManagePage")
    public Result findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam(defaultValue = "") String drugName,@RequestParam(defaultValue = "") String type,@RequestParam(defaultValue = "") Integer userId){
        pageNum=(pageNum-1)*pageSize;
        List<DrugEntity> data=drugService.findPage(pageNum, pageSize, drugName,type,userId);
        Integer total=drugService.findPageTotal(drugName,type,userId);

        Map<String,Object> res=new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return Result.success(res);
    }

    @RequestMapping("addOrUpdateDrugInfo")
    public Result updateInfo(@RequestBody DrugEntity drugEntity){
        System.out.println("drug");
        if(drugEntity.getId()!=null){
            drugService.updateDrugInfo(drugEntity);
        }else{
            drugService.addDrug(drugEntity);
        }
        return Result.success(drugEntity);
    }


    @RequestMapping("/getDrug/{id}")
    public Result getCase(@PathVariable Integer id){
        DrugEntity drugEntity=drugService.findDrugById(id);
        return Result.success(drugEntity);
    }
    @RequestMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
        drugService.deleteDrug(id);
        return Result.success();
    }

}
