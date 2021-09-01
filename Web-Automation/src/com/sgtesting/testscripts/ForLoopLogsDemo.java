package com.sgtesting.testscripts;

import org.apache.log4j.Logger;

public class ForLoopLogsDemo {
	public static Logger log=Logger.getLogger("For Loop Output");
	public static void main(String[] args) {
		log.info("For Loop Execution Starts here !!!!!");
		for(int i=20;i<=40;i++) {
			if(i%2==0)
			{
				log.info("Even Number :"+i);
			}
		}

		log.info("For Loop Execution ends here !!!!!");
	}

}
