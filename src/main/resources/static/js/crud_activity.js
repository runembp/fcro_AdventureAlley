const title = document.getElementById("title-update");
const description = document.getElementById("description-update");
const price = document.getElementById("price-update");
const minHeight = document.getElementById("minHeight-update");
const minAge = document.getElementById("minAge-update");
const equipment = document.getElementById("equipment-update");
const imageLink = document.getElementById("imageLink-update");

function submitForm(){
    if (!event.preventDefault()) {
        createActivity();
        location.reload();
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

    console.log(body1);
    console.log(requestObject);

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

let list = getAllActivities().then(x => list = x);

const dropdownAllActivities = document.getElementById("dropdownAllActivities");

async function getAllActivities() {
    const url = "http://localhost:8080/findAllActivities"
    const response = await fetch(url);
    const data = await response.json();

    dropdownAllActivities.length = 0;

    data.forEach(x => {
        let element = document.createElement("option");
        element.value = x.activityId;
        element.setAttribute('class', 'updateActivityClass');
        element.textContent = x.title;
        dropdownAllActivities.appendChild(element)
    })

    return data;
}

dropdownAllActivities.addEventListener('change', x => {
    title.value = list[dropdownAllActivities.selectedIndex].title;
    description.value = list[dropdownAllActivities.selectedIndex].description;
    price.value = list[dropdownAllActivities.selectedIndex].price;
    minHeight.value = list[dropdownAllActivities.selectedIndex].minHeight;
    minAge.value = list[dropdownAllActivities.selectedIndex].minAge;
    equipment.value = list[dropdownAllActivities.selectedIndex].equipment;
    imageLink.value = list[dropdownAllActivities.selectedIndex].imageLink;
});

function updateSubmit() {
    if(!event.preventDefault()) {
        updateActivity();
        location.reload();
    }
}

function updateActivity() {

    let updatedActivity = {
        "activityId": list[dropdownAllActivities.selectedIndex].activityId,
        "description": document.getElementById("description-update").value,
        "equipment": document.getElementById("equipment-update").value,
        "imageLink": document.getElementById("imageLink-update").value,
        "minAge": document.getElementById("minAge-update").value,
        "minHeight": document.getElementById("minHeight-update").value,
        "price": document.getElementById("price-update").value,
        "title": document.getElementById("title-update").value
    }

    let updateActivityStringified = JSON.stringify(updatedActivity);

    updateDB(updateActivityStringified);
}

function updateDB(updateActivityStringified) {
    const putUrl = "http://localhost:8080/updateActivity";

    const putObject = {
        headers: {'Content-type': 'application/json'
        },
        method: 'PUT',
        body: updateActivityStringified
    }

    console.log(putObject)

    fetch(putUrl, putObject)
}

function deleteDB() {
    const deleteURL = "/deleteActivity/" + list[dropdownAllActivities.selectedIndex].activityId

    const deleteObject = {
        method: 'DELETE'
    }

    fetch(deleteURL, deleteObject)

    location.reload()
}

document.getElementById("delete-activity").addEventListener('click', deleteDB);




