package com.zemoso.grpc.services;

import java.util.concurrent.TimeUnit;

import com.zemoso.grpc.proto.Bloglist;
import com.zemoso.grpc.proto.CmsBlogGrpc;
import com.zemoso.grpc.proto.Logincms;

import io.grpc.CallCredentials;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class AuthClient {

	private final ManagedChannel channel;
	private final CmsBlogGrpc.CmsBlogBlockingStub blockingStub;
	private final CallCredentials callCredentials;

	AuthClient(CallCredentials callCredentials, String host, int port) {
		this(callCredentials, ManagedChannelBuilder.forAddress(host, port).usePlaintext().build());
	}

	AuthClient(CallCredentials callCredentials, ManagedChannel channel) {
		this.callCredentials = callCredentials;
		this.channel = channel;
		this.blockingStub = CmsBlogGrpc.newBlockingStub(channel);
	}

	public void shutdown() throws InterruptedException {
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}

	public Bloglist getBlogs(String name) {
		Logincms request = Logincms.newBuilder().setResponsemessage(name).setResponsecode(200).build();

		// Use a stub with the given call credentials applied to invoke the RPC.
		Bloglist response = blockingStub.withCallCredentials(callCredentials).post(request);
		return response;
	}
	
	/**
	 * Greet server. If provided, the first element of {@code args} is the name to
	 * use in the greeting and the second is the client identifier to set in JWT
	 */
	/*
	 * public static void main(String[] args) throws Exception {
	 * 
	 * String host = "localhost"; int port = 50051; String user = "world"; String
	 * clientId = "default-client";
	 * 
	 * if (args.length > 0) { host = args[0]; // Use the arg as the server host if
	 * provided } if (args.length > 1) { port = Integer.parseInt(args[1]); // Use
	 * the second argument as the server port if provided } if (args.length > 2) {
	 * user = args[2]; // Use the the third argument as the name to greet if
	 * provided } if (args.length > 3) { clientId = args[3]; // Use the fourth
	 * argument as the client identifier if provided }
	 * 
	 * CallCredentials credentials = new JwtCredential(clientId); AuthClient client
	 * = new AuthClient(credentials, host, port);
	 * 
	 * try { client.greet(user); } finally { client.shutdown(); } }
	 */

}
