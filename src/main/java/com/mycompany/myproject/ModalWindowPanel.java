package com.mycompany.myproject;

import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

import wicket.contrib.tinymce.TinyMceBehavior;
import wicket.contrib.tinymce.settings.TinyMCESettings;

public class ModalWindowPanel extends Panel {
	private static final long serialVersionUID = 1L;
	protected TextArea<String> tinyTA;

	public ModalWindowPanel(String id) {
		super(id);
		
		tinyTA = new TextArea<String>("tinyTA", new Model<String>());
		tinyTA.setOutputMarkupPlaceholderTag(true);
		add(tinyTA);
		tinyTA.add(new TinyMceBehavior(new TextAreaTinyMceSettings(false, tinyTA)));
	}
}
