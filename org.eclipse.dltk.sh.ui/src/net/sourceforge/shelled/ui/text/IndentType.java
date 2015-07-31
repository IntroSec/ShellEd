/*******************************************************************************
 * Copyright (c) 2009 Red Hat Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Alexander Kurtakov - initial API and implementation
 *******************************************************************************/
package net.sourceforge.shelled.ui.text;

/**
 * A type of indent.
 */
public class IndentType {
	/** A single indent decrement */
	public static final IndentType DECREMENT = new IndentType();
	/** A single indent increment */
	public static final IndentType INCREMENT = new IndentType();
	/** An inflexion - both an increment and a decrement */
	public static final IndentType INFLEXION = new IndentType();

	private IndentType() {
	}
}
