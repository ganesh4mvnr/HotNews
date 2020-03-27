/*
 * Copyright (c) 2018 Vishrant Gupta <firstname.lastname@gmail.com>
 *
 * License: MIT
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 * 
 */
package com.news.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.cassandra.config.AbstractReactiveCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceOption;
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author bibin
 *
 */
@Configuration
@PropertySource(value = { "classpath:cassandra.yml" })
@ConfigurationProperties("spring.data.cassandra")
@EnableReactiveCassandraRepositories
public class CassandraConfig extends AbstractReactiveCassandraConfiguration {

	@Value("${contactpoints}") private String contactPoints;
	@Value("${port}") private int port;
	@Value("${keyspacename}") private String keyspace;
	@Value("${basepackages}") private String basePackages;
	@Override protected String getKeyspaceName() {
		return keyspace;
	}
	@Override protected String getContactPoints() {
		return contactPoints;
	}
	@Override protected int getPort() {
		return port;
	}
	@Override public SchemaAction getSchemaAction() {
		return SchemaAction.CREATE_IF_NOT_EXISTS;
	}
	@Override public String[] getEntityBasePackages() {
		return new String[] {
				basePackages
		};

	}
	@Override
	protected boolean getMetricsEnabled() {
		return false;
	}

	@Override
	protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {

		CreateKeyspaceSpecification specification = CreateKeyspaceSpecification.createKeyspace(keyspace)
				.ifNotExists()
				.with(KeyspaceOption.DURABLE_WRITES, true);

		return Arrays.asList(specification);
	}
}
