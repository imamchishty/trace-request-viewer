package com.shedhack.trace.request.viewer.controller;

import com.shedhack.trace.request.api.model.RequestModel;
import com.shedhack.trace.request.api.service.TraceRequestService;
import com.shedhack.trace.request.jpa.domain.Request;
import com.shedhack.trace.request.viewer.utility.RequestUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;

/**
 * @author imamchishty
 */
@Controller
public class TraceRequestController {

    @Autowired
    private TraceRequestService service;

    @RequestMapping(value = "/api/view/group/{id}", method = RequestMethod.GET)
    public String groupSearch(@PathVariable("id") String groupId, Model model) {

        //#ff5050 - exception


        List<Request> requests  = (List<Request>) service.findByGroupId(groupId);
        model.addAttribute("nodes", RequestUtility.order(requests));
        model.addAttribute("appId", "district1");
        model.addAttribute("requests", requests);

        return "requests";
    }

}
