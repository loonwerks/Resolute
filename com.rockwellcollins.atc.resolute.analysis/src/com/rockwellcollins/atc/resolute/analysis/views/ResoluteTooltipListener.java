package com.rockwellcollins.atc.resolute.analysis.views;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import com.rockwellcollins.atc.resolute.analysis.results.ClaimResult;

public class ResoluteTooltipListener implements Listener {
    private String tooltip = "";
    private TreeViewer treeViewer;

    public static void createAndRegister(TreeViewer treeViewer) {
        ResoluteTooltipListener instance = new ResoluteTooltipListener(treeViewer);
        treeViewer.getControl().addListener(SWT.MouseHover, instance);
        treeViewer.getControl().addListener(SWT.MouseMove, instance);
    }

    private ResoluteTooltipListener(TreeViewer treeViewer) {
        this.treeViewer = treeViewer;
    }

    @Override
    public void handleEvent(Event event) {
        switch (event.type) {
        case SWT.MouseMove:
            ViewerCell cell = treeViewer.getCell(new Point(event.x, event.y));
            if (cell != null && cell.getElement() instanceof ClaimResult) {
                ClaimResult claim = (ClaimResult) cell.getElement();
                tooltip = claim.getText();
            }
            break;

        case SWT.MouseHover:
            treeViewer.getControl().setToolTipText(tooltip);
            break;
        }
    }
}
