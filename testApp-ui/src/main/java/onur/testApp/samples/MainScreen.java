package onur.testApp.samples;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

import onur.testApp.MyUI;
import onur.testApp.samples.menuitem1.MenuItem1View;
import onur.testApp.samples.menuitem2.MenuItem2View;
import onur.testApp.samples.menuitem3.MenuItem3View;
import onur.testApp.samples.menuitem4.MenuItem4View;
import onur.testApp.samples.menuitem5.MenuItem5View;
import onur.testApp.samples.menuitem6.MenuItem6View;
import onur.testApp.samples.menuitem7.MenuItem7View;
import onur.testApp.samples.menuitem8.MenuItem8View;
import onur.testApp.samples.menuitem9.MenuItem9View;

/**
 * Content of the UI when the user is logged in.
 * 
 * 
 */
public class MainScreen extends HorizontalLayout {
    private Menu menu;

    public MainScreen(MyUI ui) {

        setStyleName("main-screen");

        VerticalLayout viewContainer = new VerticalLayout();
        viewContainer.addStyleName("valo-content");
        viewContainer.setSizeFull();

        final Navigator navigator = new Navigator(ui, viewContainer);
        navigator.setErrorView(ErrorView.class);
        menu = new Menu(navigator);
        menu.setStyleName("menu-left");
        menu.addView(new MenuItem1View(), MenuItem1View.VIEW_NAME, "", new ThemeResource("img/icon_box.png"));
        menu.addView(new MenuItem2View(), MenuItem2View.VIEW_NAME, "", new ThemeResource("img/icon_boxes.png"));
        menu.addView(new MenuItem3View(), MenuItem3View.VIEW_NAME, "", new ThemeResource("img/icon_gauge.png"));
        menu.addView(new MenuItem4View(), MenuItem4View.VIEW_NAME, "", new ThemeResource("img/icon_users.png"));
        menu.addView(new MenuItem5View(), MenuItem5View.VIEW_NAME, "", new ThemeResource("img/icon_barchart.png"));
        menu.addView(new MenuItem6View(), MenuItem6View.VIEW_NAME, "", new ThemeResource("img/icon_temple.png"));
        menu.addView(new MenuItem7View(), MenuItem7View.VIEW_NAME, "", new ThemeResource("img/icon_setting.png"));
        menu.addView(new MenuItem8View(), MenuItem8View.VIEW_NAME, "", new ThemeResource("img/icon_arrow.png"));
        menu.addView(new MenuItem9View(), MenuItem9View.VIEW_NAME, "", new ThemeResource("img/icon_settings.png"));

        navigator.addViewChangeListener(viewChangeListener);

        addComponent(menu);
        addComponent(viewContainer);
        setExpandRatio(viewContainer, 1);
        setSizeFull();
    }

    // notify the view menu about view changes so that it can display which view
    // is currently active
    ViewChangeListener viewChangeListener = new ViewChangeListener() {

        @Override
        public boolean beforeViewChange(ViewChangeEvent event) {
            return true;
        }

        @Override
        public void afterViewChange(ViewChangeEvent event) {
            menu.setActiveView(event.getViewName());
        }

    };
}
