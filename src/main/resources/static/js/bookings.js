const button = document.getElementById("button");
const listContainer = document.getElementById("listContainer");
const url = "http://localhost:8080/findAllBookings"
const getObject = {
    method:"GET",
    headers:{
        "Content-type":"application/json"
    }
}

button.addEventListener('click', x => getAllBookings())

async function getAllBookings() {
    const response = await fetch(url, getObject);
    const data = await response.json();

    data.forEach(x => {
        let element = document.createElement("p")
        element.textContent = "Id: " + x.id + " - Date: " + x.date + " - activityId: " + x.activityId;
        listContainer.appendChild(element)
    })
}