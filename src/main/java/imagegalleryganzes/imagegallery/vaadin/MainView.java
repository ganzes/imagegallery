package imagegalleryganzes.imagegallery.vaadin;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {

    private Label mainViewLabel = new Label("Image gallery project");
    private Button addNewImage = new Button("Add new Image");
    private Button gallery = new Button("Gallery");
    private Icon vaadinIcon = new Icon(VaadinIcon.VAADIN_V);


    public MainView() {
        mainViewLabel.setWidthFull();

        vaadinIcon.setColor("blue");
        vaadinIcon.setSize("66px");

        add(vaadinIcon);
        add(mainViewLabel);


        setAlignItems(Alignment.CENTER);

        setSizeFull();
    }
}