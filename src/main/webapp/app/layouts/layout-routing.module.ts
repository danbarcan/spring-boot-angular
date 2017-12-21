import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { navbarRoute } from '../app.route';
import { errorRoute } from './';
import {activateRoute} from "../account/activate/activate.route";

const LAYOUT_ROUTES = [
    navbarRoute,
    activateRoute,
    ...errorRoute
];

@NgModule({
    imports: [
        RouterModule.forRoot(LAYOUT_ROUTES, { useHash: true })
    ],
    exports: [
        RouterModule
    ]
})
export class LayoutRoutingModule {}
