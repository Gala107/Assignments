package com.hibernate.maven.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import com.hibernate.maven.model.User;

public class SessionBuilder {

	/*
	 * 'hbm2ddl.auto' values: create - DB is dropped if exists and created update -
	 * if DB is already there, do nothing; if not - create one
	 */
	static Session build(String dbSetup) {

		// Implementation Option 1 using Configuraion.
		Configuration config = new Configuration().configure().addAnnotatedClass(User.class);
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.applySettings(config.getProperties()).applySetting(AvailableSettings.HBM2DDL_AUTO, dbSetup).build();
		return config.buildSessionFactory(registry).openSession();

		// Implementation Option 2 using Metadata.
//		StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure()
//				.applySetting(AvailableSettings.HBM2DDL_AUTO, dbSetup).build();
//		Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
//		return metaData.getSessionFactoryBuilder().build().openSession();
	}
}
