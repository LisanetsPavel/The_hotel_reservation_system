function checkPw(form) {
pw1 = form.Password.value;
pw2 = form.RepeatPassword.value;

if (pw1 != pw2) {
alert ("\n You entered in the \"Repeat Password\" password different from those introduced in the \"Password\".")
return false;
}
else return true;
}


