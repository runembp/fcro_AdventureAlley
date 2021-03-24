getBookingToUser();

async function getBookingToUser()
{
    const bookingOverviewTable = document.getElementById("bookingOverview");
    const userUrl = "http://localhost:8080/bookingsForCurrentUser/";
    const response = await fetch(userUrl);
    const bookings = await response.json();

    for(let i = 0; i < bookings.length; i++)
    {
        const bookingId = bookings[i].bookingId;

        const activityUrl = `http://localhost:8080/getActivityToBooking/${bookingId}`;
        const response1 = await fetch(activityUrl)
        const activity = await response1.json();

        const timeslotUrl = `http://localhost:8080/timeslotForBooking/${bookingId}`;
        const response2 = await fetch(timeslotUrl);
        const timeslot = await response2.json();

        const element = document.createElement("p");
        element.innerText = activity.title + ' ' + bookings[i].bookingDate + ' '+ timeslot.start + ' ' + timeslot.end;

        const row = bookingOverviewTable.insertRow();

        const date = row.insertCell(0);
        date.innerHTML = bookings[i].bookingDate;

        const activityTitle = row.insertCell(1);
        activityTitle.innerHTML = activity.title;

        const activityStart = row.insertCell(2);
        activityStart.innerHTML = timeslot.start;

        const activityEnd = row.insertCell(3);
        activityEnd.innerHTML = timeslot.end;

        const cancel = row.insertCell(4);
        const cancelButton = document.createElement("button");
        cancelButton.innerHTML = "Aflys Booking";
        cancelButton.onclick = function ()
        {
            if(confirm("Vil du slette denne booking?") === true)
            {
                deleteBooking(bookingId);
            }
        }
        cancel.appendChild(cancelButton);
    }
}

function deleteBooking(bookingId){
    const deleteUrl = `/deleteBooking/${bookingId}`;

    const deleteObj = {
        method: 'DELETE'
    }

    fetch(deleteUrl, deleteObj);
    location.reload();
}






