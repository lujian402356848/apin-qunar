package com.apin.qunar.app.common.aop;


import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.basic.common.enums.AbnormalEnum;
import com.apin.qunar.common.enums.SysReturnCode;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  TODO: 利用切面统一处理参数校验异常的方法
 *
 * @author fy
 * @version 1.0
 * @date 2018/8/8 10:56
 */
@Aspect
@Component
@Slf4j
public class BindingResultAspect {

    /**
     * AOP页面对象参数校验
     *
     * @param proceedingJoinPoint aspectJ切面通过ProceedingJoinPoint想要获取当前执行的方法：
     * @param bindingResult       验证框架对象
     * @return GeneralResultMap
     * @throws Throwable 异常抛出
     */
    @Around(value = "(execution(* com.apin.qunar.app.*.controller.*.*(..)) && args(..,bindingResult))")
    public GeneralResultMap doAround(ProceedingJoinPoint proceedingJoinPoint, BindingResult bindingResult) throws Throwable {

        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String classUrl = "";
        RequestMapping classMapping = proceedingJoinPoint.getTarget().getClass().getAnnotation(RequestMapping.class);
        if (null != classMapping) {
            String[] classUrls = classMapping.value();
            if (classUrls.length > 0) {
                classUrl = classUrls[0];
            }
        }

        String methodUrl = "";
        PostMapping postMapping = methodSignature.getMethod().getAnnotation(PostMapping.class);
        if (null != postMapping) {
            String[] methodUrls = postMapping.value();
            if (methodUrls.length > 0) {
                methodUrl = methodUrls[0];
            }
        }

        String url;
        char slash = '/';
        if (classUrl.length() >= 1 && slash == (classUrl.charAt(classUrl.length() - 1))) {
            url = classUrl + methodUrl;
        } else {
            url = classUrl + methodUrl;
        }
        log.info("【AOP参数校验】url{}", url);

        GeneralResultMap generalResultMap;
        if (bindingResult.hasErrors()) {
            //将所有参数进行校验
            bindingResult.getAllErrors()
                    .forEach((ObjectError error)
                            -> log.error("【参数校验异常】{}!,url={}", error.getDefaultMessage(), url));

            generalResultMap = new GeneralResultMap();
            generalResultMap.setResult(SysReturnCode.FAIL, AbnormalEnum.PARAMETER_IS_INCORRECT.getMessage());
            return generalResultMap;
        } else {
            generalResultMap = (GeneralResultMap) proceedingJoinPoint.proceed();
        }

        return generalResultMap;
    }

}




