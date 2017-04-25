function valider ( )
{
    if ( document.formulaire.motdepasse.value == "" )
    {
    	alert ( "Veuillez renseigner votre identifiant et mot de passe svp" );
        valid = false;
return valid;
    }
    if ( document.formulaire.email.value == "" )
    {
        alert ( "Veuillez renseigner votre identifiant et mot de passe svp" );
        valid = false;
return valid;
    }

}