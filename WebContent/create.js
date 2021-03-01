function fun()
{
    var x=document.getElementById("id1");
    var y=document.getElementById("id0").value;
    var r=document.getElementById("bed").value;
    var t=document.getElementById("state").value;
    var e=document.getElementById("city").value;
    if(x.checkValidity()==true && r!="" && t!="" && e!="")
    {
        alert("Patient creation initiated sucessfully!!!");
        return true;
    }
    else{
    if(!x.checkValidity())
    {
        alert("Age: "+x.validationMessage);
        return false;
    }
}
}