getBookingToUser();

const bookingOverviewTable = document.getElementById("bookingOverview");

async function getBookingToUser()
{
    const userUrl = "http://localhost:8080/bookingsForCurrentUser/";

    const response = await fetch(userUrl);
    const bookings = await response.json();

    for(let i = 0; i < bookings.length; i++)
    {
        let row = bookingOverviewTable.insertRow();

        const bookingId = bookings[i].bookingID;

        const activityUrl = `http://localhost:8080/getActivityToBooking/${bookingId}`;
        const response1 = await fetch(activityUrl)
        const activity = await response1.json();

        const timeslotUrl = `http://localhost:8080/timeslotForBooking/${bookingId}`;
        const response2 = await fetch(timeslotUrl);
        const timeslot = await response2.json();

        const date = row.insertCell(0);
        date.innerHTML = bookings[i].bookingDate;

        const activityTitle = row.insertCell(1);
        activityTitle.innerHTML = activity.title;

        const activityStartEnd = row.insertCell(2);
        const editTime = document.createElement("select");
        editTime.disabled = true;

        const defaultOption = document.createElement("option");
        defaultOption.text = timeslot.start + '-' + timeslot.end;

        editTime.add(defaultOption);
        activityStartEnd.appendChild(editTime);

        const cancel = row.insertCell(3);
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

        const edit = row.insertCell(4);
        const editButton = document.createElement("button");
        editButton.id = bookingId;
        editButton.value = "Rediger tidsrum";
        editButton.innerHTML = "Rediger Tidsrum";
        editButton.onclick = async function ()
        {
            let ele = document.getElementById(bookingId);

            if(ele.value === "Rediger tidsrum"){

                editTime.disabled = false;
                ele.value = "Gem";
                ele.innerHTML = "Gem";

                const url = await fetch("http://localhost:8080/findAllTimeslots")
                const result = await url.json();

                editTime.length = 0;

                result.forEach(x =>
                {
                    let element = document.createElement("option")
                    element.value = x.timeSlotId;
                    element.textContent = x.start + "-" + x.end;
                    editTime.add(element);
                })
                return result;
            }
            else{
                editTime.disabled = true;
                ele.value = "Rediger tidsrum";
                ele.innerHTML = "Rediger Tidsrum";

                const updatedBooking = {
                    "bookingID": bookingId,
                    "bookingDate": bookings[i].bookingDate,
                    "dummy": activity.activityId,
                    "dummyTimeSlot": editTime.selectedIndex +1
                }

                const updatedTimeSlot = JSON.stringify(updatedBooking);

                updateTimeslotForBooking(updatedTimeSlot);
                defaultOption.text = timeslot.start + '-' +timeslot.end;
            }
        }
        edit.appendChild(editButton);
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


function updateTimeslotForBooking(updatedBooking){

    const updateUrl = "/updateTimeslotForBooking"

    const updateObj = {
        headers: {'Content-type': 'application/json'
        },
        method: 'PUT',
        body: updatedBooking
    }

    fetch(updateUrl, updateObj)
}




