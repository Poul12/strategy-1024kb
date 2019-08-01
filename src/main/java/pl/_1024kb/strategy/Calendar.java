package pl._1024kb.strategy;

import java.time.OffsetDateTime;
import java.util.LinkedList;
import java.util.List;

public class Calendar {
    private String UUID;
    private final String name;
    private final Scope scope;
    private final List<OffsetDateTime> dates;

    public Calendar(String name, Scope scope, List<OffsetDateTime> dates) {
        this.name = name;
        this.scope = scope;
        this.dates = new LinkedList<>(dates);
        UUID = java.util.UUID.randomUUID().toString();
    }

    public String getUUID() {
        return UUID;
    }

    public String getName() {
        return name;
    }

    public Scope getScope() {
        return scope;
    }

    public List<OffsetDateTime> getDates() {
        return new LinkedList<>(dates);
    }

    @Override
    public String toString() {
        return name + '\'' + ", scope=" + scope;
    }
}