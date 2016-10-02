package com.alekseysamoylov.note.service.issues;

import com.alekseysamoylov.note.entity.text.Issue;
import com.alekseysamoylov.note.model.WebTheme;

import java.util.List;

/**
 * Created by alekseysamoylov on 10/2/16.
 */
public interface IssueService {
    void saveIssue(Issue issue);

    List<Issue> getThemeIssues(WebTheme theme);
}
