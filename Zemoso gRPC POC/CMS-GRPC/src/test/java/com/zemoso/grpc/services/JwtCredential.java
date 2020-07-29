package com.zemoso.grpc.services;

import java.util.concurrent.Executor;

import io.grpc.CallCredentials;
import io.grpc.Metadata;
import io.grpc.Status;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtCredential extends CallCredentials{

	private final String subject;

	  JwtCredential(String subject) {
	    this.subject = subject;
	  }
	
	@Override
	public void applyRequestMetadata(RequestInfo requestInfo, Executor appExecutor, MetadataApplier applier) {
		
		final String jwt =
		        Jwts.builder()
		            .setSubject(subject)
		            .signWith(SignatureAlgorithm.HS256, Constant.JWT_SIGNING_KEY)
		            .compact();

		appExecutor.execute(new Runnable() {
		      @Override
		      public void run() {
		        try {
		          Metadata headers = new Metadata();
		          headers.put(Constant.AUTHORIZATION_METADATA_KEY,
		              String.format("%s %s", Constant.BEARER_TYPE, jwt));
		          applier.apply(headers);
		        } catch (Throwable e) {
		        	applier.fail(Status.UNAUTHENTICATED.withCause(e));
		        }
		      }
		    });
	}

	@Override
	public void thisUsesUnstableApi() {
		// TODO Auto-generated method stub
		
	}

}
