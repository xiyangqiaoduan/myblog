package com.ycb.blog.web.controller.admin;

import com.ycb.blog.common.util.base.BaseController;
import com.ycb.blog.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 文件上传控制器
 *
 * @author yangcb
 * @create 2017-05-18 11:44
 **/
@Controller
@RequestMapping("admin")
public class WebUploadController extends BaseController {


    @Autowired
    private OptionService optionService;


    /**
     *
     *       编辑器返回格式
     *        {
     *          "success": true/false,
     *          "msg": "error message", # optional
     *          "file_path": "[real file path]"
     *         }
     * @param fileDataFileName
     * @param request
     * @return
     */
    @RequestMapping("fileupload")
    @ResponseBody
    public Map<String, Object> fileUpload(MultipartFile fileDataFileName, HttpServletRequest request) {
        LOG.info("============上传文件开始==========");
        String suffix = fileDataFileName.getOriginalFilename().substring(fileDataFileName.getOriginalFilename().lastIndexOf(".") + 1);
        LOG.info("文件上传扩展名："+suffix);
        // 获取文件上传的真实路径
        String path = request.getSession().getServletContext().getRealPath("/");
        LOG.info("服务器路径信息："+ path);
        String uploadfilePath = optionService.getAllOptions().get("website_uploadfile")+File.separator+getFilePath();
        LOG.info("服务器配置上传地址："+ uploadfilePath);
        File destFile = new File(path + uploadfilePath);
        if (!destFile.exists()) {
            destFile.mkdirs();
        }
        String fileNameNew = getFileNameNew() + "." + suffix;//
        File f=new File(destFile.getAbsoluteFile()+File.separator,fileNameNew);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        //当前文件如果存在
        if(f.exists()){
            resultMap.put("success", false);
            resultMap.put("msg","当前文件已经存在");
            return resultMap;
        }
        try {
            fileDataFileName.transferTo(f);
            f.createNewFile();
            resultMap.put("success", true);
            resultMap.put("msg", "上传成功");
            resultMap.put("file_path", uploadfilePath+File.separator+fileNameNew);
            return resultMap;
        }catch (Exception e){
            LOG.error("上传文件失败：",e);
            resultMap.put("success", false);
            resultMap.put("msg","上传文件失败");
            return resultMap;
        }
    }


    /*
     *为文件重新命名，命名规则为当前系统时间毫秒数
    * @return string
    */
    private String getFileNameNew() {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return fmt.format(new Date());
    }

    private String getFilePath() {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
        return fmt.format(new Date());
    }


}
