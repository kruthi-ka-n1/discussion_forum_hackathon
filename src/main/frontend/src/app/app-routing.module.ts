import {RouterModule, Routes} from "@angular/router";
import {PostsListComponent} from "./posts/posts-list/posts-list.component";
import {NgModule} from "@angular/core";
import {PostsAddComponent} from "./posts/posts-add/posts-add.component";
import {PostDetailsComponent} from "./posts/post-details/post-details.component";
import {PostEditComponent} from "./posts/post-edit/post-edit.component";
import {SignupComponent} from "./auth/signup/signup.component";
import {SigninComponent} from "./auth/signin/signin.component";
import {AuthGuard} from "./auth/auth-guard.service";
import {SearchResultComponent} from "./posts/search-result/search-result.component";

const appRoutes: Routes = [
    {path: '', redirectTo: '/posts-list', pathMatch: 'full'},
    {path: 'posts-list', component: PostsListComponent},
    {path: 'posts-add', component: PostsAddComponent, canActivate: [AuthGuard]},
    {path: 'posts/:id', component: PostDetailsComponent},
    {path: 'posts/edit/:id', component: PostEditComponent, canActivate: [AuthGuard]},
    {path: 'search-result', component: SearchResultComponent},
    {path: 'signup', component: SignupComponent},
    {path: 'signin', component: SigninComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(appRoutes)],
    exports: [RouterModule]
})
export class AppRoutingModule {

}
