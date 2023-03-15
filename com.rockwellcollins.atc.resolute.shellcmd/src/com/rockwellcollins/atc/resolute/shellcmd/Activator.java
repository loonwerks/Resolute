package com.rockwellcollins.atc.resolute.shellcmd;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.rockwellcollins.atc.resolute.shellcmd.preferences.ShellCmdPreferenceConstants;

public class Activator extends AbstractUIPlugin implements BundleActivator {

    private static BundleContext context;
	// The shared instance
	private static Activator plugin;

    static BundleContext getContext() {
        return context;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext
     * )
     */
    @Override
    public void start(BundleContext bundleContext) throws Exception {
        Activator.context = bundleContext;
		plugin = this;

		// Disable this plugin if preference isn't set to ENABLE_ALWAYS
		// Specifically, this will disable the plugin if it was set to ENABLE_SESSION the last time eclipse was open
		if (!getPreferenceStore().getString(ShellCmdPreferenceConstants.ENABLE_PLUGIN)
				.contentEquals(ShellCmdPreferenceConstants.ENABLED_ALWAYS)) {
			getPreferenceStore().setValue(ShellCmdPreferenceConstants.ENABLE_PLUGIN,
					ShellCmdPreferenceConstants.DISABLED);
		}
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        Activator.context = null;
		plugin = null;
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
    }

}
