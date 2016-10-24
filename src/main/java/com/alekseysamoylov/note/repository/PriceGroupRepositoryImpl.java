package com.alekseysamoylov.note.repository;

import com.alekseysamoylov.note.entity.price.PriceGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by alekseysamoylov on 10/24/16.
 */
@Repository
public class PriceGroupRepositoryImpl implements PriceGroupRepository {

    private final HibernateTemplate template;

    @Autowired
    public PriceGroupRepositoryImpl(HibernateTemplate template) {
        this.template = template;
    }


    @Override
    @Transactional(readOnly = true)
    public List<PriceGroup> findAllFetchLazy() {
        return (List<PriceGroup>) template.find("from PriceGroup ");
    }
}
