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
package org.eclipse.dltk.sh.ui.editor;

import org.eclipse.core.filebuffers.IDocumentSetupParticipant;
import org.eclipse.dltk.sh.ui.Activator;
import org.eclipse.dltk.sh.ui.text.IShellPartitions;
import org.eclipse.dltk.sh.ui.text.ShellTextTools;
import org.eclipse.jface.text.IDocument;

public class ShellDocumentSetupParticipant implements IDocumentSetupParticipant {

	@Override
	public void setup(IDocument document) {
		ShellTextTools tools = Activator.getDefault().getTextTools();
		tools.setupDocumentPartitioner(document, IShellPartitions.SHELL_PARTITIONING);
	}
}
