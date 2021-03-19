require

function submitForm(){
    if (!event.preventDefault()) {
        createActivity();
    }
}

function createActivity() {

    let activity = {
            "title": document.getElementById("title").value,
            "description": document.getElementById("description").value,
            "price": document.getElementById("price").value,
            "minHeight": document.getElementById("minHeight").value,
            "minAge": document.getElementById("minAge").value,
            "equipment": document.getElementById("equipment").value,
            "imageLink": document.getElementById("imageLink").value,
        }
    console.log(activity);
    let body1 = JSON.stringify(activity);
    addActivity(body1)
}

function addActivity(body1) {
    const createActivityUrl = "http://localhost:8080/newActivity";

    const requestObject = {
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

function updateActivity() {

}




