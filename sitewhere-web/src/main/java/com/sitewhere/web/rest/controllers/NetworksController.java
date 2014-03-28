/*
 * NetworksController.java 
 * --------------------------------------------------------------------------------------
 * Copyright (c) Reveal Technologies, LLC. All rights reserved. http://www.reveal-tech.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.web.rest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sitewhere.rest.model.device.network.DeviceNetwork;
import com.sitewhere.rest.model.device.request.DeviceNetworkCreateRequest;
import com.sitewhere.server.SiteWhereServer;
import com.sitewhere.spi.SiteWhereException;
import com.sitewhere.spi.device.network.IDeviceNetwork;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

/**
 * Controller for network operations.
 * 
 * @author Derek Adams
 */
@Controller
@RequestMapping(value = "/networks")
@Api(value = "", description = "Operations related to SiteWhere device networks.")
public class NetworksController extends SiteWhereController {

	/**
	 * Create a device network.
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "Create a new device network")
	public IDeviceNetwork createDeviceNetwork(@RequestBody DeviceNetworkCreateRequest request)
			throws SiteWhereException {
		IDeviceNetwork result =
				SiteWhereServer.getInstance().getDeviceManagement().createDeviceNetwork(request);
		return DeviceNetwork.copy(result);
	}
}