package imagegalleryganzes.imagegallery.vaadin;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {

    private Button addNewBook = new Button("Add new image");
}
