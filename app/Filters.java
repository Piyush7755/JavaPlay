import play.filters.cors.CORSFilter;
import play.http.HttpFilters;
import play.mvc.EssentialFilter;
import javax.inject.Inject;
import java.util.Collections;
import java.util.List;

public class Filters implements HttpFilters {

    private EssentialFilter[] filters;

    @Inject
    public Filters(CORSFilter corsFilter) {
        filters = new EssentialFilter[]{corsFilter.asJava()};
    }

    public EssentialFilter[] filters() {
        return filters;
    }

    @Override
    public List<EssentialFilter> getFilters() {
        return Collections.emptyList();
    }
}