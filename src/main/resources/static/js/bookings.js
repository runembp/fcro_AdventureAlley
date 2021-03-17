const button = document.getElementById("button");
const dropdownAllActivities = document.getElementById("dropdownAllActivities");
const createBookingButton = document.getElementById("createBooking");

button.addEventListener('click', x => getAllBookings())
createBookingButton.addEventListener('click', x => createBooking())

async function getAllBookings() {
    const url = "http://localhost:8080/findAllActivities"
    const getObject = {
        method:"GET",
        headers:{
            "Content-type":"application/json"
        }
    }

    const response = await fetch(url, getObject);
    const data = await response.json();

    data.forEach(x => {
        let element = document.createElement("option")
        element.value = x.index;
        element.textContent = x.title;
        dropdownAllActivities.appendChild(element)
    })
}

async function createBooking()
{
    const selectedValue = dropdownAllActivities.options.selectedIndex.text;

    console.log(selectedValue)


    const url = "http://localhost:8080/createBooking"
    const postObject = {
        method:"POST",
        headers: {
            "Content-type":"application/json"
        },
        body:null
    }
}