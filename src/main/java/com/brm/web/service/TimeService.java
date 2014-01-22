package com.brm.web.service;

import com.brm.web.Performer;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service("/TimeService")
public class TimeService implements Performer {

	public Map<String, Object> service(Map<String, Object> param) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("reply", new Date().toString());
		return result;
	}
}
