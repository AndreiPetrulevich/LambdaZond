package ru.geekbrains.lambdazond;

@FunctionalInterface
public interface Predicate<T> {
    boolean apply(T current);
}
