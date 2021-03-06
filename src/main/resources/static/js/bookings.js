const dropdownAllActivities = document.getElementById("dropdownAllActivities");
const createBookingButton = document.getElementById("createBooking");
const dropdownTimeslots = document.getElementById("timeslot");
const calendar = document.getElementById("calendar");

createBookingButton.addEventListener('click', x => createBooking())

let list = getAllActivities().then(x => list = x);
let timeslotList = getTimeslots().then(x => timeslotList = x);

async function getAllActivities() {

    const url = "http://localhost:8080/findAllActivities"
    const response = await fetch(url);
    const data = await response.json();

    data.forEach(x => {
        let element = document.createElement("option")
        element.value = x.activityId;
        element.textContent = x.title;
        dropdownAllActivities.appendChild(element)
    })

    return data;
}

async function getTimeslots()
{
    const url = await fetch("http://localhost:8080/findAllTimeslots")
    const result = await url.json();

    result.forEach(x =>
    {
        let element = document.createElement("option")
        element.value = x.timeSlotId;
        element.textContent = x.start + "-" + x.end;
        dropdownTimeslots.appendChild(element);
    })

    return result;
}

function createBooking()
{
    const activity = list[dropdownAllActivities.selectedIndex];
    const timeslot = timeslotList[dropdownTimeslots.selectedIndex];
    const date = calendar.value;

    const booking = {
        "bookingDate": date,
        "dummy":activity.activityId,
        "dummyTimeSlot": timeslot.timeSlotId
    }

    const bookingStringified = JSON.stringify(booking);

    const url = "http://localhost:8080/postBooking";

    const postObject = {
        headers: {
                "Content-type": 'application/json'
            },
        method: 'POST',
        body: bookingStringified
    };

    fetch(url,postObject)
        .then(response => response.json())
        .then(x => {
            if(x.localizedMessage === "ERROR")
            {
                alert("Der findes allerede en booking p?? den valgte dato i det valgte tidsrum")
            } else
            {
                location.reload()
            }
        })
}