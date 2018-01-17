import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModalRef } from '@ng-bootstrap/ng-bootstrap';

import { ProfileService } from '../profiles/profile.service';
import { Principal, LoginModalService, LoginService } from '../../shared';

@Component({
    selector: 'jhi-navbar',
    templateUrl: './navbar.component.html',
    styleUrls: [
        'navbar.css'
    ]
})
export class NavbarComponent implements OnInit {

    inProduction: boolean;
    isNavbarCollapsed: boolean;
    swaggerEnabled: boolean;
    modalRef: NgbModalRef;
    version: string;
    headers: any[];

    constructor(
        private loginService: LoginService,
        private principal: Principal,
        private loginModalService: LoginModalService,
        private profileService: ProfileService,
        private router: Router
    ) {
        this.isNavbarCollapsed = true;

        this.headers = [{
                        'name': 'ANUL I',
                        'content': [
                                    {
                                        'name': 'Semestrul I',
                                        'show': false,
                                        'content': [
                                            {'name': 'Matematica 1',
                                             'url': 'acspedia/courses/a1s1mate1'},
                                            {'name': 'Matematica 2',
                                             'url': 'acspedia/courses/a1s1mate2'},
                                            {'name': 'Proiectare logica',
                                             'url': 'acspedia/courses/a1s1pl'},
                                            {'name': 'USO',
                                             'url': 'acspedia/courses/a1s1uso'},
                                            {'name': 'Programarea calculatoarelor',
                                             'url': 'acspedia/courses/a1s1pc'}
                                        ]
                                    },
                                    {
                                        'name': 'Semestrul II',
                                        'show': false,
                                        'content': [
                                            {'name': 'Matematica 3',
                                             'url': 'acspedia/courses/a1s2mate3'},
                                            {'name': 'Bazele electrotehnicii',
                                             'url': 'acspedia/courses/a1s2elth'},
                                            {'name': 'Fizica',
                                             'url': 'acspedia/courses/a1s2fizica'},
                                            {'name': 'Metode Numerice',
                                             'url': 'acspedia/courses/a1s2mn'},
                                            {'name': 'Structuri de date',
                                             'url': 'acspedia/courses/a1s2sd'},
                                            {'name': 'Prelucrarea informatiei',
                                             'url': 'acspedia/courses/a1s2pi'}
                                        ]
                                    }
                                    ]
                        },
                        {
                            'name': 'ANUL II',
                            'content': [
                                {
                                    'name': 'Semestrul I',
                                    'show': false,
                                    'content': [
                                        {'name': 'Analiza algoritmilor',
                                         'url': 'acspedia/courses/a2s1aa'},
                                        {'name': 'Programare orientata obiect',
                                         'url': 'acspedia/courses/a2s1poo'},
                                        {'name': 'Teoria sistemelor',
                                         'url': 'acspedia/courses/a2s1ts'},
                                        {'name': 'Elemente de electronica analogica',
                                         'url': 'acspedia/courses/a2s1eea'},
                                        {'name': 'IOCLA',
                                         'url': 'acspedia/courses/a2s1iocla'}
                                    ]
                                },
                                {
                                    'name': 'Semestrul II',
                                    'show': false,
                                    'content': [
                                        {'name': 'Achizitii de date',
                                         'url': 'acspedia/courses/a2s2ad'},
                                        {'name': 'Calculatoare numerice 1',
                                         'url': 'acspedia/courses/a2s2cn1'},
                                        {'name': 'Paradigme de programare',
                                         'url': 'acspedia/courses/a2s2pp'},
                                        {'name': 'Electronica digitala',
                                         'url': 'acspedia/courses/a2s2ed'},
                                        {'name': 'Protocoale de comunicatie',
                                         'url': 'acspedia/courses/a2s2pc'},
                                        {'name': 'Proiectarea algoritmilor',
                                         'url': 'acspedia/courses/a2s2pa'}
                                    ]
                                }
                            ]
                        },
                        {
                            'name': 'ANUL III',
                            'content': [
                                {
                                    'name': 'Semestrul I',
                                    'show': false,
                                    'content': [
                                        {'name': 'Retele locale',
                                            'url': 'acspedia/courses/a3s1rl'},
                                        {'name': 'Calculatoare numerice 2',
                                            'url': 'acspedia/courses/a3s1cn2'},
                                        {'name': 'Limbaje formale si automate',
                                            'url': 'acspedia/courses/a3s1lfa'},
                                        {'name': 'Elemente de grafica pe calculator',
                                            'url': 'acspedia/courses/a3s1egc'},
                                        {'name': 'Algoritmi paraleli si distribuiti',
                                            'url': 'acspedia/courses/a3s1apd'}
                                    ]
                                },
                                {
                                    'name': 'Semestrul II',
                                    'show': false,
                                    'content': [
                                        {'name': 'Baze de date I',
                                            'url': 'acspedia/courses/a3s2bd1'},
                                        {'name': 'Arhitectura sistemelor de calcul',
                                            'url': 'acspedia/courses/a3s2asc'},
                                        {'name': 'Ingineria calculatoarelor',
                                            'url': 'acspedia/courses/a3s2ic'},
                                        {'name': 'Sisteme de operare',
                                            'url': 'acspedia/courses/a3s2so'},
                                        {'name': 'Proiectarea cu microprocesoare',
                                            'url': 'acspedia/courses/a3s2pm'},
                                        {'name': 'Ingineria programelor',
                                            'url': 'acspedia/courses/a3s2ip'}
                                    ]
                                }
                            ]
                        },
                        {
                            'name': 'ANUL IV',
                            'content': [
                                {
                                    'name': 'Semestrul I',
                                    'show': false,
                                    'url': '',
                                    'content': [
                                        {'name': 'Interactiune Om-Calculator',
                                            'url': 'acspedia/courses/a4s1ioc'},
                                        {'name': 'Sisteme de Prelucrare Grafica',
                                            'url': 'acspedia/courses/a4s1spg'},
                                        {'name': 'Inteligenta artificiala',
                                            'url': 'acspedia/courses/a4s1ia'},
                                        {'name': 'Introducere in criptologie',
                                            'url': 'acspedia/courses/a4s1ic'},
                                        {'name': 'Baze de date II',
                                            'url': 'acspedia/courses/a4s1bdII'},
                                        {'name': 'Structuri multiprocesor',
                                            'url': 'acspedia/courses/a4s1sm'},
                                        {'name': 'Arhitecturi si prelucrari paralele',
                                            'url': 'acspedia/courses/a4s1app'},
                                        {'name': 'Proiectarea retelelor',
                                            'url': 'acspedia/courses/a4s1spg'},
                                        {'name': 'Managementul proiectelor',
                                            'url': 'acspedia/courses/a4s1mp'},
                                        {'name': 'Managementul proiectelor software',
                                            'url': 'acspedia/courses/a4s1spg'},
                                        {'name': 'Integrarea sistemelor informatice',
                                            'url': 'acspedia/courses/a4s1isi'},
                                        {'name': 'Compilatoare',
                                            'url': 'acspedia/courses/a4s1cp'},
                                        {'name': 'Sisteme de Programe pentru RL',
                                            'url': 'acspedia/courses/a4s1sprl'},
                                        {'name': 'Sisteme cu microprocesoare',
                                            'url': 'acspedia/courses/a4s1scm'},
                                        {'name': 'Procesarea semnalelor',
                                            'url': 'acspedia/courses/a4s1ps'},
                                        {'name': 'Sisteme incorporate',
                                            'url': 'acspedia/courses/a4s1si'},
                                        {'name': 'Utilizarea bazelor de date',
                                            'url': 'acspedia/courses/a4s1ubd'}
                                    ]
                                },
                                {
                                    'name': 'Semestrul II',
                                    'show': false,
                                    'url': '',
                                    'content': [
                                        {'name': 'Elemente de informatica mobila',
                                            'url': 'acspedia/courses/a4s2eim'},
                                        {'name': 'Instrumente pentru dezvoltarea programelor',
                                            'url': 'acspedia/courses/a4s2idp'},
                                        {'name': 'Invatare automata',
                                            'url': 'acspedia/courses/a4s2eia'},
                                        {'name': 'Sisteme tolerante la defecte',
                                            'url': 'acspedia/courses/a4s2std'},
                                        {'name': 'VLSI I',
                                            'url': 'acspedia/courses/a4s2vlsi1'},
                                        {'name': 'E-commerce',
                                            'url': 'acspedia/courses/a4s2ec'},
                                        {'name': 'Testarea securitatii sistemelor',
                                            'url': 'acspedia/courses/a4s2tss'},
                                        {'name': 'Sisteme de operare II',
                                            'url': 'acspedia/courses/a4s2so2'},
                                        {'name': 'Sisteme CAD/CASE',
                                            'url': 'acspedia/courses/a4s2scc'},
                                        {'name': 'Programare Web',
                                            'url': 'acspedia/courses/a4s2pw'},
                                    ]
                                }
                            ]
                        },
                        {
                            'name': 'Diverse',
                            'content': [
                                {
                                    'name': 'Orar',
                                    'show': false,
                                    'url': 'acspedia/orar',
                                    'content': []
                                },
                                {
                                    'name': 'Admitere',
                                    'show': false,
                                    'url': 'acspedia/admitere',
                                    'content': []
                                },
                                {
                                    'name': 'Internship',
                                    'show': false,
                                    'url': 'acspedia/internship',
                                    'content': []
                                },
                                {
                                    'name': 'Pareri si sfaturi',
                                    'show': false,
                                    'url': 'acspedia/parerisfaturi',
                                    'content': []
                                },
                                {
                                    'name': 'Contact',
                                    'show': false,
                                    'url': 'acspedia/contact',
                                    'content': []
                                }
                            ]
                        }
                        ];
    }

    ngOnInit() {
        this.profileService.getProfileInfo().subscribe((profileInfo) => {
            this.inProduction = profileInfo.inProduction;
            this.swaggerEnabled = profileInfo.swaggerEnabled;
        });
    }

    collapseNavbar() {
        this.isNavbarCollapsed = true;
    }

    isAuthenticated() {
        return this.principal.isAuthenticated();
    }

    login() {
        this.modalRef = this.loginModalService.open();
    }

    logout() {
        this.collapseNavbar();
        this.loginService.logout();
        this.router.navigate(['']);
    }

    toggleNavbar() {
        this.isNavbarCollapsed = !this.isNavbarCollapsed;
    }

    showSubMenu(ct: any) {
        ct.show = true;
    }

    hideSubMenu(ct: any) {
        ct.show = false;
    }

    getImageUrl() {
        return this.isAuthenticated() ? this.principal.getImageUrl() : null;
    }
}
