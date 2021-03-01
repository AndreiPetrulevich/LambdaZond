package ru.geekbrains.lambdazond;

@FunctionalInterface
public interface ReduceValues <R, T> {
    R apply(R result, T next);
}
