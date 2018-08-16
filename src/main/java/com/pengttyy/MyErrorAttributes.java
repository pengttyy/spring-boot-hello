package com.pengttyy;

import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pengt on 2017/8/3.
 */
@Component
public class MyErrorAttributes implements ErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
        for (String s : requestAttributes.getAttributeNames(0)) {
            System.out.println(s + "\t" + requestAttributes.getAttribute(s, 0));
        }
        Integer status = (Integer) requestAttributes.getAttribute("javax.servlet.error.status_code", RequestAttributes.SCOPE_REQUEST);
        Map<String, Object> map = new HashMap<>();
        map.put("message", HttpStatus.valueOf(status).getReasonPhrase());
        map.put("exception", "err");
        map.put("status", status);
        Throwable error = getError(requestAttributes);
        System.out.println("errr===" + error);
        return map;
    }

    @Override
    public Throwable getError(RequestAttributes requestAttributes) {
        return null;
    }
}
