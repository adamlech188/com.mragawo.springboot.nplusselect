package com.mragowo.springboot.nplusselect.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SchedulerService {
	
//	@Autowired
//	private DataQueue dataQueue; 
	
	@Scheduled(fixedRate=5000)
	public void readDataQueue() {
		System.out.println("Read");
	}
}
