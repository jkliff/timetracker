package de.jkliff.timetracker.util;

public class Pair<P, Q> {
    private P first;
    private Q second;

    private Pair(P p, Q q) {
        first = p;
        second = q;
    }

    public static <P, Q> Pair<P, Q> of(P p,
                                       Q q) {
        return new Pair<P, Q>(p, q);
    }

    public P first() {
        return first;

    }

    public Q second() {
        return second;
    }
}
