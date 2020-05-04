package com.rockwellcollins.atc.resolute.analysis.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import com.rockwellcollins.atc.resolute.analysis.Activator;

public class ResolutePreferenceInitializer extends AbstractPreferenceInitializer {

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		store.setDefault(ResolutePreferenceConstants.EXPORT_NODES_PREFERENCE, ResolutePreferenceConstants.UNIQUE_NODES);
		store.setDefault(ResolutePreferenceConstants.UNIQUE_NODES, true);
		store.setDefault(ResolutePreferenceConstants.DUPLICATE_NODES, false);
	}
}
