function valider ( )
{
    if ( document.formulaire.id_article.value == "" )
    {
    	alert ( "Veuillez renseigner les informations concernant la catégorie" );
        valid = false;
return valid;
    }
    if ( document.formulaire.nom.value == "" )
    {
        alert ( "Veuillez renseigner les informations concernant la catégorie" );
        valid = false;
return valid;
    }
    if ( document.formulaire.description.value == "" )
    {
        alert ( "Veuillez renseigner les informations concernant la catégorie" );
        valid = false;
return valid;
    }
    if ( document.formulaire.prix.value == "" )
    {
        alert ( "Veuillez renseigner les informations concernant la catégorie" );
        valid = false;
return valid;
    }

}

