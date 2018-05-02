package com.stark.pub.spring.exception;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

/**
 * 1. 不必在Controller中对异常进行处理，抛出即可，由此异常解析器统一控制。
 * 2. ajax请求（有@ResponseBody的Controller）发生错误，输出JSON。 
 * 3. 页面请求（无@ResponseBody的Controller）发生错误，输出错误页面。 
 * 4. 需要与AnnotationMethodHandlerAdapter使用同一个messageConverters 
 * 5. Controller中不需要有专门处理异常的方法。
 */
public class AnnotationHandlerMethodExceptionResolver extends ExceptionHandlerExceptionResolver {
    /** 错误处理页面 */
    private String defaultErrorView;

    public String getDefaultErrorView() {
        return defaultErrorView;
    }

    public void setDefaultErrorView(String defaultErrorView) {
        this.defaultErrorView = defaultErrorView;
    }

    @Override
    protected ModelAndView doResolveHandlerMethodException(HttpServletRequest request, HttpServletResponse response, HandlerMethod handlerMethod, Exception exception) {
        if (null == handlerMethod) { // 无处理方法
            return null;
        }
        Method method = handlerMethod.getMethod();
        if (null == method) { // 无处理方法
            return null;
        }
        ModelAndView returnValue = super.doResolveHandlerMethodException(request, response, handlerMethod, exception);
        ResponseBody responseBodyAnn = AnnotationUtils.findAnnotation(method, ResponseBody.class);
        RestController restControllerAnn = AnnotationUtils.findAnnotation(method.getDeclaringClass(), RestController.class);
        if (null != restControllerAnn || null != responseBodyAnn) { // Ajax 结果
            try {
                return handleResponseBody(returnValue, request, response);
            } catch (Exception e) {
                logger.debug(e);
                return null;
            }
        } else { // 页面错误
            if (returnValue.getViewName() == null) {
                returnValue.setViewName(defaultErrorView);
            }
            return returnValue;
        }

    }

    /**
     * 处理Ajax业务结果
     * 
     * @param returnValue
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    private ModelAndView handleResponseBody(ModelAndView returnValue, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ModelMap value = returnValue.getModelMap();
        HttpInputMessage inputMessage = new ServletServerHttpRequest(request);
        List<MediaType> acceptedMediaTypes = inputMessage.getHeaders().getAccept();
        if (acceptedMediaTypes.isEmpty()) {
            acceptedMediaTypes = Collections.singletonList(MediaType.ALL);
        }
        MediaType.sortByQualityValue(acceptedMediaTypes);
        Class<?> returnValueType = value.getClass(); // 返回类型
        // 获取可以处理媒体类型的转换器
        List<HttpMessageConverter<?>> messageConverters = getMessageConverters();
        if (messageConverters != null) {
            outputMediaTypeResponse(response, value, acceptedMediaTypes, returnValueType, messageConverters);
            return new ModelAndView();
        }
        if (logger.isWarnEnabled()) { // 不支持的输入类型
            logger.warn("Could not find HttpMessageConverter that supports return type [" + returnValueType + "] and " + acceptedMediaTypes);
        }
        return null;
    }

    /**
     * 输出媒体类型结果
     * 
     * @param response
     * @param resultMap
     * @param acceptedMediaTypes
     * @param returnValueType
     * @param messageConverters
     * @throws IOException
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    private void outputMediaTypeResponse(HttpServletResponse response, ModelMap resultMap, List<MediaType> acceptedMediaTypes, Class<?> returnValueType,
                                         List<HttpMessageConverter<?>> messageConverters) throws IOException {
        for (MediaType acceptedMediaType : acceptedMediaTypes) {
            for (HttpMessageConverter messageConverter : messageConverters) {
                if (messageConverter.canWrite(returnValueType, acceptedMediaType)) {
                    HttpOutputMessage outputMessage = new ServletServerHttpResponse(response);
                    if (1 == resultMap.size()) { // 如果只有一个模型，那么直接输出该模型
                        messageConverter.write(resultMap.values().iterator().next(), acceptedMediaType, outputMessage);
                    } else {
                        messageConverter.write(resultMap, acceptedMediaType, outputMessage);
                    }
                    return;
                }
            }
        }
    }
}
