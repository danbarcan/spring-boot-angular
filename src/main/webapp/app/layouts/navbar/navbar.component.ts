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
    languages: any[];
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
                                    'content': []
                                },
                                {
                                    'name': 'Semestrul II',
                                    'show': false,
                                    'url': '',
                                    'content': []
                                }
                            ]
                        },
                        {
                            'name': 'Master',
                            'content': [
                                {
                                    'name': 'Semestrul I',
                                    'show': false,
                                    'url': '',
                                    'content': []
                                },
                                {
                                    'name': 'Semestrul II',
                                    'show': false,
                                    'url': '',
                                    'content': []
                                }
                            ]
                        },
                        {
                            'name': 'Diverse',
                            'content': [
                                {
                                    'name': 'Orar',
                                    'show': false,
                                    'url': '',
                                    'content': []
                                },
                                {
                                    'name': 'Admitere',
                                    'show': false,
                                    'url': '',
                                    'content': []
                                },
                                {
                                    'name': 'Internship',
                                    'show': false,
                                    'url': '',
                                    'content': []
                                },
                                {
                                    'name': 'Pareri si sfaturi',
                                    'show': false,
                                    'url': '',
                                    'content': []
                                },
                                {
                                    'name': 'Contact',
                                    'show': false,
                                    'url': '',
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
