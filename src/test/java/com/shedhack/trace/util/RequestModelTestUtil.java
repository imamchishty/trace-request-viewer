package com.shedhack.trace.util;

import com.shedhack.trace.request.api.model.DefaultRequestModel;
import com.shedhack.trace.request.api.model.RequestModel;

/**
 * @author imamchishty
 */
public class RequestModelTestUtil {

    public static RequestModel requestBuilder(String appId, String requestId , String groupId, String callerId) {

        if(callerId != null) {
            return new DefaultRequestModel.Builder(appId, requestId, groupId).withCallerId(callerId).build();
        }

        return new DefaultRequestModel.Builder(appId, requestId, groupId).build();
    }

}
