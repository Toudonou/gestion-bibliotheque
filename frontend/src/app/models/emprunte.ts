export interface Emprunte {
    id_emprunte: number;
    id_livre: number;
    id_personne: number;
    date_emprunt: Date;
    date_retour_estimee: Date;
    date_retour: Date
}