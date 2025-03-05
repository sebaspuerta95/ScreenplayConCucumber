package screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import screenplay.userinterface.ProductPage;

import java.util.List;

public class ImagesNotLoadedQuestion implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        List<String> imageSources = ProductPage.PRODUCT_IMAGES.resolveAllFor(actor)
                .stream()
                .map(element -> element.getAttribute("src"))
                .toList();

        System.out.println("Lista de src de imágenes: " + imageSources);

        return imageSources.stream().allMatch(src -> src == null || src.isEmpty() || src.contains("Garbage"));
    }

    public static ImagesNotLoadedQuestion areBroken() {
        return new ImagesNotLoadedQuestion();
    }
}
