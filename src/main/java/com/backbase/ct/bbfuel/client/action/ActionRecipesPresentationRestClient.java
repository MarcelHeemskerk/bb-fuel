package com.backbase.ct.bbfuel.client.action;

import com.backbase.ct.bbfuel.client.common.RestClient;
import com.backbase.ct.bbfuel.config.BbFuelConfiguration;
import com.backbase.dbs.actions.actionrecipes.presentation.rest.spec.v2.actionrecipes.ActionRecipesPostRequestBody;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ActionRecipesPresentationRestClient extends RestClient {

    private final BbFuelConfiguration config;

    private static final String SERVICE_VERSION = "v2";
    private static final String ACTIONRECIPES_PRESENTATION_SERVICE = "actionrecipes-presentation-service";
    private static final String ENDPOINT_ACTION_RECIPES = "/action-recipes";

    @PostConstruct
    public void init() {
        setBaseUri(config.getPlatform().getGateway());
        setVersion(SERVICE_VERSION);
        setInitialPath(ACTIONRECIPES_PRESENTATION_SERVICE);
    }

    public Response createActionRecipe(ActionRecipesPostRequestBody actionRecipesPostRequestBody) {
        return requestSpec()
            .contentType(ContentType.JSON)
            .body(actionRecipesPostRequestBody)
            .post(getPath(ENDPOINT_ACTION_RECIPES));
    }

}
