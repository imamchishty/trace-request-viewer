package com.shedhack.trace;

import com.shedhack.trace.request.jpa.domain.Request;
import com.shedhack.trace.request.viewer.controller.Node;
import com.shedhack.trace.request.viewer.utility.RequestUtility;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TraceRequestVisualApplicationTests {

	@Test
	public void contextLoads() {

		String groupId = UUID.randomUUID().toString();
		String req1 = UUID.randomUUID().toString();
		String req2 = UUID.randomUUID().toString();
		String req3 = UUID.randomUUID().toString();
		String req4 = UUID.randomUUID().toString();
		String req5 = UUID.randomUUID().toString();
		String req6 = UUID.randomUUID().toString();
		String req7 = UUID.randomUUID().toString();
		String req8 = UUID.randomUUID().toString();
		String req9 = UUID.randomUUID().toString();
		String req10 = UUID.randomUUID().toString();
		String req11 = UUID.randomUUID().toString();
		String req12 = UUID.randomUUID().toString();
		String req13 = UUID.randomUUID().toString();

		List<Request> requests = new ArrayList<>();
		requests.add(requestBuilder("district3", req3, groupId, req2));
		requests.add(requestBuilder("district12", req12, groupId, req11));
		requests.add(requestBuilder("district2", req2, groupId, req1));
		requests.add(requestBuilder("district4", req4, groupId, req3));
		requests.add(requestBuilder("district7", req7, groupId, req6));
		requests.add(requestBuilder("district8", req8, groupId, req7));
		requests.add(requestBuilder("district5", req5, groupId, req4));
		requests.add(requestBuilder("district9", req9, groupId, req8));
		requests.add(requestBuilder("district11", req11, groupId, req10));
		requests.add(requestBuilder("district13", req13, groupId, req12));
		requests.add(requestBuilder("district1", req1, groupId, null));
		requests.add(requestBuilder("district10", req10, groupId, req9));
		requests.add(requestBuilder("district6", req6, groupId, req5));

		List<Node> nodes = RequestUtility.order(requests);

	}

	private Request requestBuilder(String appId, String requestId ,String groupId, String callerId) {
		if(callerId != null) {
			return new Request.Builder(appId, requestId, groupId).withCallerId(callerId).build();
		}

		return new Request.Builder(appId, requestId, groupId).build();
	}

}
