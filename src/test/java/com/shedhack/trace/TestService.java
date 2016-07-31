package com.shedhack.trace;

import com.shedhack.trace.request.api.model.RequestModel;
import com.shedhack.trace.request.api.service.TraceRequestService;
import com.shedhack.trace.util.RequestModelTestUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * <pre>
 *     Test implementation for the API Service
 * </pre>
 *
 * @author imamchishty
 */
public class TestService implements TraceRequestService {

    public RequestModel persist(RequestModel model) {
        return null;
    }

    public RequestModel findByRequestId(String requestId) {
        return null;
    }

    public List<? extends RequestModel> findByApplicationId(String applicationId) {
        return null;
    }

    public List<? extends RequestModel> findByGroupId(String groupId) {

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


        return requests;
    }

    public List<? extends RequestModel> findByCallerId(String callerId) {
        return null;
    }

    public List<? extends RequestModel> findByPath(String path) {
        return null;
    }

    public List<? extends RequestModel> findBySessionId(String sessionId) {
        return null;
    }

    public List<? extends RequestModel> findByHttpMethod(String httpMethod) {
        return null;
    }

    public List<? extends RequestModel> findByClientAddress(String clientAddress) {
        return null;
    }

    public List<? extends RequestModel> findByHostAddress(String hostAddress) {
        return null;
    }

    public List<? extends RequestModel> findByHeaders(String headers) {
        return null;
    }

    public List<? extends RequestModel> findByExceptionId(String exceptionId) {
        return null;
    }

    public List<? extends RequestModel> findByStatus(String status) {
        return null;
    }
}
