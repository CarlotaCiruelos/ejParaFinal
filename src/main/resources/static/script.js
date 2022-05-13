const searchForm = document.getElementById("search-form");
var results = [];

searchForm.addEventListener("submit", function(event){
    fetch(`http://localhost:8080/api/users/getAll`)
        .then(res => {
            console.log("Response here")
            return res.json()
        })

        .then(r => {
            results= r;
            console.info(r);
            if (r.length>0){
                console.log("Cogemos los users");
                updateSearchResults();
            }
            else{
                console.info("Entra");
                mensajeError();
            }

        })
        .catch(e => {
            console.error("Error " + e)
        })
    return false;
})

function updateSearchResults(){
    let html = '';
    results.forEach(function(user, i){
        html += '<div class="col">'
            + '<div >'
            +  `<h5>${user.user_id}</h5>`
            +  `<h3>${user.user}</h3>`
            +`<p>${user.comment}</p>`
            +'</div>'
            +'</div>';
    })
    document.getElementById("container-cards").innerHTML = html;
}
function mensajeError(){
    let html='';
    html+='<h5>No hay resultado para los parámetros introducidos. Repita la búsqueda</h5>';
    document.getElementById("container-cards").innerHTML = html;
}




