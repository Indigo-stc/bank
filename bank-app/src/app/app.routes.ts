import { Routes } from '@angular/router';
import { HomeComponent } from './home/home/home.component';
import { LandingLayoutComponent } from './layouts/landing-layout/landing-layout.component';
import { AuthLayoutComponent } from './layouts/auth-layout/auth-layout.component';

export const routes: Routes = [
    {
        path: '',
        component: LandingLayoutComponent,
        children: [
            { path: '', redirectTo: 'home', pathMatch: 'full' },
            { path: 'home', component: HomeComponent },
        ]
    },
    {
        path: '',
        component: AuthLayoutComponent,
        children: [
            {
                path: 'login',
                loadComponent: () =>
                    import('./auth/login/login.component').then(m => m.LoginComponent)
            },
            {
                path: 'signup',
                loadComponent: () =>
                    import('./auth/signup/signup.component').then(m => m.SignupComponent)
            },
            {
                path: 'security-question/:id',
                loadComponent: () =>
                    import('./auth/security-question/security-question.component').then(m => m.SecurityQuestionComponent)
            },
        ]
    },

];
