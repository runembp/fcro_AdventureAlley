const dropdownMyBookings = document.getElementById("dropdownMyBooking");
const booking1 = document.getElementById("booking1");

let email = window.location.pathname.substring(19);

booking1.innerHTML += email;

getBookingToUser()


async function getBookingToUser(){

    const userUrl = `http://localhost:8080/bookingsForCurrentUser/${email}`;
    const response = await fetch(userUrl);
    const user = await response.json();

    for(let i = 0; i < user.bookingSet.length; i++)
    {
        let element = document.createElement("p");
        element.value = user.bookingSet[i].booking_id;
        element.textContent = user.bookingSet[i].activity.title + ' ' + user.bookingSet[i].bookingDate;

        let timeslotModelSet = user.bookingSet[i].activity.timeSlotModelSet;

        timeslotModelSet.forEach(x => {
            element.textContent += x.start + " ";
            element.textContent += x.end;
        });

        dropdownMyBookings.appendChild(element);
    }

}







