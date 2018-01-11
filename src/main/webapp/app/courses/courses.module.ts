import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ChomeComponent} from './chome.component';
import {CoursesService} from './courses.service';
import {RankingComponent} from "./Ranking/ranking.component";
import {BrowserModule} from "@angular/platform-browser";
import {FormsModule} from "@angular/forms";
import {MaterialeComponent} from "./Materiale/Materiale.component";
import {PareriComponent} from "./Pareri/Pareri.component";
import {PrezolvareComponent} from "./Prezolvare/Prezolvare.component";
import {AdmitereComponent} from "./diverse/admitere/admitere.component";
import {ContactComponent} from "./diverse/contact/contact.component";
import {InternshipComponent} from "./diverse/internship/internship.component";
import {OrarComponent} from "./diverse/orar/orar.component";
import {ParerisfaturiComponent} from "./diverse/parerisfaturi/parerisfaturi.component";

export const courseroute: Routes = [
    {
        path: 'acspedia',
        children:  [
            {
                path: 'courses/:cid',
                component: ChomeComponent
            },
            {
                path: 'courses/:cid/materiale/:type',
                component: MaterialeComponent
            },
            {
                path: 'courses/:cid/pareri/:type',
                component: PareriComponent
            },
            {
                path: 'courses/:cid/probleme/:type',
                component: PrezolvareComponent
            },
            {
                path: 'orar',
                component: OrarComponent
            },
            {
                path: 'admitere',
                component: AdmitereComponent
            },
            {
                path: 'internship',
                component: InternshipComponent
            },
            {
                path: 'parerisfaturi',
                component: ParerisfaturiComponent
            },
            {
                path: 'contact',
                component: ContactComponent
            }]
    }

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
        RankingComponent,
        MaterialeComponent,
        PareriComponent,
        PrezolvareComponent,
        AdmitereComponent,
        ContactComponent,
        InternshipComponent,
        OrarComponent,
        ParerisfaturiComponent
    ]
})
export class CoursesModule {}
