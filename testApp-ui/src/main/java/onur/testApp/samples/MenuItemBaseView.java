package onur.testApp.samples;

import com.vaadin.navigator.View;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
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
        //
        Image imageUser = new Image(null, new ThemeResource("img/user.png"));
        imageUser.addClickListener(e -> new Notification("Notificaiton example...").show("Test", Notification.TYPE_HUMANIZED_MESSAGE));
        iconLayout.addComponent(imageUser);
        
        BaseContent.addComponent(headerLayout);
        addComponent(BaseContent);
        setStyleName("about-view");
        setComponentAlignment(BaseContent, Alignment.TOP_LEFT);
    }

	public VerticalLayout getBaseContent() {
		return BaseContent;
	}

}
