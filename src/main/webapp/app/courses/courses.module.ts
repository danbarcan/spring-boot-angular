import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ChomeComponent} from './chome.component';

export const courseroute: Routes = [
    {
        path: 'acspedia',
        children:  [
            {path: 'courses/:cid',
            component: ChomeComponent}
            ]
    },

];

@NgModule({
    imports: [
        RouterModule.forRoot(courseroute, { useHash: true }),

    ],
    providers: [
    ],
    declarations: [
        ChomeComponent,
    ]
})
export class CoursesModule {}
