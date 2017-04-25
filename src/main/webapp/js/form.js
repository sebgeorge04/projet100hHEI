function surligne(champ, erreur)
{
   if(erreur)
      champ.style.backgroundColor = "#fba";
   else
      champ.style.backgroundColor = "";
}

function verifPrenom(champ)
{
   if(champ.value.length < 0 || champ.value.length > 50)
   {
      surligne(champ, true);
      return false;
   }
   else
   {
      surligne(champ, false);
      return true;
   }
}
function verifNom(champ)
{
   if(champ.value.length < 2 || champ.value.length > 50)
   {
      surligne(champ, true);
      return false;
   }
   else
   {
      surligne(champ, false);
      return true;
   }
}
function verifEmail(champ)
{
   if(champ.value.length < 2 || champ.value.length > 50)
   {
      surligne(champ, true);
      return false;
   }
   else
   {
      surligne(champ, false);
      return true;
   }
}
function verifMdp(champ)
{
   if(champ.value.length <= 0)
   {
      surligne(champ, true);
      return false;
   }
   else
   {
      surligne(champ, false);
      return true;
   }
}
function verifForm(f)
{
   var prenomOk = verifPseudo(f.prenom);
   var nomOk = verifNom(f.nom);
   var mailOk = verifMail(f.email);
   var mdpOk = verifMdp(f.motdepasse);
   
   if(prenomOk && mailOk && mdpOk && nomOk)
      return true;
   else
   {
      alert("Veuillez remplir correctement tous les champs");
      return false;
   }
}