package com.mycompany.myproject;

import org.apache.wicket.markup.html.form.TextArea;

import wicket.contrib.tinymce.settings.Button;
import wicket.contrib.tinymce.settings.IESpellPlugin;
import wicket.contrib.tinymce.settings.StylePlugin;
import wicket.contrib.tinymce.settings.TablePlugin;
import wicket.contrib.tinymce.settings.TinyMCESettings;
import wicket.contrib.tinymce.settings.WordcountPlugin;

public class TextAreaTinyMceSettings extends TinyMCESettings {
	private static final long serialVersionUID = 1L;

	public TextAreaTinyMceSettings(boolean isReadOnly) {

		super(TinyMCESettings.Theme.advanced);

		/*
		 * This option enables you to make sure that any non block elements or text nodes are wrapped in block elements. 
		 * For example <strong>something</strong> will result in output like: <p><strong>something</strong></p>. 
		 * This option is enabled by default as of 3.0a1.If you set this option to false it will never produce P tags on enter or 
		 * automatically it will instead produce BR elements and Shift+Enter will produce a P.
		 * Note that not using P elements as root block can severly cripple the functionality of the editor.
		 */
		addCustomSetting("forced_root_block : false");
		if(isReadOnly)
		{
			addCustomSetting("readonly : true");
		}
		add(Button.newdocument, TinyMCESettings.Toolbar.first,
				TinyMCESettings.Position.before);
		add(Button .fontselect, TinyMCESettings.Toolbar.first,
				TinyMCESettings.Position.after);
		add(Button.fontsizeselect, TinyMCESettings.Toolbar.first,
				TinyMCESettings.Position.after);
		add(new IESpellPlugin().getIespellButton(), TinyMCESettings.Toolbar.first,
				TinyMCESettings.Position.after);
		add(Button.forecolor, TinyMCESettings.Toolbar.second,
				TinyMCESettings.Position.after);
		add(Button.backcolor, TinyMCESettings.Toolbar.second,
				TinyMCESettings.Position.after);
		add(Button.image, TinyMCESettings.Toolbar.second,
				TinyMCESettings.Position.after);
		add(Button.cut, TinyMCESettings.Toolbar.second,
				TinyMCESettings.Position.after);
		add(Button.copy, TinyMCESettings.Toolbar.second,
				TinyMCESettings.Position.after);
		add(new TablePlugin().getTableControls(), TinyMCESettings.Toolbar.third,
				TinyMCESettings.Position.after);
		add(new StylePlugin().getStyleButton(), TinyMCESettings.Toolbar.third,
				TinyMCESettings.Position.after);
		register(new WordcountPlugin());


		//other settings
		setToolbarAlign(
				TinyMCESettings.Align.left);
		setToolbarLocation(
				TinyMCESettings.Location.top);
		setStatusbarLocation(
				TinyMCESettings.Location.bottom);
		setResizing(true);
	}
	/**
	 * Creates the behavior and sent focus to Text Area
	 * @param isReadOnly
	 * @param replyMessageTA
	 */
	public TextAreaTinyMceSettings(boolean isReadOnly, TextArea<String> replyMessageTA) {

		this(isReadOnly);
		replyMessageTA.setOutputMarkupId(true);
		addCustomSetting("auto_focus : \"" + replyMessageTA.getMarkupId()+"\"");
	}


}
