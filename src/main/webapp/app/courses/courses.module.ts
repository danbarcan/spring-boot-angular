import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ChomeComponent} from './chome.component';
import {CoursesService} from './courses.service';
import {RankingComponent} from "./Ranking/ranking.component";
import {BrowserModule} from "@angular/platform-browser";
import {FormsModule} from "@angular/forms";
import {PareriComponent} from "./Pareri/Pareri.component";
import {PrezolvareComponent} from "./Prezolvare/Prezolvare.component";
import {AdmitereComponent} from "./diverse/admitere/admitere.component";
import {ContactComponent} from "./diverse/contact/contact.component";
import {InternshipComponent} from "./diverse/internship/internship.component";
import {OrarComponent} from "./diverse/orar/orar.component";
import {ParerisfaturiComponent} from "./diverse/parerisfaturi/parerisfaturi.component";
import {CoursesComponent} from "./Materials/courses.component";
import {ExamsComponent} from "./Materials/exams.component";
import {LabsComponent} from "./Materials/labs.component";
import {ForumComponent} from "./Forum/Forum.component";
import {LayoutRoutingModule} from "../layouts/layout-routing.module";
import {CommonModule} from "@angular/common";
import {AfisareProblemaComponent} from "./Prezolvare/AfisareProblema.component";
import {ActivareFisiereComponent} from "./ActivareFisiere/ActivareFisiere.component";
import {AcsPediaAdminModule} from "../admin/admin.module";
import {AcsPediaAccountModule} from "../account/account.module";
import {HasAnyAuthorityDirective} from "../shared/auth/has-any-authority.directive";
import {AcsPediaSharedModule} from "../shared/shared.module";

export const courseroute: Routes = [
    {
        path: 'acspedia',
        children:  [
            {
                path: 'courses/:cid',
                component: ChomeComponent
            },
            {
                path: 'activare/fisiere',
                component: ActivareFisiereComponent
            },
            {
                path: 'courses/:cid/materiale/cursuri',
                component: CoursesComponent
            },
            {
                path: 'courses/:cid/materiale/examene',
                component: ExamsComponent
            },
            {
                path: 'courses/:cid/materiale/laboratoare',
                component: LabsComponent
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
                path: 'courses/:cid/probleme/:type/:id',
                component: AfisareProblemaComponent
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
        FormsModule,
        LayoutRoutingModule,
        CommonModule,
        AcsPediaSharedModule
    ],
    providers: [
        CoursesService
    ],
    declarations: [
        ChomeComponent,
        RankingComponent,
        PareriComponent,
        PrezolvareComponent,
        AdmitereComponent,
        ContactComponent,
        InternshipComponent,
        OrarComponent,
        ParerisfaturiComponent,
        CoursesComponent,
        ExamsComponent,
        LabsComponent,
        ForumComponent,
        AfisareProblemaComponent,
        ActivareFisiereComponent
 ]
})
export class CoursesModule {}
