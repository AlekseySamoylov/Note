package com.alekseysamoylov.note.repository;

import com.alekseysamoylov.note.entity.price.PriceGroup;

import java.util.List;

/**
 * Created by alekseysamoylov on 10/24/16.
 */
public interface PriceGroupRepository {
    List<PriceGroup> findAllFetchLazy();
}
