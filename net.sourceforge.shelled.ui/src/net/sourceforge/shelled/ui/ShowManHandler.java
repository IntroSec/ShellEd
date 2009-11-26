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
package net.sourceforge.shelled.ui;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.linuxtools.man.views.ManView;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;

public class ShowManHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		try {
			ISelection selection = HandlerUtil.getActiveEditor(event)
					.getEditorSite().getSelectionProvider().getSelection();
			String manPage = "";
			if ((selection != null) & (selection instanceof TextSelection)) {
				TextSelection textSelection = (TextSelection) selection;
				manPage = textSelection.getText();
			}

			if (!manPage.isEmpty()) {
				ManView view = (ManView) HandlerUtil.getActiveWorkbenchWindow(
						event).getActivePage().showView(
						"org.eclipse.linuxtools.man.views.ManView");
				view.setManPageName(manPage);
			}
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
