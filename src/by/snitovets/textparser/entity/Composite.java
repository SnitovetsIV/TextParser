package by.snitovets.textparser.entity;

import org.apache.log4j.Logger;

import java.util.ArrayList;

/**
 * Created by Илья on 25.06.2014.
 */
public class Composite implements Component {

    private static final Logger LOG = Logger.getLogger(Composite.class);

    private ArrayList<Component> components = new ArrayList<>();

    public void add(Component c) {
        if (c != null) {
            components.add(c);
        } else {
            LOG.warn("Component can not be null. Component didn't add.");
        }
    }

    public void remove(Component c) {
        if (c != null) {
            if (components.remove(c)) {
                LOG.info("Component " + c.toString() + " removed");
            } else {
                LOG.info("Component " + c.toString() + " didn't remove");
            }
        } else {
            LOG.warn("Component can not be null. Component didn't remove.");
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        components.forEach((Component value) -> result.append(value.toString()));
        return result.toString();
    }

}
