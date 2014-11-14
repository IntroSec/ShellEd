/*******************************************************************************
 * Copyright (c) 2010 Mat Booth and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package net.sourceforge.shelled.ui.commands;

import java.util.ArrayList;
import java.util.List;

import net.sourceforge.shelled.core.ShelledNature;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;

/**
 * Implementation of the project handler that removes the ShellEd nature from a
 * project.
 */
public class RemoveNature extends AbstractProjectHandler {

	@Override
	protected void fettleProject(IProject project) {
		try {
			// Get the project description
			IProjectDescription description = project.getDescription();
			String[] natures = description.getNatureIds();

			// Filter the nature out of the list
			List<String> newNatures = new ArrayList<>();
			for (String nature : natures) {
				if (!ShelledNature.SHELLED_NATURE.equals(nature)) {
					newNatures.add(nature);
				}
			}

			// Set the project description
			description.setNatureIds(newNatures.toArray(new String[newNatures
					.size()]));
			project.setDescription(description, null);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}
}
