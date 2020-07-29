package com.zemoso.grpc;

import java.io.IOException;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import com.zemoso.grpc.proto.CmsBlogServiceImpl;
import com.zemoso.grpc.util.JwtServerInterceptor;

import io.grpc.Server;
import io.grpc.ServerBuilder;

@SpringBootApplication
@EntityScan(basePackageClasses = {
		CmsGrpcApplication.class,
		Jsr310JpaConverters.class
})
public class CmsGrpcApplication {
	
	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
	

	public static void main(String[] args) throws InterruptedException, IOException {
		SpringApplication.run(CmsGrpcApplication.class, args);

		Server server = ServerBuilder.forPort(53003)
				.addService(new CmsBlogServiceImpl())
				.intercept(new JwtServerInterceptor())
				.build();
		server.start();
		System.out.println("\ngRPC server started at port: " + server.getPort());

		server.awaitTermination();

	}

}
