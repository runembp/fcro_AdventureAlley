
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

    dropdownAllActivities.length = 0;

    data.forEach(x => {
        let element = document.createElement("option")
        element.value = x.activity_Id;
        element.textContent = x.title;
        dropdownAllActivities.appendChild(element)
    })

    return data;
}

async function getTimeslots()
{
    const url = await fetch("http://localhost:8080/findAllTimeslots")
    const result = await url.json();

    dropdownTimeslots.length = 0;

    result.forEach(x =>
    {
        let element = document.createElement("option")
        element.value = x.index;
        element.textContent = x.start + "-" + x.end;
        dropdownTimeslots.appendChild(element);
    })

    return result;
}

async function createBooking()
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
        accept: 'application/json',
        body: bookingStringified
    };

    fetch(url,postObject)
        .then(response => response.json())
        .then(() => {
            console.log("booking created")
        })
        .catch(() => {
            console.log("failure")
        })
}