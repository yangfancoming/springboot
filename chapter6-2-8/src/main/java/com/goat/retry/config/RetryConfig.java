package com.goat.retry.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;

@Configuration
@EnableRetry // 启用重试机制
public class RetryConfig {

}
