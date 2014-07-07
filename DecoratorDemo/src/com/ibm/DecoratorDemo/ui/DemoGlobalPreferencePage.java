package com.ibm.DecoratorDemo.ui;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * @author balajik
 *
 */
public class DemoGlobalPreferencePage
	extends PreferencePage
	implements IWorkbenchPreferencePage
{

	/**
	 * Constructor for DemoGlobalPreferencePage.
	 */
	public DemoGlobalPreferencePage()
	{
		super();
	}

	/**
	 * Constructor for DemoGlobalPreferencePage.
	 * @param arg0
	 */
	public DemoGlobalPreferencePage(String arg0)
	{
		super(arg0);
	}

	/**
	 * Constructor for DemoGlobalPreferencePage.
	 * @param arg0
	 * @param arg1
	 */
	public DemoGlobalPreferencePage(String arg0, ImageDescriptor arg1)
	{
		super(arg0, arg1);
	}

	/**
	 * @see org.eclipse.jface.preference.PreferencePage#createContents(Composite)
	 */
	protected Control createContents(Composite arg0)
	{
    Composite main = GuiFactory.getInstance().createComposite (arg0, 1);
	  Label informationLabel = new Label (main, 1);
    informationLabel.setText ("This is a sample global preference page");
    return main;
  }

	/**
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(IWorkbench)
	 */
	public void init(IWorkbench arg0)
	{
	}

}
