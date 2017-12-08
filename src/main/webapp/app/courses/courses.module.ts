import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ChomeComponent} from './chome.component';
import {CoursesService} from './courses.service';
import {RankingComponent} from "./Ranking/ranking.component";
import {BrowserModule} from "@angular/platform-browser";
import {FormsModule} from "@angular/forms";

export const courseroute: Routes = [
    {
        path: 'acspedia',
        children:  [
            {path: 'courses/:cid',
            component: ChomeComponent,
            children: [
            ]}
            ]
    },

];

@NgModule({
    imports: [
        RouterModule.forRoot(courseroute, { useHash: true }),
        BrowserModule,
        FormsModule
    ],
    providers: [
        CoursesService
    ],
    declarations: [
        ChomeComponent,
        RankingComponent
    ]
})
export class CoursesModule {}
