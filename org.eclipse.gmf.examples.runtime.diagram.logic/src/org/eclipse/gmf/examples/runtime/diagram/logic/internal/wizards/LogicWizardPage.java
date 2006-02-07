/******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/


package org.eclipse.gmf.examples.runtime.diagram.logic.internal.wizards;

import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.examples.runtime.diagram.logic.internal.l10n.ExampleDiagramLogicMessages;
import org.eclipse.gmf.examples.runtime.diagram.logic.internal.util.LogicDiagramFileCreator;
import org.eclipse.gmf.examples.runtime.diagram.logic.internal.util.LogicEditorUtil;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.wizards.EditorWizardPage;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.util.DiagramFileCreator;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;


/**
 * @author qili
 * @canBeSeenBy org.eclipse.gmf.examples.runtime.diagram.logic.*
 *
 * Create Logic Diagram Wizard Page
 */
public class LogicWizardPage extends EditorWizardPage{

	/**
	 * LogicDiagramWizardPage constructor
	 *
	 * @param aWorkbench
	 *            workbench
	 * @param selection
	 *            selection
	 */
	public LogicWizardPage(IWorkbench aWorkbench,
			IStructuredSelection selection) {
		super("LogicDiagramPage", aWorkbench, selection); //$NON-NLS-1$
		this.setTitle(ExampleDiagramLogicMessages.LogicWizardPage_Title);
		this.setDescription(ExampleDiagramLogicMessages.LogicWizardPage_Description);
	}
	
	public IFile createAndOpenDiagram(
			IPath containerPath,
			String fileName,
			InputStream initialContents,
			String kind,
			IWorkbenchWindow dWindow,
			IProgressMonitor progressMonitor,
			boolean saveDiagram) {
		return LogicEditorUtil.createAndOpenDiagram(
				getDiagramFileCreator(),
				containerPath,
				fileName,
				initialContents,
				kind,
				dWindow,
				progressMonitor,
				isOpenNewlyCreatedDiagramEditor(),
				saveDiagram);
	}
	

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.wizards.EditorWizardPage#getDefaultFileName()
	 */
	protected String getDefaultFileName() {
		return ExampleDiagramLogicMessages.LogicVisualizer_DefaultLogicDiagramFileName;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.wizards.EditorWizardPage#getDiagramFileCreator()
	 */
	public DiagramFileCreator getDiagramFileCreator() {
		return LogicDiagramFileCreator.getInstance();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.wizards.EditorWizardPage#getDiagramKind()
	 */
	protected String getDiagramKind() {
		return "logic"; //$NON-NLS-1$
	}

}
