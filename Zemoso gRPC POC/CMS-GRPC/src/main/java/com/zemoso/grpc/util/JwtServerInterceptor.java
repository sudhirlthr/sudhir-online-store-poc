package com.zemoso.grpc.util;

import io.grpc.Context;
import io.grpc.Contexts;
import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCall.Listener;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.Status;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;

public class JwtServerInterceptor implements ServerInterceptor{

	JwtParser parser = Jwts.parser().setSigningKey(Constant.JWT_SIGNING_KEY);
	
	@Override
	public <ReqT, RespT> Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call, Metadata headers,
			ServerCallHandler<ReqT, RespT> next) {
		
		String value = headers.get(Constant.AUTHORIZATION_METADATA_KEY);
		Status status = Status.OK;
		
		//For Login we will pass without jwt
		String methodName = call.getMethodDescriptor().getFullMethodName();
		
		
		if(methodName.equalsIgnoreCase("CmsBlog/login")) {
			return Contexts.interceptCall(Context.current().withValue(Constant.CLIENT_ID_CONTEXT_KEY, "default-client"), call, headers, next);
			
		}
		else {
			if(value == null)
				status = Status.UNAUTHENTICATED.withDescription("Authorization token is missing");
			else if(!value.startsWith(Constant.BEARER_TYPE))
				status = Status.UNAUTHENTICATED.withDescription("unknown Authorization type");
			else {
				Jws<Claims> claims = null;
				String token = value.substring(Constant.BEARER_TYPE.length()).trim();
				try {
						claims = parser.parseClaimsJws(token);
						
				} catch (JwtException e) {
			        status = Status.UNAUTHENTICATED.withDescription(e.getMessage()).withCause(e);
				}
				
				if(claims != null) {
					Context context = Context.current().withValue(Constant.CLIENT_ID_CONTEXT_KEY, claims.getBody().getSubject());
					return Contexts.interceptCall(context, call, headers, next);
				}
			}
			call.close(status, new Metadata());
			return new ServerCall.Listener<ReqT>() {
			};
		}
		
	}

}
