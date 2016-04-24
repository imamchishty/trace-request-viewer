package com.shedhack.trace.request.viewer.controller;

import com.shedhack.trace.request.jpa.domain.Request;

/**
 * Created by imamchishty on 14/04/2016.
 */
public class Node {

    private final Request from;
    private final Request to;

    public Node(Request from, Request to) {
        this.from = from;
        this.to = to;
    }

    public Request getFrom() {
        return from;
    }

    public Request getTo() {
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
