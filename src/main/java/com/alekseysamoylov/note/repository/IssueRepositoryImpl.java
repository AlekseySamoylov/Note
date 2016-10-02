package com.alekseysamoylov.note.repository;

import com.alekseysamoylov.note.entity.text.Issue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by alekseysamoylov on 10/2/16.
 */
@Repository
public class IssueRepositoryImpl implements IssueRepository {
    private final HibernateTemplate template;

    @Autowired
    public IssueRepositoryImpl(HibernateTemplate template) {
        this.template = template;
    }

    @Transactional(readOnly = true)
    public List<Issue> findAll() {
        return (List<Issue>) template.find("from Issue ");
    }

    @Transactional(readOnly = true)
    public List<Issue> findAllForTheme(Long themeMask) {
        return (List<Issue>) template.findByNamedParam("from Issue i where i.themeBitMask = :themeMask", "themeMask", themeMask);
    }

    @Override
    public Issue save(Issue issue) {
        Long id = (Long) template.save(issue);
        issue.setId(id);
        return issue;
    }

}
