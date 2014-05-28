/*
 * IDeviceCommandEncoder.java 
 * --------------------------------------------------------------------------------------
 * Copyright (c) Reveal Technologies, LLC. All rights reserved. http://www.reveal-tech.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.device.provisioning;

import com.sitewhere.spi.ISiteWhereLifecycle;
import com.sitewhere.spi.SiteWhereException;
import com.sitewhere.spi.device.IDeviceAssignment;
import com.sitewhere.spi.device.IDeviceNestingContext;
import com.sitewhere.spi.device.command.IDeviceCommandExecution;

/**
 * Encodes an {@link IDeviceCommandExecution} into a format that can be transmitted.
 * 
 * @author Derek
 */
public interface ICommandExecutionEncoder extends ISiteWhereLifecycle {

	/**
	 * Encodes a command execution as a byte array.
	 * 
	 * @param command
	 * @param nested
	 * @param assignment
	 * @return
	 * @throws SiteWhereException
	 */
	public byte[] encode(IDeviceCommandExecution command, IDeviceNestingContext nested,
			IDeviceAssignment assignment) throws SiteWhereException;

	/**
	 * Encodes a SiteWhere system command as a byte array.
	 * 
	 * @param command
	 * @param nested
	 * @param assignment
	 * @return
	 * @throws SiteWhereException
	 */
	public byte[] encodeSystemCommand(Object command, IDeviceNestingContext nested,
			IDeviceAssignment assignment) throws SiteWhereException;
}