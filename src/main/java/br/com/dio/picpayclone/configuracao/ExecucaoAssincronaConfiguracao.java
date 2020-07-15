package br.com.dio.picpayclone.configuracao;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class ExecucaoAssincronaConfiguracao {

	@Bean(name = "asyncExecutor")
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(3);
		executor.setMaxPoolSize(3);
		executor.setQueueCapacity(100);
		executor.setThreadNamePrefix("AsyncThread-");
		executor.initialize();
		return executor;
	}

//	@Bean
//	public MethodInvokingFactoryBean methodInvokingFactoryBean() {
//		MethodInvokingFactoryBean methodInvokingFactoryBean = new MethodInvokingFactoryBean();
//		methodInvokingFactoryBean.setTargetClass(SecurityContextHolder.class);
//		methodInvokingFactoryBean.setTargetMethod("setStrategyName");
//		methodInvokingFactoryBean.setArguments(new Object[] { SecurityContextHolder.MODE_INHERITABLETHREADLOCAL });
//		return methodInvokingFactoryBean;
//	}
	
}
