package com.omnitracs.platform.device.scheduler.spring;

import java.util.Arrays;

import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.omnitracs.platform.device.scheduler.entity.integration.ApplicationAttributeEntity;
import com.omnitracs.platform.device.scheduler.entity.integration.ApplicationEntity;
import com.omnitracs.platform.device.scheduler.entity.integration.CompanyEntity;
import com.omnitracs.platform.device.scheduler.entity.integration.GrantAppToCompanyEntity;
import com.omnitracs.platform.device.scheduler.entity.integration.LinkedCompanyAccountEntity;
import com.omnitracs.platform.device.scheduler.entity.integration.MdmProfileEntity;
import com.omnitracs.platform.device.scheduler.repository.integration.ApplicationAttributeRepository;
import com.omnitracs.platform.device.scheduler.repository.integration.ApplicationRepository;
import com.omnitracs.platform.device.scheduler.repository.integration.CompanyRepository;
import com.omnitracs.platform.device.scheduler.repository.integration.GrantAppToCompanyRepository;
import com.omnitracs.platform.device.scheduler.repository.integration.LinkedCompanyAccountRepository;
import com.omnitracs.platform.device.scheduler.repository.integration.MdmProfileRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class SchedulerConfiguration {

	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private GrantAppToCompanyRepository grantAppToCompanyRepository;
	@Autowired
	private LinkedCompanyAccountRepository linkedCompanyAccountRepository;

	@Autowired
	private ApplicationRepository applicationRepository;
	@Autowired
	private ApplicationAttributeRepository applicationAttributeRepository;
	@Autowired
	private MdmProfileRepository mdmProfileRepository;

	@Autowired
	private Environment environment;

	private static CloseableHttpClient httpClient = HttpClients.createDefault();

	private int fetchSize = 15000;
	private String fetchQuery = "&start=%d&end=%d";

	/**
	 * Method to process the companies. It fetches all the companies from the oracle
	 * database and upsert them into Postgres database.<br>
	 * 
	 * The method is scheduled to run every day at 0100 hrs.
	 */
	@Scheduled(cron = "0 0 1 * * *")
	public void processCompanies() {
		try {
			int start = 1;
			int end = fetchSize;
			boolean fetch = true;
			while (fetch) {
				String queryParam = String.format(fetchQuery, start, end);
				HttpGet httpGetRequest = new HttpGet(
						environment.getProperty("unity.companyUrl", "").concat(queryParam));
				httpGetRequest.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
				httpGetRequest.setHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
				String responseData = httpClient.execute(httpGetRequest, new BasicResponseHandler());

				// Create object mapper to read the companies data into an array.
				ObjectMapper om = new ObjectMapper().registerModule(new JavaTimeModule())
						.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
						.configure(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS, false);
				CompanyEntity[] companyArray = om.readValue(responseData, CompanyEntity[].class);
				// Upsert the list into Postgres database.
				companyRepository.saveAll(Arrays.asList(companyArray));
				start = start + fetchSize;
				end = end + fetchSize;
				fetch = companyArray.length > 0;
			}
		} catch (Exception e) {
			log.error("Error occurred in processing companies", e);
		}
	}

	/**
	 * Method to process the LINKED_COMPANY_ACCOUNT table data. It fetches all the
	 * linked company accounts from the oracle database and upsert them into
	 * Postgres database.<br>
	 * 
	 * The method is scheduled to run every day at 0115 hrs.
	 */
	@Scheduled(cron = "0 15 1 * * *")
	public void processLinkedCompanyAccounts() {
		try {
			int start = 1;
			int end = fetchSize;
			boolean fetch = true;
			while (fetch) {
				String queryParam = String.format(fetchQuery, start, end);
				HttpGet httpGetRequest = new HttpGet(
						environment.getProperty("unity.linkedCompanyAccountUrl", "").concat(queryParam));
				httpGetRequest.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
				httpGetRequest.setHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
				String responseData = httpClient.execute(httpGetRequest, new BasicResponseHandler());

				// Create object mapper to read the device attribute data into an array.
				ObjectMapper om = new ObjectMapper().registerModule(new JavaTimeModule())
						.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
						.configure(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS, false);
				LinkedCompanyAccountEntity[] linkedCompanyAccounts = om.readValue(responseData,
						LinkedCompanyAccountEntity[].class);
				// upsert the list into postgress database.
				linkedCompanyAccountRepository.saveAll(Arrays.asList(linkedCompanyAccounts));
				start = start + fetchSize;
				end = end + fetchSize;
				fetch = linkedCompanyAccounts.length > 0;
			}
		} catch (Exception e) {
			log.error("Error occurred in processing the linked company accounts", e);
		}
	}

	/**
	 * Method to process the GRANT_APP_TO_COMPANY table data. It fetches all the
	 * granted applications for the company from the oracle database and upsert them
	 * into Postgres database.<br>
	 * 
	 * The method is scheduled to run every day at 0130 hrs.
	 */
	@Scheduled(cron = "0 30 1 * * *")
	public void processGrantAppToCompany() {
		try {
			HttpGet httpGetRequest = new HttpGet(environment.getProperty("unity.grantAppToCompanyUrl"));
			httpGetRequest.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
			httpGetRequest.setHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
			String responseData = httpClient.execute(httpGetRequest, new BasicResponseHandler());

			// Create object mapper to read the device attribute data into an array.
			ObjectMapper om = new ObjectMapper().registerModule(new JavaTimeModule())
					.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
					.configure(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS, false);
			GrantAppToCompanyEntity[] grantedAppstoCompany = om.readValue(responseData,
					GrantAppToCompanyEntity[].class);
			// upsert the list into postgress database.
			grantAppToCompanyRepository.saveAll(Arrays.asList(grantedAppstoCompany));
		} catch (Exception e) {
			log.error("Error occurred in processing the Granted Application For the Company", e);
		}
	}

	/**
	 * Method to process the APPLICATION table data. It fetches all the applications
	 * from the oracle database and upsert them into Postgres database.<br>
	 * 
	 * The method is scheduled to run every day at 0145 hrs.
	 */
	@Scheduled(cron = "0 45 1 * * *")
	public void processApplications() {
		try {
			HttpGet httpGetRequest = new HttpGet(environment.getProperty("unity.applicationUrl"));
			httpGetRequest.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
			httpGetRequest.setHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
			String responseData = httpClient.execute(httpGetRequest, new BasicResponseHandler());

			// Create object mapper to read the device attribute data into an array.
			ObjectMapper om = new ObjectMapper().registerModule(new JavaTimeModule())
					.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
					.configure(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS, false);
			ApplicationEntity[] applications = om.readValue(responseData, ApplicationEntity[].class);
			// upsert the list into postgress database.
			applicationRepository.saveAll(Arrays.asList(applications));
		} catch (Exception e) {
			log.error("Error occurred in processing the applications", e);
		}
	}

	/**
	 * Method to process the APPLICATION_ATTRIBUTE table data. It fetches all the
	 * application attributes from the oracle database and upsert them into Postgres
	 * database.<br>
	 * 
	 * The method is scheduled to run every day at 0200 hrs.
	 */
	@Scheduled(cron = "0 0 2 * * *")
	public void processApplicationAttributes() {
		try {
			HttpGet httpGetRequest = new HttpGet(environment.getProperty("unity.applicationAttributeUrl"));
			httpGetRequest.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
			httpGetRequest.setHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
			String responseData = httpClient.execute(httpGetRequest, new BasicResponseHandler());

			// Create object mapper to read the device attribute data into an array.
			ObjectMapper om = new ObjectMapper().registerModule(new JavaTimeModule())
					.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
					.configure(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS, false);
			ApplicationAttributeEntity[] applicationAttributes = om.readValue(responseData,
					ApplicationAttributeEntity[].class);
			// upsert the list into postgress database.
			applicationAttributeRepository.saveAll(Arrays.asList(applicationAttributes));
		} catch (Exception e) {
			log.error("Error occurred in processing the application attributes", e);
		}
	}

	/**
	 * Method to process the MDM_PROFILE table data. It fetches all the mdm profiles
	 * from the oracle database and upsert them into Postgres database.<br>
	 *
	 * This method is scheduled to run every day at 0215 hrs.
	 */
	@Scheduled(cron = "0 15 2 * * *")
	public void processMdmProfiles() {
		try {
			HttpGet httpGetRequest = new HttpGet(environment.getProperty("unity.mdmProfileUrl"));
			httpGetRequest.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
			httpGetRequest.setHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
			String responseData = httpClient.execute(httpGetRequest, new BasicResponseHandler());

			// Create object mapper to read the device attribute data into an array.
			ObjectMapper om = new ObjectMapper().registerModule(new JavaTimeModule())
					.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
					.configure(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS, false);
			MdmProfileEntity[] mdmProfiles = om.readValue(responseData, MdmProfileEntity[].class);
			// upsert the list into postgress database.
			mdmProfileRepository.saveAll(Arrays.asList(mdmProfiles));
		} catch (Exception e) {
			log.error("Error occurred in processing the mdm profiles", e);
		}
	}

}
