package com.alekseysamoylov.note.service.issues;

import com.alekseysamoylov.note.entity.text.Issue;
import com.alekseysamoylov.note.model.WebTheme;
import com.alekseysamoylov.note.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by alekseysamoylov on 10/2/16.
 */
@Repository
public class IssueServiceImpl implements IssueService {

    @Autowired
    private IssueRepository issueRepository;

    @Override
    @Transactional
    public void saveIssue(Issue issue) {
        issueRepository.save(issue);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Issue> getThemeIssues(WebTheme theme) {
        return issueRepository.findAllForTheme(theme.getThemeMask());
    }
}
