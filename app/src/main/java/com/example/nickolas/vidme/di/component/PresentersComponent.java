package com.example.nickolas.vidme.di.component;

import com.example.nickolas.vidme.di.module.PresentersModule;
import com.example.nickolas.vidme.di.scopes.Scope;
import com.example.nickolas.vidme.di.scopes.Scopes;
import com.example.nickolas.vidme.fragments.FeaturedFragment;
import com.example.nickolas.vidme.fragments.FeedFragment;
import com.example.nickolas.vidme.fragments.NewFragment;

import dagger.Component;


@Scope(Scopes.VIEW)
@Component(
        modules = {PresentersModule.class},
        dependencies = {AppComponent.class}
)
public interface PresentersComponent {

    void inject(FeaturedFragment featuredFragment);
    void inject(FeedFragment feedFragment);
    void inject(NewFragment newFragment);

}
