package com.mragowo.springboot.nplusselect;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ibm.as400.access.AS400SecurityException;
import com.ibm.as400.access.DataQueue;
import com.ibm.as400.access.DataQueueEntry;
import com.ibm.as400.access.ErrorCompletingRequestException;
import com.ibm.as400.access.IllegalObjectTypeException;
import com.ibm.as400.access.ObjectDoesNotExistException;
import com.mragowo.springboot.nplusselect.schedule.SchedulerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AS400DataQueueTest {

	Logger logger = LoggerFactory.getLogger(this.getClass()); 
	
	@MockBean
	private DataQueue dataQueue; 
	
	@Autowired
	private SchedulerService schedulerService; 
	
	@TestConfiguration
	static class BeanConfiguration {
		
		@Bean
		public DataQueue dataQueue() {
			DataQueue dataqueue = new DataQueue(); 
			return dataqueue; 
		}
	}
	
	@Before
	public void setUp() { 
			
		   DataQueueEntry entry = Mockito.mock(DataQueueEntry.class); 
		   try {
			Mockito.when(entry.getString()).thenReturn("ENTRY");
			Mockito.when(dataQueue.peek()).thenReturn(entry); 
			
		} catch (UnsupportedEncodingException e) {
			logger.error("Excpetion when readign from mock data queue: " , e.getMessage(), e);
			fail(); 
		} catch (AS400SecurityException e) {
			logger.error("Excpetion when readign from mock data queue: " , e.getMessage(), e);
			fail(); 
		} catch (ErrorCompletingRequestException e) {
			logger.error("Excpetion when readign from mock data queue: " , e.getMessage(), e);
			fail(); 
		} catch (IOException e) {
			logger.error("Excpetion when readign from mock data queue: " , e.getMessage(), e);
			fail(); 
		} catch (IllegalObjectTypeException e) {
			logger.error("Excpetion when readign from mock data queue: " , e.getMessage(), e);
			fail(); 
		} catch (InterruptedException e) {
			logger.error("Excpetion when readign from mock data queue: " , e.getMessage(), e);
			fail(); 
		} catch (ObjectDoesNotExistException e) {
			logger.error("Excpetion when readign from mock data queue: " , e.getMessage(), e);
			fail(); 
		} 
		   
	}
	
	@Test
	public void testDataQueue() {

		   schedulerService.readDataQueue(); 

	}
}
