package com.taint.analysis.utils;

import java.util.ArrayList;
import java.util.List;

public class BenchmarksConfig {
    private static String basePath = "/Users/FlowDroidPlus/demo";
    public static List<String> getSourceProcessDir(String benchmark) {
        List<String> dir = new ArrayList<>();
        switch (benchmark) {
            case "pybbs":
                dir.add(basePath + "/pybbs/BOOT-INF/classes");
                return dir;
            case "shopizer":
                dir.add(basePath + "/shopizer/WEB-INF/classes");
                dir.add(basePath + "/sm-core-2.17.0/");
                dir.add(basePath + "/sm-core-model-2.17.0/");
                dir.add(basePath + "/sm-core-modules-2.17.0/");
                dir.add(basePath + "/sm-search-2.11.1/");
                dir.add(basePath + "/sm-shop-model-2.17.0/");
                return dir;
            case "SpringBlog":
                dir.add(basePath + "/SpringBlog/BOOT-INF/classes");
                return dir;
            case "WebGoat":
                dir.add(basePath + "/webwolf-8.2.2/BOOT-INF/classes");
                return dir;
            case "mall-admin":
                dir.add(basePath + "/mall-admin-1.0/BOOT-INF/classes");
                dir.add(basePath + "/mall-common-1.0");
                dir.add(basePath + "/mall-mbg-1.0");
                dir.add(basePath + "/mall-security-1.0");
                return dir;
            case "mall-search":
                dir.add(basePath + "/mall-search-1.0/BOOT-INF/classes");
                dir.add(basePath + "/mall-common-1.0");
                dir.add(basePath + "/mall-mbg-1.0");
                dir.add(basePath + "/mall-security-1.0");
                return dir;
            case "mall-portal":
                dir.add(basePath + "/mall-portal-1.0/BOOT-INF/classes");
                dir.add(basePath + "/mall-common-1.0");
                dir.add(basePath + "/mall-mbg-1.0");
                dir.add(basePath + "/mall-security-1.0");
                return dir;
            case "FEBS-Cloud-auth":
                dir.add(basePath + "/FEBS-Cloud/febs-auth-2.2-RELEASE/BOOT-INF/classes");
                dir.add(basePath + "/FEBS-Cloud/febs-common-core-2.2-RELEASE");
                dir.add(basePath + "/FEBS-Cloud/febs-common-datasource-starter-2.2-RELEASE");
                dir.add(basePath + "/FEBS-Cloud/febs-common-doc-gateway-starter-2.2-RELEASE");
                dir.add(basePath + "/FEBS-Cloud/febs-common-doc-starter-2.2-RELEASE");
                dir.add(basePath + "/FEBS-Cloud/febs-common-logging-starter-2.2-RELEASE");
                dir.add(basePath + "/FEBS-Cloud/febs-common-redis-starter-2.2-RELEASE");
                dir.add(basePath + "/FEBS-Cloud/febs-common-security-starter-2.2-RELEASE");
                return dir;
            case "FEBS-Cloud-system":
                dir.add(basePath + "/FEBS-Cloud/febs-server-system-2.2-RELEASE/BOOT-INF/classes");
                dir.add(basePath + "/FEBS-Cloud/febs-common-core-2.2-RELEASE");
                dir.add(basePath + "/FEBS-Cloud/febs-common-datasource-starter-2.2-RELEASE");
                dir.add(basePath + "/FEBS-Cloud/febs-common-doc-gateway-starter-2.2-RELEASE");
                dir.add(basePath + "/FEBS-Cloud/febs-common-doc-starter-2.2-RELEASE");
                dir.add(basePath + "/FEBS-Cloud/febs-common-logging-starter-2.2-RELEASE");
                dir.add(basePath + "/FEBS-Cloud/febs-common-redis-starter-2.2-RELEASE");
                dir.add(basePath + "/FEBS-Cloud/febs-common-security-starter-2.2-RELEASE");
                return dir;
            case "jeesite":
                dir.add(basePath + "/jeesite/WEB-INF/classes");
                return dir;
            case "FEBS-Shiro":
                dir.add(basePath + "/FEBS-Shiro-2.0/BOOT-INF/classes");
                return dir;
            case "ForestBlog":
                dir.add(basePath + "/ForestBlog-1.0.0-SNAPSHOT/WEB-INF/classes");
                return dir;
            case "Jeecg-boot":
                dir.add(basePath + "/jeecg-boot-module-system-2.4.5/BOOT-INF/classes");
                dir.add(basePath + "/jeecg-boot-base-core-2.4.5");
                dir.add(basePath + "/jeecg-boot-base-tools-2.4.5");
                dir.add(basePath + "/jeecg-boot-module-demo-2.4.5");
                dir.add(basePath + "/jeecg-system-local-api-2.4.5");
                return dir;
            case "My-Blog":
                dir.add(basePath + "/my-blog-4.0.0-SNAPSHOT/BOOT-INF/classes");
                return dir;
            case "Halo":
                dir.add(basePath + "/halo-1.4.8/BOOT-INF/classes");
                return dir;
            case "ruoyi":
                dir.add(basePath + "/ruoyi/ruoyi-admin/BOOT-INF/classes");
                dir.add(basePath + "/ruoyi/ruoyi-common-4.7.1");
                dir.add(basePath + "/ruoyi/ruoyi-framework-4.7.1");
                dir.add(basePath + "/ruoyi/ruoyi-generator-4.7.1");
                dir.add(basePath + "/ruoyi/ruoyi-quartz-4.7.1");
                dir.add(basePath + "/ruoyi/ruoyi-system-4.7.1");
                return dir;
            case "favorites-web":
                dir.add(basePath + "/favorites-web/favorites-web-1.0.0/BOOT-INF/classes");
                return dir;
            case "Vblog":
                dir.add(basePath + "/vblog/BOOT-INF/classes");
                return dir;
            case "vhr":
                dir.add(basePath + "/vhr-web-0.0.1-SNAPSHOT/BOOT-INF/classes");
                return dir;
            case "MCMS":
                dir.add(basePath + "/MCMS/WEB-INF/classes");
                return dir;
            case "SpringBlade":
                dir.add(basePath + "/SpringBlade/SpringBlade/BOOT-INF/classes");
                dir.add(basePath + "/SpringBlade/blade-core-launch-3.1.0");
                dir.add(basePath + "/SpringBlade/blade-core-develop-3.1.0/");
                dir.add(basePath + "/SpringBlade/blade-core-launch-3.1.0/");
                dir.add(basePath + "/SpringBlade/blade-core-log-3.1.0/");
                dir.add(basePath + "/SpringBlade/blade-core-mybatis-3.1.0/");
                dir.add(basePath + "/SpringBlade/blade-core-report-3.1.0/");
                dir.add(basePath + "/SpringBlade/blade-core-secure-3.1.0/");
                dir.add(basePath + "/SpringBlade/blade-core-social-3.1.0/");
                dir.add(basePath + "/SpringBlade/blade-core-swagger-3.1.0/");
                dir.add(basePath + "/SpringBlade/blade-core-tool-3.1.0/");
                return dir;
            default:
                return null;
        }
    }

    public static String getDependencyDir(String benchmark) {
        switch (benchmark) {
            case "pybbs":
                return basePath + "/pybbs/BOOT-INF/lib";
            case "shopizer":
                return basePath + "/shopizer/WEB-INF/lib";
            case "SpringBlog":
                return basePath + "/SpringBlog/BOOT-INF/lib";
            case "WebGoat":
                return basePath + "/webwolf-8.2.2/BOOT-INF/lib";
            case "mall-admin":
                return basePath + "/mall-admin-1.0/BOOT-INF/lib";
            case "mall-search":
                return basePath + "/mall-search-1.0/BOOT-INF/lib";
            case "mall-portal":
                return basePath + "/mall-portal-1.0/BOOT-INF/lib";
            case "FEBS-Cloud-auth":
                return basePath + "/FEBS-Cloud/febs-auth-2.2-RELEASE/BOOT-INF/lib";
            case "FEBS-Cloud-system":
                return basePath + "/FEBS-Cloud/febs-server-system-2.2-RELEASE/BOOT-INF/lib";
            case "jeesite":
                return basePath + "/jeesite/WEB-INF/lib";
            case "FEBS-Shiro":
                return basePath + "/FEBS-Shiro-2.0/BOOT-INF/lib";
            case "ForestBlog":
                return basePath + "/ForestBlog-1.0.0-SNAPSHOT/WEB-INF/lib";
            case "Jeecg-boot":
                return basePath + "/jeecg-boot-module-system-2.4.5/BOOT-INF/lib";
            case "My-Blog":
                return basePath + "/my-blog-4.0.0-SNAPSHOT/BOOT-INF/lib";
            case "Halo":
                return basePath + "/halo-1.4.8/BOOT-INF/lib";
            case "ruoyi":
                return basePath + "/ruoyi/ruoyi-admin/BOOT-INF/lib";
            case "favorites-web":
                return basePath + "/favorites-web/favorites-web-1.0.0/BOOT-INF/lib";
            case "Vblog":
                return basePath + "/vblog/BOOT-INF/lib";
            case "vhr":
                return basePath + "/vhr-web-0.0.1-SNAPSHOT/BOOT-INF/lib";
            case "MCMS":
                return basePath + "/MCMS/WEB-INF/lib";
            case "SpringBlade":
                return basePath + "/SpringBlade/SpringBlade/BOOT-INF/lib";
            default:
                return "";
        }
    }
}
