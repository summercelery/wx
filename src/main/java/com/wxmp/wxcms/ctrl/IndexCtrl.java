package com.wxmp.wxcms.ctrl;

import com.google.common.collect.ImmutableMap;
import com.wxmp.core.common.BaseCtrl;
import com.wxmp.core.common.Constants;
import com.wxmp.core.util.AjaxResult;
import com.wxmp.wxcms.service.SysConfigService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Properties;


@Controller
@RequestMapping("/manage")
public class IndexCtrl extends BaseCtrl {
    @Resource
    private SysConfigService sysConfigService;

    @RequestMapping("/index")
    @ResponseBody
    public AjaxResult index() {
        Properties props = System.getProperties();
        //java版本
        String javaVersion = props.getProperty("java.version");
        //操作系统名称
        String osName = props.getProperty("os.name") + props.getProperty("os.version");
        //用户的主目录
        String userHome = props.getProperty("user.home");
        //用户的当前工作目录
        String userDir = props.getProperty("user.dir");
        //服务器IP
        String serverIP = request.getLocalAddr();
        //客户端IP
        String clientIP = request.getRemoteHost();
        //WEB服务器
        String webVersion = request.getServletContext().getServerInfo();
        //CPU个数
        String cpu = Runtime.getRuntime().availableProcessors() + "核";
        //虚拟机内存总量
        String totalMemory = (Runtime.getRuntime().totalMemory() / 1024 / 1024) + "M";
        //虚拟机空闲内存量
        String freeMemory = (Runtime.getRuntime().freeMemory() / 1024 / 1024) + "M";
        //虚拟机使用的最大内存量
        String maxMemory = (Runtime.getRuntime().maxMemory() / 1024 / 1024) + "M";
        //MYSQL版本
        String mysqlVersion = sysConfigService.getMysqlVsesion();
        //网站根目录
        String webRootPath = request.getSession().getServletContext().getRealPath("");
        Map<String, String> propsMap = ImmutableMap.<String, String>builder()
                .put("javaVersion", javaVersion)
                .put("osName", osName)
                .put("userHome", userHome)
                .put("userDir", userDir)
                .put("clientIP", clientIP)
                .put("serverIP", serverIP)
                .put("cpu", cpu)
                .put("totalMemory", totalMemory)
                .put("freeMemory", freeMemory)
                .put("maxMemory", maxMemory)
                .put("webVersion", webVersion)
                .put("mysqlVersion", mysqlVersion)
                .put("webRootPath", webRootPath)
                .put("systemVersion", Constants.SYSTEM_VERSION)
                .put("systemName", Constants.SYSTEM_NAME)
                .put("systemUpdateTime", Constants.SYSTEM_UPDATE_TIME)
                .build();
        return AjaxResult.success(propsMap);
    }
}
