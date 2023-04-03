package FixtureGenerator.app;

public class Team implements Comparable<Team> {
    private final String name;

    public Team(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Team t && name == t.name;
    }

    @Override
    public String toString() {
        return String.format(name);
    }

    @Override
    public int compareTo(Team o) {
        return name.compareTo(o.name);
    }
}