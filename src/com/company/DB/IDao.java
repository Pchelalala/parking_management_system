package com.company.DB;

import java.util.List;
import java.util.Optional;

public interface IDao<T> {
    Optional<T> get(int id);
    List<T> getAll();
    boolean insert(T t);
    boolean update(T t);
    boolean delete(T t);
    boolean clearData();
}
