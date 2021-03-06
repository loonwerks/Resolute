package com.rockwellcollins.atc.resolute.analysis.preferences;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.rockwellcollins.atc.resolute.analysis.Activator;



public class ResoluteExportPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	private RadioGroupFieldEditor resoluteCheckNamePreferenceFieldEditor = null;

	public ResoluteExportPreferencePage() {
		super(GRID);
	}

	@Override
	protected void createFieldEditors() {
		resoluteCheckNamePreferenceFieldEditor = new RadioGroupFieldEditor(
				ResolutePreferenceConstants.EXPORT_NODES_PREFERENCE, "Export Format", 2,
				new String[][] { { "Assurance Argument", ResolutePreferenceConstants.UNIQUE_NODES },
						{ "Assurance Pattern", ResolutePreferenceConstants.DUPLICATE_NODES } },
			getFieldEditorParent(), true);
		addField(resoluteCheckNamePreferenceFieldEditor);

	}

	@Override
	public void init(IWorkbench workbench) {
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Resolute Export Settings");
	}

}
