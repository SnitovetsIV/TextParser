package by.snitovets.textparser.entity;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Илья on 25.06.2014.
 */
public class Composite implements Component {

    private static final Logger LOG = Logger.getLogger(Composite.class);
    private ArrayList<Component> components = new ArrayList<>();

    public Composite() {
    }

    public void add(Component component) {
        if (component != null) {
            components.add(component);
        } else {
            LOG.warn("Component can not be null. Component didn't add.");
        }
    }

    public void remove(Component component) {
        if (component != null) {
            if (components.remove(component)) {
                LOG.info("Component " + component + " removed");
            } else {
                LOG.info("Component " + component + " didn't remove");
            }
        } else {
            LOG.warn("Component can not be null. Component didn't remove.");
        }
    }

    public boolean addAll(Collection<? extends Component> components) {
        return this.components.addAll(components);
    }

    public Iterator<Component> iterator() {
        return components.iterator();
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        components.forEach((Component value) -> result.append(value.toString()));
        return result.toString();
    }

}
