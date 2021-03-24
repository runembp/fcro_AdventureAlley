
const useremail = document.getElementById("useremail");

const email = window.location.pathname.substring(19);

const userUrl = `http://localhost:8080/bookings/${email}`;

getBookingToUser();


async function getBookingToUser() {

    const bookingOverviewTable = document.getElementById("bookingOverview");
    const response = await fetch(userUrl);
    const bookings = await response.json();

    for (let i = 0; i < bookings.length; i++) {

        let row = bookingOverviewTable.insertRow();

        let bookingId = bookings[i].bookingId;

        //Bruges til at hente aktivitet til den pågælgende booking
        const activityUrl = `http://localhost:8080/getActivityToBooking/${bookingId}`;
        const response1 = await fetch(activityUrl)
        const activity = await response1.json();

        //Bruges til at hente timeslot for booking
        const timeslotUrl = `http://localhost:8080/timeslotForBooking/${bookingId}`;
        const repsonse2 = await fetch(timeslotUrl);
        const timeslot = await repsonse2.json();


        const date = row.insertCell(0);
        date.innerHTML = bookings[i].bookingDate;

        const activityTitle = row.insertCell(1);
        activityTitle.innerHTML = activity.title;

        const activityStart = row.insertCell(2);
        activityStart.innerHTML = timeslot.start;

        const activityEnd = row.insertCell(3);
        activityEnd.innerHTML = timeslot.end;

        const cancel = row.insertCell(4);
        let cancelButton = document.createElement("button");
        cancelButton.innerHTML = "Aflys Booking";
        cancel.appendChild(cancelButton);
    }
}






