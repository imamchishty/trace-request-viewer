package com.shedhack.trace;

import com.shedhack.trace.request.api.model.DefaultRequestModel;
import com.shedhack.trace.request.api.model.RequestModel;
import com.shedhack.trace.request.viewer.controller.Node;
import com.shedhack.trace.request.viewer.utility.RequestUtility;
import com.shedhack.trace.util.RequestModelTestUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RequestUtilityTest {

	@Test
	public void orderDistricts() {

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

		List<RequestModel> requests = new ArrayList<>();
		requests.add(RequestModelTestUtil.requestBuilder("district3", req3, groupId, req2));
		requests.add(RequestModelTestUtil.requestBuilder("district12", req12, groupId, req11));
		requests.add(RequestModelTestUtil.requestBuilder("district2", req2, groupId, req1));
		requests.add(RequestModelTestUtil.requestBuilder("district4", req4, groupId, req3));
		requests.add(RequestModelTestUtil.requestBuilder("district7", req7, groupId, req6));
		requests.add(RequestModelTestUtil.requestBuilder("district8", req8, groupId, req7));
		requests.add(RequestModelTestUtil.requestBuilder("district5", req5, groupId, req4));
		requests.add(RequestModelTestUtil.requestBuilder("district9", req9, groupId, req8));
		requests.add(RequestModelTestUtil.requestBuilder("district11", req11, groupId, req10));
		requests.add(RequestModelTestUtil.requestBuilder("district13", req13, groupId, req12));
		requests.add(RequestModelTestUtil.requestBuilder("district1", req1, groupId, null));
		requests.add(RequestModelTestUtil.requestBuilder("district10", req10, groupId, req9));
		requests.add(RequestModelTestUtil.requestBuilder("district6", req6, groupId, req5));

		List<Node> nodes = RequestUtility.order(requests);

		assertNotNull(nodes);
		assertEquals(12, nodes.size());

		// check the order.
		assertEquals("district1", nodes.get(0).getFrom().getApplicationId());
		assertEquals("district2", nodes.get(0).getTo().getApplicationId());

		assertEquals("district2", nodes.get(1).getFrom().getApplicationId());
		assertEquals("district3", nodes.get(1).getTo().getApplicationId());

		assertEquals("district3", nodes.get(2).getFrom().getApplicationId());
		assertEquals("district4", nodes.get(2).getTo().getApplicationId());

		assertEquals("district4", nodes.get(3).getFrom().getApplicationId());
		assertEquals("district5", nodes.get(3).getTo().getApplicationId());

		assertEquals("district5", nodes.get(4).getFrom().getApplicationId());
		assertEquals("district6", nodes.get(4).getTo().getApplicationId());

		assertEquals("district6", nodes.get(5).getFrom().getApplicationId());
		assertEquals("district7", nodes.get(5).getTo().getApplicationId());

		assertEquals("district7", nodes.get(6).getFrom().getApplicationId());
		assertEquals("district8", nodes.get(6).getTo().getApplicationId());

		assertEquals("district8", nodes.get(7).getFrom().getApplicationId());
		assertEquals("district9", nodes.get(7).getTo().getApplicationId());

		assertEquals("district9", nodes.get(8).getFrom().getApplicationId());
		assertEquals("district10", nodes.get(8).getTo().getApplicationId());

		assertEquals("district10", nodes.get(9).getFrom().getApplicationId());
		assertEquals("district11", nodes.get(9).getTo().getApplicationId());

		assertEquals("district11", nodes.get(10).getFrom().getApplicationId());
		assertEquals("district12", nodes.get(10).getTo().getApplicationId());

		assertEquals("district12", nodes.get(11).getFrom().getApplicationId());
		assertEquals("district13", nodes.get(11).getTo().getApplicationId());
	}



}
