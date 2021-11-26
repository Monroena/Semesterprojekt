/*viser dropdown menu*/
function myFunction() {
    document.getElementById("myDropdown").classList.toggle("show");
}

/* Lukker dropdown menuen */
window.onclick = function (event) {
    if (!event.target.matches('.dropdownbtn')) {
        let dropdowns = document.getElementsByClassName("dropdown-content");
        let i;
        for (i = 0; i < dropdowns.length; i++) {
            let openDropdown = dropdowns[i];
            if (openDropdown.classList.contains('show')) {
                openDropdown.classList.remove('show');
            }
        }
    }
}

/* Fetch kald som skal resultere i at xml bliver hentet*/
function fetchfunction(apiurl) {
    fetch(apiurl,{
        headers: {
            "Authorization": localStorage.getItem("token")
        }
    }).then(resp => resp.json()).then(data => displaydata(data));
}

function displaydata(data) {
    let container = "";
    for (let i = 0; i < data.aftaleliste.length; i++) {
        let cpr = "CPR: " + data.aftaleliste[i].CPR;
        let klinikid = "KlinikID: " + data.aftaleliste[i].KlinikID;
        let id = "AftaleID: " + data.aftaleliste[i].ID;
        let time = data.aftaleliste[i].TimeStart + " ----- " + data.aftaleliste[i].TimeEnd;
        let note = data.aftaleliste[i].Notat;

        let tider = '<span class="tider">' + time + '</span><br>'
        let navne = '<span class="name">' + cpr + " --- " + klinikid + " --- " + id + '</span><br>';
        let notat = '<span class="note">' + note + '</span><hr>';

        container += navne + tider + notat;
        console.log(container);
    }
    document.getElementById("tekstfelt").innerHTML = container;
}