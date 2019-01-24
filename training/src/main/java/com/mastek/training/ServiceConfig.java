package com.mastek.training;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
@Component
public class ServiceConfig extends ResourceConfig{
	
	public ServiceConfig() {
	register(CORSFilter.class);
	register(TrainingAccessAPI.class);
	register(ParticipantAccessAPI.class);

}

}