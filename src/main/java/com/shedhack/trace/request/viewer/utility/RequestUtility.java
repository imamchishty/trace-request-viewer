package com.shedhack.trace.request.viewer.utility;

import com.shedhack.trace.request.viewer.controller.Node;
import com.shedhack.trace.request.api.model.RequestModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <pre>
 *     RequestModel Utils: orders list of requests.
 * </pre>
 *
 * @author imamchishty
 */
public class RequestUtility {

    /**
     * Inefficient but first cut for demo
     */
    public static List<Node> order(List<RequestModel> requests) {

        Map<String, Node> nodesMap = new HashMap<>();
        Map<String, RequestModel> map = new HashMap<>(requests.size());

        for(RequestModel request : requests) {
            map.put(request.getRequestId(), request);
        }

        String startRequestModelId = null;

        // Find the first request, this is the one where no callerId was set.
        for (RequestModel request : requests) {

            // Not the first so put straight into the node map of requests (not sorted).
            if(request.getCallerId() != null) {
                nodesMap.put(request.getCallerId(), new Node(map.get(request.getCallerId()), request));
            }
            else {
                startRequestModelId = request.getRequestId();
            }
        }

        List<Node> orderedNodes = new ArrayList<>();
        orderedNodes.add(nodesMap.get(startRequestModelId));
        String pointer = nodesMap.get(startRequestModelId).getTo().getRequestId();

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
