package com.alekseysamoylov.note.service.issues;

import com.alekseysamoylov.note.entity.text.Issue;
import com.alekseysamoylov.note.model.WebTheme;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by alekseysamoylov on 10/2/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:testApplicationContext.xml")
@Transactional
public class IssueServiceImplTest {

    @Autowired
    IssueService issueService;

    @Test
    public void saveIssue() throws Exception {

        Issue issue = new Issue();
        issue.setMessage("Hello world");
        issue.setThemeBitMask(WebTheme.TEST.getThemeMask());
        issueService.saveIssue(issue);
    }

    @Test
    public void getThemeIssues() throws Exception {
        for (Issue issue : issueService.getThemeIssues(WebTheme.MAIN_THEME)) {
            System.out.println(issue.getMessage());
        }
    }

}