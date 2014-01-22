package com.brm.web.service;

import com.brm.web.Performer;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.springframework.stereotype.Service;

@Service("/TwitterService")
public class TwitterService implements Performer {

	@Produce(uri="direct:twitter")
	ProducerTemplate producer;

	public Map<String, Object> service(Map<String, Object> param) throws Exception {

		// 트윗 메시지 조립
		String tweet = (String) param.get("tweet") + " at " + new Date();
		
		// 트윗
		producer.sendBody(tweet);

		// 결과 반환
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("reply", "Sent the tweet, [" + tweet + "]");
		return result;
	}
}



