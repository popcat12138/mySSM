package cn.edu.bistu.quickssmdemo.controller;

import cn.edu.bistu.quickssmdemo.common.Result;
import cn.edu.bistu.quickssmdemo.entity.UserEntity;
import cn.edu.bistu.quickssmdemo.service.*;
import com.auth0.jwt.JWT;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@EnableAutoConfiguration
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private IUserService userService;
    @Resource
    private IBookService bookService;
    @Resource
    private IDrugService drugService;
    @Resource
    private ICombinationService combinationService;
    @Resource
    private ICaseService caseService;

    @RequestMapping("home")
    public Result findNum(){
        Integer bookNum=bookService.findPageTotal(null,null,null);
        Integer userNum=userService.findPageTotal(null);
        Integer drugNum=drugService.findPageTotal(null,null,null);
        Integer combNum=combinationService.findPageTotal(null,null);
        Integer caseNum=caseService.findPageTotal(null,null);
        Map<String,Object> res=new HashMap<>();
        res.put("bookNum",bookNum);
        res.put("userNum",userNum);
        res.put("drugNum",drugNum);
        res.put("combNum",combNum);
        res.put("caseNum",caseNum);
        return Result.success(res);
    }


    @RequestMapping("userManagePage")
    public Result findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize,@RequestParam(defaultValue = "") String userName){
        pageNum=(pageNum-1)*pageSize;
        List<UserEntity> data=userService.findPage(pageNum, pageSize,userName);
        Integer total=userService.findPageTotal(userName);

        Map<String,Object> res=new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return Result.success(res);
    }

    @RequestMapping("userManageBan")
    public Result userManageBan(@RequestParam String oldUserName){
        UserEntity oldUser=userService.findUserByUserName(oldUserName);
        if(!(oldUser.getRole()).equals("admin")){
            oldUser.setRole("admin");
        }else{
            oldUser.setRole("normal");
        }
        userService.updateUserInfo(oldUser);
        System.out.println(oldUser.getUserName()+oldUser.getRole());
        return Result.success();
    }

    @RequestMapping("updateUserInfo")
    public Result updateInfo(@RequestBody UserEntity userEntity){

        UserEntity user=userService.updateUserInfo(userEntity);
        return Result.success(user);
    }

    @PostMapping("/uploadFile")
    @ResponseBody
    public Map<String, Object> uploadFile(@RequestParam("file") MultipartFile file, HttpSession session) {
        Map<String, Object> location = new HashMap<>(2);
        long max = 10240*102300;

        if(file.getSize() > max){
            return null;
        }
        if (file.isEmpty()) {
            return null;
        }
        //部署到服务器，更换这个root
//        String root=session.getServletContext().getRealPath("/file/");
        String root = "E:/BigData/work/src/main/resources/static/file/";
        String fileName = file.getOriginalFilename();
//        ;不能出现中文，否则访问400？
        //加个时间戳，尽量避免文件名称重复
        String realName =  new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+fileName;
        String path = root  + realName;
        File dest = new File(path);
        //可以打印一下图片的真实地址
        System.out.println("图片路径："+path);
        //判断文件是否已经存在
        if (dest.exists()) {
            return null;
        }
        //判断文件父目录是否存在,
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }
        try {
            //保存文件
            file.transferTo(dest);
        } catch (IOException e) {
            return null;
        }
        //返回图片路径
        location.put("location","http://localhost:8088/file/"+realName);
        return location;
    }
}
