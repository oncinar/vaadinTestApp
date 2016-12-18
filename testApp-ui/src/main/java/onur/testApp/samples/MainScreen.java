package onur.testApp.samples;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

import onur.testApp.MyUI;
import onur.testApp.samples.menuitemAccouningIntegration.MenuItemAccouningIntegrationView;
import onur.testApp.samples.menuitemBusinessPartners.MenuItemBusinessPartnersView;
import onur.testApp.samples.menuitemChannels.MenuItemChannelsView;
import onur.testApp.samples.menuitemDashboard.MenuItemDashboardView;
import onur.testApp.samples.menuitemOrders.MenuItemOrdersView;
import onur.testApp.samples.menuitemReports.MenuItemReportsView;
import onur.testApp.samples.menuitemSettings.MenuItemSettingsView;
import onur.testApp.samples.menuitemTransportation.MenuItemTransportationView;
import onur.testApp.samples.menuitemWarehouse.MenuItemWarehouseView;

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
        menu.addView(new MenuItemOrdersView(), MenuItemOrdersView.VIEW_NAME, MenuItemOrdersView.VIEW_NAME, new ThemeResource("img/icon_box.png"));
        menu.addView(new MenuItemWarehouseView(), MenuItemWarehouseView.VIEW_NAME, MenuItemWarehouseView.VIEW_NAME, new ThemeResource("img/icon_boxes.png"));
        menu.addView(new MenuItemDashboardView(), MenuItemDashboardView.VIEW_NAME, MenuItemDashboardView.VIEW_NAME, new ThemeResource("img/icon_gauge.png"));
        menu.addView(new MenuItemBusinessPartnersView(), MenuItemBusinessPartnersView.VIEW_NAME, MenuItemBusinessPartnersView.VIEW_NAME, new ThemeResource("img/icon_users.png"));
        menu.addView(new MenuItemReportsView(), MenuItemReportsView.VIEW_NAME, MenuItemReportsView.VIEW_NAME, new ThemeResource("img/icon_barchart.png"));
        menu.addView(new MenuItemAccouningIntegrationView(), MenuItemAccouningIntegrationView.VIEW_NAME, MenuItemAccouningIntegrationView.VIEW_NAME, new ThemeResource("img/icon_temple.png"));
        menu.addView(new MenuItemSettingsView(), MenuItemSettingsView.VIEW_NAME, MenuItemSettingsView.VIEW_NAME, new ThemeResource("img/icon_setting.png"));
        menu.addView(new MenuItemTransportationView(), MenuItemTransportationView.VIEW_NAME, MenuItemTransportationView.VIEW_NAME, new ThemeResource("img/icon_arrow.png"));
        menu.addView(new MenuItemChannelsView(), MenuItemChannelsView.VIEW_NAME, MenuItemChannelsView.VIEW_NAME, new ThemeResource("img/icon_settings.png"));

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
