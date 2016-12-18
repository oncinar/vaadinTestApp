package onur.testApp.samples;

import com.vaadin.navigator.View;
import com.vaadin.server.Page;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

public abstract class MenuItemBaseView extends VerticalLayout implements View {
	
	private static final long serialVersionUID = 1L;
	private VerticalLayout BaseContent;

    public MenuItemBaseView() {
    	
        BaseContent = new VerticalLayout();

        HorizontalLayout headerLayout = new HorizontalLayout();
        headerLayout.setStyleName("header-layout");
        HorizontalLayout textLayout = new HorizontalLayout();
        textLayout.setStyleName("text-layout");
        textLayout.addComponent(new Label("Warehouse"));
        textLayout.addComponent(new Label(" | "));
        textLayout.addComponent(new Label("Orders"));
        textLayout.addComponent(new Label(" | "));
        textLayout.addComponent(new Label("Shipping"));
        headerLayout.addComponent(textLayout);
        //
        HorizontalLayout iconLayout = new HorizontalLayout();
        iconLayout.setStyleName("icon-layout");
        iconLayout.setSpacing(true);
        headerLayout.addComponent(iconLayout);
        //
        Image imagePrint = new Image(null, new ThemeResource("img/print.ico"));
        imagePrint.addClickListener(e -> new Notification("Notificaiton example...").show("Test", Notification.TYPE_HUMANIZED_MESSAGE));
        iconLayout.addComponent(imagePrint);
        //
        Image imageMessage = new Image(null, new ThemeResource("img/message.png"));
        imageMessage.addClickListener(e -> new Notification("Notificaiton example...").show("Test", Notification.TYPE_HUMANIZED_MESSAGE));
        iconLayout.addComponent(imageMessage);

        // logout menu item
        MenuBar logoutMenu = new MenuBar();
        logoutMenu.setStyleName("logout-menu");
        logoutMenu.setWidth("0px");
        logoutMenu.setHeight("0px");
        //
        MenuItem logout = logoutMenu.addItem("", null, null);
        logout.setIcon(new ThemeResource("img/user.png"));
        logout.setStyleName("logout-item");
        logout.addItem("Logout", new Command() {
            @Override
            public void menuSelected(MenuItem selectedItem) {
                VaadinSession.getCurrent().getSession().invalidate();
                Page.getCurrent().reload();
            }
        });
        iconLayout.addComponent(logoutMenu);
        
        BaseContent.addComponent(headerLayout);
        addComponent(BaseContent);
        setStyleName("about-view");
        setComponentAlignment(BaseContent, Alignment.TOP_LEFT);
    }

	public VerticalLayout getBaseContent() {
		return BaseContent;
	}

}
