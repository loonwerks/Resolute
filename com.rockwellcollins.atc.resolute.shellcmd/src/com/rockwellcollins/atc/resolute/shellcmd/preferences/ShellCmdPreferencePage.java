package com.rockwellcollins.atc.resolute.shellcmd.preferences;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.rockwellcollins.atc.resolute.shellcmd.Activator;

public class ShellCmdPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	private RadioGroupFieldEditor enablePluginEditor = null;

	public ShellCmdPreferencePage() {
		super(GRID);
	}

	@Override
	public void init(IWorkbench workbench) {
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Plugin Security Settings");
	}

	@Override
	protected void createFieldEditors() {
		enablePluginEditor = new RadioGroupFieldEditor(
				ShellCmdPreferenceConstants.ENABLE_PLUGIN, "Enable ShellCmd plugin", 3,
				new String[][] { { "Keep disabled", ShellCmdPreferenceConstants.DISABLED },
						{ "Enable for this session", ShellCmdPreferenceConstants.ENABLED_SESSION },
						{ "Keep enabled", ShellCmdPreferenceConstants.ENABLED_ALWAYS } },
			getFieldEditorParent(), true);
		addField(enablePluginEditor);
	}

}
