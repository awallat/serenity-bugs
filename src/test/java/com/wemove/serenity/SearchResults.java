package com.wemove.serenity;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import com.wemove.serenity.steps.GoogleSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;

@Story(Application.Portal.class)
@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SearchResults {
    private static final String featureName = "Search";
    private static final String capability = "Portal";

    @Managed(uniqueSession = false)
    public WebDriver webdriver;
    
    @Steps
    GoogleSteps google;

    @WithTags({ @WithTag(type = "feature", name = featureName), @WithTag(type = "capability", name = capability) })
    @Title("Test")
    @Test
    public void search() {
        google.open();
        google.search( "serenity" );
        google.shouldContainResult( "Serenity" );
    }


}