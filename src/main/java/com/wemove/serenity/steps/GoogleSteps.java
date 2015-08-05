package com.wemove.serenity.steps;

import com.wemove.serenity.pages.GooglePage;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

@SuppressWarnings("serial")
public class GoogleSteps extends ScenarioSteps {

    GooglePage page;

    @Step
    public void open() {
        page.open();
    }

    @Step
    public void search(String search) {
        WebElementFacade input = page.find( By.name( "q" ) );
        input.typeAndEnter( search );

    }

    @Step
    public void shouldContainResult(String text) {
        WebElementFacade result = page.find( By.id( "ires" ) );
        result.shouldContainText( text );
    }

}
