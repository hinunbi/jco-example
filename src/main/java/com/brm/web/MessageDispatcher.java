package com.brm.web;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.Body;
import org.apache.camel.Header;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class MessageDispatcher {
	@Autowired
	ApplicationContext springContext;

	public Map dispatch(@Header("CamelHttpUri") String serviceUri, @Body Map<String, Object> param) {
		Map<String, Object> result = null;
		Performer performer; 
		try {
			performer = springContext.getBean(serviceUri, Performer.class);
			try {
				// 실행자 서비스 실행
				result = performer.service(param);
				result.put("status", "ServiceOk");
			} catch (Exception e) {
				// 서비스 실행 실패
				result = new HashMap<String, Object>();
				result.put("status", "ServiceFail");
				result.put("reply", e.getMessage());
			}
		} catch (NoSuchBeanDefinitionException e) {
			// 실행자 서비스 찾기 실패
			result = new HashMap<String, Object>();
			result.put("status", "DispatcherFail");
			result.put("reply", "Not found : " + serviceUri);
		} catch (BeansException e) {
			// 그외 실패
			result = new HashMap<String, Object>();
			result.put("status", "DispatcherFail");
			result.put("reply", "Get Bean Fail : " + e.getMessage());
		}
		return result;
	}
}
