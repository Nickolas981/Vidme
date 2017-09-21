package com.example.nickolas.vidme.di.component;

import com.example.nickolas.vidme.di.module.PresentersModule;
import com.example.nickolas.vidme.di.scopes.Scope;
import com.example.nickolas.vidme.di.scopes.Scopes;
import com.example.nickolas.vidme.fragments.FeaturedFragment;

import dagger.Component;


/**
 * Created by Roman Tsekhmeistruk on 11.04.2017.
 */

@Scope(Scopes.VIEW)
@Component(
        modules = {PresentersModule.class},
        dependencies = {AppComponent.class}
)
public interface PresentersComponent {

    void inject(FeaturedFragment featuredFragment);

}
