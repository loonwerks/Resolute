package com.rockwellcollins.atc.resolute.shellcmd.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import com.rockwellcollins.atc.resolute.shellcmd.Activator;

public class ShellCmdPreferenceInitializer extends AbstractPreferenceInitializer {

	@Override
	public void initializeDefaultPreferences() {
		final IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		store.setDefault(ShellCmdPreferenceConstants.ENABLE_PLUGIN, ShellCmdPreferenceConstants.DISABLED);
	}

}
