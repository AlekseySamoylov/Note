package com.alekseysamoylov.note.repository;

import com.alekseysamoylov.note.entity.text.Issue;

import java.util.List;

/**
 * Created by alekseysamoylov on 10/2/16.
 */
public interface IssueRepository {

    public List<Issue> findAll();

    public List<Issue> findAllForTheme(Long themeMask);

    Issue save(Issue issue);

}
