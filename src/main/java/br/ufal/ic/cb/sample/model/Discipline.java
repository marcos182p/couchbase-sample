package br.ufal.ic.cb.sample.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Marcos
 */
public class Discipline {

    private final String name;
    private final int credits;
    
    private Set<Discipline> prerequisite;

    public Discipline(String name, int credits) {
        this.name = name;
        this.credits = credits;
        this.prerequisite = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public Set<Discipline> getPrerequisite() {
        return Collections.unmodifiableSet(prerequisite);
    }

    @Override
    public String toString() {
        return "Discipline{" + "name=" + name + ", credits=" + credits 
                + ", prerequisite=" + prerequisite + '}';
    }
    
    
}
