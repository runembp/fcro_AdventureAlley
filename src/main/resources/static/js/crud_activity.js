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

let list = getAllActivities().then(x => list = x);

const dropdownAllActivities = document.getElementById("dropdownAllActivities");

async function getAllActivities() {
    const url = "http://localhost:8080/findAllActivities"
    const response = await fetch(url);
    const data = await response.json();

    dropdownAllActivities.length = 0;

    data.forEach(x => {
        let element = document.createElement("option")
        element.value = x.activityId;
        //element.setAttribute('class', 'updateActivityClass')
        element.textContent = x.title;
        dropdownAllActivities.appendChild(element)
    })

    return data;
}


document.querySelector('#dropdownAllActivities').addEventListener('click', e => {

    console.log(e.target.children.indexOf());

/*    if(e.target.children == 'option') {
        console.log('hej')
    }*/
})




