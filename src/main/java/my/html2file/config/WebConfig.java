package my.html2file.config;

import my.html2file.utils.BaseUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

/**
 * @author 欧阳洁
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    /**
     * 全局忽略
     */
    private static final String IGNORURISTR = "/static/**,/**/*.ico,/**/*.css,/**/*.js,/**/open/**,/error,/captcha,/captcha_check,/temp";

    /**
     * 常量
     */
    @Value("${web.ignore.uri}")
    private String ignoreUri;

    /**
     * 获取默认忽略
     *
     * @return 忽略的url
     */
    public String getIgnorUriStr() {
        //默认忽略
        String ignorUriStr = IGNORURISTR;
        if (!BaseUtils.isBlank(ignoreUri)) {
            ignorUriStr = ignorUriStr + "," + ignoreUri;
        }
        return ignorUriStr;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //如果我们要指定一个绝对路径的文件夹（如 H:/myimgs/ ），则只需要使用 addResourceLocations 指定即可。
        //registry.addResourceHandler("/myimgs/**").addResourceLocations("file:H:/myimgs/");
        final int maxAge = 0;//无缓存静态资源，开发时候调成0
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/").setCacheControl(CacheControl.maxAge(maxAge, TimeUnit.MINUTES));
        registry.addResourceHandler("/output/**").addResourceLocations("classpath:/output/").setCacheControl(CacheControl.maxAge(maxAge, TimeUnit.MINUTES));

        super.addResourceHandlers(registry);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] e = BaseUtils.trimToEmpty(getIgnorUriStr()).split(",");
        Set<String> pset = new TreeSet<String>();
        pset.add("/login");
        for (String str : e) {
            if (!BaseUtils.isBlank(str)) {
                pset.add(str);
            }
        }
        String[] e2 = pset.toArray(new String[]{});
        // kisso 拦截器配置
        //registry.addInterceptor(new SSOSpringInterceptor()).addPathPatterns("/**").excludePathPatterns(e2);
        // 权限拦截器
        //registry.addInterceptor(new AuthenticationInterceptor()).addPathPatterns("/**");
    }
}
