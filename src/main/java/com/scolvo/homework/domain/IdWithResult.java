package com.scolvo.homework.domain;

import java.util.Objects;

/**
 * Pojo for internal data processing.
 */
public class IdWithResult {

    private final int id;
    private final String result;

    public IdWithResult(int id, String result) {
        this.id = id;
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public String getResult() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdWithResult that = (IdWithResult) o;
        return id == that.id &&
                Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, result);
    }

    @Override
    public String toString() {
        return "IdWithResult{" +
                "id=" + id +
                ", result='" + result + '\'' +
                '}';
    }
}
