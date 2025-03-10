package dev.duyhvt.section_14.LambdaExpressions;

@FunctionalInterface
public interface Operation<T> {
    T operate(T value1, T value2);
}
