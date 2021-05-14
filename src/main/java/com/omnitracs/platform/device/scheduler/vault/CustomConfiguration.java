package com.omnitracs.platform.device.scheduler.vault;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.vault.config.VaultConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomConfiguration {

	@Value("${vault.path:secret/data/product/platform/dev/device-service}")
	private String vaultPath;

	@Bean
	public VaultConfigurer configurer() {
		return configurer -> {
			configurer.add(vaultPath);
			configurer.registerDefaultKeyValueSecretBackends(false);
		};
	}

}
