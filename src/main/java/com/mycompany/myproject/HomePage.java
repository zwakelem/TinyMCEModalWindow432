package com.mycompany.myproject;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.WebPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HomePage extends WebPage {
	
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(HomePage.class);
	private ModalWindow modalWindow = new ModalWindow("modalWindow");
	private AjaxButton launchButton;
	private Form launchForm;

	public HomePage(final PageParameters parameters) {
		super(parameters);
		setOutputMarkupPlaceholderTag(true);
		
		launchForm = new Form("launchForm");
		launchForm.setOutputMarkupPlaceholderTag(true);
		add(launchForm);
		
		modalWindow.setWidthUnit("px");
		modalWindow.setHeightUnit("px");
		modalWindow.setInitialHeight(350);
		modalWindow.setInitialWidth(750);
		modalWindow.setCssClassName(ModalWindow.CSS_CLASS_GRAY);
		modalWindow.setEnabled(false);
		modalWindow.showUnloadConfirmation(false);
		modalWindow.setOutputMarkupId(true);
		ModalWindow.CloseButtonCallback callback = new ModalWindow.CloseButtonCallback() {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean onCloseButtonClicked(AjaxRequestTarget target) {
				target.add(getPage());
				return true;
			}
		};
		modalWindow.setCloseButtonCallback(callback);
		add(modalWindow);
		
		launchButton = new AjaxButton("startButton",launchForm) {
			
			private static final long serialVersionUID = 1L;
			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
		
				LOG.debug("launch button Clicked*******************");
				modalWindow.setTitle("LAUNCH TINYMCE");
				ModalWindowPanel modalWindowPanel = new ModalWindowPanel(modalWindow.getContentId());
				modalWindow.setContent(modalWindowPanel);
				modalWindow.show(target);
				modalWindow.setEnabled(true);
			}
		};
		launchButton.setVisible(true);
		launchButton.setOutputMarkupId(true);
		launchForm.add(launchButton);

    }
}
