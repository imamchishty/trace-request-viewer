package com.shedhack.trace.request.viewer.controller;

import com.shedhack.trace.request.api.model.RequestModel;

/**
 * <pre>
 *     Links multiple {@link RequestModel} objects.
 * </pre>
 *
 * @author imamchishty
 */
public class Node {

    private final RequestModel from;
    private final RequestModel to;

    public Node(RequestModel from, RequestModel to) {
        this.from = from;
        this.to = to;
    }

    public RequestModel getFrom() {
        return from;
    }

    public RequestModel getTo() {
        return to;
    }

    public boolean toHasException() {
        return (to.getExceptionId() != null && to.getExceptionId().length()>0);
    }

    @Override
    public String toString() {
        return "{\"Node\":{"
                + "\"from\":" + from
                + ", \"to\":" + to
                + "}}";
    }
}
