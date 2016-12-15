package onur.testApp.samples.menuitem8;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.Version;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;

import onur.testApp.samples.MenuItemBaseView;

public class MenuItem8View extends MenuItemBaseView{

	private static final long serialVersionUID = 1L;
	public static final String VIEW_NAME = "Menu8";

    public MenuItem8View() {
    	super();
    	
        CssLayout aboutContent = new CssLayout();
        aboutContent.setStyleName("menu-content");
        aboutContent.addComponent(new Label(FontAwesome.INFO_CIRCLE.getHtml()  + VIEW_NAME, ContentMode.HTML));
        aboutContent.addComponent(new Label(" This application is using Vaadin " + Version.getFullVersion()));
        
        getBaseContent().addComponent(aboutContent);
    }

    @Override
    public void enter(ViewChangeEvent event) {
    }

}
