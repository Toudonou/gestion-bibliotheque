export interface Personne {
    id_livre: number;
    id_personne: number;
    id_emprunt: number;
    prenom_personne: string;
    nom_personne: string;
    date_emprunt: Date;
    date_retour: Date;
    date_retour_prevue: Date;
  }
