package com.shedhack.trace.request.viewer.controller;

import com.shedhack.trace.request.api.model.RequestModel;
import com.shedhack.trace.request.api.service.TraceRequestService;
import com.shedhack.trace.request.viewer.utility.RequestUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author imamchishty
 */
@Controller
@RequestMapping("/admin/trace-viewer")
public class TraceRequestViewerController {

    @Autowired
    private TraceRequestService service;

    private static final String TRACE_REQUESTS_HTML = "tracerequests";

    @RequestMapping(value = "/group/{id}", method = RequestMethod.GET)
    public String searchByGroupId(String id, Model model) {

        //#ff5050 - exception
        List<RequestModel> requests  = (List<RequestModel>) service.findByGroupId(id);

        addAttributes(model, requests, RequestUtility.order(requests));

        return TRACE_REQUESTS_HTML;
    }


    private void addAttributes(Model model, List<RequestModel> requests, List<Node> nodes) {
        model.addAttribute("nodes", RequestUtility.order(requests));
        model.addAttribute("appId", "district1");
        model.addAttribute("requests", requests);
    }
}
