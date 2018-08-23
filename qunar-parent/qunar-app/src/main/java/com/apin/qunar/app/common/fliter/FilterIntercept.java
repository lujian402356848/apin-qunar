package com.apin.qunar.app.common.fliter;

import com.alibaba.fastjson.JSON;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.app.common.enums.AbnormalEnum;
import com.apin.qunar.basic.dao.model.Merchant;
import com.apin.qunar.basic.service.MerchantService;
import com.apin.qunar.common.enums.SysReturnCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * TODO: 拦截器将post请求加密之后的参数拦截在解密.
 *
 * @author fy
 * @version 1.0
 * @date 2018/8/14 23:31
 */
@Component
@Slf4j
@WebFilter(filterName = "myFilter", urlPatterns = "/*")
public class FilterIntercept implements Filter {

    @Resource
    private MerchantService merchantService;

    private static final Set<String> ALLOWED_PATHS = Collections.unmodifiableSet(new HashSet<>(Arrays.asList("/qufei/user/register", "/qufei/user/login", "/qufei/alipay/payCallback", "/qufei/wechatPay/payCallback", "/qufei/order/statusCallback", "/qufei/ntsOrder/statusCallback", "/api/pay/callback", "/api/refund/callback")));

    /**
     * description：将用户的请求进行拦截<url></>
     *
     * @param servletRequest  ServletRequest由Servlet容器来管理，当客户请求到来时，容器创建一个ServletRequest对象
     * @param servletResponse 封装请求数据，同时创建一个ServletResponse对象，封装响应数据
     * @param filterChain     过滤器拦截链
     * @throws IOException      异常
     * @throws ServletException 容器解析异常
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (servletRequest == null || !(servletRequest instanceof HttpServletRequest)) {
            doFilterReturning(servletResponse);
            return;
        }
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        if (request == null || StringUtils.isBlank(request.getMethod()) || !"POST".equalsIgnoreCase(request.getMethod())) {
            doFilterReturning(servletResponse);
            return;
        }
        String path = request.getRequestURI().substring(request.getContextPath().length()).replaceAll("[/]+$", "");
        if (ALLOWED_PATHS.contains(path)) {
            filterChain.doFilter(request, servletResponse);
            return;
        }
        //测试环境不用加密标识符号
        String defaultHead = request.getHeader("apiTest");
        String defaultValue = "testApi";
        if (StringUtils.isNotEmpty(defaultHead) && defaultHead.equalsIgnoreCase(defaultValue)) {
            filterChain.doFilter(request, servletResponse);
            return;
        }
        //商户号校验
        String merchantNo = request.getHeader("MerchantNo");
        if (StringUtils.isBlank(merchantNo)) {
            log.error("用户的商户号不能为空,主机名:{},ip:{},path:{}", request.getRemoteHost(), request.getRemoteAddr(), path);
            doFilterReturning(servletResponse);
            return;
        }
        //根据商户号去用数据库找到对应的秘钥
        Merchant merchant = merchantService.queryByMerchantNo(merchantNo);
        if (merchant == null || StringUtils.isBlank(merchant.getSecretKey())) {
            log.error("商户号或秘钥不存在，请核实,merchantNo:{},主机名:{},ip:{},path:{}", merchantNo, request.getRemoteHost(), request.getRemoteAddr(), path);
            doFilterReturning(servletResponse);
            return;
        }
        // 防止流读取一次后就没有了, 所以需要将流继续写出去
        ServletRequest requestWrapper = null;
        try {
            requestWrapper = new BodyReaderHttpServletRequestWrapper(merchant.getSecretKey(), request);
        } catch (Exception e) {
            log.error("从ServletRequest读取数据异常,主机名{},IP:{},path:{}", request.getRemoteHost(), request.getRemoteAddr(), path, e);
            doFilterReturning(servletResponse);
            return;
        }
        filterChain.doFilter(requestWrapper, servletResponse);
    }


    /**
     * description：将可能出现的异常打印出去
     *
     * @param response 返回数据形式
     * @throws IOException 异常
     */
    private void doFilterReturning(ServletResponse response) throws IOException {

        GeneralResultMap generalResultMap = new GeneralResultMap();
        // 自定义异常的类，用户返回给客户端相应的JSON格式的信息
        generalResultMap.setResult(SysReturnCode.FAIL, AbnormalEnum.UNLAWFUL_REQUEST.getMessage());

        response.setContentType("application/json; charset=utf-8");
        response.setCharacterEncoding("UTF-8");

        String userJson = JSON.toJSONString(generalResultMap);
        OutputStream out = response.getOutputStream();
        out.write(userJson.getBytes("UTF-8"));
        out.flush();
    }

    /**
     * Spring容器后开始执行的最后一步操作
     */
    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    /**
     * description: 运行环境信息的FilterConfig对象
     *
     * @param config FilterConfig对象
     * @throws ServletException 容器解析异常
     */
    @Override
    public void init(FilterConfig config) throws ServletException {

    }
}
