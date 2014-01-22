package com.brm.web.service;

import com.brm.web.Performer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service("/HelloService")
public class HelloService implements Performer {

	public Map<String, Object> service(Map<String, Object> param) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("reply", "Hello, " + param.get("name"));
		return result;
	}
}


