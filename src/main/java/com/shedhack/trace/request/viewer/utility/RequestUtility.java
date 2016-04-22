package com.shedhack.trace.request.viewer.utility;

import com.shedhack.trace.request.jpa.domain.Request;
import com.shedhack.trace.request.viewer.controller.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>Request Utils</pre>
 */
public class RequestUtility {

    /**
     * Inefficient but first cut for demo
     */
    public static List<Node> order(List<Request> requests) {

        Map<String, Node> nodesMap = new HashMap<>();
        Map<String, Request> map = new HashMap<>(requests.size());

        for(Request request : requests) {
            map.put(request.getRequestId(), request);
        }

        String startRequestId = null;

        for (Request request : requests) {
            if(request.getCallerId() != null) {
                nodesMap.put(request.getCallerId(), new Node(map.get(request.getCallerId()), request));
            }
            else {
                startRequestId = request.getRequestId();
            }
        }

        List<Node> orderedNodes = new ArrayList<>();
        orderedNodes.add(nodesMap.get(startRequestId));
        String pointer = nodesMap.get(startRequestId).getTo().getRequestId();

        for(int i=0; i<requests.size(); i++) {
            Node n = nodesMap.get(pointer);

            if(n !=null) {
                orderedNodes.add(n);
                pointer = nodesMap.get(pointer).getTo().getRequestId();
            }

        }

        return orderedNodes;
    }

}
