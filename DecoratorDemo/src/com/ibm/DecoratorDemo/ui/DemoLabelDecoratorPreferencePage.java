package com.ibm.DecoratorDemo.ui;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.ibm.DecoratorDemo.core.DemoStore;
import com.ibm.DecoratorDemo.ui.Decorators.DemoLightWeightDecorator;

/**
 * @author balajik
 *
 */
public class DemoLabelDecoratorPreferencePage
	extends PreferencePage
	implements IWorkbenchPreferencePage
{
  private Button displayTextLabelInformation_;
  private Button displayProjectInformation_;
  
  private boolean fileLabelsToDisplay_;
  private boolean projectToDisplay_;

	/**
	 * Constructor for DemoLabelDecoratorPreferencePage.
	 */
	public DemoLabelDecoratorPreferencePage()
	{
		super();
	}

	/**
	 * Constructor for DemoLabelDecoratorPreferencePage.
	 * @param arg0
	 */
	public DemoLabelDecoratorPreferencePage(String arg0)
	{
		super(arg0);
	}

	/**
	 * Constructor for DemoLabelDecoratorPreferencePage.
	 * @param arg0
	 * @param arg1
	 */
	public DemoLabelDecoratorPreferencePage(String arg0, ImageDescriptor arg1)
	{
		super(arg0, arg1);
	}


	/**
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(IWorkbench)
	 */
	public void init(IWorkbench arg0)
	{
	}
  
  /**
   * @see org.eclipse.jface.preference.PreferencePage#createContents(Composite)
   */
  protected Control createContents (Composite parent)
  {
    Composite main = GuiFactory.getInstance().createComposite(parent, 1);
    
    Label informationLabel = new Label (main, SWT.NONE);
    informationLabel.setText ("You can control the decorations that should be applied"); 
    Label informationLabel2 = new Label (main, SWT.NONE);
    informationLabel2.setText ("to your project by setting correct preferences");
    
    Label spacer = new Label(main, SWT.NONE);
    spacer.setText("");
    
    createDisplayProjectName(main);
    createDisplayOwnerName (main);

    return main;
  }

  /**
   * Create Checkbox for displaying owner name
   */ 
  private void createDisplayOwnerName (Composite main)
  {
    displayTextLabelInformation_ = new Button(main, SWT.CHECK);
    displayTextLabelInformation_.setText ("Show File Label Prefix/Suffix ");
    displayTextLabelInformation_.setSelection (
      DemoStore.getInstance().shouldDisplayTextLabel());
  }
  
  /**
   * Create the Display Project Name 
   * 
   * @param main Composite on which the control needs to be placed
   */ 
  private void createDisplayProjectName (Composite main)
  {
    
    displayProjectInformation_ = new Button(main, SWT.CHECK);
    displayProjectInformation_.setText ("Show Decorators with Project Name");
    displayProjectInformation_.setSelection (
      DemoStore.getInstance().shouldDisplayProject());
  }

  /**
   * Method executed when user clicks on ok button
   */   
  public boolean performOk()
  {
    fileLabelsToDisplay_ = displayTextLabelInformation_.getSelection();
    projectToDisplay_ = displayProjectInformation_.getSelection();
    
    DemoStore.getInstance().setDisplayTextLabel(
      displayTextLabelInformation_.getSelection());
    DemoStore.getInstance().setDisplayProject 
      (displayProjectInformation_.getSelection());
    DemoLightWeightDecorator demoDecorator = DemoLightWeightDecorator.getDemoDecorator();
    if(demoDecorator != null)
    {
      demoDecorator.refreshAll(fileLabelsToDisplay_, projectToDisplay_);
    }
    return true;
 }
  
  /**
   * Method invoked when the user clicks on Apply
   */ 
  protected void performApply ()
  {
    MessageDialog.openInformation (getShell(), "Decorations", 
      "Press OK in the Individiual Decorator preference page to apply preferences on decoration");
  }
}
