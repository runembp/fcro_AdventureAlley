
const createActivityUrl = "http://localhost:8080/newActivity";

const saveButton = document.getElementById("save");

function create_activity() {
    let activity = {
            "title": document.getElementById("title").value,
            "description": document.getElementById("description").value,
            "price": document.getElementById("price").value,
            "min_height": document.getElementById("minHeight").value,
            "min_age": document.getElementById("minAge").value,
            "equipment": document.getElementById("equipment").value,
        }

    console.log(activity);
    let body1 = JSON.stringify(activity);

    if(JSON.stringify(activity.title)=='""')
    {
        alert("Angiv titel");
        return false;
    }
    if(JSON.stringify(activity.description)=='""')
    {
        alert("Angiv beskrivelse");
        return false;
    }
    if(JSON.stringify(activity.price)=='""')
    {
        alert("Angiv pris");
        return false;
    }
    else
    {
        addActivity(body1)
    }
}

function addActivity(body1) {

    const requestObject =
        {
            headers:{
                'Content-type': 'application/json',
            },
            method: 'POST',
            body: body1
        };

    fetch(createActivityUrl, requestObject)
        .then(response => response.json())
        .then(data => {
            console.log("Succes: ", data);
        })
        .then(alert("Aktiviteten er gemt"))
        .then(location.reload())
        .catch((error) =>{
            console.log("Error: ", error);
        })

}

saveButton.addEventListener("click", create_activity);



